package com.laporrasm.orders;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> allProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> singleProduct(String id) {
        Optional<Product> product = productRepository.findById(id);
        return product;
    }

    public Product setProduct(Product productToSet) {
        Product product = productRepository.save(productToSet);
        return product;
    }

    public void removeProduct(String id) {
        productRepository.deleteById(id);
    }
}
