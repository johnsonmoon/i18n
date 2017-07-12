package xuyihao.i18n.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xuyihao.i18n.exception.I18nException;
import xuyihao.i18n.utils.SourceFileReader;

/**
 * 国际化消息缓存
 * 
 * Created by xuyh at 2017/7/11 14:41.
 */
public class I18nObjectsHolder {
	/**
	 * 国际化消息本地缓存
	 */
	private static Map<String, I18nObjects> i18nObjectsMapCache = new HashMap<>();

	/**
	 * 获取对应语言对应编码的消息
	 * 
	 * @param language 语言
	 * @param code 消息编码
	 * @return
	 */
	public static String getMessage(String language, String code) {
		return i18nObjectsMapCache.get(language).getMessage(code);
	}

	/**
	 * 获取格式化后的对应语言对应编码的消息
	 * 
	 * @param language 语言
	 * @param code 消息编码
	 * @param args 格式化子串
	 * @return
	 */
	public static String getMessage(String language, String code, Object... args) {
		return String.format(i18nObjectsMapCache.get(language).getMessage(code), args);
	}

	/**
	 * 获取已有的语言
	 * 
	 * @return
	 */
	public static List<String> getlanguages() {
		return new ArrayList<String>(i18nObjectsMapCache.keySet());
	}

	/**
	 * 初始化消息资源至本地缓存
	 * @throws I18nException 
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
