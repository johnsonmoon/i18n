package test.xuyihao.i18n;

import org.junit.Test;

import xuyihao.i18n.I18nInit;
import xuyihao.i18n.I18nUtils;
import xuyihao.i18n.exception.I18nException;

import java.io.File;

/**
 * Created by xuyh at 2017/7/11 17:19.
 */
public class I18nUtilsTest {
	@Test
	public void test() throws I18nException {
		String path = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\conf\\i18n";
		new I18nInit("zh_CN", path).init();
		System.out.println(I18nUtils.getDefaultLanguage());
		System.out.println(I18nUtils.getMessage("zh_CN", "xuyihao.test.hello.people", "Johnson"));
		System.out.println(I18nUtils.getMessage("en_US", "xuyihao.test.hello.people", "Johnson"));

		String has = "";
		for (String lang : I18nUtils.getLanguages()) {
			has += (lang + "  ");
		}
		System.out.println(has);
		System.out.println(I18nUtils.hasLanguage("en_US"));
	}
}
