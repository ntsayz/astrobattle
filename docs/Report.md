# ASTRO BATTLE  

#### Astro Battle is a 2D text-based Arcade style space shooter game. In Astro Battle, players control a spaceship and fight against waves of alien invaders. The objective of the game is to survive as long as possible and score as many points as possible by defeating the alien invaders.
<br>

This project was developed by *Ntsay Zacarias* (*up202008863*@fe.up.pt) for LDTS 2022⁄23.


## IMPLEMENTED FEATURES

- **Movement** - Players can control the movement of their spaceship.
- **Shooting** - Players can shoot projectiles at the alien invaders.
- **Dynamic Shooting System** - The player can change the projectile type on the go.
- **Increasing difficulty** - As the game progresses, the waves of alien invaders become more and more difficult to defeat.
- **High score tracking** - The game tracks the player's high score and displays it on the screen.

## PLANNED FEATURES

- **Boss battles** - The game will include boss battles at the end of each level, where players will have to defeat a large and powerful alien boss to progress to the next level.

## DESIGN

##### Problem #1
## THE GAME SHOULD HAVE DIFFERENT STATES

##### Problem in Context

The menu of the game could be implemented using a single class with a large switch statement to handle the different states. This may result in a large and complex class with a lot of conditional logic, which could be difficult to maintain and extend.

#### The Pattern

I applied the **State Pattern** to solve the problem of managing the different states of the menu. This pattern allowed me to represent each state as a separate class. This makes it easier to manage the different states and their transitions, which could allow me to easily add new states in the future.

#### Implementation

The following figure shows how the pattern’s roles were mapped to the application classes.

