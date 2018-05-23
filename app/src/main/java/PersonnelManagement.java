import java.util.*;
import java.util.stream.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.text.SimpleDateFormat;

@WebServlet("/personnelmgt")
public class PersonnelManagement extends HttpServlet{

	private static RoleService roleService = new RoleService();
	private static ContactService contactService = new ContactService();
	private static PersonnelService personnelService = new PersonnelService();

	public void init() throws ServletException { 
		new HibernateUtil();
	}

   	public void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {


    	PrintWriter out = response.getWriter();

    	out.println("<title>Personnel Management</title>");
      	List<Personnel> personnelList = personnelService.listPersonnel();
      	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
      	if (personnelList.isEmpty()) {
     
      	}
      	else {

         	for(Personnel p : personnelList) {

			out.println("\nID: " + p.getId());
			out.println("LAST NAME: " + p.getName().getLname());
			out.println("FIRST NAME: " + p.getName().getFname());
			out.println("MIDDLE NAME: " + p.getName().getMname());
			out.println("SUFFIX: " + p.getName().getSuffix());
			out.println("TITLE: " + p.getName().getTitle());
			out.println("STREET #: " + p.getAddress().getStNum());
			out.println("BARANGAY: " + p.getAddress().getBrgy());
			out.println("CITY: " + p.getAddress().getCity());;
			out.println("ZIP CODE: " + p.getAddress().getZipCode());
			out.println("BIRTHDAY(YYYY-MM-DD): " + p.getBirthday().toString());
			out.println("GWA: " + p.getGwa());
			out.println("DATE HIRED(YYYY-MM-DD): " + p.getDateHired().toString());
			out.println("\nCONTACTS: ");

			for(Contact c : p.getContact()) {

				out.println("LANDLINE : " + c.getLandline());
				out.println("MOBILE : "+ c.getMobile());
				out.println("EMAIL : "+ c.getEmail() + "\n");

			}

			out.println("ROLES: ");
			p.getRoles().stream().sorted(Comparator.comparing(Roles::getRoleId))
			.forEach(e -> out.println(e.getRoleId()+" - "+e.getRole()));

		}

		System.out.println("\n---------- END ----------");      	}
   	}
}