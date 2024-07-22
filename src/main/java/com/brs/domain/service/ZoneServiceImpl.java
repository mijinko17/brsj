package com.brs.domain.service;

import org.springframework.stereotype.Component;

@Component
public class ZoneServiceImpl implements ZoneService {
    @Override
    public String getZones() {
        return "component";
    }
}
