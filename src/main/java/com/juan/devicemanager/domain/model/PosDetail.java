package com.juan.devicemanager.domain.model;

import com.juan.devicemanager.domain.model.enums.CardReadCap;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table (name = "pos_detail")
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

    protected PosDetail () {}
    public PosDetail(Device device, String embeddedSoftwareVendor, Set<CardReadCap> cardReadCapabilities) {
        this.setDevice(device);
        this.embeddedSoftwareVendor = embeddedSoftwareVendor;
        this.cardReadCapabilities = cardReadCapabilities;
    }

    void setDevice(Device device) {

        if (device != null){
            this.device = device;
        }else{
            throw new RuntimeException("device should be not null");
        }

    }

    public UUID getId() {
        return id;
    }

    public Device getDevice() {
        return device;
    }

    public String getEmbeddedSoftwareVendor() {
        return embeddedSoftwareVendor;
    }

    public Set<CardReadCap> getCardReadCapabilities() {
        return cardReadCapabilities;
    }

    public void setEmbeddedSoftwareVendor(String embeddedSoftwareVendor) {
        this.embeddedSoftwareVendor = embeddedSoftwareVendor;
    }

    public void setCardReadCapabilities(Set<CardReadCap> cardReadCapabilities) {
        this.cardReadCapabilities = cardReadCapabilities;
    }
}
