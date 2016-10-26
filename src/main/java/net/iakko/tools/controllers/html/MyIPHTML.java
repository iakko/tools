package net.iakko.tools.controllers.html;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.iakko.tools.controllers.services.GetIP;
import net.iakko.tools.controllers.services.data.IP;

@Controller
public class MyIPHTML
{
	private static final Logger log = LoggerFactory.getLogger(MyIPHTML.class);

	@RequestMapping(value = "/html", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	private String html(HttpServletRequest request, @RequestParam(value = "port", required = false, defaultValue = "false") boolean port, Model model)
	{
		long ts = System.currentTimeMillis();
		String output = "<empty>";
		try
		{
			IP ip = GetIP.retrieveIP(request);
			output = ip.getIp() + (port ? ":" + ip.getPort() : "");
			model.addAttribute("my_ip", output);
			return "myip";
		}
		finally
		{
			long te = System.currentTimeMillis();
			log.info(String.format("Request from source IP '%s' executed in '%.3f' seconds.", output, (te - ts) / 1000.0));
		}
	}
}