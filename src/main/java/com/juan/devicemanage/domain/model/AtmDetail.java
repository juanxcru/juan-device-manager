package com.juan.devicemanage.domain.model;

import com.juan.devicemanage.domain.model.enums.DepositModuleType;
import com.juan.devicemanage.domain.model.enums.DispenserType;
import com.juan.devicemanage.domain.model.enums.EppType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public class AtmDetail {

    @Id
    @Column(name ="device_pk", nullable = false)
    private UUID id;

    // Normalizamos de esta manera, device_pk (PK) es FK a Device.id

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "device_pk",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_atm_details_device")
    )
    private Device device;

    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9]{4}$", message = "fiid must be 4 alphanumeric chars")
    @Column(name = "fiid", nullable = false)
    private String fiid;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "deposit_type", nullable = false)
    private DepositModuleType depositType;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "dispenser_type", nullable = false)
    private DispenserType dispenserType;

    @NotBlank
    @Column(name = "win_version")
    private String winVersion;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "EPP" , nullable = false)
    private EppType eppType;

    void setDevice(Device device) {
        this.device = device;
        this.id = (device != null) ? device.getId() : null;
    }


}
