// Yegor Kuznetsov
//
// This program runs a DFS on the peg game to determine a possible solution,
// with a little randomness added so that it generates different solutions.

public class Main
{
    private String bestPath = "";

    public static void main(String[] args)
    {
        new Main();
    }

    public Main()
    {
        boolean[][] board = new boolean[5][];
        for (int i = 1; i <= 5; i++)
        {
            board[i-1] = new boolean[i];
            for (int j = 0; j < i; j++)
            {
                board[i-1][j] = true;
            }
        }

        board[0][0] = false;

        System.out.println(search(board, ""));
    }

    private String search(boolean[][] board, String path)
    {
        if (count(board) == 1)
            bestPath = path;
        else
        {
            int numI = (int) (Math.random() * 100);
            for (int y = 0; y < 5; y++)
            {
                int i = (y+numI) % 5;
                int numJ = (int) (Math.random() * 100);
                for (int t = 0; t < i + 1; t++)
                {
                    int j = (t+numJ) % (i+1);
                    if (board[i][j])
                    {
                        int numD = (int) (Math.random() * 100);
                        for (int u = 0; u < 6; u++)
                        {
                            int d = (numD + u) % 6;
                            int[] pos = move(new int[]{i, j}, d);
                            int[] pos2 = move(pos, d);
                            if (isValid(pos) && board[pos[0]][pos[1]] && isValid(pos2) && !board[pos2[0]][pos2[1]])
                            {
                                boolean[][] newBoard = new boolean[5][];
                                for (int k = 1; k <= 5; k++)
                                {
                                    newBoard[k - 1] = new boolean[k];
                                    for (int p = 0; p < k; p++)
                                    {
                                        newBoard[k - 1][p] = board[k - 1][p];
                                    }
                                }

                                newBoard[i][j] = false;
                                newBoard[pos[0]][pos[1]] = false;
                                newBoard[pos2[0]][pos2[1]] = true;

                                search(newBoard, path + getNum(i, j) + " to " + getNum(pos2[0], pos2[1]) + "\n");
                            }
                        }
                    }
                }
            }
        }
        return bestPath;
    }

    private boolean isValid(int[] pos)
    {
        return (pos[0] >= 0 && pos[0] < 5 && pos[1] >= 0 && pos[1] <= pos[0]);
    }

    private int count(boolean[][] board)
    {
        int c = 0;
        for (boolean[] r:board)
            for (boolean t:r)
                if (t) c++;
        return c;
    }

    private int getNum(int a, int b)
    {
        int c = 1;
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j <= i; j++) {
                if (i == a && j == b)
                    return c;
                else
                    c++;
            }
        }
        return -1;
    }

    private int[] move(int[] pos, int dir)
    {
        switch (dir)
        {
            case 0: return new int[] {pos[0]-1, pos[1]};//NE
            case 1: return new int[] {pos[0], pos[1]+1};//E
            case 2: return new int[] {pos[0]+1, pos[1]+1};//SE
            case 3: return new int[] {pos[0]+1, pos[1]};//SW
            case 4: return new int[] {pos[0], pos[1]-1};//W
            case 5: return new int[] {pos[0]-1, pos[1]-1};//NW
        }
        return new int[] {0, 0};
    }
}
