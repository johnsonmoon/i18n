package xuyihao.i18n.exception;

/**
 * Created by xuyh at 2017/7/11 16:51.
 */
public class I18nException extends Throwable {
	private static final long serialVersionUID = 1L;

	public I18nException() {
		super();
	}

	public I18nException(String message) {
		super(message);
	}

	public I18nException(String message, Object... objects) {
		super(String.format(message, objects));
	}

	public I18nException(String message, Throwable cause) {
		super(message, cause);
	}
}
