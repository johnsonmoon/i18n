package com.github.johnsonmoon.i18n.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.johnsonmoon.i18n.exception.I18nException;
import com.github.johnsonmoon.i18n.utils.SourceFileReader;

/**
 * Cache for i18n messages
 * <p>
 * Created by xuyh at 2017/7/11 14:41.
 */
public class I18nObjectsHolder {
	/**
	 * Cache
	 */
	private static Map<String, I18nObjects> i18nObjectsMapCache = new HashMap<>();

	/**
	 * Get value of message code in language
	 *
	 * @param language language
	 * @param code     message code
	 */
	public static String getMessage(String language, String code) {
		return i18nObjectsMapCache.get(language).getMessage(code);
	}

	/**
	 * Get formatted value of message code in language
	 *
	 * @param language language
	 * @param code     message code
	 * @param args     format values
	 */
	public static String getMessage(String language, String code, Object... args) {
		return String.format(i18nObjectsMapCache.get(language).getMessage(code), args);
	}

	/**
	 * get languages that already exist
	 */
	public static List<String> getLanguages() {
		return new ArrayList<String>(i18nObjectsMapCache.keySet());
	}

	/**
	 * initialize language code-value into Cache
	 */
	public static void initObjects() throws I18nException {
		String sourcesFilePath = System.getProperty(Constances.I18N_SOURCES_FILE_PATH);
		List<I18nObjects> i18nObjectList = SourceFileReader.readSourceFiles(sourcesFilePath);
		if (i18nObjectList == null || i18nObjectList.isEmpty()) {
			throw new I18nException("I18n message sources files not found!");
		}
		for (I18nObjects i18nObjects : i18nObjectList) {
			I18nObjects existingI18nObjects = i18nObjectsMapCache.get(i18nObjects.getLanguage());
			if (existingI18nObjects == null) {
				i18nObjectsMapCache.put(i18nObjects.getLanguage(), i18nObjects);
			} else {
				existingI18nObjects.addMessages(i18nObjects.getMessages());
			}
		}
	}
}
