package main.java.calculator;

import static org.hamcrest.CoreMatchers.containsString;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	private final String delimeter = ",|\n";

	public int add(String input) {
		String[] numbers = input.split(delimeter);
		if (isEmpty(input)) {
			return 0;
		} else {
			return stringToIntegerConvertor(numbers);
		}

	}

	// cheacking string is empty
	private boolean isEmpty(String input) {
		return input.isEmpty();
	}

	// for String to integer convert
	private int stringToIntegerConvertor(String[] numbers) throws RuntimeException {
		List<Integer> list = new ArrayList<>();
		for (String num : numbers) {
			if (Integer.parseInt(num) <= 0) {
				// throw new RuntimeException("Negatives Numbers not allowed");
				list.add(Integer.parseInt(num));
			}
		}
		if (list.size() > 0) {
			throw new RuntimeException("Negatives Numbers not allowed" + list.toString());
		}
		int sum = 0;
		for (String num : numbers) {
			if (Integer.parseInt(num) > 1000) {
				continue;
			}
			sum += Integer.parseInt(num);
		}
		return sum;
	}

	public Object add1(String input) {
		int sum = 0;
		for (int i = 0; i < input.length(); i++) {
			if (Character.isDigit(input.charAt(i))) {

				sum += Integer.parseInt(Character.toString(input.charAt(i)));
			}
		}
		return sum;
	}

}