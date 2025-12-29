package com.juan.devicemanage.domain.model;

import com.juan.devicemanage.domain.model.enums.DepositModuleType;
import com.juan.devicemanage.domain.model.enums.DispenserType;
import com.juan.devicemanage.domain.model.enums.EppType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;
@Entity
@Table (name = "atm_detail")
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

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "deposit_type", nullable = false)
    private DepositModuleType depositType;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "dispenser_type", nullable = false)
    private DispenserType dispenserType;

    @NotBlank
    @Column(name = "win_version")
    private String winVersion;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "epp_typ" , nullable = false)
    private EppType eppType;

    protected AtmDetail() {}
    public AtmDetail(Device device, String fiid,
                     DepositModuleType depositType,
                     DispenserType dispenserType,
                     String winVersion, EppType eppType) {
        this.setDevice(device);
        this.fiid = fiid;
        this.depositType = depositType;
        this.dispenserType = dispenserType;
        this.winVersion = winVersion;
        this.eppType = eppType;
    }

    void setDevice(Device device) {

        if (device != null && device.getId() != null){
            this.id = device.getId();
            this.device = device;
        }else{
            throw new RuntimeException("device should be not null");
        }

    }

    public void setFiid(String fiid) {
        this.fiid = fiid;
    }

    public void setDepositType(DepositModuleType depositType) {
        this.depositType = depositType;
    }

    public void setDispenserType(DispenserType dispenserType) {
        this.dispenserType = dispenserType;
    }

    public void setWinVersion(String winVersion) {
        this.winVersion = winVersion;
    }

    public void setEppType(EppType eppType) {
        this.eppType = eppType;
    }

    public UUID getId() {
        return id;
    }

    public Device getDevice() {
        return device;
    }

    public String getFiid() {
        return fiid;
    }

    public DepositModuleType getDepositType() {
        return depositType;
    }

    public DispenserType getDispenserType() {
        return dispenserType;
    }

    public String getWinVersion() {
        return winVersion;
    }

    public EppType getEppType() {
        return eppType;
    }
}
