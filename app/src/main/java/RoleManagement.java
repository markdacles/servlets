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

@WebServlet(value = "/rolemgt")
public class RoleManagement extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {

    	Set<Roles> rolelist = new RoleService().findAll();
    	String activeRoles = "";
    	for(Personnel p : new PersonnelService().listPersonnel()) {
    		for(Roles r : p.getRoles()) {
    			if(!(activeRoles.contains(r.getRole())))
    				activeRoles += (r.getRole() + " ");
    		}
    	}

    	request.setAttribute("activeRoles", activeRoles);

    	request.setAttribute("rolelist", rolelist);

    	request.getRequestDispatcher("rolemgt.jsp").forward(request,response);

    }
}