package com.codingshuttle.ecommerce.product_service.controllers;

import com.codingshuttle.ecommerce.product_service.dtos.ProductDTO;
import com.codingshuttle.ecommerce.product_service.entities.Product;
import com.codingshuttle.ecommerce.product_service.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/hello")
    public String hello() {
        return "hello from Spring app";
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping(path = "/{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createNewProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.createNewProduct(productDTO));
    }
}
