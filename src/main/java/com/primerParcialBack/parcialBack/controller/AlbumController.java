package com.primerParcialBack.parcialBack.controller;

import com.primerParcialBack.parcialBack.dtos.AlbumDto;
import com.primerParcialBack.parcialBack.dtos.ArtistDto;
import com.primerParcialBack.parcialBack.entidades.Albums;
import com.primerParcialBack.parcialBack.entidades.Artist;
import com.primerParcialBack.parcialBack.services.AlbumServices;
import com.primerParcialBack.parcialBack.services.ArtistServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/Album")
public class AlbumController {
    @Autowired
    private AlbumServices albumServices;

    @GetMapping
    private ResponseEntity<List<AlbumDto>> getAll() {
        List<AlbumDto> values = albumServices.findAll();
        return ResponseEntity.ok(values);
    }
    @GetMapping("/{id}")
    private ResponseEntity<AlbumDto> getById(@PathVariable("id") Long albumId) {
        try {
            AlbumDto albumDto = this.albumServices.findById(albumId);
            return ResponseEntity.ok(albumDto);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PostMapping
    public ResponseEntity<Albums> addAlbum(@RequestBody AlbumDto albums) {
        Albums createdAlbum = albumServices.save(albums);
        if (createdAlbum != null) {
//           return ResponseEntity.status(HttpStatus.CREATED).body(createdCompany);
            return ResponseEntity.ok(createdAlbum);
        } else {
            // Manejo de error si no se pudo crear la empresa
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<AlbumDto> updateAlbum(@PathVariable("id") Long albumId, @RequestBody AlbumDto albumDto) {
        AlbumDto updatedAlbum = albumServices.update(albumId, albumDto);
        if (updatedAlbum != null) {
            return ResponseEntity.ok(updatedAlbum);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlbum(@PathVariable Long id) {
        albumServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
