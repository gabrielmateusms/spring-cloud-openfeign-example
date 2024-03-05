package com.github.gabrielmateusms.openfeignexample.service;

import com.github.gabrielmateusms.openfeignexample.bean.AlbumResponse;
import com.github.gabrielmateusms.openfeignexample.bean.LoginRequest;
import com.github.gabrielmateusms.openfeignexample.bean.LoginResponse;
import com.github.gabrielmateusms.openfeignexample.bean.SpotifyAlbum;
import com.github.gabrielmateusms.openfeignexample.client.AlbumSpotifyClient;
import com.github.gabrielmateusms.openfeignexample.client.AuthSpotifyClient;
import com.github.gabrielmateusms.openfeignexample.exception.ConfigException;
import com.github.gabrielmateusms.openfeignexample.exception.RequestException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumSpotifyService {
    private static final Log LOG = LogFactory.getLog(AlbumSpotifyService.class);

    private final AlbumSpotifyClient albumSpotifyClient;
    private final AuthSpotifyClient authSpotifyClient;
    private final LoginRequest loginRequest;

    public AlbumSpotifyService(AlbumSpotifyClient albumSpotifyClient, AuthSpotifyClient authSpotifyClient, LoginRequest loginRequest) {
        this.albumSpotifyClient = albumSpotifyClient;
        this.authSpotifyClient = authSpotifyClient;
        this.loginRequest = loginRequest;
    }

    public List<SpotifyAlbum> allAlbums() throws RequestException {
        try {
            loginRequest.valid();

            LoginResponse loginResponse = authSpotifyClient.login(loginRequest);
            AlbumResponse albumsResponse = albumSpotifyClient.getSeveralAlbums(String.format("Bearer %s", loginResponse.getAccessToken()));
            return albumsResponse.getAlbums().getItems();
        } catch (ConfigException e) {
            LOG.error(e.getMessage());
            throw new RequestException("Não foi possível acessar a API do Spotify por falta de configurações obrigatórias");
        } catch (Exception e) {
            throw new RequestException("Erro ao acessar a API do Spotify");
        }
    }
}
