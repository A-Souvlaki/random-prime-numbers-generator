package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import model.GenerateNumbers;

class GenerateNumbersTest {

	private GenerateNumbers e;
	
	private boolean[] hundred;
	
	private boolean[] aThousand;

	private boolean[] tenThousands;


	@BeforeClass
	void setUpScenary1() {
		e = new GenerateNumbers();
		hundred = e.eratostenesCribAlgorithm(100);
		aThousand = e.eratostenesCribAlgorithm(1000);
		tenThousands = e.eratostenesCribAlgorithm(10000);

	}
	/**
	 * This test would test the method eratostenesCribAlgorithm with 100 numbers
	 */
	@Test
	void test0Crib() {
		setUpScenary1();
		boolean[] expected = hundred;
		boolean [] actual = e.eratostenesCribAlgorithm(100);
		for (int i = 0; i < expected.length; i++) {
			assertEquals(actual[i], expected[i]);
		}
		
	}
	
	/**
	 * This test would test the method eratostenesCribAlgorithm with 1000 numbers
	 */
	@Test
	void test1Crib() {
		setUpScenary1();
		boolean[] expected = aThousand;
		boolean [] actual = e.eratostenesCribAlgorithm(1000);
		for (int i = 0; i < expected.length; i++) {
			assertEquals(actual[i], expected[i]);
		}
		
	}
	/**
	 * This test would test the method eratostenesCribAlgorithm with 10000 numbers
	 */
	@Test
	void test2Crib() {
		setUpScenary1();
		boolean[] expected = tenThousands;
		boolean [] actual = e.eratostenesCribAlgorithm(10000);
		for (int i = 0; i < expected.length; i++) {
			assertEquals(actual[i], expected[i]);
		}
		
	}
	
	/**
	 * This test would test the method tourAlgorithm with 100 numbers
	 */
	@Test
	void test0Tour() {
		setUpScenary1();
		boolean[] expected = hundred;
		boolean [] actual = e.tourAlgorithm(100);
		for (int i = 2; i < expected.length; i++) {
			
			assertEquals(actual[i], expected[i]);
		}
		
	}
	
	/**
	 * This test would test the method tourAlgorithm with 1000 numbers
	 */
	@Test
	void test1Tour() {
		setUpScenary1();
		boolean[] expected = aThousand;
		boolean [] actual = e.tourAlgorithm(1000);
		for (int i = 2; i < expected.length; i++) {
			assertEquals(actual[i], expected[i]);
			
		}
		
	}
	/**
	 * This test would test the method tourAlgorithm with 10000 numbers
	 */
	@Test
	void test2Tour() {
		setUpScenary1();
		boolean[] expected = tenThousands;
		boolean [] actual = e.tourAlgorithm(10000);
		for (int i = 2; i < expected.length; i++) {
			assertEquals(actual[i], expected[i]);
		}
		
	}
	
	/**
	 * This test would test the method anSimpleFormAlgorithm with 100 numbers
	 */
	@Test
	void test0Simple() {
		setUpScenary1();
		boolean[] expected = hundred;
		boolean [] actual = e.anSimpleFormAlgorithm(100);
		for (int i = 2; i < expected.length; i++) {
			
			assertEquals(actual[i], expected[i]);
		}
		
	}
	
	/**
	 * This test would test the method anSimpleFormAlgorithm with 1000 numbers
	 */
	@Test
	void test1Simple() {
		setUpScenary1();
		boolean[] expected = aThousand;
		boolean [] actual = e.anSimpleFormAlgorithm(1000);
		for (int i = 2; i < expected.length; i++) {
			assertEquals(actual[i], expected[i]);
			
		}
		
	}
	/**
	 * This test would test the method anSimpleFormAlgorithm with 10000 numbers
	 */
	@Test
	void test2Simple() {
		setUpScenary1();
		boolean[] expected = tenThousands;
		boolean [] actual = e.anSimpleFormAlgorithm(10000);
		for (int i = 2; i < expected.length; i++) {
			assertEquals(actual[i], expected[i]);
		}
		
	}
}
