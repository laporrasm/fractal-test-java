package com.laporrasm.orders;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProduct(@PathVariable String id) {
        return new ResponseEntity<>(productService.singleProduct(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.allProducts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> postProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.setProduct(product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.removeProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
