package com.example.calender.controller;

import com.example.calender.dto.ScheduleRequestDto;
import com.example.calender.dto.ScheduleResponseDto;
import com.example.calender.entity.Schedule;
import com.example.calender.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ShceduleController {
    private final ScheduleService scheduleService;

    public ShceduleController(ScheduleService scheduleService){
        this.scheduleService = scheduleService;
    }

    //추가
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto dto){

        return new ResponseEntity<>(scheduleService.saveSchedule(dto), HttpStatus.CREATED);
    }
    //조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAllSchedule(@RequestParam(required = false) String day, @RequestParam(required = false) String name ){

        return new ResponseEntity<List<ScheduleResponseDto>>(scheduleService.findAllSchedule(day, name), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findscheduleById(@PathVariable Long id){
        return new ResponseEntity<> (scheduleService.findscheduleById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<ScheduleResponseDto> updateShedule(
            @PathVariable Long id,
    @RequestBody ScheduleRequestDto dto){
        return  new ResponseEntity<>(scheduleService.updateSchedule(id, dto.getName(), dto.getTodo()), HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public  ResponseEntity<ScheduleResponseDto> updateName(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto dto){

        return  new ResponseEntity<>(scheduleService.updateName(id, dto.getName()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShcedule(@PathVariable Long id,
                                               @RequestBody ScheduleRequestDto dto){
        scheduleService.deleteMemo(id, dto.getUserPw());
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
