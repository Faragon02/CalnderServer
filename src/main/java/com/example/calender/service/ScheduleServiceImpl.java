package com.example.calender.service;

import com.example.calender.dto.ScheduleRequestDto;
import com.example.calender.dto.ScheduleResponseDto;
import com.example.calender.entity.Schedule;
import com.example.calender.repository.ScheduleReopository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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

        Schedule schedule = new Schedule(dto.getUserPw(),dto.getName(), dto.getTodo());

        return scheduleReopository.saveSchedule(schedule);
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedule(String day, String name) {
        return scheduleReopository.findAllSchedule(day, name);
    }

    @Override
    public ScheduleResponseDto findscheduleById(Long id) {
        Optional<Schedule> schedule =scheduleReopository.findscheduleById(id);
        if(schedule.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }
        return new ScheduleResponseDto(schedule.get());
    }

    @Transactional
    @Override
    public ScheduleResponseDto updateSchedule(Long id, String name, String todo) {
        int updateRow = scheduleReopository.updateSchedule( id, name, todo);
        if(updateRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }
        Optional<Schedule> optionalSchedule = scheduleReopository.findscheduleById(id);

        return new ScheduleResponseDto(optionalSchedule.get());
    }

    @Override
    public ScheduleResponseDto updateName(Long id, String name) {
        int updateRow = scheduleReopository.updateName( id, name);
        if(updateRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }
        Optional<Schedule> optionalSchedule = scheduleReopository.findscheduleById(id);
        return new ScheduleResponseDto(optionalSchedule.get());
    }


    @Override
    public void deleteMemo(Long id, String userPw) {

        int deleteRow = scheduleReopository.deleteSchedule(id, userPw);
        scheduleReopository.deleteSchedule(id, userPw);
        if(deleteRow == 0){

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }
    }
}
