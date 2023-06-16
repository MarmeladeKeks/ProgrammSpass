import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Hackerank {

    public static void main(String [] args){
        ersteExercise();
    }

    private static void ersteExercise(){
        Scanner eingabe = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println(eingabe.nextInt());
        }

    }
    private static void zweiteExercise() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        bufferedReader.close();
        if(N % 2 == 1)
            System.out.println("Weird");
        else if ( N >= 2 && N <= 5){
            System.out.println("Not Weird");
        }
        else if ( N >= 6 && N <= 20){
            System.out.println("Weird");
        }
        else
            System.out.println("Not Weird");
    }
}
