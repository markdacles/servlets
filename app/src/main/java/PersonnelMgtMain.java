import java.time.*;
import java.util.*;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.stream.*;
import java.io.*;


public class PersonnelMgtMain {

	private static RoleService roleService = new RoleService();
	private static ContactService contactService = new ContactService();
	private static PersonnelService personnelService = new PersonnelService();
	
	public static void main(String[] args) {

        int mainOption = 0, personnelOption = 0, pid = 0, contactOption = 0, roleOption = 0;
        Long id = 0L, cid = 0L, rid = 0L;
        boolean redo = true;
        boolean again = true;

        new HibernateUtil();

      	while(redo) {
      		if(mainOption == 0) {

	            System.out.println("\nPERSONNEL MANAGEMENT SYSTEM\n");
		      	System.out.println("1 - Personnel Management");
		      	System.out.println("2 - Contact Management");
		      	System.out.println("3 - Role Management");
		      	System.out.println("4 - Exit");
	      		System.out.print("Select action to proceed: ");  	
		      	mainOption = ScanUtil.scanValidInput(" ", 1, 4);

		    } else if(mainOption == 1) {

	      		showOptions("Personnel");
	      		personnelOption = ScanUtil.scanValidInput(" Personnel ", 1, 5);

	      		if(personnelOption == 1) {

	      			personnelService.addPersonnel(addPersonnel());
	      			System.out.println("Personnel successfully added.");

	      		} else if(personnelOption == 5) {

	      			mainOption = 0;
	      			personnelOption = 0;

	      		} else if(personnelService.listPersonnel().isEmpty()) {

	      			System.out.println("No personnel record.");

	      		} else if(personnelOption == 2) {

	     			showPersonnel();

	      		} else if(personnelOption == 3) {

	      			System.out.print("Enter ID of personnel to be updated: ");
	      			ScanUtil.flushScanner();
	      			id = ScanUtil.scanLong("Enter ID of personnel to be updated: ");
	      			again = true;
	      			while(personnelService.checkPerson(id) == false) {
	      				System.out.println("Invalid input. Please try again. ");
						System.out.print("Enter ID of personnel to be updated: ");
	      				id = ScanUtil.scanLong("Enter ID of personnel to be updated: ");
	      			}

	      			personnelService.updatePersonnel(updatePersonnel(id));
	      			System.out.println("Personnel successfully updated.");
	      			
	      		} else if(personnelOption == 4) {

	      			System.out.print("Enter ID of personnel to be removed: ");
	      			ScanUtil.flushScanner();
	      			id = ScanUtil.scanLong("Enter ID of personnel to be removed: ");
	      			again = true;
	      			while(personnelService.checkPerson(id) == false) {
	      				System.out.println("Invalid input. Please try again. ");
						System.out.print("Enter ID of personnel to be removed: ");
	      				id = ScanUtil.scanLong("Enter ID of personnel to be removed: ");
	      			}
	      			personnelService.deletePersonnel(id);
	      			System.out.println("Personnel successfully removed.");

	      		}

	      	} else if(mainOption == 2) {

	      		if(personnelService.listPersonnel().isEmpty()) {

	      			System.out.println("No personnel record.");
	      			mainOption = 0;
	      			continue;

	      		} else if(contactOption == 0) {

		      		showNames();
		      		System.out.print("\nSelect Personnel ID to proceed: ");
		      		ScanUtil.flushScanner();
		      		id = ScanUtil.scanLong("Enter a valid personnel ID: ");
		      		again = true;
	      			while(personnelService.checkPerson(id) == false) {
	      				System.out.println("Invalid input. Please try again. ");
						System.out.print("Enter a valid personnel ID: ");
	      				id = ScanUtil.scanLong("Enter a valid personnel ID: ");
	      			}
		      	}
		      		
		      	showOptions("Contact");
		      	contactOption = ScanUtil.scanValidInput(" Contact ", 1, 5);

	      		if(contactOption == 1) {
	      			
	      			System.out.println("\nNEW CONTACT INFO");
	      			ScanUtil.flushScanner();
	      			contactService.addContactToPersonnel(addContactInfo(personnelService.findById(id)));
	      			System.out.println("Contact successfully added.");

	      		} else if (contactOption == 2) {

	      			showContacts(id);

	      		} else if (contactOption == 3) {

	      			System.out.print("Enter ID of contact to be updated: ");
	      			ScanUtil.flushScanner();
	      			cid = ScanUtil.scanLong("Enter a valid contact ID: ");
	      			while(contactService.doesContactExist(cid) == false) {
	      				System.out.println("Invalid input. Please try again. ");
						System.out.print("Enter a valid contact ID: ");
						cid = ScanUtil.scanLong("Enter a valid contact ID: ");
	      			}

	      			contactService.updateContact(updateContact(id,cid));
	      			System.out.println("Contact successfully updated.");

	      		} else if (contactOption == 4) {

	      			System.out.print("Enter ID of contact to be removed: ");
	      			ScanUtil.flushScanner();
	      			cid = ScanUtil.scanLong("Enter a valid contact ID: ");
	      			while(contactService.doesContactExist(cid) == false) {
	      				System.out.println("Invalid input. Please try again. ");
						System.out.print("Enter a valid contact ID: ");
						cid = ScanUtil.scanLong("Enter a valid contact ID: ");
	      			}
	      			contactService.removeContact(id,cid);
	      			System.out.println("Contact successfully removed.");
	      		
	      		} else if (contactOption == 5) {

	      			mainOption = 0;
	      			contactOption = 0;

	      		}
	      	} else if(mainOption == 3) {

	      		showOptions("Role ");
	      		roleOption = ScanUtil.scanValidInput(" Role ", 1, 5);

	      		if(roleOption == 1) {

	      			System.out.print("Enter new role: ");
	      			ScanUtil.flushScanner();
	      			String stringRole = ScanUtil.scanVarCharOnly("Enter new role: ");
	      			roleService.addRole(stringRole);

	      		} else if(roleOption == 2) {

	     			System.out.println("\nRoles: ");
	     			personnelService.showRoles();

	      		} else if(roleOption == 3) {

	      			System.out.print("Enter ID of role to be updated: ");
	      			rid = ScanUtil.scanLong("Enter a valid role ID: ");
	      			System.out.print("Enter role update: ");
	      			ScanUtil.flushScanner();
	      			String urole = 	ScanUtil.scanString();
	      			roleService.updateRole(rid, urole);
	      			System.out.println("Role update Successful.");

	      		} else if(roleOption == 4) {

	      			System.out.print("Enter ID of role to be removed: ");
	  				ScanUtil.flushScanner();
	      			rid = ScanUtil.scanLong("Enter a valid role ID: ");
	      			again = true;
	      			boolean valid = false;
	      			while(again) {
		      			while(roleService.findById(rid) == null) {
		      				System.out.println("Invalid input. Please try again. ");
							System.out.print("Enter a valid role ID: ");
							rid = ScanUtil.scanLong("Enter a valid role ID: ");
							break;
		      			}
		      			valid = true;
		      			if(!personnelService.listPersonnel().isEmpty()) {
			      			for(Personnel p : personnelService.listPersonnel()) {
			      				if(p.getRoles().contains(roleService.findById(rid))) {
			      					System.out.println("Cannot delete active role. ");
									System.out.print("Enter a valid role ID: ");
									rid = ScanUtil.scanLong("Enter a valid role ID: ");
									valid = false;
									break;
			      				} else {
			      					valid = true;
			      				}
			      			}
			      		}
		      			if(valid == true) {
		      				again = false;
		      			}
		      		}
	      			roleService.deleteRole(rid);
	      			System.out.println("Role delete Successful.");

	      		} else if(roleOption == 5) {

	      			mainOption = 0;
	      			roleOption = 0;

	      		}
	      	} else if(mainOption == 4) {
	      	
	      		redo = false;
	      		HibernateUtil.shutDown();

	      	}
	    }

	}

