package com.juan.devicemanager.domain.model;

import com.juan.devicemanager.domain.model.enums.DeviceEventType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "device_event")
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

    protected DeviceEvent(){}
    public DeviceEvent(Device device, DeviceEventType type, String actor, String payloadJson) {
        this.device = device;
        this.type = type;
        this.actor = (actor != null) ? actor : "sys" ;
        this.payloadJson = payloadJson;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public void setType(DeviceEventType type) {
        this.type = type;
    }

    @PrePersist
    public void onCreate (){
        this.occurredAt = Instant.now();
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public void setPayloadJson(String payloadJson) {
        this.payloadJson = payloadJson;
    }

    public UUID getId() {
        return id;
    }

    public Device getDevice() {
        return device;
    }

    public DeviceEventType getType() {
        return type;
    }

    public Instant getOccurredAt() {
        return occurredAt;
    }

    public String getActor() {
        return actor;
    }

    public String getPayloadJson() {
        return payloadJson;
    }
}
