package com.kem.university.dto;

import com.kem.university.config.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class Account implements UserDetails {
    private String id;
    private String login;
    private String password;
    private Student student;
    private Teacher teacher;
    private Role role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + getRole()));
    }

    @Override
    public String getPassword() {
        return getPassword();
    }

    @Override
    public String getUsername() {
        return getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Account.Builder newBuilder() {
        return new Account().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Account.Builder setId(String id) {
            Account.this.id = id;
            return this;
        }

        public Account.Builder setLogin(String login) {
            Account.this.login = login;
            return this;
        }

        public Account.Builder setPassword(String password) {
            Account.this.password = password;
            return this;
        }

        public Account.Builder setStudent(Student student) {
            Account.this.student = student;
            return this;
        }

        public Account.Builder setTeacher(Teacher teacher) {
            Account.this.teacher = teacher;
            return this;
        }

        public Account.Builder setRole(Role role) {
            Account.this.role = role;
            return this;
        }

        public Account build() {
            return Account.this;
        }

    }
}
