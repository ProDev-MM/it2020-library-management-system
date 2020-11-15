package com.mds.libraryMgmtSystem.controller;

import com.mds.libraryMgmtSystem.constant.GlobalConstant;
import com.mds.libraryMgmtSystem.entity.LibraryCard;
import com.mds.libraryMgmtSystem.pojo.LibraryCardPojo;
import com.mds.libraryMgmtSystem.response.BaseResponse;
import com.mds.libraryMgmtSystem.service.LibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.System.out;

@RestController
@CrossOrigin
public class LibraryCardController {
    @Autowired
    private LibraryCardService libraryCardService;

    @GetMapping(value = "/libraryCards")
    public BaseResponse getLibraryCard(){
        List<LibraryCard> libraryCard;
        try{
            libraryCard= libraryCardService.getLibraryCard();
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

    @PostMapping(value = "/libraryCard")
    public BaseResponse createLibraryCard(@RequestBody LibraryCard libraryCard){
        try {
            libraryCard = libraryCardService.addLibraryCard(libraryCard);
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

    @PutMapping (value = "/libraryCard")
    public BaseResponse updateLibraryCard(@RequestBody LibraryCardPojo libraryCardPojo) {
        LibraryCard libraryCards;

        try{
            LibraryCard libraryCard = libraryCardService.findById(libraryCardPojo.getId());

            if(libraryCard==null) {
                return null;
            }
            libraryCard.setName(libraryCardPojo.getName());
            libraryCard.setRollNo(libraryCardPojo.getRollNo());
            libraryCard.setYear(libraryCardPojo.getYear());
            libraryCards = libraryCardService.updateLibraryCard(libraryCard);

        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }

        return new BaseResponse(GlobalConstant.success, libraryCards,GlobalConstant.Message.success_message);

    }

}
