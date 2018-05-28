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

@WebServlet(value = "/personnelmgt")
public class PersonnelManagement extends HttpServlet{


   	public void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {

    	List<Personnel> personnelList = new PersonnelService().listPersonnel();
    	
    	if("id".equals(request.getParameter("id")){

    	} else if("lname".equals(request.getParameter("id")){

    	} else if("fname".equals(request.getParameter("id")){

    	} else if("mname".equals(request.getParameter("id")){

    	} else if("brgy".equals(request.getParameter("id")){

    	} else if("city".equals(request.getParameter("id")){

    	} else if("bday".equals(request.getParameter("id")){

    	} else if("gwa".equals(request.getParameter("id")){

    	} else if("datehired".equals(request.getParameter("id")){

    	}

    	request.setAttribute("personnelList", personnelList);

    	request.getRequestDispatcher("personnelmgt.jsp").forward(request,response);

    }
}