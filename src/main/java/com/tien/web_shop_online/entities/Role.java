package com.tien.web_shop_online.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private Date modifiedDate;

    public Role() {
    }

    public Role(String name, String description, Date modifiedDate) {
        this.name = name;
        this.description = description;
        this.modifiedDate = modifiedDate;
    }

    public Role(Integer id, String name, String description, Date modifiedDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", modifiedDate=" + modifiedDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
