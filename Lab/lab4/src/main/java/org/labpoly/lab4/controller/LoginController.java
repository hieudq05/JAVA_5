package org.labpoly.lab4.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.labpoly.lab4.service.CookieService;
import org.labpoly.lab4.service.ParamService;
import org.labpoly.lab4.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

@Controller
@RequestMapping("account/login")
public class LoginController {
    private final HttpServletRequest request;
    private CookieService cookieService;
    private SessionService sessionService;
    private ParamService paramService;
    private final ServletContext servletContext;

    public LoginController(@Autowired HttpServletRequest request
                        , @Autowired CookieService cookieService
                        , @Autowired SessionService sessionService
                        , @Autowired ParamService paramService
                        , @Autowired ServletContext servletContext) {
        this.request = request;
        this.cookieService = cookieService;
        this.sessionService = sessionService;
        this.paramService = paramService;
        this.servletContext = servletContext;
    }

    @GetMapping()
    public String showLoginPage() {
        return "login";
    }

    @PostMapping()
    public String postFormLogin(@RequestParam("file") MultipartFile fileParam) throws IOException {
        String trueUsername = "poly";
        String truePassword = "123";

        String username = paramService.getString("username", null);
        String password = paramService.getString("password", null);
        Boolean rememberMe = paramService.getBoolean("remember", false);

        if(username.equals(trueUsername) && password.equals(truePassword)) {
            File file = null;
            String date = paramService.getLocalDate("birth", LocalDate.now().toString(), "dd/MM/yyyy");
            sessionService.set("username", username);

            if(!Objects.equals(fileParam.getOriginalFilename(), "")) {
                file = paramService.saveFile(fileParam, servletContext.getRealPath("pages"), "demoFile");
            }

            if(rememberMe) {
                cookieService.addCookie("username", username, 60*60*24);
            } else {
                cookieService.remove("username");
            }

            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("birth", date);
            request.setAttribute("filePath", file==null?null:file.getAbsolutePath());
            request.setAttribute("remember", rememberMe);
        } else {
            sessionService.remove("username");
            cookieService.remove("username");
            request.setAttribute("username", "?");
            request.setAttribute("password", "?");
            request.setAttribute("birth", "?");
            request.setAttribute("filePath", "?");
            request.setAttribute("remember", "?");
        }

        return "login";
    }
}
