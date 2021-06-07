package main;

import java.util.Scanner;
import java.util.Random;

public class Main
{
	
	public static int money = 500;
	
	
	private static int getInput()
	{
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter a guess between 0-30: ");
		int guess = scnr.nextInt();
		while (guess<0 || guess>30)
		{
			guess = scnr.nextInt();
		}
		return guess;
	}
	
	
	// getInput() method gets the input from the user on which number the user wants to bet on
	// Input validation - input must be between 0-30.
	
	private static void playGame()
	{
		Random rdm = new Random();
		int num = rdm.nextInt(31);
		int guess = getInput();
		int betMoney = getBetMoney();
		if (guess==num)
		{
			System.out.println("Congratulations, you guessed correcty!");
			money=calculateWinnings(num);
			System.out.println("You have won: "+money+"\n");
		}else
		{
			System.out.println("Better luck next time!");
			System.out.println("The number was "+num);
			money-=betMoney;
			System.out.println("Your balance: "+money+"\n");
		}
		
		if(money<=0)
		{
			System.out.println("GAME OVER!");
		}
		
	}
	
	// This method is the main game. It gets the input, rolls the dice.
	// Your balance is also given afterwards.
	
	private static int getBetMoney()
	{
		Scanner scnr = new Scanner(System.in);
		System.out.print("How much would you like to bet: ");
		int x = scnr.nextInt();
		while (x>money || x<0)
		{
			System.out.print("You do not have enough to bet that much, or it is below 0. Enter another amount: ");
			x = scnr.nextInt();
		}
		return x;
	}
	
	// This method gets the input for the betting money.
	// Input validation - Betting money must be above 0 and equal to or below the money the user has.
	
	private static boolean isPrime(int num)
	{
		for (int i=2;i<num;++i)
		{
			if (num%i==0)
			{
				return false;
			}
		}
		return true;
	}
	
	// Checks if the argument is prime.
	
	private static int calculateWinnings(int num)
	{
		
		
		if (num%2==0)
		{
			System.out.println("x2 - Even number");
			money*=2;
		}
		if (num%10==0)
		{
			System.out.println("x3 - Multiple of ten");
			money*=3;
		}
		if (num<5)
		{
			System.out.println("x2 - below 5");
			money*=2;
		}
		if (isPrime(num))
		{
			System.out.println("x5 - prime number");
			money*=5;
		}
		return money;
	}
	
	// Calculates the winnings that the user gets. Takes in the number the dice rolled to check conditions for any bonuses.
	
	public static void main(String[] args)
	{
		while (money>0)
		{
			playGame();
		}
	}
	
}
