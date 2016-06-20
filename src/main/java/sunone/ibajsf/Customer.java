package sunone.ibajsf;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;

@ManagedBean(name = "customer")
@NoneScoped
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3853143984225856420L;
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private String id = null;
	private String name = null;
	private String addr = null;

	// Constructors
	public Customer(String id, String name, String addr) {
		this.id = id;
		this.name = name;
		this.addr = addr;
	}

	public Customer(String id) {
		this(id, null, null);
	}

	public Customer() {

	}

	@PostConstruct
	public void init() {
		logger.info("-------------->>>>>>  " + this.getClass() + " in PostConstruct");

	}

	// Accesser methods
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddr() {
		return addr;
	}

	// Mutator methods - note you cannot change the id
	public void setName(String newName) {
		name = newName;
	}

	public void setAddr(String newAddr) {
		addr = newAddr;
	}

	@Override
	public String toString() {
		return "Customer:  " + id + "  " + name + "  " + addr;
	}
}
