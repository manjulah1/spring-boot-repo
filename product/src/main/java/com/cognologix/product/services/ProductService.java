package com.cognologix.product.services;

import com.cognologix.product.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private List<Product> productsList = new ArrayList<>();

    @Override
    public List<Product> findAllProducts() {
        return productsList;
    }

    @Override
    public List<Product> findByProductId(Integer productId) {
        return productsList.stream().filter(product1 -> product1.getProductId() == productId).map(product -> new Product(product.getProductId(), product.getProductName(), product.getBatchNo(), product.getPrice(), product.getNoofProduct())).collect(Collectors.toList());
    }

    @Override
    public void saveProduct(Product product) {
        productsList.add(product);
    }

    @Override
    public Product updateProductById(Integer productId, Product product) {
        for(Product product1: productsList) {
            if(product1.getProductId() == productId) {
                product1.setProductId(product.getProductId());
                product1.setProductName(product.getProductName());
                product1.setBatchNo(product.getBatchNo());
                product1.setPrice(product.getPrice());
                product1.setNoofProduct(product.getNoofProduct());
                return product1;
            }
        }
        return null;
    }

    @Override
    public List<Product> deleteProductById(Integer productId) {
        return productsList.stream().filter(product -> product.getProductId() != productId).collect(Collectors.toList());
    }
}
