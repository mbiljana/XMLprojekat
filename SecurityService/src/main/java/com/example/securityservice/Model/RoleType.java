package com.example.securityservice.Model;

public enum RoleType{
	
	Admin(Values.Admin), User(Values.User), Company(Values.Company);

	RoleType(String value) {
        if (!this.name().equals(value))
            throw new IllegalArgumentException("Incorrect use of Role!");
    }

    public static class Values {
        public static final String User = "User";
        public static final String Company = "Company";
        public static final String Admin = "Admin";
    }

}
