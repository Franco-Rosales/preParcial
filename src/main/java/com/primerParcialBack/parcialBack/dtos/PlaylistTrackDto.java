package com.primerParcialBack.parcialBack.dtos;

import com.primerParcialBack.parcialBack.entidades.Playlist;
import com.primerParcialBack.parcialBack.entidades.PlaylistTrackKey;
import com.primerParcialBack.parcialBack.entidades.Tracks;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistTrackDto {

    private long playlistId;

    private long trackId;

}
