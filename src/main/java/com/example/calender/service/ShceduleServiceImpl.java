package com.example.calender.service;

import com.example.calender.dto.ShceduleRequestDto;
import com.example.calender.dto.ShceduleResponseDto;
import com.example.calender.entity.Shcedule;
import com.example.calender.repository.ShceduleReopository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShceduleServiceImpl implements ShceduleService {

     private final ShceduleReopository shceduleReopository;

    public  ShceduleServiceImpl(ShceduleReopository shceduleReopositorycedule) {
        this.shceduleReopository = shceduleReopositorycedule;

    }
    @Override
    public ShceduleResponseDto saveShcedule(ShceduleRequestDto dto) {

        Shcedule shcedule = new Shcedule(dto.getUser_pw(), dto.getName(), dto.getTodo());
        Shcedule saveShcedule  = shceduleReopository.saveShcedule(shcedule);

        return new ShceduleResponseDto(saveShcedule);
    }

    @Override
    public List<ShceduleResponseDto> findMemoByMonth() {
        return List.of();
    }

    @Override
    public List<ShceduleResponseDto> findMemoByName() {
        return List.of();
    }

    @Override
    public List<ShceduleResponseDto> findMemoByPeriod() {
        return List.of();
    }

    @Override
    public void deleteMemo(Long id) {

    }
}
