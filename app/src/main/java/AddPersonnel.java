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

@WebServlet(value = "/addPersonnel")
public class AddPersonnel extends HttpServlet{
   	
   	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

   	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

			Personnel p = new Personnel();
			Name name = new Name(request.getParameter("lname"),request.getParameter("fname"),request.getParameter("mname"),"","");
			p.setName(name);
			Address address = new Address("",request.getParameter("barangay"),request.getParameter("city"),"");
			p.setAddress(address);
			p.setBirthday(java.sql.Date.valueOf(LocalDate.parse(request.getParameter("birthday"), formatter)));
			p.setGwa(Double.parseDouble(request.getParameter("gwa")));
			p.setDateHired(java.sql.Date.valueOf(LocalDate.parse(request.getParameter("date_hired"), formatter)));
			Contact contact = new Contact(request.getParameter("landline"),request.getParameter("mobile"),request.getParameter("email"));
			p.getContact().add(contact);

			Set<Roles> roles = new HashSet<Roles>();
			String[] cRoles = request.getParameterValues("checkedRoles");
			if (cRoles != null) {
	            for (String id : cRoles) {
	               Roles role = new RoleService().findById(Long.parseLong(id));
	               p.getRoles().add(role);
	            }
	        }

	        new PersonnelService().addPersonnel(p);

	       	response.sendRedirect("/personnelmgt");

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {

    	Set<Roles> roleList = new RoleService().findAll();

    	request.setAttribute("roleList", roleList);

    	request.getRequestDispatcher("personnelform.jsp").forward(request,response);

    }
}