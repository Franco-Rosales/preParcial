package com.primerParcialBack.parcialBack.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "genres")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Genres {

    @Id
    @GeneratedValue(generator = "genresGenerator")
    @TableGenerator(name = "genresGenerator", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue = "genres",
            initialValue = 1, allocationSize = 1)
    @Column(name = "genreid")
    private long genreId;

    @Column(name = "name")
    private String name;


}
