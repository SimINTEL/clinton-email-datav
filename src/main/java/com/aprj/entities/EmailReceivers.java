package com.aprj.entities;

import javax.persistence.*;

/**
 * Created by southdom on 2017/4/19.
 */
@Entity
@Table(name = "email_receivers")
public class EmailReceivers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer emailId;
    private Integer personId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmailId() {
        return emailId;
    }

    public void setEmailId(Integer emailId) {
        this.emailId = emailId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmailReceivers that = (EmailReceivers) o;

        if (!id.equals(that.id)) return false;
        if (!emailId.equals(that.emailId)) return false;
        return personId.equals(that.personId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + emailId.hashCode();
        result = 31 * result + personId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "EmailReceivers{" +
                "id=" + id +
                ", emailId=" + emailId +
                ", personId=" + personId +
                '}';
    }
}
