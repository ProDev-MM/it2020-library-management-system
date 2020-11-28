package com.mds.libraryMgmtSystem.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "library_card")
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
public class LibraryCard {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY,generator="seq")
    private  Long id;

    @Column
    @NotEmpty
    private String name;

    @Column
    @NotEmpty
    private String rollNo;

    @Column
    @NotEmpty
    private String year;

    @Column
    @NotEmpty
    private String logoUrl;

    public LibraryCard() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @Override
    public String toString() {
        return "LibraryCard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rollNo='" + rollNo + '\'' +
                ", year='" + year + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                '}';
    }
}
