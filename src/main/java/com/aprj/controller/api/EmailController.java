package com.aprj.controller.api;

import com.aprj.entities.Emails;
import com.aprj.service.impl.EmailService;
import com.aprj.service.impl.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by RickyWu on 2017/4/20.
 */

@RestController
@RequestMapping("api/email")
public class EmailController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EmailService emailService;

    @GetMapping("GetAllEmail")
    public List<Emails> GetAllEmail(){
        return emailService.GetAllMails();
    }
}
