package com.juan.devicemanager.api.controller;

import com.juan.devicemanager.api.dto.atm.AtmUpsertRequestDto;
import com.juan.devicemanager.api.dto.atm.AtmUpsertResponseDto;
import com.juan.devicemanager.api.mapper.AtmApiMapper;
import com.juan.devicemanager.api.validation.OnCreate;
import com.juan.devicemanager.app.commands.DeviceAtmData;
import com.juan.devicemanager.app.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/atm/")
public class AtmController {

    @Autowired
    DeviceService deviceService;

    @PostMapping("/new")
    public ResponseEntity<AtmUpsertResponseDto> create(@Validated(OnCreate.class) @RequestBody AtmUpsertRequestDto atmRequestDto){

        DeviceAtmData deviceAtmData = AtmApiMapper.dtoToAtmData(atmRequestDto);
        UUID idNewDevice = deviceService.newAtm(deviceAtmData);
        return ResponseEntity.status(201).body(AtmApiMapper.atmDeviceToResponseDto(idNewDevice,deviceAtmData));

    }

}
