package com.mds.libraryMgmtSystem.pojo;

import java.time.LocalDate;

public class OQPojo {
    private Long id;
    private String subject;
    private String pdfUrl;
    private String year;
    private LocalDate postedDate;

    @Override
    public String toString() {
        return "OQPojo{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", pdfUrl='" + pdfUrl + '\'' +
                ", year='" + year + '\'' +
                ", postedDate=" + postedDate +
                '}';
    }

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
