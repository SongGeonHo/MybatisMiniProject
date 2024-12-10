package com.service;

import com.config.MySqlSessionFactory;
import com.dao.StudentDAO;
import com.dto.StudentDTO;
import com.dto.StudentDetailsDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {
    private StudentDAO dao; //의존성 주입 - 데이터 접근을 위한
    private StudentDetailsDTO dao2;


    @Override
    public void setStudentDAO(StudentDAO dao) {
        this.dao = dao;
    }

    @Override
    public void setStudentDetailsDTO(StudentDetailsDTO dao2) {
        this.dao2 = dao2;
    }

    @Override
    public List<StudentDTO> findAll() {
        List<StudentDTO> list = null;
        SqlSession session = MySqlSessionFactory.getSession();
        try {
            list = dao.findAll(session);
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public List<StudentDTO> findByName(String student_name) {
        List<StudentDTO> list = null;
        SqlSession session = MySqlSessionFactory.getSession();
        try {
            list = dao.findByName(session,student_name);
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public List<StudentDTO> findEntranceYear(int startYear, int endYear) {
        List<StudentDTO> list = null;
        SqlSession session = MySqlSessionFactory.getSession();

        Map<String, Integer> yearRange = new HashMap<>();
        yearRange.put("startYear", startYear);
        yearRange.put("endYear", endYear);

        try {
            list = dao.findEntranceYear(session,startYear,endYear);
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public List<StudentDTO> findStudentNum(List<String> studentNum) {
        List<StudentDTO> list = null;
        SqlSession session = MySqlSessionFactory.getSession();
        try {
            list = dao.findStudentNum(session,studentNum);
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public int updateStudentAbsence(List<String> studentNum) {
        int rowsAffected = 0; //업데이트 된 행 수 저장
        SqlSession session = MySqlSessionFactory.getSession();

        try {
            rowsAffected = dao.updateStudentAbsence(session,studentNum);
            session.commit();
        }catch (Exception e) {
            session.rollback();
            throw new RuntimeException("학생 휴학 일괄수정 실패", e);
        }finally {
            session.close();
        }
        return rowsAffected;
    }

    @Override
    public int updateDepartmentCapacity() {
        int rowsAffected = 0; //업데이트 된 행 수 저장
        SqlSession session = MySqlSessionFactory.getSession();

        try {
            rowsAffected = dao.updateDepartmentCapacity(session);
            session.commit();
        }catch (Exception e) {
            session.rollback();
            throw new RuntimeException("학생 휴학 일괄수정 실패", e);
        }finally {
            session.close();
        }
        return rowsAffected;
    }

    @Override
    public List<StudentDetailsDTO> findStudentGrade(String studentNum) {
        List<StudentDetailsDTO> list = null;
        SqlSession session = MySqlSessionFactory.getSession();
        try {
            list = dao.findStudentGrade(session,studentNum);
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public List<StudentDTO> findWithPaging(int curPage, int perPage) {
        List<StudentDTO> list = null;
        SqlSession session = MySqlSessionFactory.getSession();
        try {
            int skip = (curPage - 1) * perPage;
            list = dao.findWithPaging(session, skip, perPage);
        } finally {
            session.close();
        }
        return list;
    }


}

