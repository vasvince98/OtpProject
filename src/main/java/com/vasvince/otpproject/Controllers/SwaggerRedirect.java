package com.vasvince.otpproject.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class SwaggerRedirect {

    @RequestMapping("/swagger-ui")
    public RedirectView swaggerRedirect() {
        return new RedirectView("/swagger-ui.html");
    }
}
