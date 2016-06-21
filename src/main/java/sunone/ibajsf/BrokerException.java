package sunone.ibajsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;


@ManagedBean
@NoneScoped
public class BrokerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2935178981369626358L;

	/**
	 * Creates new <code>BrokerException</code> without detail message.
	 */
	public BrokerException() {
		this("BrokerException");
	}

	/**
	 * Constructs an <code>BrokerException</code> with the specified detail
	 * message.
	 * 
	 * @param msg
	 *            the detail message.
	 */
	public BrokerException(String msg) {
		super(msg);
	}
}
