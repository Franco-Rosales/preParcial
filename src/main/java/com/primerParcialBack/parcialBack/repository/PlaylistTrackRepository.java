package com.primerParcialBack.parcialBack.repository;

import com.primerParcialBack.parcialBack.entidades.PlaylistTrack;
import com.primerParcialBack.parcialBack.entidades.PlaylistTrackKey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PlaylistTrackRepository extends JpaRepository<PlaylistTrack, Long> {
    @Query("SELECT CASE WHEN COUNT(pt) > 0 THEN true ELSE false END FROM PlaylistTrack pt WHERE pt.id = :playlistTrackKey")
    boolean existsByPlaylistTrackKey(@Param("playlistTrackKey") PlaylistTrackKey playlistTrackKey);

    @Modifying
    @Transactional
    @Query("DELETE FROM PlaylistTrack pt WHERE pt.id = :playlistTrackKey")
    void deleteByPlaylistTrackKey(@Param("playlistTrackKey") PlaylistTrackKey playlistTrackKey);

}
