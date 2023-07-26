package sk.m3ii0.m4p1.code.global.utils;

import sk.m3ii0.m4p1.code.global.objects.Jar;

import java.io.File;
import java.nio.file.CopyOption;
import java.nio.file.StandardCopyOption;

public class JarUtils {
	
	protected JarUtils() throws IllegalAccessException {
		throw new IllegalAccessException("You cannot create new instance of this class!");
	}
	
	public static void saveFromJar(File jarFile, String entry, File outputFile) {
		saveFromJar(jarFile, entry, outputFile, StandardCopyOption.COPY_ATTRIBUTES);
	}
	
	public static void saveFromJar(String jarFilePath, String entry, File outputFile) {
		saveFromJar(new File(jarFilePath), entry, outputFile);
	}
	
	public static void saveFromJar(File jarFile, String entry, String outputFilePath) {
		saveFromJar(jarFile, entry, new File(outputFilePath));
	}
	
	public static void saveFromJar(String jarFilePath, String entry, String outputFile) {
		saveFromJar(new File(jarFilePath), entry, new File(outputFile));
	}
	
	public static void saveFromJar(File jarFile, String entry, File outputFile, CopyOption saveOption) {
		try (Jar jar = new Jar(jarFile)) {
			jar.save(entry, outputFile, saveOption);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void saveFromJar(String jarFilePath, String entry, File outputFile, CopyOption saveOption) {
		saveFromJar(new File(jarFilePath), entry, outputFile, saveOption);
	}
	
	public static void saveFromJar(File jarFile, String entry, String outputFilePath, CopyOption saveOption) {
		saveFromJar(jarFile, entry, new File(outputFilePath), saveOption);
	}
	
	public static void saveFromJar(String jarFilePath, String entry, String outputFile, CopyOption saveOption) {
		saveFromJar(new File(jarFilePath), entry, new File(outputFile), saveOption);
	}
	
	public static void saveDirectoryFromJar(String jarFile, String directory, String outputDirectory) {
		saveDirectoryFromJar(new File(jarFile), new File(directory), new File(outputDirectory), StandardCopyOption.COPY_ATTRIBUTES);
	}
	
	public static void saveDirectoryFromJar(String jarFile, File directory, String outputDirectory) {
		saveDirectoryFromJar(new File(jarFile), directory, new File(outputDirectory), StandardCopyOption.COPY_ATTRIBUTES);
	}
	
	public static void saveDirectoryFromJar(String jarFile, String directory, File outputDirectory) {
		saveDirectoryFromJar(new File(jarFile), new File(directory), outputDirectory, StandardCopyOption.COPY_ATTRIBUTES);
	}
	
	public static void saveDirectoryFromJar(File jarFile, String directory, String outputDirectory) {
		saveDirectoryFromJar(jarFile, new File(directory), new File(outputDirectory), StandardCopyOption.COPY_ATTRIBUTES);
	}
	
	public static void saveDirectoryFromJar(File jarFile, File directory, String outputDirectory) {
		saveDirectoryFromJar(jarFile, directory, new File(outputDirectory), StandardCopyOption.COPY_ATTRIBUTES);
	}
	
	public static void saveDirectoryFromJar(File jarFile, String directory, File outputDirectory) {
		saveDirectoryFromJar(jarFile, new File(directory), outputDirectory, StandardCopyOption.COPY_ATTRIBUTES);
	}
	
	public static void saveDirectoryFromJar(String jarFile, File directory, File outputDirectory) {
		saveDirectoryFromJar(new File(jarFile), directory, outputDirectory, StandardCopyOption.COPY_ATTRIBUTES);
	}
	
	public static void saveDirectoryFromJar(File jarFile, File directory, File outputDirectory) {
		saveDirectoryFromJar(jarFile, directory, outputDirectory, StandardCopyOption.COPY_ATTRIBUTES);
	}
	
	public static void saveDirectoryFromJar(String jarFile, String directory, String outputDirectory, CopyOption saveOption) {
		saveDirectoryFromJar(new File(jarFile), new File(directory), new File(outputDirectory), saveOption);
	}
	
	public static void saveDirectoryFromJar(String jarFile, File directory, String outputDirectory, CopyOption saveOption) {
		saveDirectoryFromJar(new File(jarFile), directory, new File(outputDirectory), saveOption);
	}
	
	public static void saveDirectoryFromJar(String jarFile, String directory, File outputDirectory, CopyOption saveOption) {
		saveDirectoryFromJar(new File(jarFile), new File(directory), outputDirectory, saveOption);
	}
	
	public static void saveDirectoryFromJar(File jarFile, String directory, String outputDirectory, CopyOption saveOption) {
		saveDirectoryFromJar(jarFile, new File(directory), new File(outputDirectory), saveOption);
	}
	
	public static void saveDirectoryFromJar(File jarFile, File directory, String outputDirectory, CopyOption saveOption) {
		saveDirectoryFromJar(jarFile, directory, new File(outputDirectory), saveOption);
	}
	
	public static void saveDirectoryFromJar(File jarFile, String directory, File outputDirectory, CopyOption saveOption) {
		saveDirectoryFromJar(jarFile, new File(directory), outputDirectory, saveOption);
	}
	
	public static void saveDirectoryFromJar(String jarFile, File directory, File outputDirectory, CopyOption saveOption) {
		saveDirectoryFromJar(new File(jarFile), directory, outputDirectory, saveOption);
	}
	
	public static void saveDirectoryFromJar(File jarFile, File directory, File outputDirectory, CopyOption saveOption) {
		try (Jar jar = new Jar(jarFile)) {
			String startsWith = directory.getPath();
			for (String var : jar.getEntries()) {
				if (!var.startsWith(startsWith)) continue;
				jar.save(var, new File(outputDirectory, var), saveOption);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getJarFilePathFromMainClass(Class<?> mainClass) {
		return mainClass.getProtectionDomain().getCodeSource().getLocation().getFile();
	}
	
	public static File getJarFileFromMainClass(Class<?> mainClass) {
		return new File(getJarFilePathFromMainClass(mainClass));
	}
	
}
