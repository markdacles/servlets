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

@WebServlet(value = "/addRole")
public class AddRole extends HttpServlet{
   	
   	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

   	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

			new RoleService().addRole(request.getParameter("role"));

	       	response.sendRedirect("/rolemgt");

	}
}