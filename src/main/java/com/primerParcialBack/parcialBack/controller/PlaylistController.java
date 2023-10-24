package com.primerParcialBack.parcialBack.controller;

import com.primerParcialBack.parcialBack.dtos.PlaylistDto;
import com.primerParcialBack.parcialBack.entidades.Playlist;
import com.primerParcialBack.parcialBack.services.PlaylistServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/Playlist")
public class PlaylistController {
    @Autowired
    private PlaylistServices playlistServices;

    @GetMapping
    private ResponseEntity<List<PlaylistDto>> getAll() {
        List<PlaylistDto> values = playlistServices.findAll();
        return ResponseEntity.ok(values);
    }

    @GetMapping("/{id}")
    private ResponseEntity<PlaylistDto> getById(@PathVariable("id") Long playlistId) {
        try {
            PlaylistDto playlistDto = this.playlistServices.findById(playlistId);
            return ResponseEntity.ok(playlistDto);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping
    public ResponseEntity<Playlist> addAritst(@RequestBody PlaylistDto playlist) {
        Playlist createdPlaylist = playlistServices.save(playlist);
        if (createdPlaylist != null) {
            return ResponseEntity.ok(createdPlaylist);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<PlaylistDto> updatePlaylist(@PathVariable("id") Long playlistId, @RequestBody PlaylistDto playlistDto) {
        PlaylistDto updatedPlaylist = playlistServices.update(playlistId, playlistDto);
        if (updatedPlaylist != null) {
            return ResponseEntity.ok(updatedPlaylist);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable Long id) {
        playlistServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
