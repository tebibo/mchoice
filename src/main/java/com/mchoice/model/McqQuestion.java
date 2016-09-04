package com.mchoice.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Oualid on 30/08/2016.
 */
@Entity
@Table(name="mcq_question")
public class McqQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    private Question  question;

    @NotNull
    private Double coefficient = 1.0;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mcqQuestion", cascade = {CascadeType.ALL})
    private List<McqAnswer> answers;

    @ManyToOne
    private Mcq mcq;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public List<McqAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<McqAnswer> answers) {
        this.answers = answers;
    }

    public Mcq getMcq() {
        return mcq;
    }

    public void setMcq(Mcq mcq) {
        this.mcq = mcq;
    }
}
