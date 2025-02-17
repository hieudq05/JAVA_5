package org.labpoly.lab6.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Nationalized
    @ColumnDefault("N'Product.gif'")
    @Column(name = "Image", nullable = false, length = 50)
    private String image;

    @ColumnDefault("0")
    @Column(name = "Price", nullable = false)
    private Double price;

    @ColumnDefault("getdate()")
    @Column(name = "CreateDate", nullable = false)
    private LocalDate createDate;

    @ColumnDefault("1")
    @Column(name = "Available", nullable = false)
    private Boolean available = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "CategoryId", nullable = false)
    private Category category;

}