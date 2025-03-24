package com.example.calender.repository;

import com.example.calender.dto.ShceduleResponseDto;
import com.example.calender.entity.Shcedule;

import java.util.List;

public interface ShceduleReopository {
    Shcedule saveShcedule(Shcedule shcedule);
    List<ShceduleResponseDto> findMemoByMonth();
    List<ShceduleResponseDto> findMemoByName();
    List<ShceduleResponseDto> findMemoByPeriod();
    void deleteMemo(Long id);
}
