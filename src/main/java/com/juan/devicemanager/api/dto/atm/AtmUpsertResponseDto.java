package com.juan.devicemanager.api.dto.atm;

import java.util.UUID;

public class AtmUpsertResponseDto {

    private UUID id;
    private String deviceId;

    public AtmUpsertResponseDto(UUID id, String deviceId) {
        this.id = id;
        this.deviceId = deviceId;
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }



}
