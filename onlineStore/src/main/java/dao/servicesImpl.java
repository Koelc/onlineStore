
package dao;


	
	
	import java.util.*;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;
	 
	

	import dao.servicesImpl;
	import models.product;
	 

	@Transactional
	@Service
	public class servicesImpl  {
		
		
		@Autowired
		Studentdaoimpl di;
	    
	    //Get all product
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
	    
	    
	    
	    /*     
	    @Autowired
		Studentdaoimpl sdi;
	     */
	       
	    /* public void setProduct(Studentdaoimpl sdi) {
	            this.di = sdi;
	        }
	     */
	        
	    
	    //Add a product
	        @Transactional
	        public void addProduct(product p) {
	            this.di.addProduct(p);
	        }
	     
	        
	        //Update a product
	        
	        @Transactional
	        public void updateProduct(product p) {
	            this.di.updateProduct(p);
	        }
	     
	        
	     
	        //Search a product
	        @Transactional
	        public product getProductById(int id) {
	            return (product)this.di.getProductById(id);
	        }
	     
	   
	        @Transactional
	        public void removeProduct(int id) {
	            this.di.removeProduct(id);
	        }

		/*	public int getProductById()
			{
				// TODO Auto-generated method stub
				return 0;
			}
*/
				    


	}


