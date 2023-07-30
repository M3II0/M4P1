package sk.m3ii0.m4p1.code.global.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectUtils {
	
	protected ObjectUtils() throws IllegalAccessException {
		throw new IllegalAccessException("You cannot create new instance of this class!");
	}
	
	public static <U> U[] addToArray(U[] first, U... second) {
		if (first == null || first.length == 0)
			return second;
		if (second == null || second.length == 0)
			return first;
		U[] result = newInstance(first.getClass().getComponentType(), first.length + second.length);
		System.arraycopy(first, 0, result, 0, first.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}
	
	public static <U> U[] sumArrays(U[]... arrays) {
		if (arrays == null) {
			throw new NullPointerException("Array cannot be null");
		}
		if (arrays.length == 0) {
			return newInstance(arrays.getClass().getComponentType().getComponentType(), 0);
		}
		int totalSize = 0;
		for (U[] ts : arrays) {
			totalSize += ts.length;
		}
		U[] result = newInstance(arrays.getClass().getComponentType().getComponentType(), totalSize);
		int endPos = 0;
		for (U[] array : arrays) {
			System.arraycopy(array, 0, result, endPos, array.length);
			endPos += array.length;
		}
		return result;
	}
	
	public static <U> U pickRandom(List<U> selection) {
		int max = selection.size();
		return selection.get(MathUtils.generateRandomInt(0, max-1));
	}
	
	public static <U> U pickRandom(U[] selection) {
		int max = selection.length;
		return selection[MathUtils.generateRandomInt(0, max-1)];
	}
	
	public static <U> List<U> convertFromArray(U[] array) {
		return new ArrayList<>(Arrays.asList(array));
	}
	
	public static <U> U[] convertFromList(List<U> list) {
		if (list.isEmpty()) throw new IllegalArgumentException("List cannot be empty!");
		U first = list.get(0);
		U[] array = newInstance(first.getClass(), list.size());
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}
	
	private static <U> U[] newInstance(Class<?> clazz, int size) {
		return (U[]) (clazz == Object[].class ? new Object[size] : Array.newInstance(clazz, size));
	}
	
}
