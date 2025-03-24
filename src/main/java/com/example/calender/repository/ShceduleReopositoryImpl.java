package com.example.calender.repository;

import com.example.calender.dto.ShceduleRequestDto;
import com.example.calender.dto.ShceduleResponseDto;
import com.example.calender.entity.Shcedule;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ShceduleReopositoryImpl implements ShceduleReopository {

    private final Map<Long, Shcedule> shceduleList  = new HashMap<>();

    @Override
    public Shcedule saveShcedule(Shcedule shcedule) {
        Long shceduleId = shceduleList.isEmpty()? 1: Collections.max(shceduleList.keySet()) + 1;
        shcedule.setId(shceduleId);
        shceduleList.put(shceduleId, shcedule);
        return shcedule;
    }

    @Override
    public List<ShceduleResponseDto> findMemoByMonth() {
        return null;
    }

    @Override
    public List<ShceduleResponseDto> findMemoByName() {
        return null;
    }

    @Override
    public List<ShceduleResponseDto> findMemoByPeriod() {
        return null;
    }

    @Override
    public void deleteMemo(Long id) {

    }
}
