package com.primerParcialBack.parcialBack.services;

import com.primerParcialBack.parcialBack.dtos.PlaylistTrackDto;
import com.primerParcialBack.parcialBack.entidades.Playlist;
import com.primerParcialBack.parcialBack.entidades.PlaylistTrack;
import com.primerParcialBack.parcialBack.entidades.PlaylistTrackKey;
import com.primerParcialBack.parcialBack.repository.PlaylistTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlaylistTrackServices {
    @Autowired
    private PlaylistTrackRepository playlistTrackRepository;

    public List<PlaylistTrackDto> findAll() {
        List<PlaylistTrack> playlistTrack = playlistTrackRepository.findAll();
        return playlistTrack.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public PlaylistTrackDto findById(Long id) {
        Optional<PlaylistTrack> playlistTrack = playlistTrackRepository.findById(id);
        return playlistTrack.map(this::convertToDto).orElse(null);
    }

    public PlaylistTrack save(PlaylistTrackDto playlistTrackDto) {
        PlaylistTrack playlistTrack = new PlaylistTrack();
        playlistTrack.setPlaylistId(playlistTrackDto.getPlaylistId());
        playlistTrack.setTrackId(playlistTrackDto.getTrackId());
        this.playlistTrackRepository.save(playlistTrack);
        return playlistTrack;
    }

    public void deleteById(PlaylistTrackKey key) {
        playlistTrackRepository.deleteByPlaylistTrackKey(key);
    }

    /*public void updatePlaylistTrack(PlaylistTrackKey key, PlaylistTrack newPlaylistTrack) {
        // Verificar si la fila con la clave primaria existe
        if (playlistTrackRepository.existsById(key)) {
            // Realizar la actualización
            playlistTrackRepository.save(newPlaylistTrack);
        } else {
            // Manejar la situación si no se encuentra la fila
            // Puedes lanzar una excepción, devolver un error, o tomar otra acción apropiada.
        }
    }*/
    public PlaylistTrackDto updatePlaylistTrack(PlaylistTrackKey key, PlaylistTrackDto playlistTrackDto) {
        //Optional<PlaylistTrack> existingPlaylistTrack = playlistTrackRepository.findById(key);
        if (playlistTrackRepository.existsByPlaylistTrackKey(key)) {
            PlaylistTrack playlistTrack = convertToEntity(playlistTrackDto);
            playlistTrack.setPlaylistId(playlistTrackDto.getPlaylistId());
            playlistTrack.setTrackId(playlistTrackDto.getTrackId());
            PlaylistTrack updatedPlaylistTrack = playlistTrackRepository.save(playlistTrack);
            return convertToDto(updatedPlaylistTrack);
        } else {
            return null;
        }
    }
    private PlaylistTrackDto convertToDto(PlaylistTrack playlistTrack) {
        PlaylistTrackDto playlistTrackDto = new PlaylistTrackDto();
        playlistTrackDto.setPlaylistId(playlistTrack.getPlaylistId());
        playlistTrackDto.setTrackId(playlistTrack.getTrackId());
        return playlistTrackDto;
    }

    private PlaylistTrack convertToEntity(PlaylistTrackDto playlistTrackDto) {
        PlaylistTrack playlistTrack = new PlaylistTrack();
        playlistTrack.setPlaylistId(playlistTrackDto.getPlaylistId());
        playlistTrack.setTrackId(playlistTrackDto.getTrackId());
        return playlistTrack;
    }
}
