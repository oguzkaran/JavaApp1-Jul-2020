package org.csystem.samples;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Person {
    private int m_id;
    private String m_name;
    private LocalDate m_birthDate;
    private MaritalStatus m_maritalStatus;

    public Person(int id, String name, LocalDate birthDate, MaritalStatus maritalStatus)
    {
        m_id = id;
        m_name = name;
        m_birthDate = birthDate;
        m_maritalStatus = maritalStatus;
    }

    public int getId()
    {
        return m_id;
    }

    public void setId(int id)
    {
        m_id = id;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public LocalDate getBirthDate()
    {
        return m_birthDate;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        m_birthDate = birthDate;
    }

    public double getAge()
    {
        return ChronoUnit.DAYS.between(m_birthDate, LocalDate.now()) / 365.;
    }

    public MaritalStatus getMaritalStatus()
    {
        return m_maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus)
    {
        m_maritalStatus = maritalStatus;
    }

    @Override
    public String toString()
    {
        return String.format("{id : %d, name : \"%s\", maritalStatus : \"%s\", birthDate : \"%s\", age: %.3f}",
                m_id, m_name, m_maritalStatus, DateTimeFormatter.ofPattern("dd/MM/yyyy").format(m_birthDate), this.getAge());
    }
}
