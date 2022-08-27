package mercadona.springboot.exam.productCRUDAPI;

import mercadona.springboot.exam.productCRUDAPI.model.Product;
import mercadona.springboot.exam.productCRUDAPI.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class ProductCrudApiApplicationTests {

	@Autowired private ProductRepository productRepository;

	@Test
	public void testAddNewProducts() {
		Product product1 = new Product();
		product1.setName("Pollo");
		product1.setPrice(5.19);
		product1.setQuantity(7850);
		product1.setWeight(0.6);
		product1.setWeightFormat("kg");
		product1.setThumbnail("https://prod-mercadona.imgix.net/images/cb9ab1cef933c95b65edaaa2a91a0fb6.jpg?fit=crop&h=300&w=300");

		Product product2 = new Product();
		product2.setName("Galletas");
		product2.setPrice(1.35);
		product2.setQuantity(3504);
		product2.setWeight(0.8);
		product2.setWeightFormat("kg");
		product2.setThumbnail("https://prod-mercadona.imgix.net/images/22554a4ed21273139027cd1e46b7dd8e.jpg?fit=crop&h=300&w=300");

		Product product3 = new Product();
		product3.setName("Café");
		product3.setPrice(3.40);
		product3.setQuantity(4703);
		product3.setWeight(0.104);
		product3.setWeightFormat("kg");
		product3.setThumbnail("https://prod-mercadona.imgix.net/images/224fca0a1dfa2bfc262f6a6a6182ca54.jpg?fit=crop&h=300&w=300");

		Product product4 = new Product();
		product4.setName("Yogures");
		product4.setPrice(2.15);
		product4.setQuantity(12807);
		product4.setWeight(1.38);
		product4.setWeightFormat("kg");
		product4.setThumbnail("https://prod-mercadona.imgix.net/images/bf08a8b27dd3f4d44409d57fa230aa4e.jpg?fit=crop&h=300&w=300");

		Product product5 = new Product();
		product5.setName("Gelatina");
		product5.setPrice(0.80);
		product5.setQuantity(6305);
		product5.setWeight(0.6);
		product5.setWeightFormat("kg");
		product5.setThumbnail("https://prod-mercadona.imgix.net/images/bf08a8b27dd3f4d44409d57fa230aa4e.jpg?fit=crop&h=300&w=300");

		Product product6 = new Product();
		product6.setName("Tomate");
		product6.setPrice(1.20);
		product6.setQuantity(4306);
		product6.setWeight(1.2);
		product6.setWeightFormat("kg");
		product6.setThumbnail("https://prod-mercadona.imgix.net/images/9d043c39aa3ce18574312aeefe4ad92b.jpg?fit=crop&h=300&w=300");

		Product product7 = new Product();
		product7.setName("Mix-frutos");
		product7.setPrice(1.50);
		product7.setQuantity(2804);
		product7.setWeight(0.3);
		product7.setWeightFormat("kg");
		product7.setThumbnail("https://prod-mercadona.imgix.net/images/813d42a18c00bc85bba48324fd5341bf.jpg?fit=crop&h=300&w=300");

		Product product8 = new Product();
		product8.setName("Velas");
		product8.setPrice(0.75);
		product8.setQuantity(1432);
		product8.setWeight(1.0);
		product8.setWeightFormat("ud");
		product8.setThumbnail("https://prod-mercadona.imgix.net/images/01e1c2847ada461466ccde539af26dc3.jpg?fit=crop&h=300&w=300");

		Product product9 = new Product();
		product9.setName("Leche");
		product9.setPrice(4.68);
		product9.setQuantity(8756);
		product9.setWeight(6.0);
		product9.setWeightFormat("l");
		product9.setThumbnail("https://prod-mercadona.imgix.net/images/ab494f775eee71eefb4816d246bdc348.jpg?fit=crop&h=300&w=300");

		Product product10 = new Product();
		product10.setName("Huevos");
		product10.setPrice(2.85);
		product10.setQuantity(3052);
		product10.setWeight(12.0);
		product10.setWeightFormat("ud");
		product10.setThumbnail("https://prod-mercadona.imgix.net/images/ceaa044fec4cfe298c9c4ace12980775.jpg?fit=crop&h=300&w=300");

		List<Product> savedProducts = productRepository.saveAll(
				List.of(product1, product2, product3, product4, product5, product6, product7, product8, product9, product10));

		Assertions.assertThat(savedProducts).isNotNull();
	}

	@Test
	public void testListAllProducts() {
		Iterable<Product> products = productRepository.findAll();
		Assertions.assertThat(products).hasSizeGreaterThan(0);

		for (Product product : products) {
			System.out.format(product.getName() + "\tQuantity:" + product.getQuantity() + "\tPrice:" + product.getPrice() + "\u20AC\n");
		}
	}

	@Test
	public void testUpdateProduct() {
		Long productId = Long.valueOf(9);
		Optional<Product> optionalProduct = productRepository.findById(productId);
		Product product = optionalProduct.get();
		product.setName("nuevo nombre de producto");
		productRepository.save(product);

		Product updateProduct  =  productRepository.findById(productId).get();
		Assertions.assertThat(updateProduct.getName()).isEqualTo("nuevo nombre de producto");
	}

	@Test
	public void testGetProduct() {
		Long productId = Long.valueOf(10);
		Optional<Product> optionalProduct = productRepository.findById(productId);
		Product product = optionalProduct.get();

		Assertions.assertThat(optionalProduct).isPresent();
		System.out.println(optionalProduct.get());
	}

	@Test
	public void testDelete() {
		Long productId = Long.valueOf(10);
		productRepository.deleteById(productId);

		Optional<Product> optionalProduct = productRepository.findById(productId);
		Assertions.assertThat(optionalProduct).isNotPresent();
	}

}
