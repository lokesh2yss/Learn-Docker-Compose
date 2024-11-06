package com.codingshuttle.ecommerce.product_service.services;

import com.codingshuttle.ecommerce.product_service.dtos.ProductDTO;
import com.codingshuttle.ecommerce.product_service.entities.Product;
import com.codingshuttle.ecommerce.product_service.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    public List<ProductDTO> getAllProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() ->
                        new RuntimeException("Product not found with id: "+productId));
        return modelMapper.map(product, ProductDTO.class);
    }

    public ProductDTO createNewProduct(ProductDTO productDTO) {
        Product toCreateProduct = modelMapper.map(productDTO, Product.class);
        Product savedProduct = productRepository.save(toCreateProduct);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }
}
