package com.raj.springweb.controller;


import com.raj.springweb.dto.BusinessRequest;
import com.raj.springweb.dto.BusinessResponse;
import com.raj.springweb.dto.LoginRequest;
import com.raj.springweb.dto.RegisterRequest;
import com.raj.springweb.model.Business;
import com.raj.springweb.model.User;
import com.raj.springweb.service.BusinessService;
import com.raj.springweb.service.UserService;
import com.raj.springweb.util.JwtUtil;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
    private final BusinessService businessService;
    private final UserService userService;

    public HelloController(BusinessService businessService, UserService userService) {
        this.businessService = businessService;
        this.userService = userService;
    }

    @PostMapping("/business")
    public BusinessResponse createBusiness(@Valid @RequestBody BusinessRequest request) {


        Business business = businessService.createBusiness(
                request.getName(),
                request.getOwner(),
                request.getType()
        );

        return new BusinessResponse("Business created successfuly", business.getName());
    }

    @GetMapping("/business")
    public List<Business> getAllBusinesses() {
        return businessService.getAllBusinesses();
    }

    @GetMapping("/business/{id}")
    public Business getBusiness(@PathVariable String id) {
        return businessService.getBusinessById(id);
    }

    @PutMapping("business/{id}")
    public BusinessResponse updateBusiness(@PathVariable String id, @RequestBody BusinessRequest request) {
        Business business = businessService.updateBusiness(
                id,
                request.getName(),
                request.getOwner(),
                request.getType()
        );
        return new BusinessResponse("Business updated successfuly", business.getName());

    }

    @DeleteMapping("/business/{id}")
    public BusinessResponse deleteBusinessById(@PathVariable String id) {
        String msg = businessService.deleteBusiness(id);
        return new BusinessResponse(msg, null);
    }


    //Dynamically fetching from db and doing
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {
        User user = userService.findByUsername(request.getUsername());

        if (!userService.checkPassword(request.getPassword(),user.getPassword())) {
            throw new RuntimeException("Invalid Credentials");
        }

        String token = JwtUtil.generateToken(user.getUsername(), user.getRole());

        return Map.of("token", token);

    }
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request){
        User user =new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        userService.saveUser(user);

        return "User registered successfully";
    }

}


