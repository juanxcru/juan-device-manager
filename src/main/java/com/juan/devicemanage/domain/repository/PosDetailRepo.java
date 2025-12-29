package com.juan.devicemanage.domain.repository;

import com.juan.devicemanage.domain.model.PosDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PosDetailRepo extends JpaRepository<PosDetail, UUID> {
}
