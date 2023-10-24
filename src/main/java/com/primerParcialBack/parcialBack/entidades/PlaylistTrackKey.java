package com.primerParcialBack.parcialBack.entidades;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistTrackKey implements Serializable {

    private long playlistId;
    private long trackId;

}

