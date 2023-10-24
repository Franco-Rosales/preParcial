package com.primerParcialBack.parcialBack.services;

import com.primerParcialBack.parcialBack.dtos.AlbumDto;
import com.primerParcialBack.parcialBack.entidades.Albums;
import com.primerParcialBack.parcialBack.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumServices {
    @Autowired
    private AlbumRepository albumRepository;

    public List<AlbumDto> findAll() {
        List<Albums> albums = albumRepository.findAll();
        return albums.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public AlbumDto findById(Long id) {
        Optional<Albums> album = albumRepository.findById(id);
        return album.map(this::convertToDto).orElse(null);
    }

    public Albums save(AlbumDto albumsDto) {
        Albums albums = new Albums();
        albums.setTiltle(albumsDto.getTitle());
        this.albumRepository.save(albums);
        return albums;
    }

    public void deleteById(Long id) {
        albumRepository.deleteById(id);
    }

    public AlbumDto update(Long id, AlbumDto albumDto) {
        Optional<Albums> existingAlbums = albumRepository.findById(id);
        if (existingAlbums.isPresent()) {
            Albums albums = convertToEntity(albumDto);
            albums.setAlbumId(id);
            Albums updatedAlbums = albumRepository.save(albums);
            return convertToDto(updatedAlbums);
        } else {
            return null;
            }
        }
        private AlbumDto convertToDto(Albums albums) {
            AlbumDto albumDto = new AlbumDto();
            albumDto.setAlbumId(albums.getAlbumId());
            albumDto.setTitle(albums.getTiltle());
            albumDto.setArtistId(albums.getArtist().getArtistId());
            return albumDto;
        }

        private Albums convertToEntity(AlbumDto albumDto) {
            Albums albums = new Albums();
            albums.setTiltle(albumDto.getTitle());
            return albums;
        }



}
