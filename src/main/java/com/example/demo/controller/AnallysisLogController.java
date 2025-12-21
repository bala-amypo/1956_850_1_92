package com.example.demo.controller;

import com.example.demo.model.AnalysisLog;
import com.example.demo.service.AnalysisLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class AnalysisLogController {

    private final AnalysisLogService service;

    public AnalysisLogController(AnalysisLogService service) {
        this.service = service;
    }

    @PostMapping("/{zoneId}")
    public AnalysisLog addLog(@PathVariable long zoneId,
                              @RequestParam String message) {
        return service.addLog(zoneId, message);
    }

    @GetMapping("/zone/{zoneId}")
    public List<AnalysisLog> getLogs(@PathVariable long zoneId) {
        return service.getLogsByZone(zoneId);
    }
}
