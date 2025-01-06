package org.labpoly.lab5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @ColumnDefault("N'Product.gif'")
    @Column(name = "Image", nullable = false, length = 50)
    private String image;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "Price", nullable = false)
    private Double price;

    @NotNull
    @ColumnDefault("getdate()")
    @Column(name = "CreateDate", nullable = false)
    private LocalDate createDate;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "Available", nullable = false)
    private Boolean available = false;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CategoryId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;

}