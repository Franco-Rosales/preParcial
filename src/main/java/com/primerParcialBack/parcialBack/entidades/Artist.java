package com.primerParcialBack.parcialBack.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

//@Entity
//@Table(name = "artists")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Artist {
//
//    @Id
//    @GeneratedValue(generator = "artistsid")
//    @TableGenerator(name = "artistsid", table = "sqlite_sequence",
//            pkColumnName = "name", valueColumnName = "seq",
//            pkColumnValue="artistid",
//            initialValue=1, allocationSize=1)
//    @Column(name = "artistid")
//    private long ArtistId;
//
//    @Column(name = "name")
//    private String name;
//
//
//}
@Entity
@Table(name = "artists") // Asegúrate de que el nombre de la tabla coincide con el de tu base de datos
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artist {

    @Id
    @GeneratedValue(generator = "artistsGenerator")
    @TableGenerator(name = "artistsGenerator", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue = "artists",
            initialValue = 1, allocationSize = 1)
    @Column(name = "artistid")
    private long artistId;
    @Column(name = "name")
    private String name;

}
