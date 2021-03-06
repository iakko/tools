package net.iakko.tools.controllers.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.iakko.tools.controllers.services.data.IP;
import net.iakko.tools.core.Logic;
import net.iakko.tools.core.db.RequestDAO;

@RestController
@RequestMapping(value = "/api")
public class GetIP
{
	@Autowired
	private Logic logic;
	
	@RequestMapping(value = "/get_ip", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public IP retrieveIP(HttpServletRequest request)
	{
		return logic.getIP(request, "API");
	}
}
