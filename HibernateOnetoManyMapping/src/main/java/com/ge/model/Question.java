package com.ge.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {
    @Id
    @Column(name="question_id")
    private Integer id;
    private String question;

    /*This annotation refers to relationship between two entities where one instance of one entity should be mapped with multiple instance of another entity.*/
    /*Examples :
        One Question has Multiple Answers.
        One Student has Multiple Courses.
     */
    /*cascade property tells hibernate to perform same operations that are performed on Question to the Answer class as well. So if you persist one object the other object also gets persisted.*/
    @OneToMany(cascade = CascadeType.ALL)
    private List<Answer> answerList;

    public Question(){
        System.out.println("Zero Parameterized Constructor of Question Class.");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answerList=" + answerList +
                '}';
    }
}
