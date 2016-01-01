package com.keemono.core.mysql.domain.user;

import com.keemono.core.mysql.domain.AbstractDomain;
import com.keemono.core.mysql.domain.layout.Layout;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by edu on 23/05/2015.
 */

@Entity
@Table(name = "user")
public class User extends AbstractDomain {

    public User(){
        super();

    }

    @OneToMany
    private List<Layout> layout;

    @Column(name = "lastName", length = 2000)
    private String lastName;

    @Column(name = "email", nullable = false,length = 255)
    private String email;

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
