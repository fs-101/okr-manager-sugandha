package com.xebia.okr.domain;

import javax.persistence.*;

@Entity
@Table(name="key_results")
public class KeyResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private int confidence_score;
    private KeyResultStatus keyResultStatus;
    private int percentageFinished;

    public KeyResult(String title, int confidence_score, KeyResultStatus keyResultStatus, int percentageFinished, Objective objective) {
        this.title = title;
        this.confidence_score = confidence_score;
        this.keyResultStatus = keyResultStatus;
        this.percentageFinished = percentageFinished;
        this.objective = objective;
    }

    @ManyToOne
    @JoinColumn
    private Objective objective;

    public KeyResult()
    {

    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setConfidence_score(int confidence_score) {
        this.confidence_score = confidence_score;
    }

    public void setKeyResultStatus(KeyResultStatus keyResultStatus) {
        this.keyResultStatus = keyResultStatus;
    }

    public void setPercentageFinished(int percentageFinished) {
        this.percentageFinished = percentageFinished;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getConfidence_score() {
        return confidence_score;
    }

    public KeyResultStatus getKeyResultStatus() {
        return keyResultStatus;
    }

    public int getPercentageFinished() {
        return percentageFinished;
    }
}
