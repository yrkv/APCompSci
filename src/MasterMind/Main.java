// Yegor Kuznetsov
//
// This is the mastermind final project. I tried to use as few statements as possible.

import java.io.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        new Main(new Scanner(new File("words.txt")).next().split("\\.")[(int) (Math.random() * 50)], 100, false, 1, 0, "", "");
    }

    public Main(String word, int points, boolean a, int i, int x, String copy, String g) throws FileNotFoundException
    {
        for (; i < 11; i++, points -= 10, x = 0)
        {
            System.out.print("\n\nGuess #"+i+": ");
            System.out.printf(g = new Scanner(System.in).next() + "Result: ", copy = word);
            for (int j = 0; j < 4; j++)
                if (g.charAt(j) == copy.charAt(j))
                    System.out.printf("X", x++, copy = copy.substring(0, j) + "." + copy.substring(j+1), g = g.substring(0, j) + "/" + g.substring(j+1), points += 2);
            if (x == 4)
            {
                a = true;
                break;
            }
            for (int j = 0; j < 4; j++)
                if (g.contains(copy.charAt(j)+""))
                    System.out.printf("O", g = g.replaceFirst(word.charAt(j) + "", "/"), points++);
        }
        System.out.print("\t\t" + (a ? "CORRECT!!" : "Word = " + word) + "\t\tFinal Score: " + points);
    }
}