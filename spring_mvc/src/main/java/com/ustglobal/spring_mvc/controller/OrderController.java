package com.ustglobal.spring_mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ustglobal.spring_mvc.beans.Hotel;
import com.ustglobal.spring_mvc.beans.Retailer;
import com.ustglobal.spring_mvc.service.ProductService;

@Controller
public class OrderController {
	
	@Autowired
	public ProductService service;
	
	@GetMapping("/login")
	public String loginPage() {

		return "login";
	}

	@PostMapping("/login")
	public String login(int id , String password , HttpServletRequest request) {

		Retailer bean = service.login(id,password);
		if(bean == null) {

			request.setAttribute("msg", "Invalid Credentials");
			return "login";

		}else {

			HttpSession session = request.getSession();
			
			session.setAttribute("bean", bean);

			return "home";

		}
	}//end of login()

	@GetMapping("/register")
	public String createProfile() {

		return "register";
	}//end of createProfile()


	@PostMapping("/register")
	public String register(Retailer bean , ModelMap map) {

		int check = service.create(bean);
		if(check > 0) {
			map.addAttribute("msg", "you are Registered ID is "+ check);
		}else {
			map.addAttribute("msg", "Email is Repeted");
		}
		return "login";
	}//end of createProfile()
	
	@GetMapping("/home")
	public String home(ModelMap map, @SessionAttribute(name = "bean" ,required = false) Retailer bean) {

		if(bean == null) {

			map.addAttribute("msg", "login first!!!!!!!!!!");
			return "login";
		}else {

			return "home";
		}
	}//end of home

	@PostMapping("/home")
	public String home() {

		return "home";
	}//end of home()
	
	@GetMapping("/search")
	public String search(@RequestParam("id") int id , ModelMap map) {

		Retailer bean = service.searchByProductId(id);
		if(bean == null) {
			map.addAttribute("msg", "Data not found");

		}else {

			map.addAttribute("bean", bean);
		}
		return "home";
	}//end of search
//	
//	@GetMapping("/changepassword")
//	public String changePassword(HttpServletRequest request) {
//
//		HttpSession session = request.getSession(false);
//		if(session!= null) {
//
//			return "changepassword";
//
//		}else {
//
//			return "login";
//		}
//
//	}//end change password
//
//	@PostMapping("/changepassword")
//	public String changePassword(String password,String cpassword,@SessionAttribute(name = "bean") Retailer bean , ModelMap map) {
//
//
//		if( password.equals(cpassword)) {
//
//			service.updatePassword(bean.getId(), cpassword);
//			map.addAttribute("msg", "password changed");
//			return "home";
//		}else {
//
//			map.addAttribute("msg", "password not matching");
//			return "home";
//		}
//
//	}//end of changepassword post
//	
//	@GetMapping("/search")
//	public String searchById(@RequestParam("retailerId") int retailerId , ModelMap map) {
//
//		Hotel bean = service.searchById(retailerId);
//		if(bean == null) {
//			map.addAttribute("msg", "Data not found");
//
//		}else {
//
//			map.addAttribute("bean", bean);
//		}
//		return "home";
//	}//end of search
//	
//	
//	
//	
//	
//	@GetMapping("/delete")
//	public String delete(HttpSession session) {
//
//		Retailer bean = (Retailer)session.getAttribute("bean");
//		try {
//
//			service.deleteProfile(bean.getId());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		session.invalidate();
//		return "login";
//	}//end of delete
//	
//	
//	@GetMapping("/logout")
//	public String logout(HttpSession session) {
//		session.invalidate();
//		return "login";
//	}//logout
//	
}
