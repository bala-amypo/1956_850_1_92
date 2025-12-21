package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.CrimeReport;
import java.util.List;

public interface CrimeReportRepository extends JpaRepository<CrimeReport, Long> {
    List<CrimeReport> findByLatitudeBetweenAndLongitudeBetween(
        double minlat, double maxlat, double minlong, double maxlong
    );
}
