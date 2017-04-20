package com.aprj.controller.api;

import com.aprj.entities.Emails;
import com.aprj.models.UrlCountModel;
import com.aprj.service.impl.EmailService;
import com.aprj.service.impl.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.lang.Integer;
/**
 * Created by RickyWu on 2017/4/20.
 */

@RestController
@RequestMapping("api/email")
public class EmailController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EmailService emailService;

    @GetMapping("all")
    public List<Emails> GetAllEmail(){
        return emailService.GetAllMails();
    }

    @GetMapping("top10web")
    public List<UrlCountModel> GetTop10Web(){
        List<Emails> all = emailService.GetAllMails();
        ArrayList<String> webs = new ArrayList<String>();
        all.forEach(email -> {
            Pattern p = Pattern.compile("https?://.+?(?=/)");
            Matcher matcher = p.matcher(email.getRawText());
            if(matcher.find()){
                String url = matcher.group()
                        .replace(" ","")
                        .replace("corn","com")
                        .replace("<http:","")
                        .replace("tcom","com")
                        .replace("sa1on","salon")
                        .replace("sabon","salon")
                        .replace("i2o12","")
                        .replace("i2olgbo","")
                        .replace("juaricole.com","juancole.com")
                        .replace("controHer","controller")
                        .replace("cO.uk",".co.uk")
                        .replace("vvvvw.","www.");
                webs.add(url);
                logger.info(url);
            }
        });

        Map<String,List<String>> map = webs.stream().collect(Collectors.groupingBy(s->s));
        List<UrlCountModel> list = map.entrySet().stream()
                .map(kv->new UrlCountModel(kv.getKey(),kv.getValue().size()))
                .sorted((s1,s2)->{
                    return s2.getCount().compareTo(s1.getCount());
                })
                .limit(20)
                .collect(Collectors.toList());
        return list;
    }
}
