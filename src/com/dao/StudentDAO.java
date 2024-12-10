package com.dao;

import com.dto.StudentDTO;
import com.dto.StudentDetailsDTO;
import com.mysql.cj.Session;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StudentDAO {

    public List<StudentDTO> findAll(SqlSession session){
        return session.selectList("com.config.StudentMapper.findAll");
    }

    public List<StudentDTO> findByName(SqlSession session, String student_name){
        return session.selectList("com.config.StudentMapper.findByName",student_name);
    }

    public List<StudentDTO> findEntranceYear(SqlSession session,int startYear, int endYear){
        Map<String,Integer> params = new HashMap<>();
        params.put("startYear", startYear);
        params.put("endYear", endYear);

        return session.selectList("com.config.StudentMapper.findEntranceYear",params);
    }

    public List<StudentDTO> findStudentNum(SqlSession session,List<String> studentNum){
        return session.selectList("com.config.StudentMapper.findStudentNum",studentNum);
    }

    public int updateStudentAbsence(SqlSession session,List<String> studentNum){
        return session.update("com.config.StudentMapper.updateStudentAbsence",studentNum);
    }

    public int updateDepartmentCapacity(SqlSession session){
        return session.update("com.config.DepartmentMapper.updateDepartmentCapacity");
    }

    public List<StudentDetailsDTO> findStudentGrade(SqlSession session,String studentNum){
        return session.selectList("com.config.StudentMapper.findStudentGrade",studentNum);
    }

    public List<StudentDTO> findWithPaging(SqlSession session, int skip, int perPage){
        Map<String, Object> pararms = new HashMap<>();
        pararms.put("skip", skip);
        pararms.put("perPage", perPage);

        return session.selectList("com.config.StudentMapper.findWithPaging",pararms);
    }
}