	private static void showOptions(String option) {

	    System.out.println("\n1 - Add " + option);
  		System.out.println("2 - List " + option);
  		System.out.println("3 - Update " + option);
  		System.out.println("4 - Remove " + option);
  		System.out.println("5 - Back");
  		System.out.print("Select " + option + " action to proceed: ");

	}

	private static void showPersonnel() {

		List<Personnel> personnelList = personnelService.listPersonnel();
		System.out.println("\n----- PERSONNELS ----- ");

		for(Personnel p : personnelList) {

			System.out.println("\nID: " + p.getId());
			System.out.println("LAST NAME: " + p.getName().getLname());
			System.out.println("FIRST NAME: " + p.getName().getFname());
			System.out.println("MIDDLE NAME: " + p.getName().getMname());
			System.out.println("SUFFIX: " + p.getName().getSuffix());
			System.out.println("TITLE: " + p.getName().getTitle());
			System.out.println("STREET #: " + p.getAddress().getStNum());
			System.out.println("BARANGAY: " + p.getAddress().getBrgy());
			System.out.println("CITY: " + p.getAddress().getCity());;
			System.out.println("ZIP CODE: " + p.getAddress().getZipCode());
			System.out.println("BIRTHDAY: " + p.getBirthday().toString());
			System.out.println("GWA: " + p.getGwa());
			System.out.println("DATE HIRED: " + p.getDateHired().toString());
			System.out.println("\nCONTACTS: ");

			for(Contact c : p.getContact()) {

				System.out.println("LANDLINE : " + c.getLandline());
				System.out.println("MOBILE : "+ c.getMobile());
				System.out.println("EMAIL : "+ c.getEmail() + "\n");

			}

			System.out.println("ROLES: ");
			p.getRoles().stream().sorted(Comparator.comparing(Roles::getRoleId))
			.forEach(e -> System.out.println(e.getRoleId()+" - "+e.getRole()));

		}

		System.out.println("\n---------- END ----------");

	}

