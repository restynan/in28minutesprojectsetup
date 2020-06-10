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



    @Nested
class TestAdd {
    @Test
    @DisplayName("Testing add Method for positive")
    void testAddPostive() {
        assertEquals(5, mathUtils.add(1, 4), "The add method should add two  postive numbers");
    }

    @Test
    @DisplayName("Testing add Method for negative")
    void testAddNegative() {
        assertEquals(-1, mathUtils.add(1, -2), "The add method should add negative two numbers");
    }
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