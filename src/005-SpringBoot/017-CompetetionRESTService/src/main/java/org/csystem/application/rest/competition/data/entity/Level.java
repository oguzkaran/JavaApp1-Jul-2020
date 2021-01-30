package org.csystem.application.rest.competition.data.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "levels")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level_id", nullable = false)
    private int id;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Question> questions;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Set<Question> getQuestions()
    {
        return questions;
    }

    public void setQuestions(Set<Question> questions)
    {
        this.questions = questions;
    }
}
