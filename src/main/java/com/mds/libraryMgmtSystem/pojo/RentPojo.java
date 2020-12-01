package com.mds.libraryMgmtSystem.pojo;

import com.mds.libraryMgmtSystem.entity.Rent;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class RentPojo {
    private Long id;
    @NotNull
    private LocalDate rentFromDate;
    @NotNull
    private LocalDate rentToDate;
    @NotNull
    private LocalDate returnDate;
    private Integer fine;
    private Rent.Status status;

    @NotEmpty
    private String studentName;
    @NotEmpty
    private String bookName;
    @NotEmpty
    private String librarianName;

    public RentPojo(Long id, LocalDate rentFromDate, LocalDate rentToDate, LocalDate returnDate, Integer fine, Rent.Status status,String studentName, String bookName, String librarianName) {
        this.id = id;
        this.rentFromDate = rentFromDate;
        this.rentToDate = rentToDate;
        this.returnDate = returnDate;
        this.fine = fine;
        this.status = status;
        this.studentName = studentName;
        this.bookName = bookName;
        this.librarianName = librarianName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRentFromDate() {
        return rentFromDate;
    }

    public void setRentFromDate(LocalDate rentFromDate) {
        this.rentFromDate = rentFromDate;
    }

    public LocalDate getRentToDate() {
        return rentToDate;
    }

    public void setRentToDate(LocalDate rentToDate) {
        this.rentToDate = rentToDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getFine() {
        return fine;
    }

    public void setFine(Integer fine) {
        this.fine = fine;
    }

    public Rent.Status getStatus() {
        return status;
    }

    public void setStatus(Rent.Status status) {
        this.status = status;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getLibrarianName() {
        return librarianName;
    }

    public void setLibrarianName(String librarianName) {
        this.librarianName = librarianName;
    }
}
