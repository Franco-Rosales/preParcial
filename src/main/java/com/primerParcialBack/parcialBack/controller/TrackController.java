package com.primerParcialBack.parcialBack.controller;

import com.primerParcialBack.parcialBack.dtos.ArtistDto;
import com.primerParcialBack.parcialBack.dtos.TrackDto;
import com.primerParcialBack.parcialBack.entidades.Artist;
import com.primerParcialBack.parcialBack.entidades.Tracks;
import com.primerParcialBack.parcialBack.services.ArtistServices;
import com.primerParcialBack.parcialBack.services.TrackServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/Track")
public class TrackController {

    @Autowired
    private TrackServices trackServices;

    @GetMapping
    private ResponseEntity<List<TrackDto>> getAll() {
        List<TrackDto> values = trackServices.findAll();
        return ResponseEntity.ok(values);
    }

    @GetMapping("/{id}")
    private ResponseEntity<TrackDto> getById(@PathVariable("id") Long trackId) {
        try {
            TrackDto trackDto = this.trackServices.findById(trackId);
            return ResponseEntity.ok(trackDto);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping
    public ResponseEntity<Tracks> addAritst(@RequestBody TrackDto track) {
        Tracks createdTrack = trackServices.save(track);
        if (createdTrack != null) {
//           return ResponseEntity.status(HttpStatus.CREATED).body(createdCompany);
            return ResponseEntity.ok(createdTrack);
        } else {
            // Manejo de error si no se pudo crear la empresa
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrackDto> updateArtist(@PathVariable("id") Long trackId, @RequestBody TrackDto trackDto) {
        TrackDto updatedTrack = trackServices.update(trackId, trackDto);
        if (updatedTrack != null) {
            return ResponseEntity.ok(updatedTrack);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long id) {
        trackServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
