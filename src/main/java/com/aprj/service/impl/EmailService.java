package com.aprj.service.impl;

import com.aprj.dao.EmailsDao;
import com.aprj.service.IEmailService;
import com.aprj.entities.Emails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by RickyWu on 2017/4/20.
 */
@Service
public class EmailService implements IEmailService {

    @Autowired
    EmailsDao dao;

    @Override
    public List<Emails> GetAllMails(){
        return dao.findAll();
    }
}
