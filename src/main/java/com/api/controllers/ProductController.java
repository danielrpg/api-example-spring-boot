package com.api.controllers;

import com.api.dtos.CreateProductDTO;
import com.api.dtos.UpdateProductDTO;
import com.api.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/")
public class ProductController {

    final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "products")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.productService.getAllProducts());
    }

    @PostMapping(value = "products")
    public ResponseEntity<?> createProduct(@RequestBody CreateProductDTO createProductDTO) {
        return ResponseEntity.ok(this.productService.createProduct(createProductDTO));
    }

    @PutMapping(value = "products/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody UpdateProductDTO updateProductDTO) {
        return ResponseEntity.ok(this.productService.updateProduct(id, updateProductDTO));
    }

    @DeleteMapping(value = "products/{id}")
    public  ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(this.productService.deleteProduct(id));
    }
}
