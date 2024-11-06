package com.codingshuttle.ecommerce.product_service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    @GetMapping("/hello")
    public String hello() {
        return "hello from Spring app";
    }
}
