package com.mds.libraryMgmtSystem.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mds.libraryMgmtSystem.entity.Rent;

import java.time.LocalDate;

public class RentPojo {
    private Long id;
    private LocalDate rentFromDate;
    private LocalDate rentToDate;
    private LocalDate returnDate;
    private Integer fine;
    private Rent.Status status;

    private Long studentId;
    private Long bookId;
    private Long librarianId;

    public RentPojo(Long id, LocalDate rentFromDate, LocalDate rentToDate, LocalDate returnDate, Integer fine, Rent.Status status, Long studentId, Long bookId, Long librarianId) {
        this.id = id;
        this.rentFromDate = rentFromDate;
        this.rentToDate = rentToDate;
        this.returnDate = returnDate;
        this.fine = fine;
        this.status = status;
        this.studentId = studentId;
        this.bookId = bookId;
        this.librarianId = librarianId;
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

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(Long librarianId) {
        this.librarianId = librarianId;
    }
}
