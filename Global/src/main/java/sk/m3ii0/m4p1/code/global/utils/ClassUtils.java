package sk.m3ii0.m4p1.code.global.utils;

import sk.m3ii0.m4p1.code.global.objects.Jar;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.List;

public class ClassUtils {
	
	protected ClassUtils() throws IllegalAccessException {
		throw new IllegalAccessException("You cannot create new instance of this class!");
	}
	
	public static ClassLoader loadFromJarPath(String path) {
		return loadFromJar(new File(path), new URLClassLoader(new URL[]{}));
	}
	
	public static ClassLoader loadFromJarPath(Path path) {
		return loadFromJar(path.toFile(), new URLClassLoader(new URL[]{}));
	}
	
	public static ClassLoader loadFromJar(File jarFile) {
		return loadFromJar(jarFile, new URLClassLoader(new URL[]{}));
	}
	
	public static ClassLoader loadFromJarPath(String path, ClassLoader parent) {
		return loadFromJar(new File(path), parent);
	}
	
	public static ClassLoader loadFromJarPath(Path path, ClassLoader parent) {
		return loadFromJar(path.toFile(), parent);
	}
	
	public static ClassLoader loadFromJar(File jarFile, ClassLoader parent) {
		try (Jar jar = new Jar(jarFile)) {
			List<String> entries = jar.getEntries();
			entries.removeIf(line -> !line.endsWith(".class"));
			URL[] urls = new URL[] {new URL("jar:file:" + jarFile.getPath() + "!/")};
			try {
				URLClassLoader urlClassLoader = new URLClassLoader(urls, parent);
				for (String entry : entries) {
					try {
						entry = entry.replace("/", ".").substring(0, entry.length()-6);
						urlClassLoader.loadClass(entry);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				return urlClassLoader;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
