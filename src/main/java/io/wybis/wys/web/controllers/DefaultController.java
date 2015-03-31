package io.wybis.wys.web.controllers;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;

@Controller
@Slf4j
public class DefaultController {

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> ping() {
		Map<String, String> map = Maps.newHashMap();

		map.put("ping", "Ping Pong!");

		return map;
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
