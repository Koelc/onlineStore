package controllers;

import models.*;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dao.servicesImpl;

@Controller
public class HomeController {
	
	@Autowired
	servicesImpl si ;
	
	 List<product> productlist;

	 
	//private servicesImpl servicesImpl;
	@RequestMapping ("/")
	public String showIndex()
	{
		return "index";
	}
	
	/*@RequestMapping("/productTable")
	public ModelAndView showProd(HttpServletRequest request, HttpServletResponse response)
	{
		
		 productlist=si.getAllProducts();
		 System.out.println((productlist.get(0).name));
		 ModelAndView mv = new ModelAndView("productTable");
		 mv.addObject("plist",productlist);
		 return mv;
	}*/
	
	/*@RequestMapping(value="/Details/{id}", method=RequestMethod.GET)
	@ResponseBody
	public String showDetails(@PathVariable("id") int id, Model  model )
	{ 
		System.out.println("I am in details controller");
		String s="product"+id;
		
		switch(id)
		{
			case 1: return s;
	 
			case 2: return s;
	
			default:
				    return "#";
		}
	
		//return s;
	}*/
	
	/*@Autowired(required=true)
    @Qualifier(value="servicesImpl")
    public void setservicesImpl(servicesImpl ps){
        this.servicesImpl = ps;
    }*/
     
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String listProduct(Model model) {
        model.addAttribute("product", new product());
        model.addAttribute("listProduct", this.si.getAllProducts());
        return "productTable";
    }
     
    //For add and update person both
    @RequestMapping(value= "/productTable/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") product p){
         
        if(p.id== 0){
            //new person, add it
            this.si.addProduct(p);
        }
        else{
            //existing person, call update
            this.si.updateProduct(p);
        }
         
        return "redirect:/productTable";
         
    }
    
   
     
    @RequestMapping("/remove/{id}")
    public String removeProduct(@PathVariable("id") int id){
         
        ((dao.servicesImpl) this.productlist).removeProduct(id);
        return "redirect:/productTable";
    }
  
    @RequestMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model model){
        model.addAttribute("product", this.si.getProductById(id));
        model.addAttribute("listProduct", this.si.getAllProducts());
        return "redirect:/productTable";
    }
     

}
