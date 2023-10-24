package com.primerParcialBack.parcialBack.services;

import com.primerParcialBack.parcialBack.dtos.AlbumDto;
import com.primerParcialBack.parcialBack.dtos.TrackDto;
import com.primerParcialBack.parcialBack.entidades.Albums;
import com.primerParcialBack.parcialBack.entidades.Tracks;
import com.primerParcialBack.parcialBack.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrackServices {
    @Autowired
    private TrackRepository trackRepository;

    public List<TrackDto> findAll() {
        List<Tracks> tracks = trackRepository.findAll();
        return tracks.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public TrackDto findById(Long id) {
        Optional<Tracks> tracks = trackRepository.findById(id);
        return tracks.map(this::convertToDto).orElse(null);
    }

    public Tracks save(TrackDto tracksDto) {
        Tracks tracks = new Tracks();
        tracks.setName(tracksDto.getName());
        this.trackRepository.save(tracks);
        return tracks;
    }

    public void deleteById(Long id) {
        trackRepository.deleteById(id);
    }

    public TrackDto update(Long id, TrackDto trackDto) {
        Optional<Tracks> existingTracks = trackRepository.findById(id);
        if (existingTracks.isPresent()) {
            Tracks tracks = convertToEntity(trackDto);
            tracks.setTrackId(id);
            Tracks updatedTracks = trackRepository.save(tracks);
            return convertToDto(updatedTracks);
        } else {
            return null;
        }
    }
    private TrackDto convertToDto(Tracks tracks) {
        TrackDto trackDto = new TrackDto();
        trackDto.setTrackId(tracks.getTrackId());
        trackDto.setName(tracks.getName());
        return trackDto;
    }

    private Tracks convertToEntity(TrackDto trackDto) {
        Tracks tracks = new Tracks();
        tracks.setName(trackDto.getName());
        return tracks;
    }
}
