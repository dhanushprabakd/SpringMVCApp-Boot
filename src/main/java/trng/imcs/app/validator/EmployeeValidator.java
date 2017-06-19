package trng.imcs.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import trng.imcs.app.model.EmployeeInfo;


@Component
public class EmployeeValidator implements Validator {
	
	public boolean supports(Class<?> clazz) {
		if (clazz.equals(EmployeeInfo.class)) {
			return true;
		}
		
		return false;
	}

	public void validate(Object object, Errors errors) {
		
		EmployeeInfo empInfo = (EmployeeInfo) object;

		ValidationUtils.rejectIfEmpty(errors, "firstName", "employee.firstName.empty.err");

		if (! isValidUserName(empInfo.getFirstName())) {
			errors.reject("firstName", "firstName.err");
		}		
		
	


		if (empInfo.getSalary() < 10000) {
			errors.reject("Salary", "employee.Salary.err");
		}
	}

	

	private boolean isValidUserName(String userName) {
		
		if (StringUtils.isEmpty(userName)) {
			return false;
		}
		
		if(userName.trim().length() < 5) {
			return false;
		}
		
		return userName.matches("^[a-zA-Z0-9_]*$");
	}

	

}
