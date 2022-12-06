package com.tien.web_shop_online.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String job;

    private String email;

    private String phone;

    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    private Date modifiedDate;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String job, String email, String phone, String password, Role role, Date modifiedDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
        this.modifiedDate = modifiedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }


}
