package com.github.johnsonmoon.i18n.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.johnsonmoon.i18n.entity.I18nObjects;
import com.github.johnsonmoon.i18n.exception.I18nException;

/**
 * I18n message code-value resource file reader.
 * <p>
 * Created by xuyh at 2017/7/11 14:25.
 */
public class SourceFileReader {
	private static final Pattern sourceFilePattern = Pattern.compile(".*-(.*)\\.properties");

	/**
	 * read source file content
	 */
	public static List<I18nObjects> readSourceFiles(String filePath) throws I18nException {
		List<I18nObjects> i18nObjectsList = new ArrayList<>();

		List<File> files = new ArrayList<>();
		if (filePath != null && !filePath.isEmpty()) {
			List<File> result = listByFileDir(new File(filePath));
			if (result != null && !result.isEmpty()) {
				files.addAll(result);
			}
		}

		if (!files.isEmpty()) {
			for (File file : files) {
				I18nObjects i18nObjects = read(file);
				if (i18nObjects == null) {
					continue;
				}
				i18nObjectsList.add(i18nObjects);
			}
		}
		return i18nObjectsList;
	}

	/**
	 * Get files that matches multi conditions in directory.
	 */
	private static List<File> listByFileDir(File dir) throws I18nException {
		if (dir == null) {
			return null;
		}
		if (!dir.isDirectory()) {
			throw new I18nException("Expected a dir, but not: '{%s}'", dir.getPath());
		}
		if (!dir.isAbsolute()) {
			throw new I18nException("Expected a absolute path, bu not: '{%s}'", dir.getPath());
		}

		File[] files = dir.listFiles(file -> file.getName().endsWith(".properties"));
		if (files == null || files.length == 0) {
			return null;
		}

		List<File> filesArray = new ArrayList<>();
		for (File file : files) {
			filesArray.add(file);
		}
		return filesArray;
	}

	/**
	 * Read resource file.
	 */
	private static I18nObjects read(File file) throws I18nException {
		if (file == null) {
			return null;
		}
		String language = retrieveLang(file);
		if (language == null) {
			throw new I18nException("File name error, correct form: xxx-en_US.properties.");
		}
		Properties props = readContent(file);
		if (props.isEmpty()) {
			throw new I18nException("File format error or file not exists.");
		}
		I18nObjects i18nObjects = new I18nObjects(language);
		for (String key : props.stringPropertyNames()) {
			i18nObjects.addMessage(key, props.getProperty(key));
		}
		return i18nObjects;
	}

	/**
	 * read file in properties format with charset "utf-8"
	 */
	private static Properties readContent(File file) throws I18nException {
		Properties properties = new Properties();
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(file)));
			properties.load(reader);
		} catch (IOException e) {
			throw new I18nException("Faile to read content from file: " + file, e);
		}
		return properties;
	}

	/**
	 * Get language of a resource file.
	 */
	private static String retrieveLang(File file) {
		Matcher match = sourceFilePattern.matcher(file.getPath());
		if (match.matches() && match.groupCount() > 0) {
			return match.group(1);
		}
		return null;
	}
}
