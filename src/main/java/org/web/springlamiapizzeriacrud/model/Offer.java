package org.web.springlamiapizzeriacrud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "offers")
public class Offer {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "This field can't be empty")
    @Size(message = "Name must be between 5 and 20 characters", min = 5, max = 20)
    private String title;
    @NotNull(message = "This field can't be empty")
    @FutureOrPresent(message = "Date can't be in the past")
    private LocalDate startDate;
    @NotNull(message = "This field can't be empty")
    @FutureOrPresent(message = "Date can't be in the past")
    private LocalDate endDate;
    @ManyToOne
    private Pizza pizza;


    //getters and setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
}
