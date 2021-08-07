import java.lang.reflect.Array;

public class BasicsTest {
    public static void main(String[] args) {
        Basics tester = new Basics();

        int[] testArray = new int[]{1, 2, 5, 9, 13};

        tester.printArray(255);
        tester.oddArray(255);
        tester.sigmaReturn(255);        
        tester.iterateArray(testArray);
        tester.findMax(testArray);
        tester.oddNumbers(255);
        tester.getAverage(testArray);
    }
}
