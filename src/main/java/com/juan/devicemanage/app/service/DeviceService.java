package com.juan.devicemanage.app.service;

import com.juan.devicemanage.app.commands.DeviceAtmData;
import com.juan.devicemanage.app.commands.DevicePosData;
import com.juan.devicemanage.domain.model.AtmDetail;
import com.juan.devicemanage.domain.model.Device;
import com.juan.devicemanage.domain.model.DeviceEvent;
import com.juan.devicemanage.domain.model.enums.DeviceEventType;
import com.juan.devicemanage.domain.model.enums.DeviceStatus;
import com.juan.devicemanage.domain.model.enums.DeviceType;
import com.juan.devicemanage.domain.repository.AtmDetailsRepo;
import com.juan.devicemanage.domain.repository.DeviceEventRepo;
import com.juan.devicemanage.domain.repository.DeviceRepo;
import com.juan.devicemanage.domain.repository.PosDetailRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void newAtm(DeviceAtmData newAtmData){

        // Verificar si ya existe
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

        AtmDetail newAtmDeviceDetail = new AtmDetail(
                newAtmDevice,
                newAtmData.getFiid(),
                newAtmData.getDepositModuleType(),
                newAtmData.getDispenserType(),
                newAtmData.getWindowsVersion(),
                newAtmData.getEppType()
            );

        deviceRepo.save(newAtmDevice);
        atmDetailsRepo.save(newAtmDeviceDetail);
        deviceEventRepo.save(
                new DeviceEvent(
                        newAtmDevice,
                        DeviceEventType.CREATED,
                        null,
                        "{aca meter un json}"
                )
        );





    }

    public void newPos (DevicePosData newPosData){

    }
}
