package com.cognologix.product.services;

import com.cognologix.product.entities.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAllProducts();
    List<Product> findByProductId(Integer productId);
    void saveProduct(Product product);

    Product updateProductById(Integer productId, Product product);

    List<Product> deleteProductById(Integer productId);
}
