package controllers;

import models.*;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.servicesImpl;

@Controller
public class HomeController {
	
	@Autowired
	servicesImpl si ;
	
	 List<product> productlist;
	@RequestMapping ("/")
	public String showIndex()
	{
		return "index";
	}
	
	@RequestMapping("/productTable")
	public ModelAndView showProd(HttpServletRequest request, HttpServletResponse response)
	{
		
		 productlist=si.getAllProducts();
		 System.out.println((productlist.get(0).name));
		ModelAndView mv = new ModelAndView("productTable");
		mv.addObject("plist",productlist);
		return mv;
	}

}
