package com.juan.devicemanage.domain.model;

import com.juan.devicemanage.domain.model.enums.CardReadCap;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PosDetail {

    @Id
    @Column(name = "device_pk", nullable = false)
    private UUID id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "device_pk",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_pos_details_device")
    )
    private Device device;


    @NotBlank
    @Column(name = "embedded_software_vendor", nullable = false, length = 80)
    private String embeddedSoftwareVendor;


    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "pos_card_capability",
            joinColumns = @JoinColumn(name = "pos_device_pk", foreignKey = @ForeignKey(name = "fk_pos_read_capability_pos"))
    )
    @Column(name = "read_capability", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Set<CardReadCap> cardReadCapabilities = new HashSet<>();

    void setDevice(Device device) {
        this.device = device;
        this.id = (device != null) ? device.getId() : null;
    }

}
