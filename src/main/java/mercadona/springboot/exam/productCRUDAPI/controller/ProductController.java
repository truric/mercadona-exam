package mercadona.springboot.exam.productCRUDAPI.controller;

import mercadona.springboot.exam.productCRUDAPI.exception.ResourceNotFoundException;
import mercadona.springboot.exam.productCRUDAPI.model.Product;
import mercadona.springboot.exam.productCRUDAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@RequestBody @Valid Product product) {
        productRepository.save(product);
        return ResponseEntity.ok("Product [" + product.getName() + "] created successfully with ID: " + product.getId());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable (value = "id") Long productId) throws ResourceNotFoundException {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product with id: " + productId + " not found"));
        return ResponseEntity.ok().body(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable (value = "id") Long productId, @RequestBody Product productDetails) throws ResourceNotFoundException {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product with id: " + productId + " not found"));
        product.setName(productDetails.getName());
        product.setQuantity(productDetails.getQuantity());
        product.setPrice(productDetails.getPrice());
        product.setWeight(productDetails.getWeight());
        product.setWeightFormat(productDetails.getWeightFormat());
        product.setThumbnail(productDetails.getThumbnail());
        productRepository.save(product);
        return ResponseEntity.ok().body("Product [" + product.getName() + "] with ID: " + product.getId() + " updated successfully");
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable (value = "id") Long productId) throws ResourceNotFoundException {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product with id: " + productId + " not found"));
        productRepository.deleteById(productId);
        return ResponseEntity.ok().body("Product [" + product.getName() + "] with ID: " + product.getId() + " deleted successfully");
    }
}
