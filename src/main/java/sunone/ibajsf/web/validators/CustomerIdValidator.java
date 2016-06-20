package sunone.ibajsf.web.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "customerIdValidator")
public class CustomerIdValidator implements Validator {

	// da mozhno srazy v .xhtml regexpom
	private static final String ID_PATTERN = "[0-9]{3}-[0-9]{2}-[0-9]{4}";
	private Pattern pattern;
	private Matcher matcher;

	public CustomerIdValidator() {
		pattern = Pattern.compile(ID_PATTERN);
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		HtmlInputText htmlInputText = (HtmlInputText) component;
		matcher = pattern.matcher(value.toString());
		if (!matcher.matches()) {

			FacesMessage msg = new FacesMessage(htmlInputText.getLabel(),
					"Invalid Customer Identity format(xxx-xx-xxxx).");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}
	}

}
