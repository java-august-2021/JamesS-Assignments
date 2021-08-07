import java.util.ArrayList;

public class Basics {
    public void printArray(int number) {
        int[] myArray = new int[number];
        for (int j=0; j<myArray.length; j++){
            myArray[j]=j+1;
        }
        for (int num:myArray){
            System.out.println(num);
        }
    }

    public void oddArray(int number) {
        ArrayList<Integer> myArray = new ArrayList(number);
        for (int j=0; j <= number; j++){
            if(j%2 !=0){
                myArray.add(j);
                System.out.println(j);
            }
        }
    }

    public int sigmaReturn(int number) {
        int sum = 0;
        for(int j=1; j<= number; j++) {
            sum+=j;
        }
        return sum;
    }

    public void iterateArray(int[] testArray){       
        for(int j=0; j<testArray.length; j++){
            System.out.println(testArray[j]);
        }
    }

    public void findMax(int[] testArray){
        int maxValue = testArray[0];
        for(int j=0; j<testArray.length; j++){
            if(testArray[j]>maxValue){
                maxValue = testArray[j];
            }
        }
        System.out.println(maxValue);
    }

    public void oddNumbers(int number) {
        ArrayList<Integer> y = new ArrayList(number);
        for (int j=0; j <= number; j++){
            if(j%2 !=0){
                y.add(j);
            }
        }
        System.out.println(y);
    }

    public void getAverage(int[] testArray){
        int avg = 0;
        int sum = 0;
        for(int j : testArray){
            sum+=j;
        }
        avg = sum/testArray.length;
        System.out.println(avg);        
    }

}

