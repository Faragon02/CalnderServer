package com.example.calender.controller;

import com.example.calender.dto.ShceduleRequestDto;
import com.example.calender.dto.ShceduleResponseDto;
import com.example.calender.entity.Shcedule;
import com.example.calender.service.ShceduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shcedules")
public class ShceduleController {
    private final ShceduleService shceduleService;

    public ShceduleController(ShceduleService shceduleService){
        this.shceduleService = shceduleService;
    }

    //추가
    @PostMapping
    public ResponseEntity<ShceduleResponseDto> createShcedule(@RequestBody ShceduleRequestDto dto){

        return new ResponseEntity<>(shceduleService.saveShcedule(dto), HttpStatus.CREATED);
    }
    //조회
//    @GetMapping
//    public ShceduleResponseDto findShceduleByMonth(){
//        return null;
//    }
//    @GetMapping
//    public ShceduleResponseDto findShceduleByName(){
//        return null;
//    }
//    @GetMapping
//    public ShceduleResponseDto findShceduleByPeriod(){
//        return null;
//    }
//
//    @PutMapping("/{id}")
//    public ShceduleResponseDto updateShedule(){
//        return  null;
//    }
//    @DeleteMapping("/{id}")
//    public ShceduleResponseDto deleteShcedule(@PathVariable Long id){
//        return null;
//    }

}
