package com.juan.devicemanage.domain.model;
import com.juan.devicemanage.domain.model.enums.DeviceStatus;
import com.juan.devicemanage.domain.model.enums.DeviceType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

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

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column (name = "device_type", nullable = false)
    private DeviceType deviceType;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column (name = "device_status", nullable = false)
    private DeviceStatus deviceStatus;

    @NotBlank
    @Column (name = "vendor")
    private String vendor;

    @NotBlank
    @Column(name = "model")
    private String model;

    @NotBlank
    @Pattern(regexp = "^([0-9]+\\.){2}[0-9]+$", message = "version must be x.y.z in numbers")
    @Column(name = "sw_version", nullable = false)
    private String softwareVersion;

    @NotBlank
    @Column(name = "address", nullable = false)
    private String address;

    //aca vendria el un atributo owner para cuando implementemos billing



}
