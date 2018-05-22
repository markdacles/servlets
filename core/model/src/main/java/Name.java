import javax.persistence.*;

@Embeddable
public class Name {

    @Column
	private String lname;
	
    @Column
    private String fname;
	
    @Column
    private String mname;
	
    @Column
    private String suffix;
	
    @Column
    private String title;

    public Name() { }

    public Name(String lname, String fname, String mname, String suffix, String title) {
        this.lname = lname;
        this.fname = fname;
        this.mname = mname;
        this.suffix = suffix;
        this.title = title;
    }

    public String getLname() { return lname; }
    public void setLname(String l) { lname = l; }

    public String getFname() { return fname; }
    public void setFname(String f) { fname = f; }

	public String getMname() { return mname; }
    public void setMname(String m) { mname = m; }

    public String getSuffix() { return suffix; }
    public void setSuffix(String s) { suffix = s; }

    public String getTitle() { return title; }
    public void setTitle(String t) { title = t; }    


}