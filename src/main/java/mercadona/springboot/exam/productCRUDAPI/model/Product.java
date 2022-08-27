package mercadona.springboot.exam.productCRUDAPI.model;

import javax.persistence.*;

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
    private String name;

    @Column(name = "price", nullable = false, length = 10)
    private double price;

    @Column(name = "quantity", nullable = false, length = 10)
    private int quantity;

    @Column(name = "weight", nullable = false, length = 10)
    private double weight;

    @Column(name = "weight_format", nullable = false, length = 5)
    private String weightFormat;

    @Column(name = "thumbnail", nullable = false, length = 200)
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
