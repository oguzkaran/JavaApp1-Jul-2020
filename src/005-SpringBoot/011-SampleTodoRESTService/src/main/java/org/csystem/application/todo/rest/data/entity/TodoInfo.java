package org.csystem.application.todo.rest.data.entity;

import java.time.LocalDateTime;

public class TodoInfo {
    private long m_id;
    private String m_username;
    private String m_title;
    private String m_description;
    private final LocalDateTime m_insertDate = LocalDateTime.now();
    private LocalDateTime m_startDate;
    private LocalDateTime m_expectedEndDate;
    private LocalDateTime m_endDate;
    private boolean m_isCompleted;

    public TodoInfo()
    {
    }

    public TodoInfo(String title, String username, String description, LocalDateTime startDate, LocalDateTime expectedEndDate, LocalDateTime endDate, boolean isCompleted)
    {
        this(0, title, username, description, startDate, expectedEndDate, endDate, false);
    }

    public TodoInfo(long id, String title, String username, String description, LocalDateTime startDate, LocalDateTime expectedEndDate, LocalDateTime endDate, boolean isCompleted)
    {
        m_id = id;
        m_title = title;
        m_username = username;
        m_description = description;
        m_startDate = startDate;
        m_expectedEndDate = expectedEndDate;
        m_endDate = endDate;
        m_isCompleted = isCompleted;
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

    public LocalDateTime getInsertDate()
    {
        return m_insertDate;
    }



    public LocalDateTime getStartDate()
    {
        return m_startDate;
    }

    public void setStartDate(LocalDateTime startDate)
    {
        m_startDate = startDate;
    }

    public LocalDateTime getExpectedEndDate()
    {
        return m_expectedEndDate;
    }

    public void setExpectedEndDate(LocalDateTime expectedEndDate)
    {
        m_expectedEndDate = expectedEndDate;
    }

    public LocalDateTime getEndDate()
    {
        return m_endDate;
    }

    public void setEndDate(LocalDateTime endDate)
    {
        m_endDate = endDate;
    }

    public boolean isCompleted()
    {
        return m_isCompleted;
    }

    public void setCompleted(boolean completed)
    {
        m_isCompleted = completed;
    }
}
