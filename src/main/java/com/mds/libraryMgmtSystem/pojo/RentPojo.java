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
    private String student;
    @NotEmpty
    private String book;
    @NotEmpty
    private String librarian;

    public RentPojo() {

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

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getLibrarian() {
        return librarian;
    }

    public void setLibrarian(String librarian) {
        this.librarian = librarian;
    }
}
