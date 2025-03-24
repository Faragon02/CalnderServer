package com.example.calender.repository;

import com.example.calender.dto.ScheduleResponseDto;
import com.example.calender.entity.Schedule;

import java.util.List;

public interface ScheduleReopository {
    ScheduleResponseDto saveSchedule(Schedule schedule);
    List<ScheduleResponseDto> findMemoByMonth();
    List<ScheduleResponseDto> findMemoByName();
    List<ScheduleResponseDto> findMemoByPeriod();
    void deleteMemo(Long id);
}
