package mercadona.springboot.exam.productCRUDAPI.controller;

import mercadona.springboot.exam.productCRUDAPI.exception.ResourceNotFoundException;
import mercadona.springboot.exam.productCRUDAPI.model.Product;
import mercadona.springboot.exam.productCRUDAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public Product createProduct(@RequestBody Product product, RedirectAttributes ra) {
        ra.addFlashAttribute("message", "Product saved successfully");
        return productRepository.save(product);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable (value = "id") Long productId) throws ResourceNotFoundException {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product with id: " + productId + " not found"));
        return ResponseEntity.ok().body(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable (value = "id") Long productId, @RequestBody Product productDetails) throws ResourceNotFoundException {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product with id: " + productId + " not found"));
        product.setName(productDetails.getName());
        product.setQuantity(productDetails.getQuantity());
        product.setPrice(productDetails.getPrice());
        product.setWeight(productDetails.getWeight());
        product.setWeightFormat(productDetails.getWeightFormat());
        product.setThumbnail(productDetails.getThumbnail());
        productRepository.save(product);
        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable (value = "id") Long productId) throws ResourceNotFoundException {
        productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product with id: " + productId + " not found"));
        productRepository.deleteById(productId);
        return ResponseEntity.ok().build();
        // 200 response
    }
}
