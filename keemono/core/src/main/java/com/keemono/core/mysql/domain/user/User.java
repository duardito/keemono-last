package com.keemono.core.mysql.domain.user;

import com.keemono.core.mysql.domain.AbstractDomain;
import com.keemono.core.mysql.domain.layout.Layout;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * Created by edu on 23/05/2015.
 */

@Entity
@Table(name = "user")
public class User extends AbstractDomain {

    public User(){
        super(User.class.getName());
    }

    @OneToMany
    private List<Layout> layout;

    @Column(name = "lastName", length = 2000)
    private String lastName;

    @Column(name = "email", nullable = false,length = 255)
    private String email;

    @Column(name = "username", nullable = false,length = 255)
    private String username;

    @Column(name = "password", nullable = false,length = 255)
    private String password;

    @Column(name = "lastPasswordReset")
    private Date lastPasswordReset;

    @Column(name = "authorities")
    private String authorities;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastPasswordReset() {
        return lastPasswordReset;
    }

    public void setLastPasswordReset(Date lastPasswordReset) {
        this.lastPasswordReset = lastPasswordReset;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Layout> getLayout() {
        return layout;
    }

    public void setLayout(List<Layout> layout) {
        this.layout = layout;
    }
}
