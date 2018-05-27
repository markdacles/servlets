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

@WebServlet(value = "/addProles")
public class AddProles extends HttpServlet{
   	
   	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

			Personnel p = new PersonnelService().findById(Long.parseLong(request.getParameter("personnelid")));

			Set<Roles> roles = new HashSet<Roles>();
			String[] cRoles = request.getParameterValues("checkedRoles");
			if (cRoles != null) {
	            for (String id : cRoles) {
	               Roles role = new RoleService().findById(Long.parseLong(id));
	               p.getRoles().add(role);
	            }
	        }

	        new PersonnelService().updatePersonnel(p);

	       	response.sendRedirect("/proles?personnelId="+Long.parseLong(request.getParameter("personnelid")));

	}

   	public void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {

    	request.setAttribute("personnelid", request.getParameter("personnelid"));

    	Set<Roles> aRoles = new RoleService().findAll();
    	Personnel p = new PersonnelService().findById(Long.parseLong(request.getParameter("personnelid")));
		
		for(Roles r : p.getRoles()) {
			aRoles.removeIf(i -> i.getRoleId() == r.getRoleId());
		}

		request.setAttribute("aroles", aRoles);

    	request.getRequestDispatcher("addproleform.jsp").forward(request,response);

    }
}