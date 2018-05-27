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

@WebServlet(value = "/updatePersonnel")
public class UpdatePersonnel extends HttpServlet{

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
   	
   	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

			Personnel p = new PersonnelService().findById(Long.parseLong(request.getParameter("personnelid")));
			p.getName().setLname(request.getParameter("lname"));
			p.getName().setFname(request.getParameter("fname"));
			p.getName().setMname(request.getParameter("mname"));
			p.getAddress().setBrgy(request.getParameter("barangay"));
			p.getAddress().setCity(request.getParameter("city"));
			p.setBirthday(java.sql.Date.valueOf(LocalDate.parse(request.getParameter("birthday"), formatter)));
			p.setGwa(Double.parseDouble(request.getParameter("gwa")));
			p.setDateHired(java.sql.Date.valueOf(LocalDate.parse(request.getParameter("date_hired"), formatter)));
	        
	        new PersonnelService().updatePersonnel(p);

	       	response.sendRedirect("/personnelmgt");

	}

   	public void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {

    	request.setAttribute("personnelid", request.getParameter("personnelId"));

    	Personnel p = new PersonnelService().findById(Long.parseLong(request.getParameter("personnelId")));

    	request.setAttribute("p",p);

    	request.getRequestDispatcher("updatepersonnel.jsp").forward(request,response);

    }
}