package sk.m3ii0.m4p1.code.global.objects;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

public class Jar implements AutoCloseable {
	
	private final JarFile jarFile;
	private final File file;
	
	public Jar(File jarFile) {
		if (!jarFile.getName().endsWith(".jar")) {
			throw new IllegalArgumentException("You can use here just .jar files!");
		}
		try {
			this.jarFile = new JarFile(jarFile);
			this.file = jarFile;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public File getFile() {
		return file;
	}
	
	public JarFile getJarFile() {
		return jarFile;
	}
	
	public List<String> getEntries() {
		List<String> entries = new ArrayList<>();
		Enumeration<JarEntry> rawEntries = jarFile.entries();
		while (rawEntries.hasMoreElements()) {
			JarEntry entry = rawEntries.nextElement();
			if (entry != null) {
				entries.add(entry.getName());
			}
		}
		return entries;
	}
	
	public ZipEntry getEntry(String entry) {
		return jarFile.getEntry(entry);
	}
	
	public InputStream getStream(String entry) {
		ZipEntry zipEntry = getEntry(entry);
		if (zipEntry == null) return null;
		if (zipEntry.isDirectory()) return null;
		try {
			return jarFile.getInputStream(zipEntry);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void save(String entry, String filePath) {
		save(entry, new File(filePath));
	}
	
	public void save(String entry, Path filePath) {
		save(entry, filePath.toFile());
	}
	
	public void save(String entry, File outputFile) {
		save(entry, outputFile, StandardCopyOption.COPY_ATTRIBUTES);
	}
	
	public void save(String entry, String filePath, CopyOption saveOption) {
		save(entry, new File(filePath), saveOption);
	}
	
	public void save(String entry, Path filePath, CopyOption saveOption) {
		save(entry, filePath.toFile(), saveOption);
	}
	
	public void save(String entry, File outputFile, CopyOption saveOption) {
		try (InputStream stream = getStream(entry)) {
			if (stream == null) return;
			File parent = outputFile.getParentFile();
			if (parent != null) {
				parent.mkdirs();
			}
			Files.copy(stream, outputFile.toPath(), saveOption);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void close() throws Exception {
		jarFile.close();
	}
	
}