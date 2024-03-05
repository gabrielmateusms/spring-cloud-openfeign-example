package com.github.gabrielmateusms.openfeignexample.bean;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SpotifyAlbum {
    private String id;
    private String name;
    private String albumType;
    private String href;
}
