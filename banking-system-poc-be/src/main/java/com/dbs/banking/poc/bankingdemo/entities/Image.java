package com.dbs.banking.poc.bankingdemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class Image extends BaseEntity {

    @Column(name = "imagePath")
    private String imagePath;

    @Column(name = "userId")
    private Long userId;

}
