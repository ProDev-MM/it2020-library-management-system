package com.mds.libraryMgmtSystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@CrossOrigin
public class AppController {

    @GetMapping("/greet")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello Everyone!");
    }

    @GetMapping("/student")
    public ResponseEntity<String> staffAPI(){
        return ResponseEntity.ok("Staff but also Admin can accept this one!");
    }

    @GetMapping("/librarian")
    public ResponseEntity<String> managerAPI(){
        return ResponseEntity.ok("Only Admin Can accept this one!");
    }
}