	private static void showNames() {

		List<Personnel> personnelList = personnelService.listPersonnel();
		System.out.println("\n----- PERSONNELS ----- ");

		for(Personnel p : personnelList) {

			System.out.println("\nID: " + p.getId());
			System.out.println("LAST NAME: " + p.getName().getLname());
			System.out.println("FIRST NAME: " + p.getName().getFname());
			System.out.println("MIDDLE NAME: " + p.getName().getMname());

		}

		System.out.println("\n---------- END ----------");

	}

	private static void showContacts(Long id) {

			Personnel p = personnelService.findById(id);

			System.out.println("\n----- CONTACT INFO OF PERSONNEL#"+ p.getId() +" ----- \n");

			for(Contact c : p.getContact()) {

				System.out.println("CONTACT ID: " + c.getContactId());
				System.out.println("LANDLINE : " + c.getLandline());
				System.out.println("MOBILE : "+ c.getMobile());
				System.out.println("EMAIL : "+ c.getEmail() + "\n");

			}
		System.out.println("---------- END ----------");

	}

    private static Personnel updateContact(Long id, Long cid) {
    	Personnel p = personnelService.findById(id);
    	for(Contact c : p.getContact()) {
    		if(c.getContactId() == cid) {
	    		System.out.print("\nLandline: ");
		        String landline = ScanUtil.scanVarCharOnlyU("Landline: ", c.getLandline());
		        c.setLandline(landline);
		        System.out.print("Mobile: ");
		        String mobile = ScanUtil.scanVarCharOnlyU("Mobile: ", c.getMobile());
		        c.setMobile(mobile);
		        System.out.print("Email: ");
		        String email = ScanUtil.scanVarCharOnlyU("Email: ", c.getEmail());
		        c.setEmail(email);
		        return p;
	    	}
    	}
    	return p;
    }

