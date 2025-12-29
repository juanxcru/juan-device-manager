package com.juan.devicemanage.domain.repository;

import com.juan.devicemanage.domain.model.DeviceEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeviceEventRepo extends JpaRepository<DeviceEvent, UUID> {

}
