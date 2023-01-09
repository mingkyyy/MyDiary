package com.mingkyy.MyDiary.repository;

import com.mingkyy.MyDiary.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
