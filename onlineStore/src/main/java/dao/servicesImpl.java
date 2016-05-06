package dao;


	
	
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;

	import dao.servicesImpl;
	import models.product;
	 

	@Transactional
	@Service
	public class servicesImpl  {
		
		
		@Autowired
		Studentdaoimpl di;
	    
	    
	    public List getAllProducts() {
	        return di.getAllProducts();
	    }
	    
	    public servicesImpl()
	    {
	    		
	    }
	    /*@Override
	    @Transactional
	    public void deleteEmployee(Integer employeeId) {
	        employeeDAO.deleteEmployee(employeeId);
	    }*/
	    /*public void setEmployeeDAO(EmployeeDAO employeeDAO) {
	        this.employeeDAO = employeeDAO;
	    }*/
		

	}




