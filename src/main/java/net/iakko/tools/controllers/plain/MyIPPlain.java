package net.iakko.tools.controllers.plain;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.iakko.tools.controllers.services.GetIP;
import net.iakko.tools.controllers.services.data.IP;
import net.iakko.tools.core.db.RequestDAO;

@RestController
public class MyIPPlain
{
	private static final Logger	log	= LoggerFactory.getLogger(MyIPPlain.class);

	@Autowired
	private Environment			env;

	@Autowired
	private GetIP				getIP;

	@RequestMapping(value = "/plain", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	private String plain(HttpServletRequest request, @RequestParam(value = "port", required = false, defaultValue = "false") boolean port)
	{
		long ts = System.currentTimeMillis();
		String output = "<empty>";
		try
		{
			IP ip = getIP.retrieveIP(request, "PLAIN" );
			output = ip.getIp() + (port ? ":" + ip.getPort() : "");
			return output;
		}
		catch (Exception e)
		{
			log.error("Unknown error :/", e);
			throw e;
		}
		finally
		{
			long te = System.currentTimeMillis();
			log.info(String.format("Request from source IP '%s' executed in '%.3f' seconds.", output, (te - ts) / 1000.0));
		}
	}
}
