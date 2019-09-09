package com.dbs.banking.poc.bankingdemo.service;

import com.dbs.banking.poc.bankingdemo.entities.Customer;
import com.dbs.banking.poc.bankingdemo.entities.Image;
import com.dbs.banking.poc.bankingdemo.entities.ImageType;
import com.dbs.banking.poc.bankingdemo.exceptions.UserNotExistsException;
import com.dbs.banking.poc.bankingdemo.jwt.JwtTokenAuthorizationOncePerRequestFilter;
import com.dbs.banking.poc.bankingdemo.repositories.CustomerRepository;
import com.dbs.banking.poc.bankingdemo.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Service
public class ImageService {

    @Autowired
    CustomerService customerService;

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Value("${image.upload.dir}")
    private String uploadDirectoryPath;

    public void isDirectoryPresent() {
        File file = new File(uploadDirectoryPath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public void uploadImage(MultipartFile file, ImageType imageType) throws IOException, UserNotExistsException {
        isDirectoryPresent();


        String imagePath = uploadDirectoryPath + imageType.name()  + (System.currentTimeMillis())+getImageType(file);
        File localFile = new File(imagePath);

        InputStream inputStream = file.getInputStream();
        OutputStream outputStream = new FileOutputStream(localFile);
        FileCopyUtils.copy(inputStream, outputStream);
        Image image = new Image();
        image.setImagePath(imagePath);
        Customer customer = customerService.getLoggedInCustomer();

        switch (imageType.ordinal()) {
            case 1: {
                customer.setAdharCardImage(image);
                break;
            }
            case 2: {
                customer.setPanCardImage(image);
                break;
            }
            case 3: {
                customer.setDisplayImage(image);
                break;
            }
        }
        Set<Image> images = customer.getImages();
        if(images == null) {
            images = new HashSet<Image>();
        }
        images.add(image);
        customer.setImages(images);
        customerRepository.save(customer);
    }

    public String getImageType(MultipartFile file) {
        String contentType = file.getContentType();
        return "."+contentType.substring(contentType.indexOf("/")+1);
    }
}
