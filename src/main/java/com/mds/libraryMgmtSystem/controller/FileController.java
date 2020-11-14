package com.mds.libraryMgmtSystem.controller;

import com.mds.libraryMgmtSystem.response.UploadResponse;
import com.mds.libraryMgmtSystem.service.FileService;
import com.mds.libraryMgmtSystem.constant.GlobalConstant;
import com.mds.libraryMgmtSystem.response.BaseResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.FileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.StringTokenizer;


@RestController
@CrossOrigin
public class FileController {

    Logger logger= LoggerFactory.getLogger(FileController.class);

    @Autowired
    FileService fileService;

    @GetMapping("file/download")
    //upload/PROFILE/Htet Lwin Aun/55991602399446006/200x200bb.jpg"
    public void downloadFile(@RequestParam String path, HttpServletResponse response) {
        logger.info("Info to download file path {} ",path);

        File file = new File(path);
        try (FileInputStream fos = new FileInputStream(file)) {
            StringTokenizer token = new StringTokenizer(path, "/");
            String fileName = null;
            while (token.hasMoreTokens()) {
                fileName = token.nextToken();
            }
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
            IOUtils.copy(fos, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("file/upload")
    public BaseResponse uploadFile(@RequestParam MultipartFile file, @RequestParam Integer location, @RequestParam String name) {
        logger.debug("REST request to upload file {} to location {}", location);
        UploadResponse response = null;


        String pathFile = fileService.getFolderPath(location,name);

        try {
            fileService.saveFile(file, pathFile);
            response = new UploadResponse();
            response.setUrl(pathFile + "/" + file.getOriginalFilename());
            response.setFileName(file.getOriginalFilename());
            response.setStatus(true);
            response.setFileContentType(file.getContentType());

            logger.debug("Upload file {} success", file.getOriginalFilename());
        } catch (IOException e) {

            logger.warn("Upload file {} error", file.getOriginalFilename(), e);
            e.printStackTrace();
        }
        return new BaseResponse(GlobalConstant.success, response, GlobalConstant.Message.success_message);
    }

    @GetMapping(path = {"/file/get/**"})
    @CrossOrigin
    public ResponseEntity<byte[]> getImage(HttpServletRequest request) throws IOException {
        String fileName = request.getServletPath();
        int index = fileName.indexOf("upload");
        try {

            fileName = fileName.substring(index);

        }catch (StringIndexOutOfBoundsException e){
            return null;
        }
        File image = new File(fileName);
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(image)))
                .body(Files.readAllBytes(image.toPath()));
    }

}
