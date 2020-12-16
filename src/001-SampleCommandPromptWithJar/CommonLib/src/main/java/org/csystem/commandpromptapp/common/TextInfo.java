package org.csystem.commandpromptapp.common;

import java.time.LocalDateTime;

public class TextInfo {
    private String m_text;
    private LocalDateTime m_insertDateTime;

    public TextInfo(String text)
    {
        this(text, LocalDateTime.now());
    }

    public TextInfo(String text, LocalDateTime insertDateTime)
    {
        m_text = text;
        m_insertDateTime = insertDateTime;
    }

    public String getText()
    {
        return m_text;
    }

    public void setText(String text)
    {
        m_text = text;
    }

    public LocalDateTime getInsertDateTime()
    {
        return m_insertDateTime;
    }

    public void setInsertDateTime(LocalDateTime insertDateTime)
    {
        m_insertDateTime = insertDateTime;
    }
}
