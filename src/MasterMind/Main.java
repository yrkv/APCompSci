// Yegor Kuznetsov
//
// This is the mastermind final project. I tried to use as few statements as possible.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        new Main();
    }

    public Main() throws FileNotFoundException
    {
        String word = new Scanner(new File("words.txt")).next().split("\\.")[(int) (Math.random() * 50)];
        int points = 100;
        boolean a = false;
        for (int i = 0; i < 10; i++, points -= 10)
        {
            System.out.print("\n\nGuess #"+(i+1)+": ");
            String g = new Scanner(System.in).next();
            System.out.print("Result: ");
            String copy = word;
            int x = 0;
            for (int j = 0; j < 4; j++)
                if (g.charAt(j) == copy.charAt(j))
                {
                    System.out.print("X");
                    x++;
                    copy = copy.substring(0, j) + "." + copy.substring(j+1);
                    g = g.substring(0, j) + "/" + g.substring(j+1);
                    points += 2;
                }
            if (x == 4)
            {
                a = true;
                break;
            }
            for (int j = 0; j < 4; j++)
                if (g.contains(copy.charAt(j)+""))
                {
                    System.out.print("O");
                    g = g.replaceFirst(word.charAt(j) + "", "/");
                    points++;
                }
        }
        System.out.print("\t\t" + (a ? "CORRECT!!" : "Word = " + word) + "\t\tFinal Score: " + points);
    }
}
