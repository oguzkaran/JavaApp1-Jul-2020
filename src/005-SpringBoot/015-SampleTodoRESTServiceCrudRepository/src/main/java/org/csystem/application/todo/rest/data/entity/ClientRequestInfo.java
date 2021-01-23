package org.csystem.application.todo.rest.data.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "clients_request_info")
public class ClientRequestInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clients_request_info_id")
    private long m_id;

    @Column(name = "host", nullable = false)
    private String m_host;

    @Column(name = "local_port", nullable = false)
    private int m_localPort;

    @Column(name = "username", nullable = false)
    private String m_username;

    @Column(name = "query_time", nullable = false)
    private LocalDateTime m_queryTime;

    public ClientRequestInfo()
    {}


    public ClientRequestInfo(String host, int localPort, String username)
    {
        this(0, host, username, localPort, LocalDateTime.now());
    }

    public ClientRequestInfo(String host, String username, int localPort, LocalDateTime queryTime)
    {
        this(0, host, username, localPort, queryTime);
    }

    public ClientRequestInfo(long id, String host, String username, int localPort, LocalDateTime queryTime)
    {
        m_id = id;
        m_host = host;
        m_username = username;
        m_localPort = localPort;
        m_queryTime = queryTime;
    }

    public long getId()
    {
        return m_id;
    }

    public void setId(long id)
    {
        m_id = id;
    }

    public String getHost()
    {
        return m_host;
    }

    public void setHost(String host)
    {
        m_host = host;
    }

    public int getLocalPort()
    {
        return m_localPort;
    }

    public void setLocalPort(int localPort)
    {
        m_localPort = localPort;
    }

    public void setUsername(String username)
    {
        m_username = username;
    }

    public LocalDateTime getQueryTime()
    {
        return m_queryTime;
    }

    public void setQueryTime(LocalDateTime queryTime)
    {
        m_queryTime = queryTime;
    }
}
