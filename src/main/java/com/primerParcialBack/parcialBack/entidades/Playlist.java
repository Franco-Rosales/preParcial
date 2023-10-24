package com.primerParcialBack.parcialBack.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "playlists")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Playlist {
    @Id
    @GeneratedValue(generator = "playlistsGenerator")
    @TableGenerator(name = "playlistsGenerator", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue = "playlists",
            initialValue = 1, allocationSize = 1)
    @Column(name = "playlistid")
    private long playlisId;

    @Column(name = "name")
    private String name;
}
