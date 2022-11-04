package com.cognologix.product.controllers;

import com.cognologix.product.entities.Product;
import com.cognologix.product.services.IProductService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = iProductService.findAllProducts();
        ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(products, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(value = "/product/{id}")
    public ResponseEntity<List<Product>> getProductById(@PathVariable Integer id) {
        List<Product> product = iProductService.findByProductId(id);
        ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addProduct(@RequestBody List<Product> products) {
        for (Product product : products) {
            iProductService.saveProduct(product);
        }
        Integer numberOfRecordsAdded = products.size();
        String message = numberOfRecordsAdded + " product/s added";
        ResponseEntity<String> responseEntity = new ResponseEntity<>(message, HttpStatus.CREATED);
        return responseEntity;
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Object> modifyProductById(@RequestParam("id") Integer id, @RequestBody Product product) {
        ResponseEntity<Object> responseEntity = null;
        List<Product> product1 = iProductService.findByProductId(id);
        if (!(product1.isEmpty())) {
            Product product2 = iProductService.updateProductById(id, product);
            responseEntity = new ResponseEntity<>(product2, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>("Update Failed!", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @DeleteMapping(value = "/deleteProduct/{id}")
    public ResponseEntity<List<Product>> removeByProductId(@PathVariable Integer id) {
        List<Product> products = iProductService.deleteProductById(id);
        ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(products, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(value = "/find/{id}/replace")
    public ResponseEntity<Object> findAndReplaceProduct(@RequestParam("replaceId") String replaceId, @PathVariable("id") String id) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("product id", id);
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(jsonObject.toMap());

        if (id.equals("100")) {
            return new ResponseEntity<>(jsonObject.toMap(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Invalid request", HttpStatus.BAD_REQUEST);
        }
    }
}