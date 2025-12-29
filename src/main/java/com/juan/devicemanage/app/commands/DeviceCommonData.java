package com.juan.devicemanage.app.commands;

public class DeviceCommonData {

    private final String deviceId;
    private final String vendor;
    private final String model;
    private final String softwareVersion;
    private final String address;

    public DeviceCommonData(String deviceId, String vendor, String model, String softwareVersion, String address) {
        this.deviceId = deviceId;
        this.vendor = vendor;
        this.model = model;
        this.softwareVersion = softwareVersion;
        this.address = address;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public String getAddress() {
        return address;
    }
}
