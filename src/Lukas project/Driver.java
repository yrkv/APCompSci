//Lukas Anson
//
//This program randomly selects a word from a text file
//and then the player trys to guess the word.
//after 10 incorrect guesses the

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver
{
    //private ArrayList<String> list = new ArrayList<String>(); // convert to local
    //private String word; // convert to local
    //private int counter = 0; // convert to local
    //private String guess; // convert to local

    public static void main(String[] args)
    {
        Driver d = new Driver();
    }

    public Driver()
    {
        ArrayList<String> list = new ArrayList<String>();
        try
        {
            Scanner scanner = new Scanner(new File("Word_Master_Mind.txt"));
            while (scanner.hasNextLine())
                list.add(/*new String(*/scanner.nextLine()/*)*/); // why do you have "new String"? it doesnt do anything.
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        //Random Word in the ArrayList
        String word = list.get((int)(Math.random() * 50));
        int score = 100;
        int counter = 0; // initialize counter
        for(int i = 0; i < 10; i++)
        {
            counter = 0; //reset counter
            String copy = word;
            System.out.println("\n\n" + copy);
            Scanner sc = new Scanner(System.in);
            System.out.print("Guess #" + (i+1) + ": "); // add a space after :
            String guess = sc.nextLine();

            System.out.print("Result: "); // the example output has this.

            //Checks if there is a number in the right place
            for(int k = 0; k < 4; k++)
            {
                if(guess.substring(k, k+1).equals(copy.substring(k, k+1)))
                {
                    copy = copy.substring(0, k) + "." + copy.substring(k+1);
                    guess = guess.substring(0, k) + "/" + guess.substring(k+1);
                    counter++;
                    System.out.print("X"); // capitalize
                    score += 2;
                }
            }
            //Ends if the Correct guess has been made
            if(counter == 4)
            {
                //FINISH SCORE SHIT
                System.out.println("\tCORRECT!!\tFinal Score = " + score);
                break;
            }

            //Checks if there is a letter in the word, but in the wrong place
            for(int j = 0; j < 4; j++)
            {
                if (guess.contains(copy.charAt(j)+""))
                {
                    System.out.print("O"); // capitalize
                    guess = guess.replaceFirst(word.charAt(j) + "", "/");
                    score++;
                }
            }
            score -= 10; //Subtract 10 from score

        }
        if(counter != 4)
            System.out.println("\t\tWord = " + word + "\t\tFinal Score = " + score);
    }
}


