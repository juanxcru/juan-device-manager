package com.juan.devicemanager.api.mapper;

import com.juan.devicemanager.api.dto.atm.AtmUpsertRequestDto;
import com.juan.devicemanager.api.dto.atm.AtmUpsertResponseDto;
import com.juan.devicemanager.app.commands.DeviceAtmData;
import com.juan.devicemanager.app.commands.DeviceCommonData;

import java.util.UUID;


public class AtmApiMapper {

    public static DeviceAtmData dtoToAtmData(AtmUpsertRequestDto atmRequestUpsertDto){

        DeviceCommonData newDeviceCommonData = new DeviceCommonData(
                atmRequestUpsertDto.getDeviceId(),
                atmRequestUpsertDto.getVendor(),
                atmRequestUpsertDto.getModel(),
                atmRequestUpsertDto.getSoftwareVersion(),
                atmRequestUpsertDto.getAddress()
        );

        return new DeviceAtmData(
                newDeviceCommonData,
                atmRequestUpsertDto.getFiid(),
                atmRequestUpsertDto.getDepositModuleType(),
                atmRequestUpsertDto.getDispenserType(),
                atmRequestUpsertDto.getEppType(),
                atmRequestUpsertDto.getWindowsVersion()
        );
        
        
    }

    public static AtmUpsertResponseDto atmDeviceToResponseDto (UUID id, DeviceAtmData deviceAtmData){

        return new AtmUpsertResponseDto(id, deviceAtmData.getDeviceCommonData().getDeviceId());

    }
}
