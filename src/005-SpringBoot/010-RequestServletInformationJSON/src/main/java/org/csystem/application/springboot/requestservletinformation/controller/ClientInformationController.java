package org.csystem.application.springboot.requestservletinformation.controller;

import org.csystem.application.springboot.requestservletinformation.viewmodel.ClientInformationViewModel;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/info")
@Scope("prototype")
public class ClientInformationController {
    private final HttpServletRequest m_httpServletRequest;
    private final ClientInformationViewModel m_clientInformationViewModel;

    public ClientInformationController(
                    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
                    HttpServletRequest httpServletRequest,
                    ClientInformationViewModel clientInformationViewModel)
    {
        m_httpServletRequest = httpServletRequest;
        m_clientInformationViewModel = clientInformationViewModel;
    }

    //...
    @GetMapping("/client")
    public ClientInformationViewModel getClientInformation()
    {
        return m_clientInformationViewModel
                .setLocalAddress(m_httpServletRequest.getLocalAddr())
                .setRemoteAddress(m_httpServletRequest.getRemoteAddr())
                .setRemoteHost(m_httpServletRequest.getRemoteHost())
                .setLocalPort(m_httpServletRequest.getLocalPort())
                .setRemotePort(m_httpServletRequest.getRemotePort());
    }
}
