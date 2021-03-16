package com.api.services;

import com.api.dtos.CreateProductDTO;
import com.api.dtos.ProductDTO;
import com.api.dtos.UpdateProductDTO;
import com.api.models.Product;
import com.api.payload.ProductMessageResponse;
import com.api.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    public static final String LIST_OF_PRODUCTS = "List of products";
    public static final String PRODUCT_WAS_ALREADY_SAVED_SUCCESSFULLY = "Product was already saved successfully";
    public static final String PRODUCT_WAS_ALREADY_UPDATED_SUCCESSFULLY = "Product was already updated successfully";
    public static final String PRODUCT_WAS_ALREADY_DELETED_SUCCESSFULLY = "Product was already deleted successfully";
    public static final String PRODUCT_WAS_FOUND_SUCCESSFUL = "Product was found successful!";
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
    @Transactional
    public ProductMessageResponse createProduct(CreateProductDTO createProductDTO) {
        Product newProduct = getProduct(createProductDTO, new Product());
        this.productRepository.save(newProduct);
        List<Product> productList = new ArrayList<>();
        productList.add(newProduct);
        return getProductMessageResponse(productList, PRODUCT_WAS_ALREADY_SAVED_SUCCESSFULLY);
    }

    @Override
    @Transactional
    public ProductMessageResponse updateProduct(Long id, UpdateProductDTO updateProductDTO) {
        Product oldProduct = this.productRepository.findById(id).get();
        Product newProduct = getProduct(updateProductDTO, oldProduct);
        List<Product> productList = new ArrayList<>();
        productList.add(newProduct);
        return getProductMessageResponse(productList, PRODUCT_WAS_ALREADY_UPDATED_SUCCESSFULLY);
    }

    @Override
    @Transactional
    public ProductMessageResponse deleteProduct(Long id) {
        Product oldProduct = this.productRepository.findById(id).get();
        List<Product> productList = new ArrayList<>();
        productList.add(oldProduct);
        this.productRepository.deleteById(id);
        return getProductMessageResponse(productList, PRODUCT_WAS_ALREADY_DELETED_SUCCESSFULLY);
    }

    @Override
    public ProductMessageResponse getProductById(Long id) {
        Product product = this.productRepository.findById(id).get();
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        return getProductMessageResponse(productList, PRODUCT_WAS_FOUND_SUCCESSFUL);
    }

    private ProductMessageResponse getProductMessageResponse(List<Product> productList, String message) {
        ProductMessageResponse productMessageResponse = new ProductMessageResponse();
        productMessageResponse.setStatus(true);
        productMessageResponse.setErrorCode(200);
        productMessageResponse.setMessage(message);
        productMessageResponse.setProductList(productList);

        return productMessageResponse;
    }

    private Product getProduct(ProductDTO productDTO, Product product) {
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setProductDate(productDTO.getProductDate());
        return product;
    }
}
