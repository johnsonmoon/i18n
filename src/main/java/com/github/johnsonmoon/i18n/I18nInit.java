package com.github.johnsonmoon.i18n;

import com.github.johnsonmoon.i18n.exception.I18nException;

/**
 * Initialization of i18n.
 * 
 * Created by xuyh at 2017年7月11日 下午3:33:37.
 */
public class I18nInit {
	public static I18nInit getInstance(String defaultLanguage, String languageResourceFilePath) {
		return new I18nInit(defaultLanguage, languageResourceFilePath);
	}

	private String defaultLanguage;
	private String languageResourceFilePath;

	public I18nInit(String defaultLanguage, String languageResourceFilePath) {
		this.defaultLanguage = defaultLanguage;
		this.languageResourceFilePath = languageResourceFilePath;
	}

	public void init() throws I18nException {
		I18nUtils.init(defaultLanguage, languageResourceFilePath);
	}
}
