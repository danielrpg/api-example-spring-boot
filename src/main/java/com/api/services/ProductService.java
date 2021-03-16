package com.api.services;

import com.api.dtos.CreateProductDTO;
import com.api.dtos.UpdateProductDTO;
import com.api.payload.ProductMessageResponse;

public interface ProductService {
    ProductMessageResponse getAllProducts();

    ProductMessageResponse createProduct(CreateProductDTO createProductDTO);

    ProductMessageResponse updateProduct(Long id, UpdateProductDTO updateProductDTO);

    ProductMessageResponse deleteProduct(Long id);

    ProductMessageResponse getProductById(Long id);
}
