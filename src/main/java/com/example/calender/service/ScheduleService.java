package com.example.calender.service;

import com.example.calender.dto.ScheduleRequestDto;
import com.example.calender.dto.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {
    ScheduleResponseDto saveSchedule(ScheduleRequestDto dto);
    List<ScheduleResponseDto> findMemoByMonth();
    List<ScheduleResponseDto> findMemoByName();
    List<ScheduleResponseDto> findMemoByPeriod();
    void deleteMemo(Long id);
}
