package com.juan.devicemanager.domain.model;
import com.juan.devicemanager.domain.model.enums.DeviceStatus;
import com.juan.devicemanager.domain.model.enums.DeviceType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(
        name = "device",
        indexes = {
                @Index(name = "idx_device_device_id", columnList = "device_id")
        },
        uniqueConstraints = {
                @UniqueConstraint(name = "uqc_device_device_id", columnNames = {"device_id"})
        }
)
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(name = "device_id", nullable = false, length = 32)
    private String deviceId;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column (name = "device_type", nullable = false)
    private DeviceType deviceType;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column (name = "device_status", nullable = false)
    private DeviceStatus deviceStatus;

    @NotBlank
    @Column (name = "vendor", length = 32)
    private String vendor;

    @NotBlank
    @Column(name = "model", length = 64)
    private String model;

    @NotBlank
    @Pattern(regexp = "^([0-9]+\\.){2}[0-9]+$", message = "version must be x.y.z in numbers")
    @Column(name = "sw_version", nullable = false)
    private String softwareVersion;


    @NotBlank
    @Column(name = "address", nullable = false)
    private String address;

    //aca vendria el un atributo owner para cuando implementemos billing

    public Device(String deviceId, DeviceType deviceType,
                  DeviceStatus deviceStatus,
                  String vendor, String model,
                  String softwareVersion, String address) {
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.deviceStatus = deviceStatus;
        this.vendor = vendor;
        this.model = model;
        this.softwareVersion = softwareVersion;
        this.address = address;
    }

    protected Device () {}

    @PrePersist
    void onCreate() {
        Instant now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    void onUpdate() {
        this.updatedAt = Instant.now();
    }



    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }


    public Instant getUpdatedAt() {
        return updatedAt;
    }


    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public DeviceStatus getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(DeviceStatus deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UUID getId() {
        return id;
    }
}
