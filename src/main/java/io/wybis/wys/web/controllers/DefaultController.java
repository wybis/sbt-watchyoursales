package io.wybis.wys.web.controllers;

import lombok.extern.java.Log;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Log
@Controller
public class DefaultController {

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public @ResponseBody String ping() {
		return "Ping Pong!";
	}

	String deviceResponseTemplate = "Hello! Youre device is %s!";

	@RequestMapping("/whatIsMyDeviceType")
	public @ResponseBody String detectDevice(Device device) {
		String deviceType = "Unknown";

		if (device.isNormal()) {
			deviceType = "PC or Laptop or TV";
		} else if (device.isMobile()) {
			deviceType = "Mobile";
		} else if (device.isTablet()) {
			deviceType = "Tablet";
		}

		return String.format(this.deviceResponseTemplate, deviceType);
	}
}
