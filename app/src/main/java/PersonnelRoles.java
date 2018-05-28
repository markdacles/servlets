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

@WebServlet(value = "/proles")
public class PersonnelRoles extends HttpServlet{


   	public void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	
    	Personnel p = new PersonnelService().findById(Long.parseLong(request.getParameter("personnelId")));

    	List<Roles> roleList = new ArrayList<Roles>(p.getRoles());

    	if("id".equals(request.getParameter("sortby"))) {
    		Collections.sort(roleList, (Roles a1, Roles a2) -> a1.getRoleId().compareTo(a2.getRoleId()) );
    	} else if("role".equals(request.getParameter("sortby"))) {
    		Collections.sort(roleList, (Roles a1, Roles a2) -> a1.getRole().compareTo(a2.getRole()) );
   		}

   		request.setAttribute("roles", roleList);

    	request.setAttribute("personnel", p);
    	request.getRequestDispatcher("personnelroles.jsp").forward(request,response);

    }
}