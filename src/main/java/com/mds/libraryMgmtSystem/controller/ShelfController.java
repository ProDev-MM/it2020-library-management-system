package com.mds.libraryMgmtSystem.controller;

import com.mds.libraryMgmtSystem.constant.GlobalConstant;
import com.mds.libraryMgmtSystem.entity.Shelf;
import com.mds.libraryMgmtSystem.pojo.ShelfPojo;
import com.mds.libraryMgmtSystem.response.BaseResponse;
import com.mds.libraryMgmtSystem.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.System.out;

@RestController
public class ShelfController {
    @Autowired
    ShelfService shelfService;

    @GetMapping(value = "/shelfs")
    public BaseResponse getShelves(){
        List<Shelf> shelf;
        try{
            shelf= shelfService.getShelves();
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, shelf, GlobalConstant.Message.success_message);
    }

    @GetMapping(value="/shelf/{id}")
    public BaseResponse getById(@PathVariable Long id){
        Shelf shelf;
        try{
            shelf = shelfService.findById(id);
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, shelf, GlobalConstant.Message.success_message);
    }

    @PostMapping(value = "/shelf")
    public BaseResponse createShelf(@RequestBody Shelf shelf){
        try {
            shelf = shelfService.addShelf(shelf);
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, shelf, GlobalConstant.Message.success_message);

    }

    @DeleteMapping(value="/shelf/{id}")
    public BaseResponse deleteShelf(@PathVariable Long id){
        try {
            shelfService.deleteShelf(id);
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, null, GlobalConstant.Message.success_message);

    }
//
    @PutMapping (value = "/shelf")
    public BaseResponse updateStudent(@RequestBody ShelfPojo shelfPojo) {
        Shelf shelves;

        try{
            Shelf shelf = shelfService.findById(shelfPojo.getId());

            if(shelf==null) {
                return null;
            }
            shelf.setRoom(shelfPojo.getRoom());
            shelves = shelfService.updateShelf(shelf);

        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }

        return new BaseResponse(GlobalConstant.success, shelves,GlobalConstant.Message.success_message);

    }

}
