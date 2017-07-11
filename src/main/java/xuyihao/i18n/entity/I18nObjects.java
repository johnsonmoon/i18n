package xuyihao.i18n.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 储存语言键值对对象
 *
 * Created by xuyh at 2017/7/11 14:22.
 */
public class I18nObjects {
	/**
	 * 语言
	 */
	private String language;
	/**
	 * 消息code-value键值对
	 */
	private Map<String, String> messages;

	public I18nObjects(String language) {
		this.language = language;
		messages = new HashMap<>();
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Map<String, String> getMessages() {
		return messages;
	}

	public void setMessages(Map<String, String> messages) {
		this.messages = messages;
	}

	public void addMessages(Map<String, String> messages) {
		this.messages.putAll(messages);
	}

	public void addMessage(String code, String message) {
		this.messages.put(code, message);
	}

	public String getMessage(String code) {
		return this.messages.get(code);
	}
}
