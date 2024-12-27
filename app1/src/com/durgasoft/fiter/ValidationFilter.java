package com.durgasoft.fiter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class ValidationFilter implements Filter {

	
	public void destroy() {
	
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			response.setContentType("text/html");
			PrintWriter  out =response.getWriter();
			
			  String uname = request.getParameter("uname");
			  String upwd = request.getParameter("upwd");
			  String uage = request.getParameter("uage");
			  String uemail = request.getParameter("uemail");
			  String umobile=request.getParameter("umobile");
			  
			  boolean flag = true;
			  String uname_Error_message = "";
			  String upwd_Error_message = "";
			  String uage_Error_message = "";
			  String uemail_Error_message = "";
			  String umobile_Error_message = "";
			  
			  if(uname == null || uname.equals("")) {
				  uname_Error_message="User Name is Required";
				   flag = false; 
			  }
			  if(upwd == null || upwd.equals("")) {
				  upwd_Error_message="User Password is Required";
				   flag = false; 
			  }
			  else {
				  if(upwd.length()<6) {
					  upwd_Error_message = "User Password must be minimum 6 Character.";
					  flag=false;
				  }
				  else if(upwd.length()>10) {
					  upwd_Error_message = "User Password must be maximum 10 Character.";
				      flag = false;
				  }
			  }
			  if(uage == null || uage.equals("")) {
				  uage_Error_message="User Password is Required";
				   flag = false; 
			  }else {
				  int age = Integer.parseInt(uage);
				  if(age<18 || age>25) {
					  uage_Error_message ="User age must be in the range from 19 to 25";
					  flag = false;
				  }
			  }
			  if(uemail == null || uemail.equals("")) {
				  uemail_Error_message="User Email is Required";
				   flag = false; 
			  }else {
				  if(!uemail.endsWith("@gmail.com")) {
					  uemail_Error_message="User email must end with @gmail.com";
							  flag=false;
				  }
			  }
			  if(umobile == null || umobile.equals("")) {
				   umobile_Error_message="User Password is Required";
				   flag = false; 
			  }else {
				  if(!umobile.startsWith("91-")) {
					  umobile_Error_message="Mobile Number Start with 91-";
					  flag=false;
				  }
			  }
			  if(flag == true) {
				  chain.doFilter(request, response);
			  }
			  else {
				  out.println("<html>");
				  out.println("<body>");
				  out.println("<h2 style='color:red;'align='center'>Durga Software Solution </h2>");
				  out.println("<h3 style='color:blue;' align='center'>User Registration Form</h3>");
				  out.println("<form method='POST' action='./reg'>");
				  out.println("<table align='center'>");
				  
				  out.println("<tr>");
				  out.println("<td>User Name</td>");
				  out.println("<td> <input type='text' name='uname' value='"+uname+"'></td>");
				  out.println("<td><font color='red' size='5'>"+uname_Error_message+"</font></td>");
				  out.println("</tr>");
				  
				  out.println("<tr>");
				  out.println("<td>Password</td>");
				  out.println("<td> <input type='text' name='upwd' value='"+upwd+"'> </td>");
				  out.println("<td><font color='red' size='5'>"+upwd_Error_message+"</font></td>");
				  out.println("</tr>");
				  
				  out.println("<tr>");
				  out.println("<td>User Age</td>");
				  out.println("<td> <input type='text' name='uage' value='"+uage+"'>  </td>");
				  out.println("<td><font color='red' size='5'>"+uage_Error_message+"</font></td>");
				  out.println("</tr>");
				  
				  out.println("<tr>");
				  out.println("<td>User Email</td>");
				  out.println("<td> <input type='text' name='uemail' value='"+uemail+"'></td>");
				  out.println("<td><font color='red' size='5'>"+uemail_Error_message+"</font></td>");
				  out.println("</tr>");
				  
				  out.println("<tr>");
				  out.println("<td>User Mobile</td>");
				  out.println("<td> <input type='text' name='umobile' value='"+umobile+"'></td>");
				  out.println("<td><font color='red' size='5'>"+umobile_Error_message+"</font></td>");
				  out.println("</tr>");
				  
				  out.println("<tr>");
				  out.println("<td> <input type='submit' value='Registration'/></td>");
				  out.println("</tr>");
				  
				  out.println("</table></form></body></html>");
			  }
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
