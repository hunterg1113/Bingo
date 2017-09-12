package com.arkansascodingacademy;

import java.util.ArrayList;

public class Game
{
    private Numbers numbers = new Numbers(1, 75);
    private RandomCard card = new RandomCard();
    private ArrayList<RandomCard> cards = new ArrayList<>();

    public Game()
    {
        for (int cardNumber = 1; cardNumber <= 10; cardNumber++)
        {
            RandomCard card = new RandomCard();
            cards.add(card);
        }


    }

    public void play()
    {
        boolean bingo = false;

        while (!bingo)
        {
            int number = numbers.drawNumber();

            for (RandomCard card : cards)
            {
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

    public void printWinningCards()
    {
        System.out.println("The winning cards are: ");
        System.out.println();

        for (RandomCard card : cards)
        {
            if (card.bingo())
            {
                card.print();
                System.out.println();
            }
        }
    }
}
