package com.aprj.entities;

import javax.persistence.*;

/**
 * Created by southdom on 2017/4/19.
 */

@Entity
@Table(name = "aliases")
public class Aliases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String alias;
    private Integer personId;


    public Integer getId() {
        return id;
    }

    public String getAlias() {
        return alias;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aliases aliases = (Aliases) o;

        if (!id.equals(aliases.id)) return false;
        if (alias != null ? !alias.equals(aliases.alias) : aliases.alias != null) return false;
        return personId.equals(aliases.personId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (alias != null ? alias.hashCode() : 0);
        result = 31 * result + personId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Aliases{" +
                "id=" + id +
                ", alias='" + alias + '\'' +
                ", persionId=" + personId +
                '}';
    }
}
