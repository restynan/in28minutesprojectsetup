package example.com;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {
    MathUtils mathUtils;
    @BeforeAll
    static void beforeAllInit(){
        System.out.print("Running before all methods");
    }

    @BeforeEach
    void init() {
        mathUtils = new MathUtils();
    }
    @AfterEach
    void cleanup(){
        System.out.print("cleaning up ...");
    }

    @Test
    void testAdd() {


        int expected = 4;
        int actual = mathUtils.add(1, 3);

        assertEquals(expected, actual, "The add method should add two numbers");
        // System.out.print("test  has ran");

    }

    @Test
    void testComputeCircleRadius() {

        double expected = 254.34;
        double actual = mathUtils.computeCircleArea(9);

        assertEquals(expected, actual, "should return the circle  area");


    }

    @Test
    void testDivide() {


        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero should throw");

    }


}