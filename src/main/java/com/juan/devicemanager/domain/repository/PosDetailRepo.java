package com.juan.devicemanager.domain.repository;

import com.juan.devicemanager.domain.model.PosDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PosDetailRepo extends JpaRepository<PosDetail, UUID> {
}
