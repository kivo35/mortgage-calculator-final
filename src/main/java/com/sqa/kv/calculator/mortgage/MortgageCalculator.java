package com.sqa.kv.calculator.mortgage;

import java.util.Scanner;

public class MortgageCalculator
{
	/*
	 * Create an application which calculates the mortgage of a house given the
	 * principle, interest and term. The application should do the following
	 * steps: // // Welcome the user to the application. // Ask the user what
	 * the property ID is. // Ask the user what the principle is (ex: 200000),
	 * the interest (ex: .0575), and term in months (360). // Calculate the
	 * payments based on the formula below: // payment = principle * (interest /
	 * Math.pow (1 / 1 + interest), termMonths); // Let the user know what the
	 * payments would be each month, for how many years and months for what
	 * property. Not just total months based on supplied term (Must use modulus
	 * operator). // Ask the user if they would like to find out the mortgage of
	 * another home and if not, exit. // Echo a farewell message to the user. //
	 * Exit the application. // // NOTE: // * To compare Strings you must use
	 * equals method or equalsIgnoreCase(). For example: // if
	 * (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q")) {... pg
	 * 70, Java24Hrs
	 */

	public static void calcPay(double l, double i, int t, int id)
	{
		// find the payment made per month
		double mp = (l * i / 12.0) / (1 - Math.pow(1 + i / 12.0, -t));

		System.out.println("The total of $" + Math.round(mp) + " will be payed in " + t / 12 + " years and " + t % 12
				+ ((t > 1) ? " months" : " month") + " for " + id);
	}

	public static void main(String[] args)
	{
		System.out.println("Welcome to the mortgage calculator!");

		while (true)
		{
			// Variables to hold various mortgage data
			String input;
			Scanner scanner = new Scanner(System.in);

			System.out.println("What's the property ID?: ");
			input = scanner.nextLine();

			int id = Integer.parseInt(input);

			System.out.println("What's the principle/loan amount?: ");
			input = scanner.nextLine();

			double loan = Double.parseDouble(input);

			System.out.println("What's the interest?: ");
			input = scanner.nextLine();

			double interest = Double.parseDouble(input) / 100.0;
			System.out.println(interest);

			System.out.println("What's the term (in months)?: ");
			input = scanner.nextLine();

			int term = Integer.parseInt(input);

			calcPay(loan, interest, term, id);

			System.out.println("Do you wanna calculate another mortgage payment? "
					+ "[\"quit\" or \"q\" to exit the app]");
			input = scanner.nextLine();

			// exit condition
			if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q"))
			{
				System.out.println("Thank you for using the app, goodbye!");
				break;
			}
		}
	}
}
