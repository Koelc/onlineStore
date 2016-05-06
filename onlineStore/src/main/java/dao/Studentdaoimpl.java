package dao;

	import java.util.List;

	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

	import models.product;
		 
		 
		@Repository
		@Transactional
		public class Studentdaoimpl {

		    @Autowired
		    SessionFactory sessionFactory;
		    
			public List<product> getAllProducts() {
				Session s=sessionFactory.getCurrentSession();
		        List<product> plist=s.createQuery(" from product").list();
		        return plist;
				
			}
			
			public Studentdaoimpl()
			
			{
				
			}
		}



