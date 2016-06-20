package sunone.ibajsf.web;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import sunone.ibajsf.BrokerException;
import sunone.ibajsf.BrokerModel;
import sunone.ibajsf.BrokerModelImpl;
import sunone.ibajsf.Customer;

@ManagedBean
@SessionScoped
public class CustomerManagedBean implements Serializable {

	/**
	 * 
	 */

	public CustomerManagedBean() {

	}

	@ManagedProperty(value = "#{customer}")
	private Customer customer;
	private static final long serialVersionUID = -5987863306439575163L;
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private BrokerModel brokerModel = BrokerModelImpl.getInstance();

	@PostConstruct
	public void init() {
		logger.info(this.getClass() + " in PostConstruct");
	}

	@PreDestroy
	public void destroy() {
		logger.info(this.getClass() + " in PreDestroy");
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void ajaxPerformGetCustomer(final AjaxBehaviorEvent event) {

		customer = findCustomer();
		logger.info("ajax finding customer");

	}

	public void addCustomer() {
		logger.info("add customer");

		try {
			brokerModel.addCustomer(customer);
		} catch (BrokerException e) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Problem with adding customer to DB " + customer.toString(), e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
		logger.info("add customer complete");
	}

	public void deleteCustomer() {
		logger.info("delete customer");
		FacesMessage facesMessage;
		try {
			brokerModel.deleteCustomer(customer);
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					String.format("Customer %s deleted", customer.toString()), "customer deleted");

		} catch (NullPointerException | BrokerException e) {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unable delete customer" + customer.toString(),
					e.getMessage());

		}
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);

		logger.info("delete customer complete");
	}

	public void updateCustomer() {
		logger.info("update customer");
		FacesMessage facesMessage;
		try {
			brokerModel.updateCustomer(customer);
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					String.format("Customer %s deleted", customer.toString()), "customer updated");
		} catch (BrokerException e) {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unable update customer" + customer.toString(),
					e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
		logger.info("update customer complete");
	}

	public void getCustomerFromDb() {
		logger.info("get customer");
		findCustomer();
		logger.info("get customer complete");
	}

	private Customer findCustomer() {

		FacesMessage facesMessage = new FacesMessage();
		try {
			for (Customer cust : brokerModel.getAllCustomers()) {
				if (cust.getId().equalsIgnoreCase(customer.getId())) {
					customer = cust;
					facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Recieved from DB", " recieved");
					break;

				}
				if (cust.getName().equalsIgnoreCase(customer.getName())) {
					customer = cust;
					facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Recieved from DB", " recieved");
					break;
				}
				if (cust.getAddr().equalsIgnoreCase(customer.getAddr())) {
					customer = cust;
					facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Recieved from DB", " recieved");
					break;
				}

			}
		} catch (

		BrokerException e1) {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unable get customers from DB",
					e1.getMessage());

		}
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		return customer;

	}
}
