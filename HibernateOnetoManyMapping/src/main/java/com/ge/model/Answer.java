package com.ge.model;

import jakarta.persistence.*;

@Entity
public class Answer {
    @Id
    private Integer id;
    private String answer;

    /*It refers to relationship between two entities where multiple instances of one entity should be mapped with exactly one instance of another entity.*/
    /*Examples:
        Multiple answers belong to one question.
        Multiple students have joined the same course.
    */
    @ManyToOne(cascade = CascadeType.ALL)
    private Question question;

    public Answer(){
        System.out.println("Zero Parameterized Constructor of Answer");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                '}';
    }
}
