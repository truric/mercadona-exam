package mercadona.springboot.exam.productCRUDAPI.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, generator = "product_sequence"
    )
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    @NotBlank(message = "Product name cannot be blank")
    @Length(min = 3, max = 50, message = "Product name must be between 3 to 50 characters long")
    private String name;

    @Column(name = "price", nullable = false, length = 10)
    @Max(value = 999, message = "Product price maximum value is 999")
    private double price;

    @Column(name = "quantity", nullable = false, length = 10)
    @Max(value = 99999, message = "Product quantity maximum value is 99999")
    private int quantity;

    @Column(name = "weight", nullable = false, length = 10)
    @Max(value = 999, message = "Product weight maximum value is 999")
    private double weight;

    @Column(name = "weight_format", nullable = false, length = 5)
    @NotBlank(message = "Product weight format cannot be blank")
    @Length(min = 1, max = 5, message = "Product weight format must be between 1 to 5 characters long")
    private String weightFormat;

    @Column(name = "thumbnail", nullable = false, length = 200)
    @Size(max = 300, message = "Product image URL maximum length is 300 characters long")
    private String thumbnail;

    public Product(String name, double price, int quantity, double weight, String weightFormat, String thumbnail) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
        this.weightFormat = weightFormat;
        this.thumbnail = thumbnail;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getWeightFormat() {
        return weightFormat;
    }

    public void setWeightFormat(String weightFormat) {
        this.weightFormat = weightFormat;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Long getId() {
        return id;
    }
}
