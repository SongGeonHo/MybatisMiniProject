package com.service;

import com.dao.StudentDAO;
import com.dto.StudentDTO;
import com.dto.StudentDetailsDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface StudentService {
   void setStudentDAO(StudentDAO dao);//종속성 주입을 위한 set
   void setStudentDetailsDTO(StudentDetailsDTO dao2);//종속성 주입을 위한 set
   List<StudentDTO> findAll();
   List<StudentDTO> findByName(String student_name);
   List<StudentDTO> findEntranceYear(int startYear, int endYear);
   List<StudentDTO> findStudentNum(List<String> studentNum);
   int updateStudentAbsence(List<String> studentNum);
   int updateDepartmentCapacity();
   List<StudentDetailsDTO> findStudentGrade(String studentNum);
   List<StudentDTO> findWithPaging( int skip, int perPage);
}
