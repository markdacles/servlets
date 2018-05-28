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

@WebServlet(value = "/contactmgt")
public class ContactManagement extends HttpServlet{


   	public void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {

    	Personnel p = new PersonnelService().findById(Long.parseLong(request.getParameter("personnelId")));
    	
    	List<Contact> contactList = new ArrayList<Contact>(p.getContact());

    	if("id".equals(request.getParameter("sortby"))) {
    		Collections.sort(contactList, (Contact a1, Contact a2) -> a1.getContactId().compareTo(a2.getContactId()) );
    	} else if("landline".equals(request.getParameter("sortby"))) {
    		Collections.sort(contactList, (Contact a1, Contact a2) -> a1.getLandline().compareTo(a2.getLandline()) );
    	} else if("mobile".equals(request.getParameter("sortby"))) {
    		Collections.sort(contactList, (Contact a1, Contact a2) -> a1.getMobile().compareTo(a2.getMobile()) );
    	} else if("email".equals(request.getParameter("sortby"))) {
    		Collections.sort(contactList, (Contact a1, Contact a2) -> a1.getEmail().compareTo(a2.getEmail()) );
    	} 

    	request.setAttribute("contact", contactList);
    	request.setAttribute("personnel", p);
    	request.getRequestDispatcher("contactmgt.jsp").forward(request,response);

    }
}