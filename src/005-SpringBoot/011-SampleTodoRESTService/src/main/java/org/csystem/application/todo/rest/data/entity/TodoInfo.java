package org.csystem.application.todo.rest.data.entity;

import java.time.LocalDate;

public class TodoInfo {
    private long m_id;
    private String m_username;
    private String m_title;
    private String m_description;
    private final LocalDate m_insertDate = LocalDate.now();
    private LocalDate m_startDate;
    private LocalDate m_expectedEndDate;
    private LocalDate m_endDate;
    private boolean m_completed;

    public TodoInfo()
    {
    }

    public TodoInfo(String title, String username, String description, LocalDate startDate, LocalDate expectedEndDate, LocalDate endDate, boolean completed)
    {
        this(0, title, username, description, startDate, expectedEndDate, endDate, false);
    }

    public TodoInfo(long id, String title, String username, String description, LocalDate startDate, LocalDate expectedEndDate, LocalDate endDate, boolean completed)
    {
        m_id = id;
        m_title = title;
        m_username = username;
        m_description = description;
        m_startDate = startDate;
        m_expectedEndDate = expectedEndDate;
        m_endDate = endDate;
        m_completed = completed;
    }

    public long getId()
    {
        return m_id;
    }

    public void setId(long id)
    {
        m_id = id;
    }

    public String getTitle()
    {
        return m_title;
    }

    public void setTitle(String title)
    {
        m_title = title;
    }

    public String getUsername()
    {
        return m_username;
    }

    public void setUsername(String username)
    {
        m_username = username;
    }

    public String getDescription()
    {
        return m_description;
    }

    public void setDescription(String description)
    {
        m_description = description;
    }

    public LocalDate getInsertDate()
    {
        return m_insertDate;
    }



    public LocalDate getStartDate()
    {
        return m_startDate;
    }

    public void setStartDate(LocalDate startDate)
    {
        m_startDate = startDate;
    }

    public LocalDate getExpectedEndDate()
    {
        return m_expectedEndDate;
    }

    public void setExpectedEndDate(LocalDate expectedEndDate)
    {
        m_expectedEndDate = expectedEndDate;
    }

    public LocalDate getEndDate()
    {
        return m_endDate;
    }

    public void setEndDate(LocalDate endDate)
    {
        m_endDate = endDate;
    }

    public boolean isCompleted()
    {
        return m_completed;
    }

    public void setCompleted(boolean completed)
    {
        m_completed = completed;
    }
}
