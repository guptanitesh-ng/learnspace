/**
 * 
 */
package com.training.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.training.spring.mvc.model.Contact;

/**
 * @author 150088
 *
 */
@Controller
public class SayHelloController {

	@RequestMapping(value="/hello")
	public String sayHello(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getServletPath());
		System.out.println(request.getPathInfo());
		request.setAttribute("text", "Hi there");
		System.out.println("Hi there !!!");
		return "hello";
	}
	
	@RequestMapping(value="/addContact")
	public ModelAndView addContact(@ModelAttribute("contact")Contact contact) {
		System.out.println(contact.getFirstname());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("viewContact");
		modelAndView.addObject("cont", contact);
		return modelAndView;
	}
	
	@RequestMapping(value="/contact")
	public ModelAndView contact() {		
		return new ModelAndView("addContact", "command", new Contact());
	}
}
