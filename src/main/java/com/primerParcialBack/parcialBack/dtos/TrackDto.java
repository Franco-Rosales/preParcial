package com.primerParcialBack.parcialBack.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackDto {

        private long trackId;

        private String name;

        private long albumId;

        private long mediaTypeId;

        private long genreId;

        private String composer;

        private long milliseconds;

        private long bytes;

        private double unitPrice;
}
