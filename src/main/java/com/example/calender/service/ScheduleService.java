package com.example.calender.service;

import com.example.calender.dto.ScheduleRequestDto;
import com.example.calender.dto.ScheduleResponseDto;
import com.example.calender.entity.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {
    ScheduleResponseDto saveSchedule(ScheduleRequestDto dto);
    List<ScheduleResponseDto> findAllSchedule(String day, String name);
    ScheduleResponseDto findscheduleById(Long id);
    ScheduleResponseDto updateSchedule(Long id, String name, String todo);
    ScheduleResponseDto updateName(Long id, String name);
    void deleteMemo(Long id, String userPw);
}
