package com.github.johnsonmoon.i18n;

import java.util.List;

import com.github.johnsonmoon.i18n.entity.Constances;
import com.github.johnsonmoon.i18n.entity.I18nObjectsHolder;
import com.github.johnsonmoon.i18n.exception.I18nException;

/**
 * Utilities of i18n.
 * <p>
 * Created by xuyh at 2017/7/11 14:16.
 */
public class I18nUtils {
	private static String defaultLanguage;

	public static void init(String defaultLanguage, String languageResourceFilePath) throws I18nException {
		I18nUtils.defaultLanguage = defaultLanguage;
		System.setProperty(Constances.I18N_SOURCES_FILE_PATH, languageResourceFilePath);
		I18nObjectsHolder.initObjects();
	}

	public static String getDefaultLanguage() {
		return defaultLanguage;
	}

	public static void setDefaultLanguage(String defaultLanguage) {
		I18nUtils.defaultLanguage = defaultLanguage;
	}

	/**
	 * Get i18n message by code in language.
	 *
	 * @param language language
	 * @param code     message code
	 */
	public static String getMessage(String language, String code) {
		if (language == null || language.isEmpty())
			language = defaultLanguage;
		if (!hasLanguage(language))
			language = defaultLanguage;
		return I18nObjectsHolder.getMessage(language, code);
	}

	/**
	 * Get i18n message by code in language with format.
	 *
	 * @param language language
	 * @param code     message code
	 * @param args     format args
	 */
	public static String getMessage(String language, String code, Object... args) {
		if (language == null || language.isEmpty())
			language = defaultLanguage;
		if (!hasLanguage(language))
			language = defaultLanguage;
		return I18nObjectsHolder.getMessage(language, code, args);
	}

	/**
	 * Get languages that exist
	 */
	public static List<String> getLanguages() {
		return I18nObjectsHolder.getLanguages();
	}

	/**
	 * Whether i18n framework support the given language.
	 *
	 * @param language language to check
	 */
	public static boolean hasLanguage(String language) {
		return I18nObjectsHolder.getLanguages().contains(language);
	}
}
