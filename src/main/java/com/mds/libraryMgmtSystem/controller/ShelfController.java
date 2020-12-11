package com.mds.libraryMgmtSystem.controller;

import com.mds.libraryMgmtSystem.constant.GlobalConstant;
import com.mds.libraryMgmtSystem.entity.Shelf;
import com.mds.libraryMgmtSystem.pojo.ShelfPojo;
import com.mds.libraryMgmtSystem.response.BaseResponse;
import com.mds.libraryMgmtSystem.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.System.out;

@RestController
@CrossOrigin
public class ShelfController {
    @Autowired
    private ShelfService shelfService;

    @GetMapping(value = "/shelves")
    public BaseResponse getShelves(@RequestParam(defaultValue = "0") Integer pageNo,
                                   @RequestParam(defaultValue = "3000") Integer pageSize){
        List<Shelf> shelf;
        try{
            shelf= shelfService.getShelves(pageNo, pageSize);
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

    @PostMapping(value = "/create/shelf")
    public BaseResponse createShelf(@Validated @RequestBody Shelf shelf){
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

    @PutMapping (value = "/update/shelf")
    public BaseResponse updateStudent(@Validated @RequestBody ShelfPojo shelfPojo) {
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
