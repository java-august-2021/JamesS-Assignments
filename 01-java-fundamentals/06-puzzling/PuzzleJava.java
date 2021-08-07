import java.util.Random;
import java.util.Arrays;

public class PuzzleJava {
    public void getTenRolls(int length) {
        Random rand = new Random();
        int[] myArray;
        myArray = new int[length];
        for(int j=0; j<myArray.length; j++){
            int num = rand.nextInt(20-1);
            myArray[j] = num;
        }
        System.out.println(Arrays.toString(myArray));
    }

    public void getRandomLetter(int arrlength, int indexLength) {
        char[] alphabet = new char[arrlength];
        for(int j = 0; j< alphabet.length; j++){
            alphabet[j] = (char)(65+j);
        }
        Random rand = new Random();
        int randIndex = rand.nextInt(indexLength);

        System.out.println(alphabet[randIndex]);
    }

    public void generatePassword(int arrlength) {
        char[] alphabet = new char[arrlength];
        for(int j = 0; j< alphabet.length; j++){
            alphabet[j] = (char)(65+j);
        }
        char[] password = new char[8];
        for(int x = 0; x < password.length; x++){
            Random rand = new Random();
            int randLetter = rand.nextInt(arrlength);
            password[x] = alphabet[randLetter];
        }
        System.out.println(password);
    }

    public void getNewPasswordSet(int arrlength, int wordLength) {
        char[] alphabet = new char[arrlength];
        for(int j = 0; j< alphabet.length; j++){
            alphabet[j] = (char)(65+j);
        }
        char[] password = new char[wordLength];
        for(int x = 0; x < wordLength; x++){
            Random rand = new Random();
            int randLetter = rand.nextInt(arrlength);
            password[x] = alphabet[randLetter];
        }
        System.out.println(password);
        
    }
}
