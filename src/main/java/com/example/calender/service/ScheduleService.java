package com.example.calender.service;

import com.example.calender.dto.ScheduleRequestDto;
import com.example.calender.dto.ScheduleResponseDto;
import com.example.calender.entity.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {
    ScheduleResponseDto saveSchedule(ScheduleRequestDto dto);
    List<ScheduleResponseDto> findAllSchedule();
    Optional<Schedule> findscheduleById(Long id);
    ScheduleResponseDto updateSchedule(Long id, String name, String todo);
    ScheduleResponseDto updateName(Long id, String name);
    void deleteMemo(Long id);
}
