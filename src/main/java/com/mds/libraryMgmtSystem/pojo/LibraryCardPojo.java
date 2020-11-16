package com.mds.libraryMgmtSystem.pojo;

public class LibraryCardPojo {
    private Long id;
    private String name;
    private String rollNo;
    private String year;
    private String logoUrl;

    public LibraryCardPojo(Long id, String name, String rollNo, String year, String logoUrl) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.year = year;
        this.logoUrl = logoUrl;
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
}
