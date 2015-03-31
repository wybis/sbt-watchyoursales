package io.wybis.wys.web.controllers;

import io.wybis.wys.dto.ResponseDto;
import io.wybis.wys.dto.UserDto;
import io.wybis.wys.service.SessionService;
import io.wybis.wys.service.exceptions.InvalidCredentialException;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/sessions")
@Slf4j
public class SessionServiceController extends AbstractController {

	@Resource
	SessionService sessionService;

	@RequestMapping(value = "/properties", method = RequestMethod.GET)
	public @ResponseBody ResponseDto properties(HttpSession session) {
		ResponseDto responseDto = new ResponseDto();

		try {
			Map<String, Object> props = sessionService.properties(session);
			responseDto.setData(props);
			responseDto.setType(ResponseDto.SUCCESS);

		} catch (Throwable t) {
			String s = "Unable to retrive session properties...";
			responseDto.setType(ResponseDto.ERROR);
			responseDto.setMessage(s);
		}

		return responseDto;
	}

	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public @ResponseBody ResponseDto login(final HttpSession session,
			@RequestBody final UserDto userDto) {
		ResponseDto responseDto = new ResponseDto();

		try {
			sessionService.login(session, userDto);

			responseDto.setType(ResponseDto.SUCCESS);
			responseDto.setMessage("Successfulyy logged in...");

		} catch (InvalidCredentialException t) {
			String s = "Invalid User Id or Password...";
			responseDto.setType(ResponseDto.ERROR);
			responseDto.setMessage(s);
		}

		return responseDto;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/signOut", method = RequestMethod.GET)
	public @ResponseBody ResponseDto logout(HttpSession session) {
		ResponseDto responseDto = new ResponseDto();

		sessionService.logout(session);

		responseDto.setType(ResponseDto.SUCCESS);
		responseDto.setMessage("Successfulyy logged in...");

		return responseDto;
	}
}
