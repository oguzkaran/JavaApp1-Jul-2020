package org.csystem.application.todo.rest.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TodoInfoDTO {
    private long m_id;
    private String m_username;
    private String m_title;
    private String m_description;
    private LocalDate m_startDate;
    private LocalDate m_expectedEndDate;
    private LocalDate m_endDate;
    private boolean m_isCompleted;

    public TodoInfoDTO()
    {}

    public TodoInfoDTO(long id, String username, String title, String description, LocalDate startDate, LocalDate expectedEndDate, LocalDate endDate, boolean isCompleted)
    {
        m_id = id;
        m_username = username;
        m_title = title;
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

    public String getUsername()
    {
        return m_username;
    }

    public void setUsername(String username)
    {
        m_username = username;
    }

    public String getTitle()
    {
        return m_title;
    }

    public void setTitle(String title)
    {
        m_title = title;
    }

    public String getDescription()
    {
        return m_description;
    }

    public void setDescription(String description)
    {
        m_description = description;
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
        return m_isCompleted;
    }

    public void setCompleted(boolean completed)
    {
        m_isCompleted = completed;
    }
}