![State Pattern UML GameState](https://github.com/FEUP-LDTS-2022/project-l10gr08/blob/main/docs/uml/StatePatternUML.png)
These classes can be found in the following files:
- [GameState](https://github.com/FEUP-LDTS-2022/project-l10gr08/blob/main/src/main/java/State/GameState.java)
- [MenuState](https://github.com/FEUP-LDTS-2022/project-l10gr08/blob/main/src/main/java/State/Menu.java)
- [PlayingState](https://github.com/FEUP-LDTS-2022/project-l10gr08/blob/main/src/main/java/State/Playing.java)
- [InstructionsState](https://github.com/FEUP-LDTS-2022/project-l10gr08/blob/main/src/main/java/State/Instructions.java)
- [ExitState](https://github.com/FEUP-LDTS-2022/project-l10gr08/blob/main/src/main/java/State/Exit.java)
- [LostState](https://github.com/FEUP-LDTS-2022/project-l10gr08/blob/main/src/main/java/State/Lost.java)
- [StateController](https://github.com/FEUP-LDTS-2022/project-l10gr08/blob/main/src/main/java/Controller/StateController.java)

#### Consequences

After applying the State pattern, the menu is much easier to maintain and extend. The different states and their transitions are now represented in separate classes, which makes the code more modular and readable.
<br><br>
##### Problem #2
## THE BULLETS SHOT BY THE SPACESHIP SHOULD HAVE DIFFERENT BEHAVIORS DEPENDING ON THEIR POWER AND SPEED

#### Problem in Context

Initially, the behavior of the bullets shot by the spaceship was implemented in the Player class, which increased coupling, with a large and complex conditional blocks to handle the different behavior based on the bullet's power and speed. 

#### The Pattern

I applied the **Strategy pattern** to solve the problem of managing the different behaviors of the bullets. This pattern allows me to represent each behavior as a separate class, with its own properties and state transitions. This makes it easier to manage the different behaviors and allows me to add new behaviors in the future.

#### Implementation

The following figure shows how the pattern’s roles were mapped to the application classes.
![STRAT Pattern Bullet behaviour](https://github.com/FEUP-LDTS-2022/project-l10gr08/blob/main/docs/uml/StrategyPatternUMLBULLETBEHAVIOUR.png)
- [BulletBehaviour](https://github.com/FEUP-LDTS-2022/project-l10gr08/blob/main/src/main/java/Model/DynamicElement/Strategy/BulletBehavior.java)
- [FastWeakBullet](https://github.com/FEUP-LDTS-2022/project-l10gr08/blob/main/src/main/java/Model/DynamicElement/Strategy/FastWeakBullet.java)
- [SlowStrongBullet](https://github.com/FEUP-LDTS-2022/project-l10gr08/blob/main/src/main/java/Model/DynamicElement/Strategy/SlowStrongBullet.java)
- [Bullet](https://github.com/FEUP-LDTS-2022/project-l10gr08/blob/main/src/main/java/Model/DynamicElement/Bullet.java)

#### Consequences
This pattern allowed me to manage and change, more easily, the behaviour of the bullets according to my needs during development time. Which made it much shorter.
<br><br>
##### Problem #3
## HUMANS AND COMPUTERS BEHAVE DIFFERENTLY

#### Problem in Context
While developing the movement of ships, I initially used constant values for the friction coefficient and maximum speed, for example, that were chosen based on the assumption that a human player would be operating the ships. However, when testing the program, I found that these values were not appropriate because of how fast the ships were being controlled by the computer.
#### The Pattern

I applied the **Strategy Pattern** to solve the problem of different operators(User and Computer) having different behaviours while using certain methods of shared classes.

#### Implementation

The following figure shows how the pattern’s roles were mapped to the application classes.
![](https://github.com/FEUP-LDTS-2022/project-l10gr08/blob/main/docs/uml/StrategyPatternUMLSHIPSPEED.png)
- [ShipSpeed](https://github.com/FEUP-LDTS-2022/project-l10gr08/blob/main/src/main/java/Model/DynamicElement/Strategy/ShipSpeed.java)
- [SuperSlowShip](https://github.com/FEUP-LDTS-2022/project-l10gr08/blob/main/src/main/java/Model/DynamicElement/Strategy/SuperSlowShip.java)
- [SlowShip](https://github.com/FEUP-LDTS-2022/project-l10gr08/blob/main/src/main/java/Model/DynamicElement/Strategy/SlowShip.java)
- [FastShip](https://github.com/FEUP-LDTS-2022/project-l10gr08/blob/main/src/main/java/Model/DynamicElement/Strategy/FastShip.java)
- [Ship](https://github.com/FEUP-LDTS-2022/project-l10gr08/blob/main/src/main/java/Model/DynamicElement/Ship.java)

#### Consequences
This pattern allowed me to not only solve the problem of erratic computer behaviour when moving, but also creating the possibility to add features like ship speed and managing them more efficiently.
<br><br>
##### Problem #4
## THE MOVEMENT OF THE SPACESHIP SHOULD BE SMOOTH AND RESPONSIVE

##### Problem in Context:
Initially, the movement of the spaceship was implemented using the `ElementInstance.setPosition()` method, which immediately moved the spaceship to the desired position. This resulted in jerky and unresponsive movement, which was not satisfying to the player.

##### The Solution

I applied [**Interpolation**](https://en.wikipedia.org/wiki/Interpolation) to smooth out the movement of the spaceship. This method allowed me to smoothly transition the spaceship from its current position to the desired position over a short period of time, which results in a more natural and responsive movement.

#### Implementation

The class can be found in the following file:
- [Position](https://github.com/FEUP-LDTS-2022/project-l10gr08/blob/main/src/main/java/Model/Position.java)
> On the Position.move() method

#### Consequences

After applying the Interpolation method, the movement of the spaceship is much smoother and more responsive, which has greatly improved the player experience. But upon further testing, it appeared that computers with less processing capacity struggled a bit more while running the game.

## KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS

### LARGE CLASS

The `ElementController` class is a **Large Class**, it contains too many fields and methods, because it basically controls every element that is rendered on the screen.

Creating more classes that are specialized to those elements, such as `PlayerController`, `EnemyController`, and `AssetsController`, and using instances of those classes in the `ElementController` class might be the best way to improve the code - **Extract Class**.
<br><br>
### SPECULATIVE GENERALITY (FIXED)
I made the mistake of expecting that some classes would be valuable while the program's architecture was still being designed, but they turned out not to be. For example, some of the classes that implement `View`, like `Pause` ended up not being used because I figured another way to implement it. The `PowerUp` class was for a feature that wasn't prioritised and ended up not making it to the final version of the game.

A way to solve this problem might be deleting the altogether, or continue developing and giving the classes function and purpose.
<br><br>
### INAPPROPRIATE INTIMACY (FIXED)
For the `MenuView` to know when to change colors, it needed to know in which state the program was, so I created a static  instance of the field that holds the value of state in the `StateController` class, to share between those two classes.

One way to solve it would be to pass that value as an argument to the function of `MenuView` that needs the variable - **Add Parameter**.

### TESTING

#### Tests coverage
![](https://github.com/FEUP-LDTS-2022/project-l10gr08/blob/refactor/docs/assets/coverage.png)

#### Mutation testing report
>After many attemps and hours lost trying to generate the mutation testing report, because of how picky pitest was with versions, be it of junit or even what jvm gradle was using. It proved for me to be impossible to get it, the [only time](https://github.com/FEUP-LDTS-2022/project-l10gr08/blob/refactor/docs/assets/mylostbattlewithpitest.jpeg) I managed to make it work, it wasn't recognizing that tests were being run on the target classes, so I ended up leaving it at that.



### SELF-EVALUATION

- Ntsay Zacarias: 100%
