package com.ustglobal.retailerapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ustglobal.retailerapp.dto.OrderBean;
import com.ustglobal.retailerapp.dto.ProductBean;
import com.ustglobal.retailerapp.dto.RetailerBean;
import com.ustglobal.retailerapp.service.RetailerServiceImpl;

@Controller
public class RetailerController {
	@Autowired
	RetailerServiceImpl service;
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	@PostMapping("/login")
	public String login(int id, String password, HttpServletRequest req) {
		RetailerBean bean = service.login(id, password);
		if(bean==null) {
			req.setAttribute("msg", "Invalid Credentials");
			return "login";
		}else {
			//getSession value by default true we cannot set false in this
			HttpSession session = req.getSession();
			session.setAttribute("bean", bean);
			return "home";
		}

	}// end of login()
	@GetMapping("/createprofile")
	public String createProfilePage() {
		return "createprofile";
	}//end of createprofilePage()
	@PostMapping("/createprofile")
	public String register(RetailerBean bean,ModelMap map) {
		boolean check = service.createProfile(bean);
		if(check) {
			map.addAttribute("msg","Profile Created");
		}
		else {
			map.addAttribute("msg", "id is repeated");
		}
		return "login";
	}//end of createprofile()
	@GetMapping("/home")
	public String home(ModelMap map, @SessionAttribute(name="bean", required = false)RetailerBean bean) {
		if(bean==null) {
			map.addAttribute("msg", "Login First!!!!!");
			return "login";
		}
		else {
			return "home";
		}
	}//end of home()

	@PostMapping("/home")
	public String homePage() {
		return "home";
	}//end of homePage() post mapping
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	@GetMapping("/updatepassword")
	public String changePassword(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session!=null) {
			return "updatepassword";
		}
		else {
			return "login";
		}
	}//end of changePassword()
	@PostMapping("/updatepassword")
	public String changePassword(String password, String confirmpassword,@SessionAttribute(name="bean")RetailerBean bean,ModelMap map) {

		if(password.equals(confirmpassword)) {
			service.updatePassword(bean.getRetailerId(), password);
			map.addAttribute("msg","Password Changed");
		}
		else {
			map.addAttribute("msg","Password Not Matching");
		}

		return "home";
	}
	@GetMapping("/search")
	public String search(@RequestParam ("pid")int pid,ModelMap map) {
		OrderBean bean = service.searchProduct(pid);
		if(bean==null) {
			map.addAttribute("msg","Data not found!!!");
		}else {
			map.addAttribute("bean",bean);

		}
		return "home";
	}

}
