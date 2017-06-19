package trng.imcs.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import trng.imcs.app.model.EmployeeInfo;
import trng.imcs.app.services.EmployeeOperations;
import trng.imcs.app.validator.EmployeeValidator;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeOperations operations;
	@Autowired
	private EmployeeValidator employeeValidator;
	
	 @InitBinder
	    protected void initBinder(WebDataBinder binder) {
	     //   logger.debug("initBinder method called");
			binder.addValidators(employeeValidator);

	        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	        dateFormat.setLenient(false);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	    }

	@RequestMapping("/employeeSearch")
	public String redirectEmployeeSearch() {

		return "employeeSearch";
	}

	@ModelAttribute
	public EmployeeInfo addUser(ModelMap model) {

		model.addAttribute("deptNames", operations.getDepartmentNames());
		return new EmployeeInfo();
	}

	@RequestMapping("/employeeSearch.do")
	public String searchEmployee(@RequestParam("empNo") Integer empNo, Model model) {
		EmployeeInfo emp = operations.getEmployee(empNo);
		System.out.println(emp.getFirstName());
		model.addAttribute("Employee", emp);
		return "employeeDisplay";
	}

	@RequestMapping("/AddUpdate")
	public String redirectAddUpdate(Model model) {
		model.addAttribute("employee", new EmployeeInfo());
		return "AddUpdate";
	}

	@RequestMapping(value = "/addUpdate.do", method = RequestMethod.POST)
	public ModelAndView redirectSearchHtml(@ModelAttribute("employee") @Valid EmployeeInfo emp,BindingResult result) {

        ModelAndView modelAndView = new ModelAndView("AddUpdate");
        modelAndView.addObject("deptNames", operations.getDepartmentNames());
        if (result.hasErrors()) {
            return modelAndView;
        } else {
            operations.addOrUpdateEmployee(emp, emp.getSalary(), emp.getDeptName());
            modelAndView.addObject("employee", new EmployeeInfo());
            modelAndView.addObject("message", "Successfully Registered");
            return modelAndView;
        }
	}

}
