package sk.m3ii0.m4p1.code.global.utils;

import java.util.List;

public class TextUtils {
	
	protected TextUtils() throws IllegalAccessException {
		throw new IllegalAccessException("You cannot create new instance of this class!");
	}
	
	public static String createText(String[] array, String between) {
		StringBuilder stringBuilder = new StringBuilder();
		for (String var : array) {
			stringBuilder.append(var).append(between);
		}
		String result = stringBuilder.toString();
		int cut = result.length() - between.length();
		return result.substring(0, cut);
	}
	
	public static String createText(List<String> list, String between) {
		StringBuilder stringBuilder = new StringBuilder();
		for (String var : list) {
			stringBuilder.append(var).append(between);
		}
		String result = stringBuilder.toString();
		int cut = result.length() - between.length();
		return result.substring(0, cut);
	}
	
	public static String createText(String[] array, String between, int start) {
		String[] cut = new String[array.length-start];
		System.arraycopy(array, start, cut, 0, cut.length);
		return createText(cut, between);
	}
	
	public static String createText(List<String> list, String between, int start) {
		return createText(list.subList(start, list.size()), between);
	}
	
	public static String createSpacedText(String[] array) {
		return createText(array, " ");
	}
	
	public static String createSpacedText(List<String> list) {
		return createText(list, " ");
	}
	
	public static List<String> copyAllStartingWith(String start, List<String> input) {
		input.removeIf(line -> !line.startsWith(start));
		return input;
	}
	
	public static List<String> copyAllEndingWith(String end, List<String> input) {
		input.removeIf(line -> !line.endsWith(end));
		return input;
	}
	
	public static List<String> copyAllContains(String contain, List<String> input) {
		input.removeIf(line -> !line.contains(contain));
		return input;
	}
	
}
