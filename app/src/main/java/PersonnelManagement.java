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
public class PersonnelManagement extends HttpServlet {


   	public void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {

    	List<Personnel> personnelList = new PersonnelService().listPersonnel();
    	
    	if("id".equals(request.getParameter("sortby"))) {
    		Collections.sort(personnelList, (Personnel a1, Personnel a2) -> a1.getId().compareTo(a2.getId()) );
    	} else if("fname".equals(request.getParameter("sortby"))) {
    		Collections.sort(personnelList, (Personnel a1, Personnel a2) -> a1.getName().getFname().compareTo(a2.getName().getFname()) );
    	} else if("lname".equals(request.getParameter("sortby"))) {
    		Collections.sort(personnelList, (Personnel a1, Personnel a2) -> a1.getName().getLname().compareTo(a2.getName().getLname()) );
    	} else if("mname".equals(request.getParameter("sortby"))) {
    		Collections.sort(personnelList, (Personnel a1, Personnel a2) -> a1.getName().getMname().compareTo(a2.getName().getMname()) );
    	} else if("brgy".equals(request.getParameter("sortby"))) {
    		Collections.sort(personnelList, (Personnel a1, Personnel a2) -> a1.getAddress().getBrgy().compareTo(a2.getAddress().getBrgy()) );
    	} else if("city".equals(request.getParameter("sortby"))) {
    		Collections.sort(personnelList, (Personnel a1, Personnel a2) -> a1.getAddress().getCity().compareTo(a2.getAddress().getCity()) );
    	} else if("bday".equals(request.getParameter("sortby"))) {
    		Collections.sort(personnelList, (Personnel a1, Personnel a2) -> a1.getBirthday().compareTo(a2.getBirthday()) );
    	} else if("gwa".equals(request.getParameter("sortby"))) {
    		Collections.sort(personnelList, (Personnel a1, Personnel a2) -> a1.getGwa().compareTo(a2.getGwa()) );
    	} else if("datehired".equals(request.getParameter("sortby"))) {
    		Collections.sort(personnelList, (Personnel a1, Personnel a2) -> a1.getDateHired().compareTo(a2.getDateHired()) );
    	}

    	request.setAttribute("personnelList", personnelList);

    	request.getRequestDispatcher("personnelmgt.jsp").forward(request,response);

    }
}