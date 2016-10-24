package net.iakko.tools.controllers.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.iakko.tools.controllers.services.data.IP;

@RestController
@RequestMapping(value="/api")
public class GetIP
{
	@RequestMapping(value="/get_ip", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public static IP retrieveIP(HttpServletRequest request)
	{
		IP ip = new IP();
		ip.setIp(request.getRemoteAddr());
		ip.setPort(request.getRemotePort());
		return ip;
	}
}
