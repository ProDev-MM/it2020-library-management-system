package com.mds.libraryMgmtSystem.controller;

import com.mds.libraryMgmtSystem.constant.GlobalConstant;
import com.mds.libraryMgmtSystem.entity.OQ;
import com.mds.libraryMgmtSystem.pojo.OQPojo;
import com.mds.libraryMgmtSystem.response.BaseResponse;
import com.mds.libraryMgmtSystem.service.OQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class OQController {
    @Autowired
    private OQService oqService;

    @GetMapping(value = "/oqs")
    public BaseResponse getOQ() {
        List<OQ> oq;
        try {
            oq = oqService.getOQ();
        } catch (Exception e) {
            System.out.println("Error occur " + e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, oq, GlobalConstant.Message.success_message);
    }

    @GetMapping(value = "/oq/{id}")
    public BaseResponse getById(@PathVariable Long id) {
        OQ oq;
        try {
            oq = oqService.findById(id);
        } catch (Exception e) {
            System.out.println("Error occur " + e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, oq, GlobalConstant.Message.success_message);
    }

    @PostMapping(value = "/oq")
    public BaseResponse createOQ(@RequestBody OQ oq) {
        try {
            oq = oqService.addOQ(oq);
        } catch (Exception e) {
            System.out.println("Error occur " + e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, oq, GlobalConstant.Message.success_message);

    }

    @DeleteMapping(value = "/oq/{id}")
    public BaseResponse deleteOQ(@PathVariable Long id) {
        try {
            oqService.deleteOQ(id);
        } catch (Exception e) {
            System.out.println("Error occur " + e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, null, GlobalConstant.Message.success_message);

    }

    @PutMapping(value = "/oq")
    public BaseResponse updateOQ(@RequestBody OQPojo oqPojo) {

        OQ oqs;

        try {
            OQ oq = oqService.findById(oqPojo.getId());

            if (oq == null) {
                return null;
            }
            oq.setSubject(oqPojo.getSubject());
            oq.setPdfUrl(oqPojo.getPdfUrl());
            oq.setYear(oqPojo.getYear());
            oq.setPostedDate(oqPojo.getPostedDate());
            oqs = oqService.updateOQ(oq);

        } catch (Exception e) {
           System.out.println("Error occur " + e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }

        return new BaseResponse(GlobalConstant.success, oqs, GlobalConstant.Message.success_message);

    }
}
