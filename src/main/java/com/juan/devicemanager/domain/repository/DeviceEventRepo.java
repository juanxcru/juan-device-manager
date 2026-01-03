package com.juan.devicemanager.domain.repository;

import com.juan.devicemanager.domain.model.DeviceEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeviceEventRepo extends JpaRepository<DeviceEvent, UUID> {

}
