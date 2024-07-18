package com.shyam.clients;

import java.util.List;

import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;

import com.shyam.dto.ProductDTO;
import com.shyam.dto.ProductRequestDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DemoClient {

    private final HttpGraphQlClient graphQlClient;

    public List<ProductDTO> viewProducts() {
        String graphQLQuery = "query GetProducts {\n" +
                "    getProducts {\n" +
                "        id\n" +
                "        name\n" +
                "        price\n" +
                "    }\n" +
                "}";

        return graphQlClient.document(graphQLQuery)
                .retrieve("getProducts")
                .toEntityList(ProductDTO.class).block();
    }

    public ProductDTO addProduct(ProductRequestDTO request) {
        String query = String.format("mutation CreateProduct {\n"+
                            "createProduct(name: \"%s\", category: \"%s\", price: %f, stock: %d) {\n"+
                                "id\n"+
                                "name\n"+
                                "price\n"+
                            "}\n"+
                        "}", request.getName(), request.getCategory(), request.getPrice(), request.getStock());

        return graphQlClient.document(query)
                        .retrieve("createProduct")
                        .toEntity(ProductDTO.class).block();

        
    }

}