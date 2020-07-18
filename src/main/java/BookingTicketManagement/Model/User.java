package BookingTicketManagement.Model;


public class User {
    
    private int id;
    private int roleID;
    private String username;
    private String password;
    private String displayname;
    private int isactive;
    private String createdDate;
    private String createdBy;
    private String updatedDate;
    private String updatedBy;
    private String phonenumber;
    private String address;
    private String email;

    

	public User(int id, int roleID, String username, String password, String displayname, int isactive,
			String createdDate, String createdBy, String updatedDate, String updatedBy, String phonenumber,
			String address, String email) {

		this.id = id;
		this.roleID = roleID;
		this.username = username;
		this.password = password;
		this.displayname = displayname;
		this.isactive = isactive;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.phonenumber = phonenumber;
		this.address = address;
		this.email = email;
	}

	public int getId() {
        return id;
    }

    public int getRoleID() {
        return roleID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDisplayname() {
        return displayname;
    }

    public int getIsactive() {
        return isactive;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
    
}
