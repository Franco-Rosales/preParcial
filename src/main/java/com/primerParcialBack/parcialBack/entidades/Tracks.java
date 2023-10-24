package com.primerParcialBack.parcialBack.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tracks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tracks {
        @Id
        @GeneratedValue(generator = "tracksGenerator")
        @TableGenerator(name = "tracksGenerator", table = "sqlite_sequence",
                pkColumnName = "name", valueColumnName = "seq",
                pkColumnValue = "tracks",
                initialValue = 1, allocationSize = 1)
        @Column(name = "trackid")
        private long trackId;

        @Column(name = "name")
        private String name;

        @ManyToOne
        @JoinColumn(name = "albumid", referencedColumnName = "albumid")
        private Albums albumId;

        @ManyToOne
        @JoinColumn(name = "mediatypeid", referencedColumnName = "mediatypeid")
        private MediaTypes mediaTypeId;

        @ManyToOne
        @JoinColumn(name = "genreid", referencedColumnName = "genreid")
        private Genres genreId;

        @Column(name = "composer")
        private String composer;

        @Column(name = "milliseconds")
        private long milliseconds;

        @Column(name = "bytes")
        private long bytes;

        @Column(name = "unitprice")
        private double unitPrice;
}
