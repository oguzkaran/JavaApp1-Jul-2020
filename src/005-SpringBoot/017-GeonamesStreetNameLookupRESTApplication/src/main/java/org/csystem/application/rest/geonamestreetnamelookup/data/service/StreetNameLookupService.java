package org.csystem.application.rest.geonamestreetnamelookup.data.service;

import org.csystem.application.rest.geonamestreetnamelookup.data.dal.StreetNameLookupHelper;
import org.csystem.application.rest.geonamestreetnamelookup.mapper.IAddressMapper;
import org.csystem.application.rest.geonamestreetnamelookup.viewmodel.StreetNameLookupViewModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StreetNameLookupService {
    @Value("${geonames.url}")
    private String m_url;

    private final IAddressMapper m_addressMapper;
    private final RestTemplate m_restTemplate;
    private final StreetNameLookupHelper m_streetNameLookupHelper;

    public StreetNameLookupService(IAddressMapper addressMapper, RestTemplate restTemplate, StreetNameLookupHelper streetNameLookupHelper)
    {
        m_addressMapper = addressMapper;
        m_restTemplate = restTemplate;
        m_streetNameLookupHelper = streetNameLookupHelper;
    }

    public StreetNameLookupViewModel findStreetNames(String query)
    {
        var url = String.format(m_url, query);

        var streetNameViewModel = m_restTemplate.getForObject(url, StreetNameLookupViewModel.class);

        if (streetNameViewModel != null)
            streetNameViewModel.getAddress().stream()
                    .map(m_addressMapper::toAddressInfo)
                    .forEach(m_streetNameLookupHelper::save);

        return streetNameViewModel;
    }
}
