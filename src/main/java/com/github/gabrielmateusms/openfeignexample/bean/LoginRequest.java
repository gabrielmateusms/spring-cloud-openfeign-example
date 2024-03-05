package com.github.gabrielmateusms.openfeignexample.bean;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.gabrielmateusms.openfeignexample.exception.ConfigException;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spotify.auth")
public class LoginRequest {
    private String grant_type;
    private String client_id;
    private String client_secret;

    public LoginRequest() {
        this.grant_type = "client_credentials";
    }

    @JsonIgnore
    public void valid() throws ConfigException {
        if (this.client_id.equalsIgnoreCase("") || this.client_secret.equalsIgnoreCase("")) {
            throw new ConfigException("Configurações obrigatórias (spotify.auth.client_id e spotify.auth.client_secret) não informadas no application.properties da aplicação");
        }
    }
}
