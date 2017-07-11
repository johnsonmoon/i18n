package xuyihao.i18n;

import xuyihao.i18n.exception.I18nException;

/**
 * 多语言本地初始化(使用Spring即可)
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
