package com.ge.model;

import jakarta.persistence.*;

@Entity
public class Question {
    @Id
    @Column(name="question_id")
    private Integer id;

    private String question;

    /*This annotation tells one instance of the entity will be mapped to one instance of another entity.*/
    /*cascade property tells hibernate to perform same operations that are performed on Question to the Answer class as well. So if you persist one object the other object also gets persisted.*/
    @OneToOne(cascade = CascadeType.ALL)
    private Answer answer;

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

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer=" + answer +
                '}';
    }
}
