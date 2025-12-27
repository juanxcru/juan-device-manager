package com.juan.devicemanage.domain.model;

import com.juan.devicemanage.domain.model.enums.DeviceEventType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.UUID;

public class DeviceEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "device_pk", nullable = false, foreignKey = @ForeignKey(name = "fk_device_event_device"))
    private Device device;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "event_type", nullable = false, length = 20)
    private DeviceEventType type;

    @Column(name = "occurred_at", nullable = false)
    private Instant occurredAt;

    @Column(name = "actor", nullable = false, length = 120)
    private String actor;

    @Column(name = "payload_json", columnDefinition = "text")
    private String payloadJson;


}
