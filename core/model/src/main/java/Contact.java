import javax.persistence.*;
import java.util.Objects;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
	private Long contactId;
	
    @Column(name = "landline")
    private String landline;
	
    @Column(name = "mobile")
    private String mobile;
	
    @Column(name = "email")
    private String email;

    public Contact() { }

    public Contact(String landline, String mobile, String email) { 
        this.landline = landline;
        this.mobile = mobile;
        this.email = email;
    }

	public Long getContactId() { return contactId; }
    public void setContactId(Long cid) { contactId = cid; }  

    public String getLandline() { return landline; }
    public void setLandline(String l) { landline = l; }  

    public String getMobile() { return mobile; }
    public void setMobile(String m) { mobile = m; }  

    public String getEmail() { return email; }
    public void setEmail(String e) { email = e; } 

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Contact))
            return false;
        if (obj == this)
            return true;
        return this.getContactId() == ((Contact) obj).getContactId();
    }

    public int hashCode() {
        return Objects.hash(contactId);
    }
}