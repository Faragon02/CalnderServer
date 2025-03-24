package com.example.calender.repository;

import com.example.calender.dto.ScheduleResponseDto;
import com.example.calender.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcTemplateShceduleRepository implements ScheduleReopository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateShceduleRepository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public ScheduleResponseDto saveSchedule(Schedule schedule) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("shcedule").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("user_pw", schedule.getUser_pw());
        parameters.put("name", schedule.getName());
        parameters.put("todo", schedule.getTodo());

        // 저장 후 생성된 key값을 Number 타입으로 반환하는 메서드
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        return new ScheduleResponseDto(key.longValue(), schedule.getUser_pw(), schedule.getName(), schedule.getTodo());
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
