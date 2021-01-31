package com.api.payload;

import com.api.models.Product;

import java.util.List;

public class ProductMessageResponse extends MessageResponse {

    private List<Product> productList;

    public ProductMessageResponse() {

    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
