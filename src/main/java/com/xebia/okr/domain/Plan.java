package com.xebia.okr.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="plans")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startOn=" + startOn +
                ", endOn=" + endOn +
              //  ", ObjList=" + ObjList +
                '}';
    }

    private String title;
    private Date startOn;

    public Plan( String title, Date startOn, Date endOn) {
        this.title = title;
        this.startOn = startOn;
        this.endOn = endOn;
    }

    private Date endOn;

    public Plan()
    {

    }
    @OneToMany(mappedBy = "plan")
    private List<Objective> ObjList;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartOn(Date startOn) {
        this.startOn = startOn;
    }

    public void setEndOn(Date endOn) {
        this.endOn = endOn;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getStartOn() {
        return startOn;
    }

    public Date getEndOn() {
        return endOn;
    }
}
