package sunone.ibajsf.web;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import sunone.ibajsf.BrokerException;
import sunone.ibajsf.BrokerModel;
import sunone.ibajsf.BrokerModelImpl;
import sunone.ibajsf.Stock;

@ManagedBean
@RequestScoped
public class StockManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2897671886882474597L;
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private BrokerModel brokerModel = BrokerModelImpl.getInstance();

	public StockManagedBean() {

	}

	static {
		System.out.println("in static block");
	}

	@PreDestroy
	private void destroyable() {
		logger.info(this.getClass() + " in @preDestroy");

	};

	@PostConstruct
	private void init() {
		logger.info(this.getClass() + " in @postConstruct");

	};

	public Stock[] getAllStocks() {
		logger.info(this.getClass() + " in getAllStocks");

		Stock[] stocks = null;
		try {
			stocks = brokerModel.getAllStocks();
		} catch (BrokerException e) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Can't find Stocks",
					e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
		logger.info(this.getClass() + " in getAllStocks complete");
		return stocks;

	}

}
