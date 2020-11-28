package com.mds.libraryMgmtSystem.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "category")
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY,generator="seq")
    private Long id;

    @Column
    @NotEmpty
    private String type;

    @Column
    @NotEmpty
    private String description;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
