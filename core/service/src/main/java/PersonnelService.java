import java.time.*;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.stream.Collectors;
import java.util.stream.*;
 
public class PersonnelService {

    private static PersonnelDao personnelDao;
    private static RoleService roleService;

    public PersonnelService() {
        personnelDao = new PersonnelDao();
        roleService = new RoleService();
    }

    public void addPersonnel(Personnel p) {
		personnelDao.addPersonnel(p);
    }

    public void updatePersonnel(Personnel p) {
    	personnelDao.personnelUpdate(p);
    }

    public List<Personnel> listPersonnel() {
    	return personnelDao.findAll();
    }

    public void deletePersonnel(Long id) {
    	personnelDao.deletePersonnel(id);
    }

    public static void showRoles() {
		Set<Roles> roleList = roleService.findAll();
		roleList.stream().sorted(Comparator.comparing(Roles::getRoleId))
		.forEach(e -> System.out.println(e.getRoleId()+" - "+e.getRole()));
	}

	public Personnel findById(Long id) {
        Personnel personnel = personnelDao.findById(id);
        return personnel;
    }

    public boolean checkPerson(Long id) {
    	return personnelDao.checkPerson(id);
    }
}