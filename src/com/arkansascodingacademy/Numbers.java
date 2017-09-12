package com.arkansascodingacademy;

import java.util.ArrayList;
import java.util.Random;

public class Numbers
{
    private ArrayList<Integer> calledNumbers = new ArrayList<>();
    private ArrayList<Integer> uncalledNumbers = new ArrayList<>();
    private Random randGen = new Random();

    public Numbers(int min, int max)
    {
        fillUncalledNumbers(min, max);
    }

    public void fillUncalledNumbers(int min, int max)
    {
        for (int i = min; i <= max; i++)
        {
            uncalledNumbers.add(i);
        }
    }

    public int drawNumber()
    {
        int randomNumber = randGen.nextInt(uncalledNumbers.size());

        int calledNumber = uncalledNumbers.remove(randomNumber);

        calledNumbers.add(calledNumber);

        return calledNumber;
    }

    public void printCalledNumbers()
    {
        for (int number : calledNumbers)
        {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public void printUncalledNumbers()
    {
        for (int number : uncalledNumbers)
        {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}