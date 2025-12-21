package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.HotspotZone;
import java.util.Optional;
import java.util.List;

public interface HotspotZoneRepository extends JpaRepository<HotspotZone, Long> {

    Optional<HotspotZone> findByZoneName(String zoneName);

    List<HotspotZone> findBySeverityLevel(String level);
}
