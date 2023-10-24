package com.primerParcialBack.parcialBack.services;

import com.primerParcialBack.parcialBack.dtos.ArtistDto;
import com.primerParcialBack.parcialBack.entidades.Artist;
import com.primerParcialBack.parcialBack.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArtistServices {

    @Autowired
    private ArtistRepository artistRepository;

    public List<ArtistDto> findAll() {
        List<Artist> artists = artistRepository.findAll();
        return artists.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public ArtistDto findById(Long id) {
        Optional<Artist> artist = artistRepository.findById(id);
        return artist.map(this::convertToDto).orElse(null);
    }

    public Artist save(ArtistDto artistDto) {
        Artist artist = new Artist();
        artist.setName(artistDto.getName());
        this.artistRepository.save(artist);
        return artist;
    }


    public void deleteById(Long id) {
        artistRepository.deleteById(id);
    }

    public ArtistDto update(Long id, ArtistDto artistDto) {
        Optional<Artist> existingArtist = artistRepository.findById(id);
        if (existingArtist.isPresent()) {
            Artist artist = convertToEntity(artistDto);
            Artist updatedArtist = artistRepository.save(artist);
            return convertToDto(updatedArtist);
        } else {
            return null;
           }
        }
        private ArtistDto convertToDto(Artist artist) {
            ArtistDto artistDto = new ArtistDto();
            artistDto.setArtistId(artist.getArtistId());
            artistDto.setName(artist.getName());
            return artistDto;
        }

        private Artist convertToEntity(ArtistDto artistDto) {
            Artist artist = new Artist();
            artist.setName(artistDto.getName());
            return artist;
        }


}
