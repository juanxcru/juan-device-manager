package com.juan.devicemanager;

import org.springframework.boot.SpringApplication;

public class TestDevicemanageApplication {

	public static void main(String[] args) {
		SpringApplication.from(DevicemanageApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
