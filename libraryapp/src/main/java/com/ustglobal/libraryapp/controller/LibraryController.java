package com.ustglobal.libraryapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ustglobal.libraryapp.dto.BookBean;
import com.ustglobal.libraryapp.dto.LibraryResponse;
import com.ustglobal.libraryapp.dto.UserBean;
import com.ustglobal.libraryapp.service.UserService;
@CrossOrigin(origins ="*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class LibraryController {
	@Autowired
	private UserService service;
	@PostMapping(path="/login", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse login(@RequestBody UserBean bean) {
		LibraryResponse response = new LibraryResponse();
		UserBean bean1 = service.login(bean.getEmail(), bean.getPassword());
		if(bean1!=null) {
			response.setStatusCode(201);
			response.setMessage("Login Succesfully");
			response.setDescription("You Login");
			response.setUserBean(bean1);
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Credential not Match");
			response.setDescription("Not Login");
		}
		return response;
	}
	@PostMapping(path="/register", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse register(@RequestBody UserBean bean) {
		LibraryResponse response = new LibraryResponse();
		boolean check = service.register(bean);
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
	@PostMapping(path="/changepassword", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse changePassword(@RequestBody UserBean bean) {
		LibraryResponse response = new LibraryResponse();
		if(service.changePassword(bean.getEmail(), bean.getPassword())) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("password changed");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("password not changed");
		}
		return response;
	}// end of changePassword
	@PostMapping(path="/addbook", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse addBook(@RequestBody BookBean bean){
		LibraryResponse response = new LibraryResponse();
		if(service.addBook(bean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Book added...");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Book not added...");
		}
		return response;
	}// end of addBook
	@GetMapping(path="/search/{bauthor}",produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse search(@PathVariable("bauthor")String bauthor) {
		LibraryResponse response = new LibraryResponse();
		BookBean bookBean = service.search(bauthor);
		if(bookBean!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Book searched");
			response.setBookBeans(Arrays.asList(bookBean));
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("book not found");
		}
		return response;
	}// end of search
	@GetMapping(path="/searchbook",produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse searchBook(@RequestParam("bid")int bid) {
		LibraryResponse response = new LibraryResponse();
		BookBean bean = service.searchBook(bid);
		if(bean!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Book Searched");
			response.setBookBeans(Arrays.asList(bean));
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Book not Searched");
		}
		return response;
	}//end of searchBook
	@GetMapping(path="/issuebook",produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse issueBook(@RequestParam("bid")int bid,@RequestParam("uid")int uid) {
		LibraryResponse response = new LibraryResponse();
		if(service.issueBook(bid,uid)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Book Issue");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Book not Issue");
		}
		return response;
	}// end of issueBook
	@GetMapping(path="/returnbook",produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse returnBook(@RequestParam("bid") int bid, @RequestParam("uid")int uid) {
		LibraryResponse response = new LibraryResponse();

		if(service.returnBook(bid, uid)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Book Return");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Book not Return");
		}
		return response;
	}// end of returnBook
	@PutMapping(path = "/updatebook", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse updateBook(@RequestBody BookBean bean) {
		LibraryResponse response = new LibraryResponse();
		if(service.updateBook(bean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Book Updated");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Book Not Updated");
		}
		return response;
	}//end of updateBook
	@DeleteMapping(path = "/delete/{bid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse deleteBook(@PathVariable("bid")int bid) {
		LibraryResponse response = new LibraryResponse();
		if(service.deleteBook(bid)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Book deleted!!!");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Book not deleted!!!");
		}
		return response;

	}//end of deleteBook
	@GetMapping(path="/getallbook", produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse getAllBook() {
		LibraryResponse response = new LibraryResponse();
		List<BookBean> list = service.getAllBook();
		if(!list.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Books found Succesfully");
			response.setBookBeans(list);
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Books not found Succesfully");
		}
		return response;
	}//end of getAllBook
}
