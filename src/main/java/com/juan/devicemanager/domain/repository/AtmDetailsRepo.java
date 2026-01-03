package com.juan.devicemanager.domain.repository;

import com.juan.devicemanager.domain.model.AtmDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AtmDetailsRepo extends JpaRepository<AtmDetail, UUID> {
}
