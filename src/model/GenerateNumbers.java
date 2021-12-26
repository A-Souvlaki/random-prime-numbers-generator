package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GenerateNumbers implements GenerationAlgorithms {
	// Attributes
	


	// Constructor
	public GenerateNumbers() {
		
	}
	
	/**
	 * This method allows to obtain a list of prime number from the Erastotenes crib
	 * method.
	 * @param: n, represents a maximum number to calculate the prime numbers before it.
	 * @return: A list of prime number from 2 till n
	 * 
	 */
	@Override
	public boolean[] eratostenesCribAlgorithm(int n) {

		boolean prime[] = new boolean[n + 1];

		for (int i = 2; i <= (int) Math.floor(Math.sqrt(n)); i++) {
			if (prime[i] == false) {
				for (int j = i; j <= n / i; j++) {
					prime[j * i] = true;
				}
			}

		}

		return prime;
	}

	/**
	 * This method check the prime test, by the n-1 number basically searching for
	 * multiples of n
	 * 
	 * @param n = represents the given number;
	 * @return
	 */
	@Override
	public boolean[] tourAlgorithm(int n) {
		boolean prime[] = new boolean[n + 1];
		for (int i = 0; i < prime.length; i++) {
			prime[i] = true;
		}
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				prime[i] = false;
			}
		}
		return prime;
	}

	/**
	 * This is a method that check if a number is prime
	 * 
	 * @param n the number to check
	 * @return true if is prime , false if not
	 */
	public boolean isPrime(int n) {
		int i = n - 1;
		boolean isPrime = true;
		if (n > 2) {
			while (i > 1 && isPrime) {
				if (n % i != 0) {
					i -= 1;
				} else {
					isPrime = false;
				}
			}
		} else {
			isPrime = true;
		}

		return isPrime;
	}

	@Override
	/**
	 * This method allows to obtain a list of prime number from a simple analyze
	 * method. 
	 * @param: n, represents a maximum number to calculate the prime
	 * numbers before it. return: A list of prime number from 2 till n
	 */
	public boolean[] anSimpleFormAlgorithm(int n) {
		boolean prime[] = new boolean[n + 1];
		
		for (int i = 0; i < prime.length; i++) {
			prime[i] = true;
		}
		boolean isPrime;
		for (int i = 2; i <= n; i++) {
			isPrime = true;

			for (int j = 2; j <= (int) Math.sqrt(i) && isPrime; j++) {
				if (i % j == 0) {
					isPrime = false;
				}
			}

			if (isPrime) {
				prime[i] = false;
			}
		}
		return prime;
	}

}
