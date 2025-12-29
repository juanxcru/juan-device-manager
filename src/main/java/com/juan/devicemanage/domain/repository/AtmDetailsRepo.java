package com.juan.devicemanage.domain.repository;

import com.juan.devicemanage.domain.model.AtmDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AtmDetailsRepo extends JpaRepository<AtmDetail, UUID> {
}
