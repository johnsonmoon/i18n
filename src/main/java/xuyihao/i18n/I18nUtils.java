package xuyihao.i18n;

import java.util.List;

import xuyihao.i18n.entity.Constances;
import xuyihao.i18n.entity.I18nObjectsHolder;
import xuyihao.i18n.exception.I18nException;

/**
 * 国际化工具
 *
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
	 * 获取对应语言language对应消息编码code的消息
	 * 
	 * @param language
	 * @param code
	 * @return
	 */
	public static String getMessage(String language, String code) {
		return I18nObjectsHolder.getMessage(language, code);
	}

	/**
	 * 获取对应语言language对应消息编码code的消息
	 * 
	 * @param language
	 * @param code
	 * @param args
	 * @return
	 */
	public static String getMessage(String language, String code, Object... args) {
		return I18nObjectsHolder.getMessage(language, code, args);
	}

	/**
	 * 获取已有的语言列表
	 * 
	 * @return
	 */
	public static List<String> getLanguages() {
		return I18nObjectsHolder.getlanguages();
	}

	/**
	 * 是否支持此语言
	 * 
	 * @param language
	 * @return
	 */
	public static boolean hasLanguage(String language) {
		return I18nObjectsHolder.getlanguages().contains(language);
	}
}
