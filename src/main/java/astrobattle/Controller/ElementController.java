package astrobattle.Controller;

import astrobattle.Controller.Utilities.Window;
import astrobattle.Model.DynamicElement.Bullet;
import astrobattle.Model.DynamicElement.Enemy;
import astrobattle.Model.DynamicElement.Player;
import astrobattle.Model.DynamicElement.Ship;
import astrobattle.Model.DynamicElement.Strategy.SuperSlowShip;
import astrobattle.Model.Position;
import astrobattle.Model.StaticElement.Asset;
import astrobattle.Model.StaticElement.Coin;


import astrobattle.Model.StaticElement.PowerUp;
import astrobattle.View.LostView;
import astrobattle.View.PlayingView;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;


import java.util.ArrayList;
import java.util.Random;

public class ElementController {
    Player player;
    Bullet playerBullet, enemyBullet;
    int dir = 3;
    boolean lost= false;
    int posY1 = 30;
    int posY2 = 40;
    int winCols =  Window.getCols();
    int winRows = Window.getRows();
    Position middle = new Position(winCols/2,winRows-posY1);
    Position middleUp = new Position(winCols/2,winRows-posY2);
    Position left = new Position(4,winRows-posY1);
    Position leftUp = new Position(4,winRows-posY2);
    Position right = new Position(winCols,winRows-posY1);
    Position rightUp = new Position(winCols,winRows-posY2);
    ArrayList<Enemy> enemies, copyEnemies;
    ArrayList<Asset> assets, copyAssets;
    Random random = new Random();
    boolean addpower = false;
    int bound = 6 ;

    public ElementController(){
        player = new Player(Window.getCols()/2 +3,Window.getRows()/2,4,4);
        playerBullet = new Bullet(0,0,2,2);
        enemyBullet = new Bullet(0,0,2,2);
        enemies = new ArrayList<>();
        assets = new ArrayList<>();
        copyEnemies = new ArrayList<>();
        copyAssets = new ArrayList<>();
        generateAssets();
    }
    public int manager(TextGraphics graphics, KeyStroke key) throws InterruptedException {
        int code = processKey(key);
        PlayingView.draw(graphics,player,enemies);
        player.move(0);
        enemyManager(graphics,bound);
        assetManager(graphics);
        player.update(graphics);
        playerBullet.drawPlayer(graphics,player.getPosition());
        if(player.getPosition().equals(enemyBullet.getPosition())){
            player.damage(enemyBullet.getPower());
        }

        if(player.getHealth()/100 == 0){
            LostView.draw(graphics);
            code = 1;
            lost = true;
        }

        return code;
    }
    public int processKey(KeyStroke key){
        if(key == null)return 6;
        player.move(0);
        switch (key.getKeyType()){
            case Escape : return 1;
            case ArrowUp :player.move(1);break;
            case ArrowDown : player.move(2);break;
            case ArrowLeft :player.move(3);break;
            case ArrowRight :player.move(4);break;
            case Tab :playerBullet.go();break;
            case Enter : playerBullet.changeShootingBehaviour();break;
            default:
                return 10;
        }
        return 0;
    }
    void generateAssets(){
        Enemy en = new Enemy(winCols/2,winRows -posY1,4,4);
        Enemy en1 = new Enemy(winCols/2,winRows -posY2,4,4);
        en.setShipSpeed(new SuperSlowShip());
        en1.setShipSpeed(new SuperSlowShip());
        enemies.add(en1);
        enemies.add(en);
        for(int i = 0; i < 7 ; i++){
            addCoin();
        }
    }
    public void assetManager(TextGraphics graphics){
        retrieveAssets(bound);
        for(Asset coin: assets){
            coin.update(graphics);
        }

    }
    public void check(){
        if(lost){
            reset();
            lost = false;
        }
    }
    public void retrieveAssets(int bound) {
        copyAssets = new ArrayList<>();
        for (Asset asset : assets) {
            if (this.player.equals(asset)) {
                if(asset instanceof PowerUp){
                    player.increaseHealth(50);
                }else {
                    player.increaseScore(1);
                }
                copyAssets.add(asset);
                if(random.nextInt(bound) ==1 || assets.size() ==2){
                    addCoin();
                }
                break;
            }
            if(player.getHealth() < 500 && enemies.size()==2){
                addpower = true;
            }
        }
        assets.removeAll(copyAssets);
        copyAssets.clear();
        if(addpower){
            if(random.nextInt(1000) ==1 && assets.size() < 6){
                addPowerUp();
            }
            addpower = false;
        }
        if(random.nextInt(10000000) ==1 && assets.size()  < 4){
            addCoin();
        }
    }
    private void addCoin(){
        assets.add(new Coin(random.nextInt(150 - 2) + 1, random.nextInt(50 - 2) + 1,1,1));
    }
    private void addPowerUp(){
        assets.add(new PowerUp(random.nextInt(150 - 2) + 1, random.nextInt(50 - 2) + 1,1,1));
    }


    private void enemyManager(TextGraphics graphics, int bound){// Higher makes it less likely

        for(Enemy enemy: enemies){
            enemy.update(graphics);
            if(random.nextInt(bound) ==1){
                enemyBullet.drawEnemy(graphics,enemy.getPosition());
            }if(playerBullet.getPosition().equals(enemy.getPosition())){
                enemy.damage(50); // playerbulletgetpower();
                player.increaseScore(10);
            }
            if(enemy.getHealth()/100 == 0){
                copyEnemies.add(enemy);
            }
        }
        enemies.removeAll(copyEnemies);
        copyEnemies.clear();
        moveEnemies();

    }

    private void moveEnemies(){
        for (Ship enemy: enemies) {
            if(enemy.getPosition().equals(middle) || enemy.getPosition().equals(right)){
                dir = 3;
            } else if (enemy.getPosition().equals(left)) {
                dir =4;
            }
            if(enemy.getPosition().equals(middleUp) || enemy.getPosition().equals(leftUp) ){
                dir = 4;
            } else if (enemy.getPosition().equals(rightUp)) {
                dir =3;
            }
            if(random.nextInt(10) ==1){
                enemy.move(dir);
            }

        }
    }
    public void reset(){
        player = new Player(Window.getCols()/2+3,Window.getRows()/2,4,4);
        playerBullet = new Bullet(0,0,2,2);
        enemyBullet = new Bullet(0,0,2,2);
        enemies = new ArrayList<>();
        assets = new ArrayList<>();
        generateAssets();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Asset> getAssets() {
        return assets;
    }

    public void setAssets(ArrayList<Asset> assets) {
        this.assets = assets;
    }

    public void setPlayerBullet(Bullet playerBullet) {
        this.playerBullet = playerBullet;
    }

    public void setEnemyBullet(Bullet enemyBullet) {
        this.enemyBullet = enemyBullet;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }
}
