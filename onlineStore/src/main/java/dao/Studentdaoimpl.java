package dao;

	import java.util.*;

	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
    //import org.hibernate.annotations.common.util.impl.Log_.logger;
    import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.stereotype.Repository;

	import models.product;
		 
		 
		@Repository
		@Transactional
		public class Studentdaoimpl {

			
			private static final Logger logger = LoggerFactory.getLogger(Studentdaoimpl.class);
			 
		    @Autowired
		    SessionFactory sessionFactory;
		    
//Get all product
			public List<product> getAllProducts() {
				Session s=sessionFactory.getCurrentSession();
		        List<product> plist=s.createQuery(" from product").list();
		        return plist;
				
			}
			
			
			 
			public Studentdaoimpl()
			
			{
				
			}
		//Method for deleting product
			/*public void removePerson(int id) {
		        Session session = this.sessionFactory.getCurrentSession();
		        product p = (product) session.load(product.class, id);
		        if(null != p){
		            session.delete(p);
		        }
		        logger.info("Product deleted successfully, person details="+p);
		    }
		*/
			//Method for adding product
	
		
//Add a Product
	  public void addProduct(product p) {
	        Session session = this.sessionFactory.getCurrentSession();
	        session.persist(p);
	        logger.info("Product saved successfully, Product Details="+p);
	    }

//Search a Product
		public product getProductById(int id) {
			Session session = this.sessionFactory.getCurrentSession();      
	        product p = (product) session.load(product.class, id);
	        logger.info("Person loaded successfully, Person details="+p);
	        return p;
			
		}


//Remove a product
		public void removeProduct(int id) {
			Session session = this.sessionFactory.getCurrentSession();
	        product p = (product) session.load(product.class,id);
	        if(null != p){
	            session.delete(p);
	        }
	        logger.info("Person deleted successfully, person details="+p);
	    
			
		}

		public void updateProduct(product p) {
			Session session=this.sessionFactory.getCurrentSession();
			session.update(p);
	    }


}