package com.juan.devicemanager.app.service;

import com.juan.devicemanager.app.commands.DeviceAtmData;
import com.juan.devicemanager.app.commands.DevicePosData;
import com.juan.devicemanager.domain.model.AtmDetail;
import com.juan.devicemanager.domain.model.Device;
import com.juan.devicemanager.domain.model.DeviceEvent;
import com.juan.devicemanager.domain.model.enums.DeviceEventType;
import com.juan.devicemanager.domain.model.enums.DeviceStatus;
import com.juan.devicemanager.domain.model.enums.DeviceType;
import com.juan.devicemanager.domain.repository.AtmDetailsRepo;
import com.juan.devicemanager.domain.repository.DeviceEventRepo;
import com.juan.devicemanager.domain.repository.DeviceRepo;
import com.juan.devicemanager.domain.repository.PosDetailRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class DeviceService {

    @Autowired
    DeviceRepo deviceRepo;
    @Autowired
    AtmDetailsRepo atmDetailsRepo;
    @Autowired
    PosDetailRepo posDetailRepo;
    @Autowired
    DeviceEventRepo deviceEventRepo;
    public UUID newAtm(DeviceAtmData newAtmData){

        // Verificar si ya existe
        System.out.println(newAtmData.getDeviceCommonData().getDeviceId());

        if (deviceRepo.existsByDeviceId(newAtmData.getDeviceCommonData().getDeviceId())){
            throw new RuntimeException("deviceId already exists");
        }
        // JPA
        Device newAtmDevice = new Device(
                newAtmData.getDeviceCommonData().getDeviceId(),
                DeviceType.ATM, DeviceStatus.ACTIVE,
                newAtmData.getDeviceCommonData().getVendor(),
                newAtmData.getDeviceCommonData().getModel(),
                newAtmData.getDeviceCommonData().getSoftwareVersion(),
                newAtmData.getDeviceCommonData().getAddress()
            );



        deviceRepo.save(newAtmDevice);

        AtmDetail newAtmDeviceDetail = new AtmDetail(
                newAtmDevice,
                newAtmData.getFiid(),
                newAtmData.getDepositModuleType(),
                newAtmData.getDispenserType(),
                newAtmData.getWindowsVersion(),
                newAtmData.getEppType()
        );

        atmDetailsRepo.save(newAtmDeviceDetail);
        deviceEventRepo.save(
                new DeviceEvent(
                        newAtmDevice,
                        DeviceEventType.CREATED,
                        null,
                        "{aca meter un json}"
                )
        );

        return newAtmDevice.getId();





    }

    public void newPos (DevicePosData newPosData){

    }
}
