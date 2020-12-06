package com.mds.libraryMgmtSystem.controller;

import com.mds.libraryMgmtSystem.constant.GlobalConstant;
import com.mds.libraryMgmtSystem.entity.LibraryCard;
import com.mds.libraryMgmtSystem.pojo.LibraryCardPojo;
import com.mds.libraryMgmtSystem.repository.LibraryCardRepository;
import com.mds.libraryMgmtSystem.response.BaseResponse;
import com.mds.libraryMgmtSystem.service.LibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static java.lang.System.out;

@RestController
@CrossOrigin
public class LibraryCardController {
    @Autowired
    private LibraryCardService libraryCardService;

    @Autowired
    private LibraryCardRepository libraryCardRepository;

    @GetMapping(value = "/libraryCards")
    public BaseResponse getLibraryCard(Pageable pageable){
        Page<LibraryCard> libraryCard;
        try{
            libraryCard= libraryCardService.getLibraryCard(pageable);
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, libraryCard, GlobalConstant.Message.success_message);
    }

    @GetMapping(value="/libraryCard/{id}")
    public BaseResponse getById(@PathVariable Long id){
        LibraryCard libraryCard;
        try{
            libraryCard = libraryCardService.findById(id);
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, libraryCard, GlobalConstant.Message.success_message);
    }

    @GetMapping(value="/search/libraryCard")
    public BaseResponse searchLibraryCard(String rollNo){
        List<LibraryCard> libraryCard;

        try{
            libraryCard = libraryCardService.searchLibraryCard(rollNo);
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, libraryCard, GlobalConstant.Message.success_message);
    }

    @PostMapping(value = "/create/libraryCard")
    public BaseResponse createLibraryCard(@Validated @RequestBody LibraryCard libraryCard){
        try {

            Optional<LibraryCard> rollNo = libraryCardService.findByRollNo(libraryCard.getRollNo());
             if (rollNo.isPresent() ){
                out.println("Already RollNo Exists!");
                return null;
            } else{
                libraryCard = libraryCardService.addLibraryCard(libraryCard);
            }
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, libraryCard, GlobalConstant.Message.success_message);

    }

    @DeleteMapping(value="/libraryCard/{id}")
    public BaseResponse deleteLibraryCard(@PathVariable Long id){
        try {
            libraryCardService.deleteLibraryCard(id);
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, null, GlobalConstant.Message.success_message);

    }
    @PutMapping (value = "/update/libraryCard")
    public BaseResponse updateLibraryCard(@Validated @RequestBody LibraryCardPojo libraryCardPojo) {
        LibraryCard libraryCards;
        try{
            if(this.libraryCardRepository.existsById(libraryCardPojo.getId())){
                LibraryCard libraryCard= libraryCardService.findById(libraryCardPojo.getId());
                Optional<LibraryCard> libraryCardRollNo = libraryCardService.findByRollNo(libraryCardPojo.getRollNo());
                if(libraryCardRollNo.isPresent() && libraryCardRollNo.get().getId() == libraryCard.getId()){
                    libraryCard.setName(libraryCardPojo.getName());
                    libraryCard.setRollNo(libraryCardPojo.getRollNo());
                    libraryCard.setYear(libraryCardPojo.getYear());
                    libraryCard.setLogoUrl(libraryCardPojo.getLogoUrl());
                    libraryCards = libraryCardService.updateLibraryCard(libraryCard);
                }else if(!libraryCardRollNo.isPresent()){
                    libraryCard.setName(libraryCardPojo.getName());
                    libraryCard.setRollNo(libraryCardPojo.getRollNo());
                    libraryCard.setYear(libraryCardPojo.getYear());
                    libraryCard.setLogoUrl(libraryCardPojo.getLogoUrl());
                    libraryCards = libraryCardService.updateLibraryCard(libraryCard);
                }else{
                    throw new EntityExistsException("Already roll no exists");
                }
            }else{
                throw new EntityNotFoundException(libraryCardPojo.getId()+" not found");
            }

        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, e.getMessage());
        }

        return new BaseResponse(GlobalConstant.success, libraryCards,GlobalConstant.Message.success_message);

    }

}
