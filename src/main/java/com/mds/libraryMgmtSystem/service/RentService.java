package com.mds.libraryMgmtSystem.service;

import com.mds.libraryMgmtSystem.entity.Book;
import com.mds.libraryMgmtSystem.entity.Librarian;
import com.mds.libraryMgmtSystem.entity.Rent;
import com.mds.libraryMgmtSystem.entity.Student;
import com.mds.libraryMgmtSystem.pojo.RentPojo;
import com.mds.libraryMgmtSystem.repository.BookRepository;
import com.mds.libraryMgmtSystem.repository.LibrarianRepository;
import com.mds.libraryMgmtSystem.repository.RentRepository;
import com.mds.libraryMgmtSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class RentService {
    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LibrarianRepository librarianRepository;
    @Autowired
    private BookRepository bookRepository;

    public List<Rent> getRent() {
        return rentRepository.findAll();
    }

    public Rent findById(Long id) {
        return rentRepository.findById(id).orElse(null);
    }


    public Rent addRent(RentPojo rentPojo) {
        Optional<Book> book =bookRepository.findByName(rentPojo.getBook());
        if(!book.isPresent()){
            throw new EntityNotFoundException("Book not found");
        }
        Optional<Student> student =studentRepository.findByStudentName(rentPojo.getStudent());
        if(!student.isPresent()){
            throw new EntityNotFoundException("Student not found");
        }
        Optional<Librarian> librarian =librarianRepository.findByName(rentPojo.getLibrarian());
        if(!librarian.isPresent()){
            throw new EntityNotFoundException("Librarian not found");
        }

        Rent rent = new Rent();

        rent.setRentFromDate(rentPojo.getRentFromDate());
        rent.setRentToDate(rentPojo.getRentToDate());
        rent.setReturnDate(rentPojo.getReturnDate());
        rent.setFine(rentPojo.getFine());
        rent.setStatus(rentPojo.getStatus());
        rent.setStudent(student.get());
        rent.setBook(book.get());
        rent.setLibrarian(librarian.get());
        return rentRepository.save(rent);
    }


    public Rent updateRent(Rent rent) {

        return rentRepository.save(rent);
    }

    public void deleteRent(Long id) {
        rentRepository.deleteById(id);
    }

    public List<Rent> findRentByStudentName(String name) {
        return rentRepository.findByStudentName(name);
    }
}
