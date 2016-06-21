package sunone.ibajsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;

@ManagedBean
@NoneScoped
public class Stock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4657695963888884520L;
	private String symbol;
	private double price;

	public Stock(String symbol, double price) {
		this.symbol = symbol;
		this.price = price;
	}

	// Methods to return the private values of this object
	public double getPrice() {
		return price;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setPrice(double newPrice) {
		price = newPrice;
	}

	@Override
	public String toString() {
		return "Stock:  " + symbol + "  " + price;
	}
}
