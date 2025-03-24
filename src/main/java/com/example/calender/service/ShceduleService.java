package com.example.calender.service;

import com.example.calender.dto.ShceduleRequestDto;
import com.example.calender.dto.ShceduleResponseDto;
import com.example.calender.entity.Shcedule;

import java.util.List;

public interface ShceduleService {
    ShceduleResponseDto saveShcedule(ShceduleRequestDto dto);
    List<ShceduleResponseDto> findMemoByMonth();
    List<ShceduleResponseDto> findMemoByName();
    List<ShceduleResponseDto> findMemoByPeriod();
    void deleteMemo(Long id);
}
