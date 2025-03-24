package com.example.calender.controller;

import com.example.calender.dto.ScheduleRequestDto;
import com.example.calender.dto.ScheduleResponseDto;
import com.example.calender.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
public class ShceduleController {
    private final ScheduleService shceduleService;

    public ShceduleController(ScheduleService shceduleService){
        this.shceduleService = shceduleService;
    }

    //추가
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createShcedule(@RequestBody ScheduleRequestDto dto){

        return new ResponseEntity<>(shceduleService.saveSchedule(dto), HttpStatus.CREATED);
    }
    //조회
    @GetMapping
    public ScheduleResponseDto findShceduleByMonth(){
        return null;
    }

    @PutMapping("/{id}")
    public ScheduleResponseDto updateShedule(){
        return  null;
    }
    @DeleteMapping("/{id}")
    public ScheduleResponseDto deleteShcedule(@PathVariable Long id){
        return null;
    }

}
