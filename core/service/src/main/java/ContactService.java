import java.util.*;

public class ContactService {
    private static PersonnelDao personnelDao;

    public ContactService() {
        personnelDao = new PersonnelDao();
    }

    public void addContactToPersonnel(Personnel p) {
        personnelDao.addContactToPersonnel(p);
    }

    public void updateContact(Personnel p) {
        personnelDao.contactUpdate(p);
    }

    public void removeContact(Long id, Long cid) {
        Personnel p = personnelDao.getPersonnel(id);
        for(Contact c : p.getContact()) {
            if(c.getContactId() == cid) {
                p.getContact().remove(c);
                break;
            }
        }
        personnelDao.removeContact(p);
    }

    public boolean doesContactExist(Long id) {
        List<Personnel> personnelList =  personnelDao.findAll();
        for(Personnel p : personnelList) {
            for(Contact c : p.getContact()) {
                if(c.getContactId() == id) {
                    return true;
                }
            }
        }
        return false;
    }
}