    private static Personnel updatePersonnel(Long id) {
   	    Personnel upPersonnel = personnelService.findById(id);
    	ScanUtil.flushScanner();
    	upPersonnel = updateBasicInfo(upPersonnel);
    	Set<Contact> upContact = new HashSet<Contact>();
    	for(Contact c : upPersonnel.getContact()) {
    		// upPersonnel = updateContact(id,c.getContactId());
    		System.out.print("\nLandline: ");
	        String landline = ScanUtil.scanVarCharOnlyU("Landline: ", c.getLandline());
	        c.setLandline(landline);
	        System.out.print("Mobile: ");
	        String mobile = ScanUtil.scanVarCharOnlyU("Mobile: ", c.getMobile());
	        c.setMobile(mobile);
	        System.out.print("Email: ");
	        String email = ScanUtil.scanVarCharOnlyU("Email: ", c.getEmail());
	        c.setEmail(email);
	        upContact.add(c);
    	}
    	upPersonnel.setContact(upContact);

    	System.out.println("Available Roles: ");
  		Set<Roles> aRoles = roleService.findAll();
		for(Roles r : upPersonnel.getRoles()) {
			aRoles.removeIf(i -> i.getRoleId() == r.getRoleId());
		}
		aRoles.stream().sorted(Comparator.comparing(Roles::getRoleId))
		.forEach(e -> System.out.println(e.getRoleId()+" - "+e.getRole()));
    	System.out.print("Add roles: ");
    	String roleStringAdd = ScanUtil.scanString();
    	List<Long> roleListIdAdd = new ArrayList<>();
    	boolean redo = true;
    	if(roleStringAdd == null || roleStringAdd.isEmpty()) { 
			redo = false;
		}
    	while(redo) {
    		try {
				roleListIdAdd = Stream.of(roleStringAdd.split(","))
		        	.map(Long::parseLong)
		            .collect(Collectors.toList());
		        for(Long i : roleListIdAdd) {
		        	Roles r = roleService.findById(i);
		        	if(aRoles.contains(r)) {
		        		redo = false;
		        	} else {
		        		redo = true;
		        		System.out.println("Invalid input. Please try again. ");
		        		System.out.print("Add roles: ");
		        		roleStringAdd = ScanUtil.scanString();
		        		if(roleStringAdd == null || roleStringAdd.isEmpty()) { 
							redo = false;
						}
		        		break;
		        	}
		        }
		    } catch  (Exception e){
	        	System.out.println("Invalid input. Please try again. ");
	        	System.out.print("Add roles: ");
	        	roleStringAdd = ScanUtil.scanString();
	        	if(roleStringAdd == null || roleStringAdd.isEmpty()) { 
					redo = false;
				}
	       	}
	    }

        for(Long i : roleListIdAdd) {
        	Roles r = roleService.findById(i);
        	upPersonnel.getRoles().add(r);
        }

        System.out.println("\nPersonnel Roles: ");
       	upPersonnel.getRoles().stream().sorted(Comparator.comparing(Roles::getRoleId))
		.forEach(e -> System.out.println(e.getRoleId()+" - "+e.getRole()));
		System.out.print("Delete roles: ");
		String roleStringDel = ScanUtil.scanString();
		List<Long> roleListIdDel = new ArrayList<>();
    	redo = true;
    	if(roleStringDel == null || roleStringDel.isEmpty()) { 
			redo = false;
		}
    	while(redo) {
    		try {
				roleListIdDel = Stream.of(roleStringDel.split(","))
		                .map(Long::parseLong)
		                .collect(Collectors.toList());
		        for(Long i : roleListIdDel) {
		        	Roles r = roleService.findById(i);
		        	if(upPersonnel.getRoles().contains(r)) {
		        		redo = false;
		        	} else {
		        		redo = true;
		        		System.out.println("Invalid input. Please try again. ");
		        		System.out.print("Delete roles: ");
		        		roleStringDel = ScanUtil.scanString();
		        		if(roleStringDel == null || roleStringDel.isEmpty()) { 
							redo = false;
						}
		        		break;
		        	}
		        }
	        } catch  (Exception e){
		        	System.out.println("Invalid input. Please try again. ");
		        	System.out.print("Delete roles: ");
		        	roleStringDel = ScanUtil.scanString();
		        	if(roleStringDel == null || roleStringDel.isEmpty()) { 
						redo = false;
					}
		    }
		}
        for(Long i : roleListIdDel) {
        	Roles r = roleService.findById(i);
        	upPersonnel.getRoles().remove(r);
        }

        return upPersonnel;
    }

    private static Personnel updateBasicInfo(Personnel p) {

		System.out.print("\nLast Name: ");
		String lname = ScanUtil.scanCharOnlyU("Last Name: ", p.getName().getLname());
		System.out.print("First Name: ");
		String fname = ScanUtil.scanCharOnlyU("First Name: ", p.getName().getFname());
		System.out.print("Middle Name: ");
		String mname = ScanUtil.scanCharOnlyU("Middle Name: ", p.getName().getMname());
		System.out.print("Suffix: ");
		String suffix  = ScanUtil.scanCharOnlyU("Suffix: ", p.getName().getSuffix());
		System.out.print("Title: ");
		String title = ScanUtil.scanCharOnlyU("Title: ", p.getName().getTitle());
		Name newName = new Name(lname,fname,mname,suffix,title);
		p.setName(newName);

		System.out.print("\nStreet Number: ");
		String stNum = ScanUtil.scanVarCharOnlyU("Street Number: ", p.getAddress().getStNum());
		System.out.print("Barangay: ");
		String brgy = ScanUtil.scanVarCharOnlyU("Barangay: ", p.getAddress().getBrgy());
		System.out.print("City: ");
		String city = ScanUtil.scanVarCharOnlyU("City: ", p.getAddress().getCity());
		System.out.print("Zip Code: ");
		String zipCode = ScanUtil.scanVarCharOnlyU("Zip Code: ", p.getAddress().getZipCode());
		Address newAdd = new Address(stNum,brgy,city,zipCode);
		p.setAddress(newAdd);

		System.out.print("\nBirthday(YYYY-MM-DD): ");
		Date birthday = ScanUtil.scanDateU("Birthday", p.getBirthday());
		p.setBirthday(birthday);
		System.out.print("GWA: ");
		Double gwa = ScanUtil.scanDoubleOnlyU("GWA: ", p.getGwa());
		p.setGwa(gwa);
		System.out.print("Date Hired(YYYY-MM-DD) ");
		Date dayHired = ScanUtil.scanDateU("Date Hired", p.getDateHired());
		p.setDateHired(dayHired);

		return p;
	}

