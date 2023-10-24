package com.primerParcialBack.parcialBack.controller;

import com.primerParcialBack.parcialBack.entidades.PlaylistTrackKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.primerParcialBack.parcialBack.dtos.PlaylistTrackDto;
import com.primerParcialBack.parcialBack.entidades.PlaylistTrack;
import com.primerParcialBack.parcialBack.services.PlaylistTrackServices;

import java.util.List;
import java.util.NoSuchElementException;
@RestController
@RequestMapping("/api/Playlisttrack")

public class PlaylistTrackController {
    @Autowired
    private PlaylistTrackServices playlistTrackServices;

    @GetMapping
    private ResponseEntity<List<PlaylistTrackDto>> getAll() {
        List<PlaylistTrackDto> values = playlistTrackServices.findAll();
        return ResponseEntity.ok(values);
    }

    @GetMapping("/{id}")
    private ResponseEntity<PlaylistTrackDto> getById(@PathVariable("id") Long playlistTrackId) {
        try {
            PlaylistTrackDto playlistTrackDto = this.playlistTrackServices.findById(playlistTrackId);
            return ResponseEntity.ok(playlistTrackDto);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping
    public ResponseEntity<PlaylistTrack> addPlaylistTrack(@RequestBody PlaylistTrackDto playlistTrack) {
        PlaylistTrack createdPlaylistTrack = playlistTrackServices.save(playlistTrack);
        if (createdPlaylistTrack != null) {
            return ResponseEntity.ok(createdPlaylistTrack);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @PutMapping
    public ResponseEntity<PlaylistTrackDto> updatePlaylistTrack(@RequestBody PlaylistTrackKey key, @RequestBody PlaylistTrackDto playlistTrackDto ) {
        PlaylistTrackDto updatedPlaylistTrack = playlistTrackServices.updatePlaylistTrack(key, playlistTrackDto);
        if (updatedPlaylistTrack != null) {
            return ResponseEntity.ok(updatedPlaylistTrack);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deletePlaylistTrack(@RequestBody PlaylistTrackKey key) {
        playlistTrackServices.deleteById(key);
        return ResponseEntity.noContent().build();
    }
}
