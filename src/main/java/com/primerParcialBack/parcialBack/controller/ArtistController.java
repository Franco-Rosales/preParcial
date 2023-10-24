package com.primerParcialBack.parcialBack.controller;


import com.primerParcialBack.parcialBack.dtos.ArtistDto;
import com.primerParcialBack.parcialBack.entidades.Artist;
import com.primerParcialBack.parcialBack.services.ArtistServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/Artist")
public class ArtistController {

    @Autowired
    private ArtistServices artistServices;

    @GetMapping
    private ResponseEntity<List<ArtistDto>> getAll() {
        List<ArtistDto> values = artistServices.findAll();
        return ResponseEntity.ok(values);
    }

    @GetMapping("/{id}")
    private ResponseEntity<ArtistDto> getById(@PathVariable("id") Long artistId) {
        try {
            ArtistDto artistDto = this.artistServices.findById(artistId);
            return ResponseEntity.ok(artistDto);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping
    public ResponseEntity<Artist> addAritst(@RequestBody ArtistDto artist) {
        Artist createdArtist = artistServices.save(artist);
        if (createdArtist != null) {
//           return ResponseEntity.status(HttpStatus.CREATED).body(createdCompany);
            return ResponseEntity.ok(createdArtist);
        } else {
            // Manejo de error si no se pudo crear la empresa
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


};


