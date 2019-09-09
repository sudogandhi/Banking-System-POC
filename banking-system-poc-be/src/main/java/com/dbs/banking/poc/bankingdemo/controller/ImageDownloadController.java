package com.dbs.banking.poc.bankingdemo.controller;

import com.dbs.banking.poc.bankingdemo.entities.ImageType;
import com.dbs.banking.poc.bankingdemo.exceptions.UserNotExistsException;
import com.dbs.banking.poc.bankingdemo.jwt.JwtTokenAuthorizationOncePerRequestFilter;
import com.dbs.banking.poc.bankingdemo.repositories.CustomerRepository;
import com.dbs.banking.poc.bankingdemo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/download")
public class ImageDownloadController {


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    JwtTokenAuthorizationOncePerRequestFilter jwtTokenAuthorizationOncePerRequestFilter;

    @Autowired
    ImageService imageService;
    @GetMapping(value = "/adhar/{username}")
    ResponseEntity<Resource> downloadAdhar(@PathVariable("username") String username)
            throws UserNotExistsException, FileNotFoundException {
        System.out.println(username);
        return imageService.downloadImage(ImageType.ADHAR,username);
    }


    @GetMapping(value = "/pan/{username}")
    ResponseEntity<Resource> downloadPan(@PathVariable("username") String username)
            throws UserNotExistsException, FileNotFoundException {
        return imageService.downloadImage(ImageType.PAN, username);
    }


    @GetMapping(value = "/display/{username}")
    ResponseEntity<Resource> downloadDisplayImage(@PathVariable("username") String username)
            throws UserNotExistsException, FileNotFoundException {
        return imageService.downloadImage(ImageType.DISPLAY, username);
    }
}
