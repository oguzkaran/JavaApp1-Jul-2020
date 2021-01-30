package org.csystem.application.rest.competition.dto;

import org.csystem.application.rest.competition.data.entity.Option;

import java.util.List;

public class QuestionInfoDTO {
    private String m_description;
    private int m_answerIndex;
    private List<Option> m_options;
    private String m_levelStr;

    public String getDescription()
    {
        return m_description;
    }

    public void setDescription(String description)
    {
        m_description = description;
    }

    public int getAnswerIndex()
    {
        return m_answerIndex;
    }

    public void setAnswerIndex(int answerIndex)
    {
        m_answerIndex = answerIndex;
    }

    public List<Option> getOptions()
    {
        return m_options;
    }

    public void setOptions(List<Option> options)
    {
        m_options = options;
    }

    public String getLevelStr()
    {
        return m_levelStr;
    }

    public void setLevelStr(String levelStr)
    {
        m_levelStr = levelStr;
    }
}
