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
    	
    	if("ID".equals(request.getParameter("sortby"))) {
    		Collections.sort(personnelList, (Personnel a1, Personnel a2) -> a1.getId().compareTo(a2.getId()) );
    		Collections.reverse(personnelList);
    	} else if("fname".equals(request.getParameter("sortby"))) {
    		Collections.sort(personnelList, (Personnel a1, Personnel a2) -> a1.getName().getFname().compareTo(a2.getName().getFname()) );
    	}
    	
    	request.setAttribute("personnelList", personnelList);

    	request.getRequestDispatcher("personnelmgt.jsp").forward(request,response);

    }
}