package com.dbs.banking.poc.bankingdemo.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "image")
@ToString
public class Image extends BaseEntity {

    @Column(name = "imagePath")
    private String imagePath;

    @Column(name = "userId")
    private Long userId;

}
