package org.labpoly.lab6.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "Categories")
public class Category {
    @Id
    @Column(name = "Id", nullable = false, length = 4)
    private String id;

    @Nationalized
    @Column(name = "Name", nullable = false, length = 50)
    private String name;

}