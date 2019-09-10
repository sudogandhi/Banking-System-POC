package com.dbs.banking.poc.bankingdemo.controller;

import com.dbs.banking.poc.bankingdemo.dto.ResponseDTO;
import com.dbs.banking.poc.bankingdemo.email.EmailServiceImpl;
import com.dbs.banking.poc.bankingdemo.entities.Customer;
import com.dbs.banking.poc.bankingdemo.entities.ImageType;
import com.dbs.banking.poc.bankingdemo.exceptions.UserNotExistsException;
import com.dbs.banking.poc.bankingdemo.jwt.JwtTokenAuthorizationOncePerRequestFilter;
import com.dbs.banking.poc.bankingdemo.repositories.CustomerRepository;
import com.dbs.banking.poc.bankingdemo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/upload")
public class ImageUploadController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    JwtTokenAuthorizationOncePerRequestFilter jwtTokenAuthorizationOncePerRequestFilter;

    @Autowired
    ImageService imageService;

    @Autowired
    EmailServiceImpl emailService;


    @PostMapping("/helloWorld1")
    public String helloWorld() {

        return jwtTokenAuthorizationOncePerRequestFilter.getLoggedInUsername();
    }

    @RequestMapping(value = "/adhar",method = { RequestMethod.POST, RequestMethod.PUT },
            consumes = { "multipart/form-data","image/jpeg","image/png" })
    ResponseDTO uploadAdharCard(@RequestParam("file") MultipartFile file) throws Exception {
        System.out.println(file);
        if(file == null) {
            return new ResponseDTO("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            imageService.uploadImage(file,ImageType.ADHAR);
            emailService.sendSimpleMessage("gauravgo4friends@gmail.com","Test","Adhar is downloaded.");
            return new ResponseDTO("success",HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/pan",method = { RequestMethod.POST, RequestMethod.PUT },
            consumes = { "multipart/form-data","image/jpeg","image/png" })
    ResponseDTO uploadPanCard(@RequestParam("file") MultipartFile file) throws Exception {
        System.out.println(file);
        if(file == null) {
            return new ResponseDTO("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            imageService.uploadImage(file,ImageType.PAN);
            return new ResponseDTO("success",HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/display",method = { RequestMethod.POST, RequestMethod.PUT },
            consumes = { "multipart/form-data","image/jpeg","image/png" })
    ResponseDTO uploadDisplayImage(@RequestParam("file") MultipartFile file) throws Exception {
        System.out.println(file);
        if(file == null) {
            return new ResponseDTO("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            imageService.uploadImage(file, ImageType.DISPLAY);
            return new ResponseDTO("success",HttpStatus.OK);
        }
    }


}
