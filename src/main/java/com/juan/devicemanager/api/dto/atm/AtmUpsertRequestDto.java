package com.juan.devicemanager.api.dto.atm;

import com.juan.devicemanager.api.validation.OnCreate;
import com.juan.devicemanager.api.validation.OnPatch;
import com.juan.devicemanager.domain.model.enums.DepositModuleType;
import com.juan.devicemanager.domain.model.enums.DispenserType;
import com.juan.devicemanager.domain.model.enums.EppType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AtmUpsertRequestDto {

    @NotBlank(groups = {OnCreate.class, OnPatch.class})
    @Size (max = 20, groups = {OnCreate.class, OnPatch.class})
    private String deviceId;
    @NotBlank(groups = OnCreate.class)
    @Size(max = 80, groups = {OnCreate.class, OnPatch.class})
    private String vendor;

    @NotBlank(groups = OnCreate.class)
    @Size(max = 80, groups = {OnCreate.class, OnPatch.class})
    private String model;

    @NotBlank(groups = OnCreate.class)
    private String softwareVersion;

    @Size(max = 255, groups = {OnCreate.class, OnPatch.class})
    private String address;

    @NotBlank(groups = OnCreate.class)
    @Pattern(regexp="^[A-Za-z0-9]{4}$", groups = {OnCreate.class, OnPatch.class})
    private String fiid;

    @NotNull(groups = OnCreate.class)
    private DepositModuleType depositModuleType;

    @NotNull(groups = OnCreate.class)
    private DispenserType dispenserType;

    @NotNull(groups = OnCreate.class)
    private EppType eppType;

    @NotBlank(groups = OnCreate.class)
    @Size(max = 80, groups = {OnCreate.class, OnPatch.class})
    private String windowsVersion;

    public AtmUpsertRequestDto() {
    }

    public AtmUpsertRequestDto(String deviceId, String vendor, String model, String softwareVersion, String address, String fiid, DepositModuleType depositModuleType, DispenserType dispenserType, EppType eppType, String windowsVersion) {
        this.deviceId = deviceId;
        this.vendor = vendor;
        this.model = model;
        this.softwareVersion = softwareVersion;
        this.address = address;
        this.fiid = fiid;
        this.depositModuleType = depositModuleType;
        this.dispenserType = dispenserType;
        this.eppType = eppType;
        this.windowsVersion = windowsVersion;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public String getAddress() {
        return address;
    }

    public String getFiid() {
        return fiid;
    }

    public DepositModuleType getDepositModuleType() {
        return depositModuleType;
    }

    public DispenserType getDispenserType() {
        return dispenserType;
    }

    public EppType getEppType() {
        return eppType;
    }

    public String getWindowsVersion() {
        return windowsVersion;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFiid(String fiid) {
        this.fiid = fiid;
    }

    public void setDepositModuleType(DepositModuleType depositModuleType) {
        this.depositModuleType = depositModuleType;
    }

    public void setDispenserType(DispenserType dispenserType) {
        this.dispenserType = dispenserType;
    }

    public void setEppType(EppType eppType) {
        this.eppType = eppType;
    }

    public void setWindowsVersion(String windowsVersion) {
        this.windowsVersion = windowsVersion;
    }
}
