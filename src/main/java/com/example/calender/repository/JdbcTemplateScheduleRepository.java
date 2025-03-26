package com.example.calender.repository;

import com.example.calender.dto.ScheduleResponseDto;
import com.example.calender.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public class JdbcTemplateScheduleRepository implements ScheduleReopository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateScheduleRepository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public ScheduleResponseDto saveSchedule(Schedule schedule) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("schedule_data").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("user_pw", schedule.getUserPw());
        parameters.put("name", schedule.getName());
        parameters.put("todo", schedule.getTodo());
        parameters.put("created_at", LocalDateTime.now());
        parameters.put("updated_at", LocalDateTime.now());

        // 저장 후 생성된 key값을 Number 타입으로 반환하는 메서드
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));

        return new ScheduleResponseDto(key.longValue(), schedule.getUserPw(), schedule.getName(), schedule.getTodo(),schedule.getCreated_at(), schedule.getUpdated_at());
    }


    public List<ScheduleResponseDto> findAllSchedule(String day, String name) {
        if(day!= null && name == null) {
            return jdbcTemplate.query("SELECT * FROM schedule_data WHERE substring(updated_at, 1,7) like? ORDER BY updated_at DESC", scheduleRowMapper(), day);
        }else if (name != null && day==null) {
            return jdbcTemplate.query("SELECT * FROM schedule_data WHERE  name =? ORDER BY updated_at DESC", scheduleRowMapper(), name);
        }else {
            return jdbcTemplate.query("SELECT * FROM schedule_data ORDER BY updated_at DESC", scheduleRowMapper());
        }
    }
    private RowMapper<ScheduleResponseDto> scheduleRowMapper(){
        return new RowMapper<ScheduleResponseDto>() {
            @Override
            public ScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ScheduleResponseDto(
                        rs.getLong("id"),
                        rs.getString("user_pw"),
                        rs.getString("name"),
                        rs.getString("todo"),
                        rs.getString("created_at"),
                        rs.getString("updated_at")
                );
            }
        };
    }

    @Override
    public Optional<Schedule> findscheduleById(Long id){
        List<Schedule> result = jdbcTemplate.query("SELECT * FROM schedule_data WHERE id =?", scheduleRowMapperV2(), id);
        return result.stream().findAny();
    }
    private RowMapper<Schedule> scheduleRowMapperV2(){
        return new RowMapper<Schedule>() {
            @Override
            public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Schedule(
                        rs.getLong("id"),
                        rs.getString("user_pw"),
                        rs.getString("name"),
                        rs.getString("todo"),
                        rs.getString("created_at"),
                        rs.getString("updated_at")
                );
            }
        };
    }
    //전체 일정 조회
    @Override
    public int updateSchedule( Long id, String name, String todo) {
        return jdbcTemplate.update("UPDATE schedule_data SET name = ? , todo = ?  WHERE id=? ORDER BY updated_at desc", name, todo, id);
    }

    //작성자 기준 글as
    @Override
    public int updateName( Long id, String name) {
        return jdbcTemplate.update("UPDATE schedule_data SET name = ?   where id = ?" , name, id);
    }

    @Override
    public int deleteSchedule(Long id, String userPw) {
        return jdbcTemplate.update("DELETE FROM schedule_data WHERE user_pw =? and id = ?" ,userPw,  id);
    }
}
