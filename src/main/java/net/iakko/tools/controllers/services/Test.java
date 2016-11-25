package net.iakko.tools.controllers.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.iakko.tools.controllers.services.data.IP;
import net.iakko.tools.controllers.services.exception.BaseException;
import net.iakko.tools.core.Logic;
import net.iakko.tools.core.db.RequestDAO;

@RestController
@RequestMapping(value = "/api")
public class Test
{
	@Autowired
	private Logic logic;
	
	@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void retrieveIP(@RequestParam(name="raise_exception", required = false, defaultValue = "false") boolean raiseException) throws BaseException
	{
		if (raiseException)
		{
			throw new BaseException("Test error");
		}
	}
}
