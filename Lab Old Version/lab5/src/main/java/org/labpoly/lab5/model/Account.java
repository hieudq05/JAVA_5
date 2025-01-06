package org.labpoly.lab5.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "Accounts")
public class Account {
    @Id
    @Size(max = 50)
    @Nationalized
    @Column(name = "Username", nullable = false, length = 50)
    private String username;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "Password", nullable = false, length = 50)
    private String password;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "Fullname", nullable = false, length = 50)
    private String fullname;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "Email", nullable = false, length = 50)
    private String email;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @ColumnDefault("N'Photo.gif'")
    @Column(name = "Photo", nullable = false, length = 50)
    private String photo;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "Activated", nullable = false)
    private Boolean activated = false;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "Admin", nullable = false)
    private Boolean admin = false;

}