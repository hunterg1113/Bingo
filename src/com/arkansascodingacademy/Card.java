package com.arkansascodingacademy;

public class Card
{
    private Square square[][] = new Square[5][5];

    public Card()
    {
        square[0][0] = new Square(6);
        square[0][1] = new Square(28);
        square[0][2] = new Square(37);
        square[0][3] = new Square(51);
        square[0][4] = new Square(65);

        square[1][0] = new Square(10);
        square[1][1] = new Square(26);
        square[1][2] = new Square(44);
        square[1][3] = new Square(50);
        square[1][4] = new Square(69);

        square[2][0] = new Square(4);
        square[2][1] = new Square(24);
        square[2][2] = new Square(0);
        square[2][2].cover();
        square[2][3] = new Square(57);
        square[2][4] = new Square(64);

        square[3][0] = new Square(12);
        square[3][1] = new Square(30);
        square[3][2] = new Square(42);
        square[3][3] = new Square(58);
        square[3][4] = new Square(73);

        square[4][0] = new Square(9);
        square[4][1] = new Square(29);
        square[4][2] = new Square(36);
        square[4][3] = new Square(46);
        square[4][4] = new Square(67);
    }

    public void play(int number)
    {
        for (int row = 0; row < 5; row++)
        {
            for (int column = 0; column < 5; column++)
            {
                if (number == square[row][column].getNumber())
                {
                    square[row][column].cover();
                }
            }
        }
    }

    public boolean bingo()
    {
        return bingobByStamp() || bingoByColumn() || bingoByRow() || bingoByDiagonal();
    }

    public boolean bingoByRow()
    {
        boolean bingo = false;

        for (int row = 0; row < 5; row++)
        {
            if (square[row][0].isCovered() &&
                    square[row][1].isCovered() &&
                    square[row][2].isCovered() &&
                    square[row][3].isCovered() &&
                    square[row][4].isCovered())
            {
                bingo = true;
            }
        }
        return bingo;
    }

    public boolean bingoByColumn()
    {
        boolean bingo = false;

        for (int column = 0; column < 5; column++)
        {
            if (square[0][column].isCovered() &&
                    square[1][column].isCovered() &&
                    square[2][column].isCovered() &&
                    square[3][column].isCovered() &&
                    square[4][column].isCovered())
            {
                bingo = true;
            }
        }
        return bingo;
    }

    public boolean bingoByDiagonal()
    {
        boolean bingo = false;

        if (square[0][0].isCovered() && square[1][1].isCovered() && square[2][2].isCovered() &&
                square[3][3].isCovered() && square[4][4].isCovered())
        {
            bingo = true;
        }

        if (square[4][0].isCovered() && square[3][1].isCovered() && square[2][2].isCovered() &&
                square[1][3].isCovered() && square[0][4].isCovered())
        {
            bingo = true;
        }

        return bingo;
    }

    public boolean bingobByStamp()
    {
        boolean bingo = false;

        for (int y = 0; y < 4; y++)
        {
            for (int x = 0; x < 4; x++)
            {
                if (square[x][y].isCovered() &&
                        square[x + 1][y].isCovered() &&
                        square[x][y + 1].isCovered() &&
                        square[x + 1][y + 1].isCovered())
                {
                    bingo = true;
                }
            }
        }
        return bingo;
    }

    public void print()
    {
        for (int row = 0; row < 5; row++)
        {
            for (int column = 0; column < 5; column++)
            {
                square[row][column].print();
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}