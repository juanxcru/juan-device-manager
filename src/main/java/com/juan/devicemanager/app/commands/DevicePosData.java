package com.juan.devicemanager.app.commands;

import com.juan.devicemanager.domain.model.enums.CardReadCap;

import java.util.Set;

public class DevicePosData {

    private final String embeddedSoftwareVendor;
    private final Set<CardReadCap> cardReadCapabilities;

    public DevicePosData(String embeddedSoftwareVendor, Set<CardReadCap> cardReadCapabilities) {
        this.embeddedSoftwareVendor = embeddedSoftwareVendor;
        this.cardReadCapabilities = cardReadCapabilities;
    }

    public String getEmbeddedSoftwareVendor() {
        return embeddedSoftwareVendor;
    }

    public Set<CardReadCap> getCardReadCapabilities() {
        return cardReadCapabilities;
    }
}
