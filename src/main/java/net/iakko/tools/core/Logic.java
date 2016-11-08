package net.iakko.tools.core;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.iakko.tools.controllers.services.data.IP;
import net.iakko.tools.core.db.RequestDAO;

@Component
public class Logic
{
	@Autowired
	private RequestDAO ipRequest;

	public IP getIP(HttpServletRequest request, String source)
	{
		IP ip = new IP();

		ip.setIp(request.getRemoteAddr());
		ip.setPort(request.getRemotePort());

		ipRequest.trace(ip.getIp(), ip.getPort(), source);

		return ip;
	}
}