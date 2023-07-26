package sk.m3ii0.m4p1.code.global.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MathUtils {
	
	private static final Random random = new Random();
	private static final DecimalFormat defaultFormat = new DecimalFormat("#.###");
	
	protected MathUtils() throws IllegalAccessException {
		throw new IllegalAccessException("You cannot create new instance of this class!");
	}
	
	public static List<Number> selectAllBiggerThan(Number[] numbers, Number limit) {
		List<Number> result = new ArrayList<>();
		for (Number number : numbers) {
			if (number.doubleValue() > limit.doubleValue()) {
				result.add(number);
			}
		}
		return result;
	}
	
	public static List<Number> selectAllLowerThan(Number[] numbers, Number limit) {
		List<Number> result = new ArrayList<>();
		for (Number number : numbers) {
			if (number.doubleValue() < limit.doubleValue()) {
				result.add(number);
			}
		}
		return result;
	}
	
	public static List<Number> selectAllBiggerAndEqualThan(Number[] numbers, Number limit) {
		List<Number> result = new ArrayList<>();
		for (Number number : numbers) {
			if (number.doubleValue() >= limit.doubleValue()) {
				result.add(number);
			}
		}
		return result;
	}
	
	public static List<Number> selectAllLowerAndEqualThan(Number[] numbers, Number limit) {
		List<Number> result = new ArrayList<>();
		for (Number number : numbers) {
			if (number.doubleValue() <= limit.doubleValue()) {
				result.add(number);
			}
		}
		return result;
	}
	
	public static double[] generateLinear(double from, double to, int max) {
		final double[] res = new double[max];
		for (int i = 0; i < max; i++) {
			res[i] = from + i * ((to - from) / (max - 1));
		}
		return res;
	}
	
	public static double[] generateQuadratic(double from, double to, int max) {
		final double[] results = new double[max];
		double a = (from - to) / (max * max);
		double b = -2 * a * max;
		for (int i = 0; i < results.length; i++) {
			results[i] = a * i * i + b * i + (double) 0;
		}
		return results;
	}
	
	public static int generateRandomInt() {
		return generateRandomInt(0, 100);
	}
	
	public static int generateRandomInt(int max) {
		return generateRandomInt(0, max);
	}
	
	public static int generateRandomInt(int min, int max) {
		return random.nextInt((max - min) + 1) + min;
	}
	
	public static double generateRandomDouble() {
		return generateRandomDouble(0.0, 100.0);
	}
	
	public static double generateRandomDouble(double max) {
		return generateRandomDouble(0.0, max);
	}
	
	public static double generateRandomDouble(double min, double max) {
		return generateRandomDouble(min, max, "#.###");
	}
	
	public static double generateRandomDouble(double min, double max, String format) {
		double result = generateRandomInt((int) min, (int) max)-1 + random.nextDouble();
		if (format.equals("#.###")) {
			return Double.parseDouble(defaultFormat.format(result).replace(",", "."));
		}
		DecimalFormat decimalFormat = new DecimalFormat(format);
		return Double.parseDouble(decimalFormat.format(result).replace(",", "."));
	}
	
	public static long generateRandomLong() {
		return random.nextLong();
	}
	
	public static float generateRandomFloat() {
		return random.nextFloat();
	}
	
	public static boolean percentage(int percentage) {
		if (percentage > 100) return true;
		return generateRandomInt(0, 100) < percentage;
	}
	
	public static boolean percentage(double percentage) {
		if (percentage > 100.0) return true;
		return generateRandomDouble(0.0, 100.0) < percentage;
	}
	
}
