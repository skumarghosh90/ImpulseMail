package in.net.impulsetech.ImpulseMail.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebappController {

	@RequestMapping("/")
	public String getWebApp() {
		return "index.html";
	}

}
