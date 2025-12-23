package com.example.demo.controller;

import com.example.demo.model.HotspotZone;
import com.example.demo.service.HotspotZoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotspots")
public class HotspotZoneController {

    private final HotspotZoneService hotspotZoneService;

    public HotspotZoneController(HotspotZoneService hotspotZoneService) {
        this.hotspotZoneService = hotspotZoneService;
    }

    @PostMapping
    public HotspotZone create(@RequestBody HotspotZone zone) {
        return hotspotZoneService.save(zone);
    }

    @GetMapping
    public List<HotspotZone> getAll() {
        return hotspotZoneService.getAll();
    }
}
