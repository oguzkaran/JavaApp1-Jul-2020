package org.csystem.application.todo.data.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "todos")
public class TodoInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "insert_date", nullable = false)
    private LocalDate insertDate = LocalDate.now();

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "expected_end_date", nullable = false)
    private LocalDate expectedEndDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "completed", nullable = false)
    private boolean completed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", nullable = false)
    private UserInfo userInfo;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public LocalDate getInsertDate()
    {
        return insertDate;
    }

    public void setInsertDate(LocalDate insertDate)
    {
        this.insertDate = insertDate;
    }

    public LocalDate getStartDate()
    {
        return startDate;
    }

    public void setStartDate(LocalDate startDate)
    {
        this.startDate = startDate;
    }

    public LocalDate getExpectedEndDate()
    {
        return expectedEndDate;
    }

    public void setExpectedEndDate(LocalDate expectedEndDate)
    {
        this.expectedEndDate = expectedEndDate;
    }

    public LocalDate getEndDate()
    {
        return endDate;
    }

    public void setEndDate(LocalDate endDate)
    {
        this.endDate = endDate;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }

    public UserInfo getUserInfo()
    {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo)
    {
        this.userInfo = userInfo;
    }
}
