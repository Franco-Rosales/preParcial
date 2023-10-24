package com.primerParcialBack.parcialBack.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "albums")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Albums {
    @Id
    @GeneratedValue(generator = "albumsGenerator") // Cambia el nombre del generador
    @TableGenerator(name = "albumsGenerator", table = "sqlite_sequence",
            pkColumnName = "title", valueColumnName = "seq",
            pkColumnValue = "albums", // Cambia el valor de pkColumnValue
            initialValue = 1, allocationSize = 1)
    @Column(name = "albumid") // Asegúrate de que el nombre de la columna coincida con el de tu base de datos
    private long albumId; // Cambia el nombre del campo a minúsculas

    @Column(name = "title")
    private String tiltle;


    @ManyToOne
    @JoinColumn(name = "artistid", referencedColumnName = "artistid")
    private Artist artist;


}
