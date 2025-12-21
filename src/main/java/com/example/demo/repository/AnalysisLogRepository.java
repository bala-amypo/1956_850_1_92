package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.AnalysisLog;
import java.util.List;

public interface AnalysisLogRepository extends JpaRepository<AnalysisLog, Long> {

    List<AnalysisLog> findByZone_Id(long zoneId);
}
