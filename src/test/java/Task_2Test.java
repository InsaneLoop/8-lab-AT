import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task_2Test {

    Task_2 task = new Task_2();

    @Test(dataProvider = "additionDataProvider")
    public void testAdd(int a, int b, int expected) {
        assertEquals(task.add(a, b), expected, "Addition method failed");
    }

    @Test(dataProvider = "evenDataProvider")
    public void testIsEven(int number, boolean expected) {
        assertEquals(task.isEven(number), expected, "Even check method failed");
    }

    @Test(dataProvider = "maxDataProvider")
    public void testFindMax(int[] numbers, int expected) {
        assertEquals(task.findMax(numbers), expected, "Find max method failed");
    }

    @Parameters({"paramA", "paramB", "expectedSum"})
    @Test
    public void testAddWithParameters(int paramA, int paramB, int expectedSum) {
        assertEquals(task.add(paramA, paramB), expectedSum, "Parameterized addition method failed");
    }

    @DataProvider(name = "additionDataProvider")
    public Object[][] additionData() {
        return new Object[][]{
                {1, 2, 3},
                {5, 7, 12},
                {-3, 3, 0}
        };
    }

    @DataProvider(name = "evenDataProvider")
    public Object[][] evenData() {
        return new Object[][]{
                {2, true},
                {3, false},
                {0, true}
        };
    }

    @DataProvider(name = "maxDataProvider")
    public Object[][] maxData() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4}, 4},
                {new int[]{-5, -2, -1}, -1},
                {new int[]{100}, 100}
        };
    }
}