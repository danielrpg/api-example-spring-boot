package com.api.services;

import com.api.dtos.CreateProductDTO;
import com.api.dtos.UpdateProductDTO;
import com.api.models.Product;
import com.api.payload.MessageResponse;
import com.api.payload.ProductMessageResponse;
import com.api.repositories.ProductRepository;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    public static final String LIST_OF_PRODUCTS = "List of products";
    final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductMessageResponse getAllProducts() {
        List<Product> productList = this.productRepository.findAll();
        return getProductMessageResponse(productList, LIST_OF_PRODUCTS);
    }

    @Override
    public ProductMessageResponse createProduct(CreateProductDTO createProductDTO) {
        return null;
    }

    @Override
    public ProductMessageResponse updateProduct(Long id, UpdateProductDTO updateProductDTO) {
        return null;
    }

    @Override
    public ProductMessageResponse deleteProduct(Long id) {
        return null;
    }

    private ProductMessageResponse getProductMessageResponse(List<Product> productList, String message) {
        ProductMessageResponse productMessageResponse = new ProductMessageResponse();
        productMessageResponse.setMessage(message);
        productMessageResponse.setProductList(productList);

        return productMessageResponse;
    }
}
