package com.example.calender.repository;

import com.example.calender.dto.ScheduleResponseDto;
import com.example.calender.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class JdbcTemplateShceduleRepository implements ScheduleReopository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateShceduleRepository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public ScheduleResponseDto saveSchedule(Schedule schedule) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("schedule_data").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("user_pw", schedule.getUserPW());
        parameters.put("name", schedule.getName());
        parameters.put("todo", schedule.getTodo());
        parameters.put("createdAt", LocalDateTime.now());
        parameters.put("updatedAt", LocalDateTime.now());
        // 저장 후 생성된 key값을 Number 타입으로 반환하는 메서드
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        return new ScheduleResponseDto(key.longValue(), schedule.getUserPW(), schedule.getName(), schedule.getTodo(), schedule.getCreatedAt(),schedule.getUpdatedAt());
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedule() {
        return jdbcTemplate.query("SELECT *  FROM schedule_data WHERE updatedAt is not NULL or name is not NULL", scheduleRowMapper());
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
                        rs.getString("createdAt"),
                        rs.getString("updatedAt")
                );
            }
        };
    }

    @Override
    public Optional<Schedule> findscheduleById(@PathVariable Long id) {
        List<Schedule> result = jdbcTemplate.query("SELECT * FROM schedule_data WHERE id = ?", scheduleRowMapperV2(), id);
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
                        rs.getString("createdAt"),
                        rs.getString("updatedAt")
                );
            }
        };
    }

    @Override
    public int updateSchedule(@PathVariable Long id, String name, String todo) {
        return jdbcTemplate.update("UPDATE schedule_data set name = ? , todo = ? ,updatedAT=? where id=?", name, todo, LocalDateTime.now(), id);
    }

    @Override
    public int updateName(Long id, String name) {
        return jdbcTemplate.update("UPDATE schedule_data set name = ? ,updatedAT=? where id = ?" , name, LocalDateTime.now(), id);
    }

    @Override
    public int deleteSchedule(Long id) {
        return jdbcTemplate.update("DELETE FROM schedule_data WHERE id = ?" , id);

    }
}
