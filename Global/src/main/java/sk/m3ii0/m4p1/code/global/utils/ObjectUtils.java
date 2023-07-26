package sk.m3ii0.m4p1.code.global.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectUtils {
	
	protected ObjectUtils() throws IllegalAccessException {
		throw new IllegalAccessException("You cannot create new instance of this class!");
	}
	
	public static <T> T[] addToArray(T[] first, T... second) {
		if (first == null || first.length == 0)
			return second;
		if (second == null || second.length == 0)
			return first;
		T[] result = newInstance(first.getClass().getComponentType(), first.length + second.length);
		System.arraycopy(first, 0, result, 0, first.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}
	
	public static <T> T[] sumArrays(T[]... arrays) {
		if (arrays == null) {
			throw new NullPointerException("Array cannot be null");
		}
		if (arrays.length == 0) {
			return newInstance(arrays.getClass().getComponentType().getComponentType(), 0);
		}
		int totalSize = 0;
		for (T[] ts : arrays) {
			totalSize += ts.length;
		}
		T[] result = newInstance(arrays.getClass().getComponentType().getComponentType(), totalSize);
		int endPos = 0;
		for (T[] array : arrays) {
			System.arraycopy(array, 0, result, endPos, array.length);
			endPos += array.length;
		}
		return result;
	}
	
	public static <T> T pickRandom(List<T> selection) {
		int max = selection.size();
		return selection.get(MathUtils.generateRandomInt(0, max-1));
	}
	
	public static <T> T pickRandom(T[] selection) {
		int max = selection.length;
		return selection[MathUtils.generateRandomInt(0, max-1)];
	}
	
	public static <T> List<T> convertFromArray(T[] array) {
		return new ArrayList<>(Arrays.asList(array));
	}
	
	public static <T> T[] convertFromList(List<T> list) {
		if (list.isEmpty()) throw new IllegalArgumentException("List cannot be empty!");
		T first = list.get(0);
		T[] array = newInstance(first.getClass(), list.size());
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}
	
	private static <T> T[] newInstance(Class<?> clazz, int size) {
		return (T[]) (clazz == Object[].class ? new Object[size] : Array.newInstance(clazz, size));
	}
	
}
