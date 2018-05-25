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

@WebServlet(value = "/updateContactView")
public class UpdateContactView extends HttpServlet{


   	public void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {

    	request.setAttribute("contactid", request.getParameter("contactid"));
    	request.setAttribute("personnelid", request.getParameter("personnelid"));

    	request.getRequestDispatcher("upcontactform.jsp").forward(request,response);

    }
}