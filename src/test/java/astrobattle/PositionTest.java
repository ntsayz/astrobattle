package astrobattle;

import astrobattle.Model.Position;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    static Position element1,element2,element3,element4,element5;
    static int initialXValue, initialYValue;
    @BeforeAll
    public static void setup(){
        element1 = new Position(3,2,2,2);
        element2 = new Position(4,3,1,2);
        element3 = new Position(6,2,2,3);
        element4 = new Position(6,4,2,3);
        element5 = new Position(3,1,3,5);
        //Guaranteeing that state is being set as expected
        assertEquals(2,element1.getY());
        assertEquals(6,element4.getX());
        assertEquals(3,element3.getRowLen());
        assertNotEquals(3,element2.getColLen());

    }
    @Test
    public void CollisionBetweenElements(){
        //Verifying collisions
        assertNotEquals(element1,element4);
        assertEquals(element3,element4);
        assertEquals(element5,element2);
        assertEquals(element5,element1);
        assertNotEquals(element2,element4);
    }
    //Mock, move precisa de window size
    @Test
    public void ElementsMovement(){
        initialXValue = element1.getX();
        initialYValue = element1.getX();

        for(int i = 0; i< 10; i++){
            element1.move(3,(float) 0.3);
            element1.move(2,(float) 0.3);
        }

        assertNotEquals(initialXValue,element1.getX());
        assertNotEquals(initialYValue,element1.getY());

    }
    //test collision between ships and assets
}
