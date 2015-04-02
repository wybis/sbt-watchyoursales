package io.wybis.wys.web.controllers;

import io.wybis.wys.dto.ResponseDto;
import io.wybis.wys.model.Branch;
import io.wybis.wys.service.ConsoleService;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

import org.gradle.jarjar.com.google.common.base.Throwables;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
			responseDto.setData(Throwables.getStackTraceAsString(t));
			t.printStackTrace();
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
			String s = "Unable to clear...";
			responseDto.setType(ResponseDto.ERROR);
			responseDto.setMessage(s);
			responseDto.setData(Throwables.getStackTraceAsString(t));
			t.printStackTrace();
		}

		return responseDto;
	}

	@RequestMapping(value = "/clearTransactions", method = RequestMethod.GET)
	public @ResponseBody ResponseDto clearTransactions(HttpSession session) {
		ResponseDto responseDto = new ResponseDto();

		try {
			consoleService.clearTransactions(session);
			responseDto.setType(ResponseDto.SUCCESS);
			String s = "Successfully cleared all transactional data...";
			responseDto.setMessage(s);
		} catch (Throwable t) {
			String s = "Unable to clear transactions...";
			responseDto.setType(ResponseDto.ERROR);
			responseDto.setMessage(s);
			responseDto.setData(Throwables.getStackTraceAsString(t));
			t.printStackTrace();
		}

		return responseDto;
	}

	@RequestMapping(value = "/addBranch", method = RequestMethod.POST)
	public @ResponseBody ResponseDto addBranch(HttpSession session,
			@RequestBody final Branch branch) {
		ResponseDto responseDto = new ResponseDto();

		try {
			consoleService.addBranch(session, branch);
			responseDto.setData(branch);
			responseDto.setType(ResponseDto.SUCCESS);
			String s = "Successfully cleared all transactional data...";
			responseDto.setMessage(s);
		} catch (Throwable t) {
			String s = "Unable to add branch...";
			responseDto.setType(ResponseDto.ERROR);
			responseDto.setMessage(s);
			responseDto.setData(Throwables.getStackTraceAsString(t));
			t.printStackTrace();
		}

		return responseDto;
	}
	
	@RequestMapping(value = "/branchs", method = RequestMethod.GET)
	public @ResponseBody ResponseDto branchs(HttpSession session) {
		ResponseDto responseDto = new ResponseDto();

		try {
			List<Branch> branchs = consoleService.branchs(session);
			responseDto.setData(branchs);
			responseDto.setType(ResponseDto.SUCCESS);
			String s = "Successfully retrived branchs...";
			responseDto.setMessage(s);
		} catch (Throwable t) {
			String s = "Unable to retrive branchs...";
			responseDto.setType(ResponseDto.ERROR);
			responseDto.setMessage(s);
			responseDto.setData(Throwables.getStackTraceAsString(t));
			t.printStackTrace();
		}

		return responseDto;
	}

}
