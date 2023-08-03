package sk.m3ii0.m4p1.code.global.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RefUtils {
	
	protected RefUtils() throws IllegalAccessException {
		throw new IllegalAccessException("You cannot create new instance of this class!");
	}
	
	public static Class<?> getClass(String className, boolean initialize, ClassLoader classLoader) {
		try {
			return Class.forName(className, initialize, classLoader);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Class<?> getClass(String className) {
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Field getDeclaredField(Class<?> object, String field, boolean invoke) {
		try {
			Field field1 = object.getDeclaredField(field);
			if (invoke) field1.setAccessible(true);
			return field1;
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Constructor<?> getDeclaredConstructor(Class<?> object, boolean invoke, Class<?>... args) {
		try {
			Constructor<?> constructor = object.getDeclaredConstructor(args);
			if (invoke) constructor.setAccessible(true);
			return constructor;
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Method getDeclaredMethod(Class<?> objects, String method, boolean invoke, Class<?>... args) {
		try {
			Method method1 = objects.getDeclaredMethod(method, args);
			if (invoke) method1.setAccessible(true);
			return method1;
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Object getStaticObject(Method method, boolean invoke, Object... args) {
		try {
			if (invoke) method.setAccessible(true);
			return method.invoke(null, args);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Object newInstance(Constructor<?> constructor, boolean invoke, Object... args) {
		try {
			if (invoke) constructor.setAccessible(true);
			return constructor.newInstance(args);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Field getDeclaredField(Class<?> object, String field) {
		return getDeclaredField(object, field, false);
	}
	
	public static Constructor<?> getDeclaredConstructor(Class<?> object, Class<?>... args) {
		return getDeclaredConstructor(object, false, args);
	}
	
	public static Method getDeclaredMethod(Class<?> objects, String method, Class<?>... args) {
		return getDeclaredMethod(objects, method, false, args);
	}
	
	public static Object getStaticObject(Method method, Object... args) {
		return getStaticObject(method, false, args);
	}
	
	public static Field[] getDeclaredFields(Class<?> object) {
		return object.getDeclaredFields();
	}
	
	public static Constructor<?>[] getConstructors(Class<?> object) {
		return object.getConstructors();
	}
	
	public static Method[] getDeclaredMethods(Class<?> object) {
		return object.getDeclaredMethods();
	}
	
	public static Object newInstance(Constructor<?> constructor, Object... args) {
		return newInstance(constructor, false, args);
	}
	
}
