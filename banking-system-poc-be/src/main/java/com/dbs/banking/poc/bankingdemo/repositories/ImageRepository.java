package com.dbs.banking.poc.bankingdemo.repositories;

import com.dbs.banking.poc.bankingdemo.entities.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<Image,Long> {
}
