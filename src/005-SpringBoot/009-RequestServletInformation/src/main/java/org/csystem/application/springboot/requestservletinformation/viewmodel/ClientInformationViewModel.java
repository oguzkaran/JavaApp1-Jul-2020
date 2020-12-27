package org.csystem.application.springboot.requestservletinformation.viewmodel;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Scope("prototype")
public class ClientInformationViewModel {
    private String m_localAddress = "";
    private String m_remoteAddress = "";
    private String m_remoteHost = "";
    private int m_localPort;
    private int m_remotePort;
    private LocalDateTime m_requestTime;

    public ClientInformationViewModel(LocalDateTime requestTime)
    {
        m_requestTime = requestTime;
    }

    public String getLocalAddress()
    {
        return m_localAddress;
    }

    public ClientInformationViewModel setLocalAddress(String localAddress)
    {
        m_localAddress = localAddress;

        return this;
    }

    public String getRemoteAddress()
    {
        return m_remoteAddress;
    }

    public ClientInformationViewModel setRemoteAddress(String remoteAddress)
    {
        m_remoteAddress = remoteAddress;

        return this;
    }

    public String getRemoteHost()
    {
        return m_remoteHost;
    }

    public ClientInformationViewModel setRemoteHost(String remoteHost)
    {
        m_remoteHost = remoteHost;

        return this;
    }

    public int getLocalPort()
    {
        return m_localPort;
    }

    public ClientInformationViewModel setLocalPort(int localPort)
    {
        m_localPort = localPort;

        return this;
    }

    public int getRemotePort()
    {
        return m_remotePort;
    }

    public ClientInformationViewModel setRemotePort(int remotePort)
    {
        m_remotePort = remotePort;

        return this;
    }

    public LocalDateTime getRequestTime()
    {
        return m_requestTime;
    }

    public ClientInformationViewModel setRequestTime(LocalDateTime requestTime)
    {
        m_requestTime = requestTime;

        return this;
    }

    @Override
    public String toString()
    {
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        var formatString ="Local Address: %s, Remote Address: %s, Remote Host: %s, LocalPort: %d, Remote Port: %d, Request Time: %s";

        return String.format(formatString, m_localAddress, m_remoteAddress, m_remoteHost, m_localPort, m_remotePort, formatter.format(m_requestTime));
    }
}
