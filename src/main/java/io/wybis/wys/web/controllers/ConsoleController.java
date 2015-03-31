package io.wybis.wys.web.controllers;

import io.wybis.wys.dto.ResponseDto;
import io.wybis.wys.service.ConsoleService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/console")
@Slf4j
public class ConsoleController extends AbstractController {

	@Resource
	ConsoleService consoleService;

	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public @ResponseBody ResponseDto reset(HttpSession session) {
		ResponseDto responseDto = new ResponseDto();

		try {
			consoleService.reset(session);
			responseDto.setType(ResponseDto.SUCCESS);
			responseDto.setMessage("Successfully reseted...");
		} catch (Throwable t) {
			String s = "Unable to reset...";
			responseDto.setType(ResponseDto.ERROR);
			responseDto.setMessage(s);
		}

		return responseDto;
	}

	@RequestMapping(value = "/clear", method = RequestMethod.GET)
	public @ResponseBody ResponseDto clear(HttpSession session) {
		ResponseDto responseDto = new ResponseDto();

		try {
			consoleService.clear(session);
			responseDto.setType(ResponseDto.SUCCESS);
			responseDto.setMessage("Successfully cleared all data...");
		} catch (Throwable t) {
			String s = "Unable to reset...";
			responseDto.setType(ResponseDto.ERROR);
			responseDto.setMessage(s);
		}

		return responseDto;
	}

	@RequestMapping(value = "/clearTransactions", method = RequestMethod.GET)
	public @ResponseBody ResponseDto clearTransactions(HttpSession session) {
		ResponseDto responseDto = new ResponseDto();

		try {
			consoleService.clearTransactions(session);
			responseDto.setType(ResponseDto.SUCCESS);
			responseDto
					.setMessage("Successfully cleared all transactional data...");
		} catch (Throwable t) {
			String s = "Unable to reset...";
			responseDto.setType(ResponseDto.ERROR);
			responseDto.setMessage(s);
		}

		return responseDto;
	}
}
