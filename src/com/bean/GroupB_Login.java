package com.bean;

public class GroupB_Login {
	private String user_ID,user_Designation,password;

	public GroupB_Login() {
		super();
	}

	public GroupB_Login(String user_ID, String user_Designation, String password) {
		super();
		this.user_ID = user_ID;
		this.user_Designation = user_Designation;
		this.password = password;
	}

	public String getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}

	public String getUser_Designation() {
		return user_Designation;
	}

	public void setUser_Designation(String user_Designation) {
		this.user_Designation = user_Designation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}






/*insert
into tablename (timestamp_value)
values (CURRENT_TIMESTAMP);

timestamp java
Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);*/