package com.arkansascodingacademy;

public class Game
{
    private Numbers numbers = new Numbers();
    private Card card = new Card();

    public Game()
    {
    }

    public void play()
    {
        boolean bingo = false;

        while (!bingo)
        {
            int number = numbers.drawNumber();

            card.play(number);
            card.print();
            System.out.println();

            if (card.bingo())
            {
                bingo = true;
            }
        }
    }
}
