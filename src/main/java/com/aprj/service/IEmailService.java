/**
 * Created by RickyWu on 2017/4/20.
 */
package com.aprj.service;

import com.aprj.entities.Emails;

import java.util.List;

public interface IEmailService {
    List<Emails> GetAllMails();
}
