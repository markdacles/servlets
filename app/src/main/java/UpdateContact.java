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

@WebServlet(value = "/updateContact")
public class UpdateContact extends HttpServlet{
   	
   	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

			Personnel p = new PersonnelService().findById(Long.parseLong(request.getParameter("personnelid")));
			for(Contact c : p.getContact()) {
				if(c.getContactId() == Long.parseLong(request.getParameter("contactid"))) {
					if(request.getParameter("landline") != "") {
						c.setLandline(request.getParameter("landline"));
					}
					if(request.getParameter("mobile") != "") {
						c.setMobile(request.getParameter("mobile"));
					}
					if(request.getParameter("email") != "") {
						c.setEmail(request.getParameter("email"));
					}
				}
			}
	        new ContactService().updateContact(p);

	       	response.sendRedirect("/contactmgt?personnelId="+Long.parseLong(request.getParameter("personnelid")));

	}

   	public void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {

    	request.setAttribute("contactid", request.getParameter("contactid"));
    	request.setAttribute("personnelid", request.getParameter("personnelid"));

    	Personnel p = new PersonnelService().findById(Long.parseLong(request.getParameter("personnelid")));
    	for(Contact c : p.getContact()) {
    		if(c.getContactId() == Long.parseLong(request.getParameter("contactid"))) {
    			request.setAttribute("contact", c);
    			break;
    		}

    	}

    	request.getRequestDispatcher("upcontactform.jsp").forward(request,response);

    }
}