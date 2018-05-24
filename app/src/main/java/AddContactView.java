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

@WebServlet(value = "/addContactView")
public class AddContactView extends HttpServlet{


   	public void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    		 System.out.println(request.getParameter("flag"));
    	System.out.println("val: " + request.getParameter("personnelId"));
    	Personnel p = new PersonnelService().findById(Long.parseLong(request.getParameter("personnelId")));
    	request.setAttribute("personnel", p);

    	request.getRequestDispatcher("contactform.jsp").forward(request,response);

    }
}