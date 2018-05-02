package com.github.johnsonmoon.i18n;

import org.junit.Test;

import com.github.johnsonmoon.i18n.entity.Constances;
import com.github.johnsonmoon.i18n.entity.I18nObjectsHolder;
import com.github.johnsonmoon.i18n.exception.I18nException;

import java.io.File;

/**
 * Created by xuyh at 2017/7/11 16:36.
 */
public class I18nObjectsHolderTest {
	@Test
	public void test() throws I18nException {
		String path = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\conf\\i18n";

		System.setProperty(Constances.I18N_SOURCES_FILE_PATH, path);
		I18nObjectsHolder.initObjects();
		String hello_CN = I18nObjectsHolder.getMessage("zh_CN", "test.hello");
		String hello_US = I18nObjectsHolder.getMessage("en_US", "test.hello");
		System.out.println(hello_CN);
		System.out.println(hello_US);
	}
}
