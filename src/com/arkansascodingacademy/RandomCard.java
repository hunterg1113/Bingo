package com.arkansascodingacademy;

public class RandomCard
{
    private Square square[][] = new Square[5][5];


    public RandomCard()
    {
        int x = 1;
        int y = 15;

        for (int column = 0; column < 5; column++)
        {
            Numbers numbers = new Numbers(x, y);

            for (int row = 0; row < 5; row++)
            {
                square[row][column] = new Square(numbers.drawNumber());
            }

            x += 15;
            y += 15;
        }




        /*
        Numbers numbers = new Numbers(1, 15);

        for (int row = 0; row < 5; row++)
        {
            square[row][0] = new Square(numbers.drawNumber());
        }

        numbers = new Numbers(16, 30);

        for (int row = 0; row < 5; row++)
        {
            square[row][1] = new Square(numbers.drawNumber());
        }

        numbers = new Numbers(31, 45);

        for (int row = 0; row < 5; row++)
        {
            square[row][2] = new Square(numbers.drawNumber());
        }

        numbers = new Numbers(46, 60);

        for (int row = 0; row < 5; row++)
        {
            square[row][3] = new Square(numbers.drawNumber());
        }

        numbers = new Numbers(61, 75);

        for (int row = 0; row < 5; row++)
        {
            square[row][4] = new Square(numbers.drawNumber());
        }

        square[2][2] = new Square(0);
        square[2][2].cover();
        */
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
        return bingoByStamp() || bingoByColumn() || bingoByRow() || bingoByDiagonal();
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

    public boolean bingoByStamp()
    {
        boolean bingo = false;

        for (int column = 0; column < 4; column++)
        {
            for (int row = 0; row < 4; row++)
            {
                if (square[row][column].isCovered() &&
                        square[row + 1][column].isCovered() &&
                        square[row][column + 1].isCovered() &&
                        square[row + 1][column + 1].isCovered())
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