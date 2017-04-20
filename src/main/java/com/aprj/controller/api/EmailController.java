package com.aprj.controller.api;

import com.aprj.entities.Emails;
import com.aprj.models.MoneyCountModel;
import com.aprj.models.SenderCount;
import com.aprj.models.UrlCountModel;
import com.aprj.service.impl.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
    public List<Emails> GetAllEmail() {
        return emailService.GetAllMails();
    }

    @GetMapping("top10web")
    public List<UrlCountModel> GetTop10Web() {
        List<Emails> all = emailService.GetAllMails();
        ArrayList<String> webs = new ArrayList<String>();
        all.forEach(email -> {
            Pattern p = Pattern.compile("https?://.+?(?=/)");
            Matcher matcher = p.matcher(email.getRawText());
            if (matcher.find()) {
                String url = matcher.group()
                        .replace(" ", "")
                        .replace("corn", "com")
                        .replace("<http:", "")
                        .replace("tcom", "com")
                        .replace("sa1on", "salon")
                        .replace("sabon", "salon")
                        .replace("i2o12", "")
                        .replace("i2olgbo", "")
                        .replace("juaricole.com", "juancole.com")
                        .replace("controHer", "controller")
                        .replace("cO.uk", ".co.uk")
                        .replace("vvvvw.", "www.");
                webs.add(url);
                logger.info(url);
            }
        });

        Map<String, List<String>> map = webs.stream().collect(Collectors.groupingBy(s -> s));
        List<UrlCountModel> list = map.entrySet().stream()
                .map(kv -> new UrlCountModel(kv.getKey(), kv.getValue().size()))
                .sorted((s1, s2) -> {
                    return s2.getCount().compareTo(s1.getCount());
                })
                .limit(10)
                .collect(Collectors.toList());
        return list;
    }

    @GetMapping("top100money")
    public List<MoneyCountModel> GetTop100MoneyMentionedEmail() {
        List<MoneyCountModel> temp = new ArrayList<MoneyCountModel>();
        List<Emails> all = emailService.GetAllMails();
        Pattern p = Pattern.compile("\\$\\d+ (million|billion|hundred|thousand)");

        all.forEach(email -> {
            Matcher matcher = p.matcher(email.getRawText());
            if (matcher.find()) {
                String s = matcher.group();

                BigDecimal bigDecimal = new BigDecimal(Double.parseDouble(matcher.group()
                        .replace(" ", "")
                        .replace("$", "")
                        .replace("million", "000000")
                        .replace("billion", "000000000")
                        .replace("hundreds", "00")
                        .replace("thousands", "000")
                        .replace("hundred", "00")
                        .replace("thousand", "000")
                ));

                MoneyCountModel m = new MoneyCountModel(bigDecimal,
                        email.getMetadataFrom(),
                        email.getMetadataTo());
                temp.add(m);
                logger.info(s);
            }
        });

        List<MoneyCountModel> result = temp.stream()
                .sorted((s1, s2) -> {
                    return s2.getAmount().compareTo(s1.getAmount());
                }).limit(100)
                .collect(Collectors.toList());

        return result;
    }

    @GetMapping("top10senders")
    public List<SenderCount> GetTop10Senders() {
        List<Emails> all = emailService.GetAllMails();
        Map<String, Integer> mails = new HashMap<>();

        all.forEach(email -> {
            if (null != email.getExtractedFrom() && !"".equals(email.getExtractedFrom())) {
                String from = email.getExtractedFrom()
                        .replace("< ", "<")
                        .replace(" >", ">");

                if (mails.containsKey(from)) {
                    mails.put(from, mails.get(from) + 1);
                } else {
                    mails.put(from, 1);
                }
                logger.info(from);
            }
        });

        List<SenderCount> list = mails.entrySet().stream()
                .map(kv -> new SenderCount(kv.getValue(), kv.getKey()))
                .sorted((s1, s2) -> {
                    return s2.getCount().compareTo(s1.getCount());
                })
                .limit(10)
                .collect(Collectors.toList());
        return list;
    }

    //todo: read json file dncs_link and dncs_node, return datav connection json
    //todo: read json file podestas_link and podestas_node return datav connection json

}
