package com.cognizant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;

import org.apache.cxf.ws.security.SecurityConstants;

/**
 * Servlet implementation class CalculatorServlet
 */
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@WebServiceRef(CalculatorService_Service.class)
	private CalculatorService calculatorService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		((BindingProvider)calculatorService).getRequestContext().put(SecurityConstants.USERNAME, "kermit");
		((BindingProvider)calculatorService).getRequestContext().put(SecurityConstants.CALLBACK_HANDLER,"com.cognizant.handler.callback.UsernamePassword");
		System.out.println(calculatorService.multiply(2, 34));
	}

}
