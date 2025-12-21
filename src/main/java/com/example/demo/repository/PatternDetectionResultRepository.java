package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.PatternDetectionResult;
import java.util.List;

public interface PatternDetectionResultRepository
        extends JpaRepository<PatternDetectionResult, Long> {

    List<PatternDetectionResult> findByZone_Id(long zoneId);
}
