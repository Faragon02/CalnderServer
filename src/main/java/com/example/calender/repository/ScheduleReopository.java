package com.example.calender.repository;

import com.example.calender.dto.ScheduleResponseDto;
import com.example.calender.entity.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleReopository {
    ScheduleResponseDto saveSchedule(Schedule schedule);
    List<ScheduleResponseDto> findAllSchedule();
    Optional<Schedule> findscheduleById(Long id);
    void deleteMemo(Long id);
}
