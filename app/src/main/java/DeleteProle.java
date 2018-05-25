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

@WebServlet(value = "/deleteProle")
public class DeleteProle extends HttpServlet{
   	
   	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

	        Personnel p = new PersonnelService().findById(Long.parseLong(request.getParameter("personnelid")));
	        Roles r = new RoleService().findById(Long.parseLong(request.getParameter("roleid")));
	        System.out.println("todelete "+r.getRole());
	        System.out.println(request.getParameter("roleid"));
	        p.getRoles().remove(r);

	        new PersonnelService().updatePersonnel(p);

	       	response.sendRedirect("/proles?personnelId="+Long.parseLong(request.getParameter("personnelid")));

	}
}