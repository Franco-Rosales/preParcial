package com.primerParcialBack.parcialBack.repository;

import com.primerParcialBack.parcialBack.entidades.Artist;
import com.primerParcialBack.parcialBack.entidades.Tracks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Tracks, Long> {
}
