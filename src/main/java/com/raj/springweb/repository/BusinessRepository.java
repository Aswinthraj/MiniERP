package com.raj.springweb.repository;

import com.raj.springweb.model.Business;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusinessRepository extends MongoRepository<Business, String> {
}