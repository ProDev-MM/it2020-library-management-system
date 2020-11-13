package com.mds.libraryMgmtSystem.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "oq")
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
public class OQ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq")
    private Long id;

    @Column
    private String subject;
    @Column
    private String pdfUrl;
    @Column
    private String year;
    @Column
    private LocalDate postedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public LocalDate getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }
}
