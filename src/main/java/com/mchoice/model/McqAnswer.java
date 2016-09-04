package com.mchoice.model;

import javax.persistence.*;

/**
 * Created by Oualid on 30/08/2016.
 */
@Entity
@Table(name="mcq_answer")
public class McqAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer points;

    @ManyToOne
    private Answer answer;

    @ManyToOne
    private McqQuestion mcqQuestion;

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public McqQuestion getMcqQuestion() {
        return mcqQuestion;
    }

    public void setMcqQuestion(McqQuestion mcqQuestion) {
        this.mcqQuestion = mcqQuestion;
    }
}
