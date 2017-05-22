// Yegor Kuznetsov
//
// This is the mastermind final project. I tried to use as few statements as possible.

import java.io.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        new Main(new Scanner(new File("words.txt")).next().split("\\.")[(int) (Math.random() * 50)], 100, 1);
    }

    public Main(String word, int points, int i) throws FileNotFoundException
    {
        for (int x = 0; i < 11; i++, points -= 10, x = 0)
        {
            System.out.print("\n\nGuess #"+i+": ");
            String g = new Scanner(System.in).next();
            System.out.print("Result: ");
            String copy = word;
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
                break;
            for (int j = 0; j < 4; j++)
                if (g.contains(copy.charAt(j)+""))
                {
                    System.out.print("O");
                    g = g.replaceFirst(word.charAt(j) + "", "/");
                    points++;
                }
        }
        System.out.print("\t\t" + (i < 11 ? "CORRECT!!" : "Word = " + word) + "\t\tFinal Score: " + points);
    }
}