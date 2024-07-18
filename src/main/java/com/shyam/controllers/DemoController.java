package com.shyam.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shyam.Services.DemoService;
import com.shyam.dto.ProductDTO;
import com.shyam.dto.ProductRequestDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/get-products")
    public List<ProductDTO> getProducts() {
        return demoService.getProducts();
    }

    @PostMapping("/add-product")
    public ProductDTO addProduct(@RequestBody ProductRequestDTO dto) {
        return demoService.addProduct(dto);
    }

}