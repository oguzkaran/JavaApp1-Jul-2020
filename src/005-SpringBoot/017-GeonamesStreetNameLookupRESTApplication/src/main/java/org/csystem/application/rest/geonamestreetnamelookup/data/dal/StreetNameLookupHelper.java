package org.csystem.application.rest.geonamestreetnamelookup.data.dal;

import org.csystem.application.rest.geonamestreetnamelookup.data.entity.AddressInfo;
import org.csystem.application.rest.geonamestreetnamelookup.data.repository.IAddressRepository;
import org.springframework.stereotype.Component;

@Component
public class StreetNameLookupHelper {
    private final IAddressRepository m_addressRepository;

    public StreetNameLookupHelper(IAddressRepository addressRepository)
    {
        m_addressRepository = addressRepository;
    }

    public AddressInfo save(AddressInfo address)
    {
        return m_addressRepository.save(address);
    }
}
