package com.order.model.product;

import com.order.model.category.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn (
            name = "category_id"
    )
    private Category category;
    private String description;
    private int price;
    private boolean status;
    private String image;
    private LocalDate createDate;
    private LocalDate updateDate;
}