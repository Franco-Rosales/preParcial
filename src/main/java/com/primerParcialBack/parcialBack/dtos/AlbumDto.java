package com.primerParcialBack.parcialBack.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDto {

    private long albumId;

    private String title;

    private long artistId;

}