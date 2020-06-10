package example.com;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {
    MathUtils mathUtils;
    @BeforeAll
    void beforeAllInit(){
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
    @DisplayName("Testing add Method")
    void testAdd() {


        int expected = 4;
        int actual = mathUtils.add(1, 3);

        assertEquals(expected, actual, "The add method should add two numbers");
        // System.out.print("test  has ran");

    }

    @Test
    @DisplayName("Multiply Method")
    void testMultiply() {
        //assertEquals(4, mathUtils.multiply(2, 2), "The add method should add two numbers");

        assertAll(
                ()->assertEquals(4, mathUtils.multiply(2, 2), "The add method should add two numbers"),
        ()->assertEquals(0, mathUtils.multiply(0, 2), "The add method should add two numbers"),
                ()->assertEquals(-2, mathUtils.multiply(-1, 2), "The add method should add two numbers")
        );
    }


    @Test
    void testComputeCircleRadius() {

        double expected = 254.34;
        double actual = mathUtils.computeCircleArea(9);

        assertEquals(expected, actual, "should return the circle  area");


    }

    @Test
    void testDivide() {
        boolean isServerUp= false;
         assumeTrue(isServerUp);

        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero should throw");

    }
    @Test
    @Disabled
    @DisplayName("TDD Method should not run")
    void testDisabled() {
        fail("This test is disabled");
    }

}