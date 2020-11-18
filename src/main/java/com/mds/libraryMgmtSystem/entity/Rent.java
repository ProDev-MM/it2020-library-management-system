package com.mds.libraryMgmtSystem.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="rent")
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
public class Rent {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY,generator="seq")
    private Long id;

    @Column
    private LocalDate rentFromDate;

    @Column
    private LocalDate rentToDate;

    @Column
    private LocalDate returnDate;

    @Column
    private Integer fine;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public enum Status{
      Pending, Accessed ;
    }

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @OneToOne
    @JoinColumn(name = "librarian_id")
    private Librarian librarian;

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }
}
