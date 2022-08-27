package mercadona.springboot.exam.productCRUDAPI.repository;

import mercadona.springboot.exam.productCRUDAPI.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
