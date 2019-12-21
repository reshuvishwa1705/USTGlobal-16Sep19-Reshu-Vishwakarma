package com.ustglobal.mail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ustglobal.mail.dto.MailBean;
import com.ustglobal.mail.dto.MailResponse;
import com.ustglobal.mail.dto.UserBean;
import com.ustglobal.mail.service.MailService;
import com.ustglobal.mail.service.UserService;

@RestController
@CrossOrigin(origins ="*", allowedHeaders = "*", allowCredentials = "true")
public class MailController {
	@Autowired 
	private MailService mailService;
	@Autowired 
	private UserService userService;
	@PostMapping(path="/login", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public MailResponse login(@RequestBody UserBean bean) {
		MailResponse response = new MailResponse();
		UserBean bean1 = userService.login(bean.getEmail(), bean.getPassword());
		if(bean1!=null) {
			response.setStatusCode(201);
			response.setMessage("Login Succesfully");
			response.setDescription("You Login");
			response.setUserBean(bean1);
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Email and Password is not Match");
			response.setDescription("Not Login");
		}
		return response;
	}//end of login
	@PostMapping(path="/register", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public MailResponse register(@RequestBody UserBean bean) {
		MailResponse response = new MailResponse();
		boolean check = userService.register(bean);
		if(check) {
			response.setStatusCode(201);
			response.setMessage("Registration Success");
			response.setDescription("Data added to the DB");
		}
		else if (check==false) {
			response.setStatusCode(401);
			response.setMessage("Email already exist");
			response.setDescription("Data not added to the DB");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Registration Failure");
			response.setDescription("Data not added to the DB");
		}
		return response;
	}// end of register
	@PutMapping(path="/changepassword",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public MailResponse changePassword(@RequestBody UserBean bean) {
		MailResponse response = new MailResponse();
		boolean check = userService.changePassword(bean);
		if(check) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Password changed Success");
		}
		else if (check==false) {
			response.setStatusCode(401);
			response.setMessage("Not Success");
			response.setDescription("Password not changed ");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Password changed Failure");
			response.setDescription("Password not changed");
		}
		return response;
	}//end of changepassword
	@DeleteMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public MailResponse delete(@RequestParam("bean") MailBean bean) {
		MailResponse response = new MailResponse();
		boolean check = mailService.delete(bean);
		if(check) {
			response.setStatusCode(201);
			response.setMessage("Delete Successfuly");
			response.setDescription("Data deleted to the DB");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Delete Failure");
			response.setDescription("Data not deleted to the DB");
		}

		return response;
	}// end of delete
	@GetMapping(path="/inbox", produces = MediaType.APPLICATION_JSON_VALUE)
	public MailResponse inbox(@RequestParam("email") String email){
		MailResponse response = new MailResponse();
		List<MailBean> beans= mailService.inbox(email);
		if(!beans.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("mail found Succesfully");
			response.setMailBeans(beans);
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Their is no mail");
		}

		return response;
	}// end of inbox
	@GetMapping(path = "/sent", produces = MediaType.APPLICATION_JSON_VALUE)
	public MailResponse sent(@RequestParam String fromMail, @RequestParam String toMail, @RequestParam String msg,@RequestParam String sub) {
		MailResponse response = new MailResponse();
		System.out.println("fromMail"+fromMail);
		String message = mailService.sent(fromMail, toMail, msg, sub);
		if(message!=null) {
			response.setStatusCode(201);
			response.setMessage(message);
			response.setDescription("mail found Succesfully");
		}
		else {
			response.setStatusCode(401);
			response.setMessage(message);
			response.setDescription("Their is no mail");
		}
		return response;
	}// end of sent
	@GetMapping(path = "/draft", produces = MediaType.APPLICATION_JSON_VALUE)
	public MailResponse draft(@RequestParam String fromMail,@RequestParam String toMail,@RequestParam String msg,@RequestParam String sub) {
		System.out.println("toMail"+toMail);
		MailResponse response = new MailResponse();
		String message = mailService.draft(fromMail, toMail, msg, sub);
		if(message!=null) {
			response.setStatusCode(201);
			response.setMessage(message);
			response.setDescription("mail found Succesfully");
		}
		else {
			response.setStatusCode(401);
			response.setMessage(message);
			response.setDescription("Their is no mail");
		}
		return response;
	}//end of draft
}
