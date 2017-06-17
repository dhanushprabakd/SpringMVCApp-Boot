package trng.imcs.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import trng.imcs.app.model.Employee;
import trng.imcs.app.services.EmployeeOperations;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeOperations operations;

	@RequestMapping("/employeeSearch")
	public String searchEmployee(@RequestParam("empNo") Integer empNo, Model model){
		Employee emp = operations.getEmployee(empNo);
		System.out.println(emp.getFirstName());
		model.addAttribute("Employee", emp);
		return "searchMsg";
	}
	
	
	@RequestMapping(value="/addEmployee", method=RequestMethod.POST)
	public String redirectSearchHtml(@ModelAttribute Employee emp, Model model){
		model.addAttribute("Employee", emp);
		return "addEmployeeMsg";
	}

}
