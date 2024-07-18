package com.shyam.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shyam.clients.DemoClient;
import com.shyam.dto.ProductDTO;
import com.shyam.dto.ProductRequestDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DemoService {
    
    private final DemoClient demoClient;

    public ProductDTO addProduct(ProductRequestDTO requestDTO) {
        return demoClient.addProduct(requestDTO);
    }
    
    public List<ProductDTO> getProducts() {
        return demoClient.viewProducts();
    }

}