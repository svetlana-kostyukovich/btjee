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
import sunone.ibajsf.Customer;

@ManagedBean
@RequestScoped
public class AllCustomersManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8397829712958666767L;
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private BrokerModel brokerModel = BrokerModelImpl.getInstance();

	public AllCustomersManagedBean() {

	}

	@PostConstruct
	public void init() {
		logger.info(String.format("%s  constructed in @PostConstruct", this.toString()));
	}

	@PreDestroy
	public void destroy() {
		logger.info(String.format("%s  destroy in @PreDestroy", this.toString()));
	}

	public Customer[] getAllCustomers() {
		logger.info(String.format("%s  , get allCustomers", this.toString()));
		Customer[] custArray = null;
		try {
			custArray = brokerModel.getAllCustomers();
		} catch (BrokerException e) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Can't find customers",
					e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
		return custArray;
	}

}