	private static Personnel addPersonnel() {

    	Personnel newPersonnel = new Personnel();

        System.out.println("\nNEW PERSONNEL");
	    			
		ScanUtil.flushScanner();
		newPersonnel = addBasicInfo(newPersonnel);
		newPersonnel = addContactInfo(newPersonnel);

		personnelService.showRoles();
		System.out.print("Roles (Separate by comma for multiple roles): ");
		String roleString = ScanUtil.scanString();
		boolean redo = true;
		List<Long> roleList = new ArrayList<>();
		if(roleString == null || roleString.isEmpty()) { 
			redo = false;
		}
		while(redo) {
			try {
				roleList = Stream.of(roleString.split(","))
	                .map(Long::parseLong)
	                .collect(Collectors.toList());
	            for(Long i : roleList) {
		        	Roles r = roleService.findById(i);
		        	newPersonnel.getRoles().add(r);
		        }
	            redo = false;
	        } catch (Exception e){
	        	System.out.println("Invalid input. Please try again. ");
	        	System.out.print("Roles (Separate by comma for multiple roles): ");
	        	roleString = ScanUtil.scanString();
	        	if(roleString == null || roleString.isEmpty()) { 
					redo = false;
				}
	        }
	    }

		return newPersonnel;
    }

    private static Personnel addBasicInfo(Personnel p) {

		System.out.print("\nLast Name: ");
		String lname = ScanUtil.scanCharOnly("Last Name: ");
		System.out.print("First Name: ");
		String fname = ScanUtil.scanCharOnly("First Name: ");
		System.out.print("Middle Name: ");
		String mname = ScanUtil.scanCharOnly("Middle Name: ");
		System.out.print("Suffix: ");
		String suffix  = ScanUtil.scanCharOnly("Suffix: ");
		System.out.print("Title: ");
		String title = ScanUtil.scanCharOnly("Title: ");
		Name newName = new Name(lname,fname,mname,suffix,title);
		p.setName(newName);

		System.out.print("\nStreet Number: ");
		String stNum = ScanUtil.scanVarCharOnly("Street Number: ");
		System.out.print("Barangay: ");
		String brgy = ScanUtil.scanVarCharOnly("Barangay: ");
		System.out.print("City: ");
		String city = ScanUtil.scanVarCharOnly("City: ");
		System.out.print("Zip Code: ");
		String zipCode = ScanUtil.scanVarCharOnly("Zip Code: ");
		Address newAdd = new Address(stNum,brgy,city,zipCode);
		p.setAddress(newAdd);

		System.out.print("\nBirthday(YYYY-MM-DD): ");
		LocalDate birthdate = ScanUtil.scanDate("Birthday");
		Date birthday = java.sql.Date.valueOf(birthdate);
		p.setBirthday(birthday);
		System.out.print("GWA: ");
		Double gwa = ScanUtil.scanDoubleOnly("GWA: ");
		p.setGwa(gwa);
		System.out.print("Date Hired(YYYY-MM-DD) ");
		LocalDate dayHired = ScanUtil.scanDate("Date Hired");
		Date dateHired = java.sql.Date.valueOf(dayHired);
		p.setDateHired(dateHired);

		return p;
	}

	private static Personnel addContactInfo(Personnel p) {
		Contact newContact = new Contact();
		System.out.print("\nLandline: ");
		String landline = ScanUtil.scanVarCharOnly("Landline: ");
		newContact.setLandline(landline);
		System.out.print("Mobile: ");
		String mobile = ScanUtil.scanVarCharOnly("Mobile: ");
		newContact.setMobile(mobile);
		System.out.print("Email: ");
		String email = ScanUtil.scanVarCharOnly("Email: ");
		newContact.setEmail(email);

		p.getContact().add(newContact);
		return p;
	}
}