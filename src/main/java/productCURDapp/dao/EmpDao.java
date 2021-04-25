package productCURDapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;


import productCURDapp.model.Employee;

@Component
public class EmpDao {

	@Autowired
	public HibernateTemplate hibernateTemplate;
	
	
	@Transactional
	public void createEmployee(Employee emp)
	{
		this.hibernateTemplate.saveOrUpdate(emp);
	}
	
	//GET ALL
	public List<Employee> getEmployee()
	{
		List<Employee> employees=this.hibernateTemplate.loadAll(Employee.class);
		return employees;
	}
	
	//DELETE 
	@Transactional
	public void deleteEmployee(int pid)
	{
		Employee e=this.hibernateTemplate.load(Employee.class,pid);
		this.hibernateTemplate.delete(e);
	}
	
	//GET SINGLE EMPLOYEE
	public Employee getEmployee(int pid)
	{
		return this.hibernateTemplate.get(Employee.class,pid);
	}
	
}
