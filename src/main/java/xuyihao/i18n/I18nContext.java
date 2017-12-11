package xuyihao.i18n;

/**
 * 国际化信息上下文
 * 
 * Created by xuyh at 2017/7/11 14:16.
 */
public class I18nContext {
	/**
	 * 语言
	 */
	private static String language;
	/**
	 * 地区
	 */
	private static String region;

	public static String getLanguage() {
		if (language == null || language.isEmpty())
			return I18nUtils.getDefaultLanguage();
		if (!I18nUtils.hasLanguage(language))
			return I18nUtils.getDefaultLanguage();
		return language;
	}

	public static void setLanguage(String language) {
		I18nContext.language = language;
	}

	public static String getRegion() {
		return region;
	}

	public static void setRegion(String region) {
		I18nContext.region = region;
	}
}
