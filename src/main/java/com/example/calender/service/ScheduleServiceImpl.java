package com.example.calender.service;

import com.example.calender.dto.ScheduleRequestDto;
import com.example.calender.dto.ScheduleResponseDto;
import com.example.calender.entity.Schedule;
import com.example.calender.repository.ScheduleReopository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleReopository scheduleReopository;

    public ScheduleServiceImpl(ScheduleReopository scheduleReopository) {

        this.scheduleReopository = scheduleReopository;

    }

    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto dto) {

        Schedule schedule = new Schedule(dto.getUserPW(), dto.getName(), dto.getTodo());

        return scheduleReopository.saveSchedule(schedule);
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedule() {
        return scheduleReopository.findAllSchedule();
    }

    @Override
    public Optional<Schedule> findscheduleById(Long id) {
        return scheduleReopository.findscheduleById(id);
    }

    @Override
    public void deleteMemo(Long id) {

    }
}
