package xuyihao.i18n;

import java.util.Locale;

/**
 * 国际化信息上下文
 * 
 * Created by xuyh at 2017/7/11 14:16.
 */
public class I18nContext {
	/**
	 * 语言
	 */
	private String language;
	/**
	 * 地区
	 */
	private String region;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * 返回本地化对象，当语言或地区不合法时将抛出异常： {@link java.util.IllformedLocaleException } 。
	 *
	 * @return Locale 对象
	 */
	public Locale getLocale() {
		return new Locale.Builder().setLanguage(language).setRegion(region).build();
	}
}
