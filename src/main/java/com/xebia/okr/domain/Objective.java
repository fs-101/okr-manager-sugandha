package com.xebia.okr.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="objectives")
public class Objective {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String title;
    private String labels;

    public Objective()
    {

    }
    public void setId(Long id) {
        Id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public void setKeyResults(List<KeyResult> keyResults) {
        this.keyResults = keyResults;
    }

    @ManyToOne
    @JoinColumn
    private Plan plan;

    public Long getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public Objective(String title, String labels, Plan plan/*, List<KeyResult> keyResults*/) {
        this.title = title;
        this.labels = labels;
        this.plan = plan;
        //this.keyResults = keyResults;
    }

    public String getLabels() {
        return labels;
    }

    public List<KeyResult> getKeyResults() {
        return keyResults;
    }

    @OneToMany(mappedBy="objective")
    private List<KeyResult> keyResults;
}
