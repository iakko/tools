package net.iakko.tools.controllers.html;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.iakko.tools.controllers.services.data.IP;
import net.iakko.tools.core.Logic;

@Controller
public class MyIPHTML
{
	private static final Logger	log	= LoggerFactory.getLogger(MyIPHTML.class);

	@Autowired
	private Logic logic;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	private ModelAndView html(HttpServletRequest request, @RequestParam(value = "port", required = false, defaultValue = "false") boolean port)
	{
		long ts = System.currentTimeMillis();
		String output = "<empty>";
		try
		{
			IP ip = logic.getIP(request, "HTML");
			output = ip.getIp() + (port ? ":" + ip.getPort() : "");

			ModelAndView model = new ModelAndView();
		    model.setViewName("myip");
			model.addObject("my_ip", output);
			
			return model;
		}
		finally
		{
			long te = System.currentTimeMillis();
			log.info(String.format("Request from source IP '%s' executed in '%.3f' seconds.", output, (te - ts) / 1000.0));
		}
	}
}
