package productCURDapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productCURDapp.dao.EmpDao;
import productCURDapp.model.Employee;

@Controller
public class MainController {

	@Autowired
	private EmpDao empdao;
	
	@RequestMapping("/")
	public String home(Model m)
	{
		
		List<Employee> emps=empdao.getEmployee();
		m.addAttribute("Employees", emps);
		
		return "index";
	}
	
	//Add Employee webpage
	@RequestMapping("/addemployee")
	public String addEmployee(Model m)
	{
		m.addAttribute("title","ADD EMPLOYEE PAGE");		
		return "add_employee_form";
	}
	
	
	//Handle Add Employee
	@RequestMapping(value="/handle-employee", method = RequestMethod.POST)
	public RedirectView handleEmployee(@ModelAttribute Employee emp, HttpServletRequest request) {
		this.empdao.createEmployee(emp);
		RedirectView redirectview=new RedirectView();
		redirectview.setUrl(request.getContextPath()+"/");		
		return redirectview;
		
	}
	
	
	//Delete Operation
	@RequestMapping("/delete/{empid}")
	public RedirectView deleteEmployee(@PathVariable("empid") int empid,HttpServletRequest request )
	{
		this.empdao.deleteEmployee(empid);
		RedirectView redirectview=new RedirectView();
		redirectview.setUrl(request.getContextPath()+"/");		
		return redirectview;
	}
	
	@RequestMapping("/update/{empid}")
	public String updateform(@PathVariable("empid") int empid, Model model)
	{
		
		Employee employee=this.empdao.getEmployee(empid);
		model.addAttribute("employee", employee);
		return "update_emp";
	}
	
}
