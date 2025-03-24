package com.example.calender.service;

import com.example.calender.dto.ScheduleRequestDto;
import com.example.calender.dto.ScheduleResponseDto;
import com.example.calender.entity.Schedule;
import com.example.calender.repository.ScheduleReopository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleReopository scheduleReopository;

    public ScheduleServiceImpl(ScheduleReopository scheduleReopository) {

        this.scheduleReopository = scheduleReopository;

    }

    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto dto) {

        Schedule schedule = new Schedule(dto.getUser_pw(), dto.getName(), dto.getTodo());

        return scheduleReopository.saveSchedule(schedule);
    }

    @Override
    public List<ScheduleResponseDto> findMemoByMonth() {
        return List.of();
    }

    @Override
    public List<ScheduleResponseDto> findMemoByName() {
        return List.of();
    }

    @Override
    public List<ScheduleResponseDto> findMemoByPeriod() {
        return List.of();
    }

    @Override
    public void deleteMemo(Long id) {

    }
}
