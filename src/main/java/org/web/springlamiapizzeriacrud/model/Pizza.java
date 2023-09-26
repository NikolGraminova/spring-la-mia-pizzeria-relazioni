package org.web.springlamiapizzeriacrud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;

@Entity
@Table(name = "pizzas")
public class Pizza {

    // fields
    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "This field can't be empty")
    @Size(message = "Name must be between 5 and 20 characters", min = 5, max = 20)
    private String name;

    @NotBlank(message = "This field can't be empty")
    @Size(message = "Description must be between 10 and 100 characters", min = 10, max = 100)
    private String description;

    @NotNull(message = "This field can't be empty")
    @DecimalMin(value = "0.99", message = "Price must be between 0.99 and 30.00")
    @DecimalMax(value = "99.00", message = "Price must be between 0.99 and 99.00")
    @Column(scale = 2)
    private BigDecimal price;

    @NotBlank(message = "This field can't be empty")
    @URL(message = "This field must contain a valid URL")
    private String img;

    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
