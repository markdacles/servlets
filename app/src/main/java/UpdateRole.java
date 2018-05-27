import java.util.*;
import java.util.stream.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

@WebServlet(value = "/updateRole")
public class UpdateRole extends HttpServlet{
   	
   	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			
	        new RoleService().updateRole(Long.parseLong(request.getParameter("roleid")),request.getParameter("role"));

	       	response.sendRedirect("/rolemgt");

	}

  	public void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {

    	request.setAttribute("roleid", request.getParameter("roleid"));

    	Roles r = new RoleService().findById(Long.parseLong(request.getParameter("roleid")));

    	request.setAttribute("r",r);

    	request.getRequestDispatcher("updaterole.jsp").forward(request,response);

    }
}