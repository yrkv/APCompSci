import java.util.Arrays;

public class FRU5
{
    public static void main(String[] args)
    {
        FRU5 aaa = new FRU5();
    }

    public FRU5()
    {
        int[] arr1 = {0, 1, 2, 1, 3};
        int[][] mat1 = {
                {0, 1, 2},
                {0, 4, 1},
                {8, 1, 9}
        };

        int[][] mat2 = {
                {2, 1, 2},
                {0, 4, 1},
                {8, 1, 9}
        };

        System.out.println(Arrays.equals(rotate(arr1), new int[] {3, 0, 1, 2, 1}));
        System.out.println(arraySum(arr1) == 7);
        System.out.println(Arrays.equals(rowSums(mat1), new int[] {3, 5, 18}));
        System.out.println(isDiverse(mat1));
        System.out.println(!isDiverse(mat2));
    }

    private int[] rotate(int[] array)
    {
        int last = array[array.length - 1];

        for (int i = array.length - 1; i > 0; i--)
            array[i] = array[i - 1];

        array[0] = last;

        return array;
    }

    private int arraySum(int[] array)
    {
        int sum = 0;
        for (int value: array)
            sum += value;

        return  sum;
    }

    private int[] rowSums(int[][] array2D)
    {
        int[] newArray = new int[array2D.length];

        for (int i = 0; i < array2D.length; i++) {
            newArray[i] = arraySum(array2D[i]);
        }

        return  newArray;
    }

    private boolean isDiverse(int[][] array2D)
    {
        int[] newArray = rowSums(array2D);

        for (int i = 0; i < array2D.length; i++)
        {
            for (int j = i + 1; j < array2D.length; j++) {
                if (newArray[i] == newArray[j]) return false;
            }
        }

        return true;
    }
}
