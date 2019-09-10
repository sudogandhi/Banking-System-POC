package com.dbs.banking.poc.bankingdemo.entities;

public enum ImageType  {
    ADHAR("ADHAR"),PAN("PAN"),DISPLAY("DISPLAY");

    String imageType;
    ImageType(String imageType) {
        this.imageType = imageType;
    }
}
