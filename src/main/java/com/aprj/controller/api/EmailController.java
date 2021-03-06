package com.aprj.controller.api;

import com.aprj.entities.EmailReceivers;
import com.aprj.entities.Emails;
import com.aprj.models.*;
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

    @GetMapping("over_emotive")
    public List<EmailContentModel> GetAllEmailOverEmotive() {
        List<Emails> all = emailService.GetAllMails();
        ArrayList<EmailContentModel> webs = new ArrayList<EmailContentModel>();
        all.forEach(email -> {
            Pattern p = Pattern.compile("[a-z]+[?|]{2,}");
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
                EmailContentModel model = new EmailContentModel();
                model.setFrom(email.getExtractedFrom());
                model.setTo(email.getExtractedTo());
                model.setContent(email.getExtractedBodyText());
                webs.add(model);
                logger.info(url);
            }
        });
        return webs;
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

    @GetMapping("top10receviers")
    public List<RecvCount> GetTop10Receviers() {
        List<Emails> all = emailService.GetAllMails();
        Map<String, Integer> mails = new HashMap<>();

        all.forEach(email -> {
            if (null != email.getExtractedFrom() && !"".equals(email.getExtractedTo())) {
                String to = email.getExtractedTo()
                        .replace("< ", "<")
                        .replace(" >", ">");

                if (mails.containsKey(to)) {
                    mails.put(to, mails.get(to) + 1);
                } else {
                    mails.put(to, 1);
                }
                logger.info(to);
            }
        });

        List<RecvCount> list = mails.entrySet().stream()
                .map(kv -> new RecvCount(kv.getValue(), kv.getKey()))
                .sorted((s1, s2) -> {
                    return s2.getCount().compareTo(s1.getCount());
                })
                .limit(10)
                .collect(Collectors.toList());
        return list;
    }

    @GetMapping("email-time")
    public List<TimeCount> EmailCountAlongTime() {
        List<Emails> all = emailService.GetAllMails();
        Map<String, Integer> mails = new HashMap<>();

        Map<String, List<Emails>> grouped = all.stream().collect(Collectors.groupingBy(email -> email.getMetadataDateSent()));
        List<TimeCount> list = grouped.entrySet().stream().filter(kv -> !kv.getKey().isEmpty()).map(kv -> {
            TimeCount t = new TimeCount();
            t.setTime(kv.getKey().substring(0,19).replace("T"," ").replace("-","/"));
            t.setCount(kv.getValue().size());
            t.setIds(kv.getValue().stream().map(x -> x.getDocNumber()).collect(Collectors.toList()));
            return t;
        }).sorted((m1,m2)->m1.getTime().compareTo(m2.getTime())).collect(Collectors.toList());
        return list;
    }

    @GetMapping("email-relationship")
    public List<EmailRelationshipModel> GetEmailRelationship() {
        List<Emails> all = emailService.GetAllMails();
        Set<Node> nodes = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();

        all.forEach(email -> {
            if (email.getMetadataFrom() != null && email.getMetadataTo() != null &&
                    !"".equals(email.getMetadataFrom()) && !"".equals(email.getMetadataTo())) {
                String key = email.getMetadataFrom() + "#" + email.getMetadataTo();
                String key1 = email.getMetadataTo() + "#" + email.getMetadataFrom();

                if (map.containsKey(key) || map.containsKey(key1)) {
                    if (map.get(key) != null) {
                        map.put(key, map.get(key) + 1);
                    } else {
                        map.put(key1, map.get(key1) + 1);
                    }
                } else {
                    map.put(key, 1);
                }
            }
        });

        List<Link> list = map.entrySet().stream()
                .map(kv -> new Link(kv.getKey().split("#")[0],
                        kv.getKey().split("#")[1],
                        kv.getValue().toString())
                )
                .sorted((s1, s2) -> {
                    return Integer.valueOf(s2.getValue()).compareTo(Integer.valueOf(s1.getValue()));
                })
                .limit(50)
                .collect(Collectors.toList());

        list.forEach(link -> {
            if(link.getSource().equals("H")){
                Node n = new Node("", link.getSource(), "group");
                nodes.add(n);
            }
            else{
                Node n = new Node("", link.getSource(), "group2");
                nodes.add(n);
            }

            if(link.getTarget().equals("H")) {
                Node n = new Node("", link.getTarget(), "group");
                nodes.add(n);
            }
            else{
                Node n = new Node("", link.getTarget(), "group2");
                nodes.add(n);
            }
        });

        EmailRelationshipModel m = new EmailRelationshipModel(nodes, list);
        List<EmailRelationshipModel> result = new ArrayList<>();
        result.add(m);

        return result;
    }
}
