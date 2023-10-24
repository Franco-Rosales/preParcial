package com.primerParcialBack.parcialBack.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "artists")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artist {

    @Id
    @GeneratedValue(generator = "artistsGenerator") // Cambia el nombre del generador
    @TableGenerator(name = "artistsGenerator", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue = "artists", // Cambia el valor de pkColumnValue
            initialValue = 1, allocationSize = 1)
    @Column(name = "artistid") // Asegúrate de que el nombre de la columna coincida con el de tu base de datos
    private long artistId; // Cambia el nombre del campo a minúsculas

    @Column(name = "name")
    private String name;
}
