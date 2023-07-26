package sk.m3ii0.m4p1.code.global.utils;

import java.util.List;

public class RandomUtils {
	
	protected RandomUtils() throws IllegalAccessException {
		throw new IllegalAccessException("You cannot create new instance of this class!");
	}
	
	public static <T> T pickRandom(List<T> selection) {
		int max = selection.size();
		return selection.get(MathUtils.generateRandomInt(0, max-1));
	}
	
	public static <T> T pickRandom(T[] selection) {
		int max = selection.length;
		return selection[MathUtils.generateRandomInt(0, max-1)];
	}
	
}
