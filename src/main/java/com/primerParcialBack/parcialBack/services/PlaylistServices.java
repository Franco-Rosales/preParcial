package com.primerParcialBack.parcialBack.services;

import com.primerParcialBack.parcialBack.dtos.PlaylistDto;
import com.primerParcialBack.parcialBack.entidades.Playlist;
import com.primerParcialBack.parcialBack.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlaylistServices {

    @Autowired
    private PlaylistRepository playlistRepository;

    public List<PlaylistDto> findAll() {
        List<Playlist> playlists = playlistRepository.findAll();
        return playlists.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public PlaylistDto findById(Long id) {
        Optional<Playlist> playlist = playlistRepository.findById(id);
        return playlist.map(this::convertToDto).orElse(null);
    }

    public Playlist save(PlaylistDto playlistDto) {
        Playlist playlist = new Playlist();
        playlist.setName(playlistDto.getName());
        this.playlistRepository.save(playlist);
        return playlist;
    }


    public void deleteById(Long id) {
        playlistRepository.deleteById(id);
    }

    public PlaylistDto update(Long id, PlaylistDto playlistDto) {
        Optional<Playlist> existingPlaylist = playlistRepository.findById(id);
        if (existingPlaylist.isPresent()) {
            Playlist playlist = convertToEntity(playlistDto);
            playlist.setPlaylistId(id);
            Playlist updatedPlaylist = playlistRepository.save(playlist);
            return convertToDto(updatedPlaylist);
        } else {
            return null;
        }
    }
    private PlaylistDto convertToDto(Playlist playlist) {
        PlaylistDto playlistDto = new PlaylistDto();
        playlistDto.setPlaylistId(playlist.getPlaylistId());
        playlistDto.setName(playlist.getName());
        return playlistDto;
    }

    private Playlist convertToEntity(PlaylistDto playlistDto) {
        Playlist playlist = new Playlist();
        playlist.setName(playlistDto.getName());
        return playlist;
    }


}
