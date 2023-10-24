package com.primerParcialBack.parcialBack.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistDto {
    private long playlistId;

    private String name;
}
