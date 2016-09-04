package com.mchoice.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Oualid on 30/08/2016.
 */
@Entity
@Table(name="mcq")
public class Mcq {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String createdBy;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mcq", cascade = {CascadeType.ALL})
    private List<McqQuestion> questions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<McqQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<McqQuestion> questions) {
        this.questions = questions;
    }
}
