package com.example.businessdelegate.delegate;

import java.util.Optional;

public class BusinessDelegate{

    private BusinessLookup lookupService;
    private BusinessService businessService;
    private ServiceType serviceType;

    public void setLookupService(BusinessLookup businessLookup) {
        this.lookupService = businessLookup;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Object add(Object o) {
        businessService = lookupService.getBusinessService(serviceType);
        return businessService.add(o);
    }

    public Optional<Object> findById(long id) throws Exception {
        businessService = lookupService.getBusinessService(serviceType);
        return businessService.findById(id);
    }

    public Iterable<Object> findAll() throws Exception {
        businessService = lookupService.getBusinessService(serviceType);
        return businessService.findAll();
    }

    public void deleteById(Object o) throws Exception {
        businessService = lookupService.getBusinessService(serviceType);
        businessService.deleteById(o);
    }
}
