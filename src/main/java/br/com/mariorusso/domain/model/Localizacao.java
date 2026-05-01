package br.com.mariorusso.domain.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Localizacao {
    public Double latitude;
    public Double longitude;

    public Localizacao() {
    }

    public Localizacao(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Localizacao setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Localizacao setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }
}
