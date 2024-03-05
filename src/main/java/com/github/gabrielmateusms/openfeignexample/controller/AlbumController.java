package com.github.gabrielmateusms.openfeignexample.controller;

import com.github.gabrielmateusms.openfeignexample.exception.RequestException;
import com.github.gabrielmateusms.openfeignexample.service.AlbumSpotifyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/spotify/album")
public class AlbumController {
    private final AlbumSpotifyService albumSpotifyService;

    public AlbumController(AlbumSpotifyService albumSpotifyService) {
        this.albumSpotifyService = albumSpotifyService;
    }

    @GetMapping
    public ResponseEntity<?> albums() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(albumSpotifyService.allAlbums());
        } catch (RequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
