package com.raj.springweb.service;

import com.raj.springweb.dto.BusinessResponse;
import com.raj.springweb.exception.BusinessNotFoundException;
import com.raj.springweb.model.Business;
import com.raj.springweb.repository.BusinessRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class BusinessService {

    private final BusinessRepository businessRepository;
    public BusinessService(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }
    public Business createBusiness(String name,String owner,String type){
        System.out.println("Creating business: " + name);

        Business business=new Business(name,owner,type);
        return businessRepository.save(business);
    }
    public List<Business> getAllBusinesses(){
        System.out.println("Fetching all businesses");
        return businessRepository.findAll();
    }
    public Business getBusinessById(String id){
        return businessRepository.findById(id)
                .orElseThrow(()->new BusinessNotFoundException("Business not found with id"+id));
    }
    public Business updateBusiness(String id,String name,String owner,String type) {
        Business existing = businessRepository.findById(id)
                .orElseThrow(() -> new BusinessNotFoundException("Business not found by id" + id));
        existing.setName(name);
        existing.setOwner(owner);
        existing.setType(type);
        return businessRepository.save(existing);

    }
    public String deleteBusiness(String id){
        Business existing=getBusinessById(id);
        businessRepository.delete(existing);
        return "business deleted";
    }


}
