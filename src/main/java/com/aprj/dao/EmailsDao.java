package com.aprj.dao;

import com.aprj.entities.Emails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by southdom on 2017/4/19.
 */
public interface EmailsDao extends JpaRepository<Emails, Long> {

    @Query("select u from Emails u")
    Stream<Emails> findAllByCustomQueryAndStream();

    @Query("select u from Emails u where u.extractedfrom = ?1")
    List<Emails> findByExtractedFrom(String emailFrom);
}
