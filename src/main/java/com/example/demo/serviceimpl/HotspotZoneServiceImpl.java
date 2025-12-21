package com.example.demo.service.impl;

import com.example.demo.model.HotspotZone;
import com.example.demo.repository.HotspotZoneRepository;
import com.example.demo.service.HotspotZoneService;
import com.example.demo.util.CoordinateValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotspotZoneServiceImpl implements HotspotZoneService {

    private final HotspotZoneRepository repository;

    public HotspotZoneServiceImpl(HotspotZoneRepository repository) {
        this.repository = repository;
    }

    @Override
    public HotspotZone addZone(HotspotZone zone) {

        if (repository.findByZoneName(zone.getZoneName()).isPresent()) {
            throw new RuntimeException("zone already exists");
        }

        CoordinateValidator.validate(
                zone.getCenterLat(),
                zone.getCenterLong()
        );

        return repository.save(zone);
    }

    @Override
    public List<HotspotZone> getAllZones() {
        return repository.findAll();
    }
}
