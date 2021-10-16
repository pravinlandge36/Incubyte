package test.java.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.calculator.StringCalculator;

public class StringCalculatorShould {

	@Test
	void emptyStringShouldReturn_0() {
		StringCalculator stringCalculator = new StringCalculator();
		// for empty string it will return 0
		assertEquals(0, stringCalculator.add(""));
	}

	@Test
	void stringWithSingleNumberShouldReturnNumberAsInt() {
		StringCalculator stringCalculator = new StringCalculator();
		// String with single number will return that number.
		assertEquals(1, stringCalculator.add("1"));
	}

	@Test
	void stringWithTwoNumberCommaDelimterReturnNumberAsSum() {
		StringCalculator stringCalculator = new StringCalculator();
		// return sum of comma seperated numbers
		assertEquals(3, stringCalculator.add("1,2"));
	}

	@Test
	void stringWithUnknownNumberWithCommaDelimterReturnNumberAsSum() {
		StringCalculator stringCalculator = new StringCalculator();
		// Allow the Add method to handle an unknown amount of numbers
		assertEquals(10, stringCalculator.add("1,2,3,4"));
	}

	@Test
	void stringWithNewLinesAndCommBetweenNumbersAndReturnSum() {
		StringCalculator stringCalculator = new StringCalculator();
		// Allow the Add method to handle new lines between numbers (instead of commas)
		assertEquals(6, stringCalculator.add("1\n2,3"));
	}

	@Test()
	void stringWithWithNegativeNumberThrowException() {
		StringCalculator stringCalculator = new StringCalculator();
		// Calling Add with a negative number will throw an exception “negatives not
		// allowed” -and the negative that was passed.
		try {
			stringCalculator.add("3,-6,15,18,46,33");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test()
	void stringWithWithMultipleNegativeNumberThrowException() {
		StringCalculator stringCalculator = new StringCalculator();
		// If there are multiple negatives, show all of them in the exception message
		try {
			stringCalculator.add("3,-6,15,18,-46,33");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void stringWithNumbersBiggerThan1000ShouldBeIgnored() {
		StringCalculator stringCalculator = new StringCalculator();
		// Numbers bigger than 1000 should be ignored
		assertEquals(2, stringCalculator.add("2,1001"));
	}

	@Test
	void stringWithAllowMultipleDelimiters() {
		StringCalculator stringCalculator = new StringCalculator();
		// Allow multiple delimiters like this:
		assertEquals(6, stringCalculator.add1("//[*][%]\\n1*2%3"));
	}

	@Test
	void stringWithDelimeterAnyLength() {
		StringCalculator stringCalculator = new StringCalculator();
		// Delimiters can be of any length.
		// . make sure you can also handle multiple delimiters with length longer than
		// one char
		// for example
		// “//[**][%%]\n1**2%%3” == 6.
		assertEquals(6, stringCalculator.add1("//[***]\\n1***2***3"));
	}

}