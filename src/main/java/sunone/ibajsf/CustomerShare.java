package sunone.ibajsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;

@ManagedBean
@NoneScoped
public class CustomerShare implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2892193206173254908L;
	private int id;
	private String customerId;
	private String stockSymbol;
	private int quantity;

	public CustomerShare(String customerId, String stockSymbol, int quantity) {
		this.customerId = customerId;
		this.stockSymbol = stockSymbol;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
