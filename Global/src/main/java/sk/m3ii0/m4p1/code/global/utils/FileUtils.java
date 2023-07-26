package sk.m3ii0.m4p1.code.global.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileUtils {
	
	protected FileUtils() throws IllegalAccessException {
		throw new IllegalAccessException("You cannot create new instance of this class!");
	}
	
	public static void createParentDirectories(File file) {
		File parent = file.getParentFile();
		if (parent != null) {
			parent.mkdirs();
		}
	}
	
	public static InputStream getFromFile(File file) {
		try {
			return new FileInputStream(file);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static InputStream getFromFilePath(String filePath) {
		return getFromFile(new File(filePath));
	}
	
	public static InputStream getFromFilePath(Path filePath) {
		return getFromFile(filePath.toFile());
	}
	
	public static InputStream getFromUrl(URL url) {
		try {
			return url.openStream();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static InputStream getFromUrl(String url) {
		try {
			return getFromUrl(new URL(url));
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Path fromFile(File file) {
		return file.toPath();
	}
	
	public static File fromPath(Path path) {
		return path.toFile();
	}
	
	public static void save(InputStream stream, File outputFile, CopyOption option) {
		try {
			createParentDirectories(outputFile);
			Files.copy(stream, outputFile.toPath(), option);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void save(InputStream stream, String outputFilePath, CopyOption option) {
		save(stream, new File(outputFilePath), option);
	}
	
	public static void save(InputStream stream, Path outputFilePath, CopyOption option) {
		save(stream, outputFilePath.toFile(), option);
	}
	
	public static void save(InputStream stream, File outputFile) {
		save(stream, outputFile, StandardCopyOption.COPY_ATTRIBUTES);
	}
	
	public static void save(InputStream stream, String outputFilePath) {
		save(stream, new File(outputFilePath), StandardCopyOption.COPY_ATTRIBUTES);
	}
	
	public static void save(InputStream stream, Path outputFilePath) {
		save(stream, outputFilePath.toFile(), StandardCopyOption.COPY_ATTRIBUTES);
	}
	
	public static void save(File file, File outputFile, CopyOption option) {
		save(getFromFile(file), outputFile, option);
	}
	
	public static void save(File file, String outputFilePath, CopyOption option) {
		save(getFromFile(file), new File(outputFilePath), option);
	}
	
	public static void save(File file, Path outputFilePath, CopyOption option) {
		save(getFromFile(file), outputFilePath.toFile(), option);
	}
	
	public static void save(File file, File outputFile) {
		save(getFromFile(file), outputFile, StandardCopyOption.COPY_ATTRIBUTES);
	}
	
	public static void save(File file, String outputFilePath) {
		save(getFromFile(file), new File(outputFilePath), StandardCopyOption.COPY_ATTRIBUTES);
	}
	
	public static void save(File file, Path outputFilePath) {
		save(getFromFile(file), outputFilePath.toFile(), StandardCopyOption.COPY_ATTRIBUTES);
	}
	
	public static void copy(File input, File output, CopyOption option) {
		try (InputStream stream = getFromFile(input)) {
			save(stream, output, option);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void copy(String input, File output, CopyOption option) {
		copy(new File(input), output, option);
	}

	public static void copy(File input, String output, CopyOption option) {
		copy(input, new File(output), option);
	}
	
	public static void copy(String input, String output, CopyOption option) {
		copy(new File(input), new File(output), option);
	}
	
	public static void copy(File input, File output) {
		copy(input, output, StandardCopyOption.COPY_ATTRIBUTES);
	}
	
	public static void copy(String input, File output) {
		copy(new File(input), output, StandardCopyOption.COPY_ATTRIBUTES);
	}
	
	public static void copy(File input, String output) {
		copy(input, new File(output), StandardCopyOption.COPY_ATTRIBUTES);
	}
	
	public static void copy(String input, String output) {
		copy(new File(input), new File(output), StandardCopyOption.COPY_ATTRIBUTES);
	}
	
	public static void move(File from, File to) {
		try {
			createParentDirectories(to);
			Files.move(from.toPath(), to.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void move(String from, File to) {
		move(new File(from), to);
	}
	
	public static void move(File from, String to) {
		move(from, new File(to));
	}
	
	public static void move(String from, String to) {
		move(new File(from), new File(to));
	}
	
	public static void download(String url, File location) {
		try {
			download(new URL(url), location);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void download(URL url, String location) {
		download(url, new File(location));
	}
	
	public static void download(URL url, File location) {
		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			createParentDirectories(location);
			try (InputStream stream = connection.getInputStream()) {
				Files.copy(stream, location.toPath());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
