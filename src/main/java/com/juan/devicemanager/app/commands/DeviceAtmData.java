package com.juan.devicemanager.app.commands;

import com.juan.devicemanager.domain.model.enums.DepositModuleType;
import com.juan.devicemanager.domain.model.enums.DispenserType;
import com.juan.devicemanager.domain.model.enums.EppType;

public class DeviceAtmData {

    private final DeviceCommonData deviceCommonData;

    private final String fiid;
    private final DepositModuleType depositModuleType;
    private final DispenserType dispenserType;
    private final EppType eppType;
    private final String windowsVersion;

    public DeviceAtmData(DeviceCommonData deviceCommonData, String fiid,
                         DepositModuleType depositModuleType, DispenserType dispenserType,
                         EppType eppType, String windowsVersion) {
        this.deviceCommonData = deviceCommonData;
        this.fiid = fiid;
        this.depositModuleType = depositModuleType;
        this.dispenserType = dispenserType;
        this.eppType = eppType;
        this.windowsVersion = windowsVersion;
    }

    public DeviceCommonData getDeviceCommonData() {
        return deviceCommonData;
    }

    public String getFiid() {
        return fiid;
    }

    public DepositModuleType getDepositModuleType() {
        return depositModuleType;
    }

    public DispenserType getDispenserType() {
        return dispenserType;
    }

    public EppType getEppType() {
        return eppType;
    }

    public String getWindowsVersion() {
        return windowsVersion;
    }
}
