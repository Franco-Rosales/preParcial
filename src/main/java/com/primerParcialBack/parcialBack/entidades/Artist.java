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
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @TableGenerator(name = "artists", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="artistid",
            initialValue=1, allocationSize=1)
    @Column(name = "artistid")
    private long ArtistId;

    @Column(name = "name")
    private String name;


}
