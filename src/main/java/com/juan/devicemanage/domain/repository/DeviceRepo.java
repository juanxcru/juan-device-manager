package com.juan.devicemanage.domain.repository;

import com.juan.devicemanage.domain.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DeviceRepo extends JpaRepository<Device, UUID> {
    Optional<Device> findByDeviceId(String deviceId);
    boolean existsByDeviceId(String deviceId);
}
