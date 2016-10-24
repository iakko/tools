package net.iakko.tools.controllers.plain;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.iakko.tools.controllers.services.GetIP;
import net.iakko.tools.controllers.services.data.IP;

@RestController
public class MyIPPlain
{
	private static final Logger log = LoggerFactory.getLogger(MyIPPlain.class);

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	private String plain(HttpServletRequest request, @RequestParam(value = "port", required = false, defaultValue = "false") boolean port)
	{
		long ts = System.currentTimeMillis();
		String output = "<empty>";
		try
		{
			IP ip = GetIP.retrieveIP(request);
			output = ip.getIp() + (port ? ":" + ip.getPort() : "");
			return output;
		}
		finally
		{
			long te = System.currentTimeMillis();
			log.info(String.format("Request from source IP '%s' executed in '%.3f' seconds.", output, (te - ts) / 1000.0));
		}
	}
}
