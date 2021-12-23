package com.kem.university.dto;

import com.kem.university.config.Role;

public class Profile {
    private String login;
    private String password;
    private String firstName;
    private String secondName;
    private String email;
    private String role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Profile.Builder newBuilder() {
        return new Profile().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Profile.Builder setLogin(String login) {
            Profile.this.login = login;
            return this;
        }

        public Profile.Builder setPassword(String password) {
            Profile.this.password = password;
            return this;
        }

        public Profile.Builder setFirstName(String firstName) {
            Profile.this.firstName = firstName;
            return this;
        }

        public Profile.Builder setSecondName(String secondName) {
            Profile.this.secondName = secondName;
            return this;
        }

        public Profile.Builder setEmail(String email) {
            Profile.this.email = email;
            return this;
        }


        public Profile.Builder setRole(String role) {
            Profile.this.role = role;
            return this;
        }

        public Profile build() {
            return Profile.this;
        }

    }
}
