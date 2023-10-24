package com.primerParcialBack.parcialBack.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "playlist_track")
@IdClass(PlaylistTrackKey.class)
public class PlaylistTrack {

    @Id
    @ManyToOne
    @JoinColumn(name = "playlistid", referencedColumnName = "playlistid")
    private Playlist playlistId;

    @Id
    @ManyToOne
    @JoinColumn(name = "trackid", referencedColumnName = "trackid")
    private Tracks trackId;

    public void setPlaylistId(long playlistId) {
        PlaylistTrackKey oldKey = PlaylistTrackKey find
        PlaylistTrackKey newKey = new PlaylistTrackKey();
        newKey.setPlaylistId(playlistId);
        newKey.setTrackId(this.getTrackId());
        this.playlistId = newKey.getPlaylistId();
        this.trackId = newKey.getTrackId()
    }

    public void setTrackId(long trackId) {
        PlaylistTrackKey newKey = new PlaylistTrackKey();
        newKey.setPlaylistId(this.playlistTrackKey.getPlaylistId());
        newKey.setTrackId(trackId);
        this.playlistTrackKey = newKey;
    }

    // Otros métodos de la entidad

    public PlaylistTrackKey getPlaylistTrackKey() {
        return playlistTrackKey;
    }

    public void setPlaylistTrackKey(PlaylistTrackKey playlistTrackKey) {
        this.playlistTrackKey = playlistTrackKey;
    }

}
