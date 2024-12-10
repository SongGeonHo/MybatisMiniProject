import com.dao.StudentDAO;
import com.dto.StudentDTO;
import com.dto.StudentDetailsDTO;
import com.service.StudentService;
import com.service.StudentServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        StudentService service = new StudentServiceImpl();
        service.setStudentDAO(new StudentDAO());
        service.setStudentDetailsDTO(new StudentDetailsDTO());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("*****************");
            System.out.println("[학생 정보 관리 메뉴]");
            System.out.println("*****************");
            System.out.println("1.전체 학생 목록");
            System.out.println("2.학생 이름 조회");
            System.out.println("3.학생 입학년도 범위 검색");
            System.out.println("4.학생 학번으로 다중 검색 (쉼표 구분자)");
            System.out.println("5.학생 휴학 일괄수정");
            System.out.println("6.학생 학과 정원 수정");
            System.out.println("7.학생 학점 조회");
            System.out.println("8.전체 학생 목록 -페이징");
            System.out.println("*****************");
            System.out.print("메뉴 입력 =>");

            String input_num = scanner.next();
            int count = 0;

            if ("1".equals(input_num)) {
                List<StudentDTO> list = service.findAll();
                for (StudentDTO studentDTO : list) {
                    System.out.println(studentDTO);
                    count++;
                }
                System.out.println("총 학생수: " + count + "명");
            } else if ("2".equals(input_num)) {
                System.out.println("이름을 입력하세요");
                String student_name = scanner.next();
                List<StudentDTO> list = service.findByName(student_name);
                for (StudentDTO studentDTO : list) {
                    System.out.println(studentDTO);
                    count++;
                }
                System.out.println("총 학생수: " + count + "명");
//                3번 문제
            } else if ("3".equals(input_num)) {
                System.out.println("입학년도 시작값을 입력하세요");
                int startYear = scanner.nextInt();
                System.out.println("입학년도 종료값을 입력하세요");
                int endYear = scanner.nextInt();

                List<StudentDTO> list = service.findEntranceYear(startYear, endYear);
                for (StudentDTO studentDTO : list) {
                    System.out.println(studentDTO);
                    count++;
                }
                System.out.println("총 학생수: " + count + "명");

            } else if ("4".equals(input_num)) {
                System.out.print("검색할 학생의 학번을 입력하시오 => ");
                String studentNum = scanner.next();

                List<String> studentNums = Arrays.stream(studentNum.split(","))
                        .map(String::trim)
                        .filter(s -> !s.isEmpty())
                        .toList();

                if (studentNums.isEmpty()) {
                    System.out.println("학번 리스트가 비어 있습니다. 다시 입력해주세요.");
                    continue;
                }

                List<StudentDTO> list = service.findStudentNum(studentNums);
                for (StudentDTO studentDTO : list) {
                    System.out.println(studentDTO);
                    count++;
                }
                System.out.println("총 학생수: " + count + "명");

            } else if ("5".equals(input_num)) {
                System.out.print("수정할 학생의 학번을 입력하시오 =>");
                String studentNum = scanner.next();

                List<String> studentNums = Arrays.stream(studentNum.split(","))
                        .map(String::trim)
                        .filter(s -> !s.isEmpty())
                        .toList();

                if (studentNums.isEmpty()) {
                    System.out.println("학번 리스트가 비었습니다. 다시 입력해주세요");
                    continue;
                }

                int rowsUpdate = service.updateStudentAbsence(studentNums);
                System.out.println("휴학 처리된 학생수: " + rowsUpdate + "명");

            } else if ("6".equals(input_num)) {
                System.out.println("학과 정원 수정");
                int rowUpdate = service.updateDepartmentCapacity();
                System.out.println("학과 정원 수정 완료. 수정된 학과 수: " + rowUpdate + "개");

            } else if ("7".equals(input_num)) {
                System.out.print("학생의 학번을 입력하시오:");
                String studentNum = scanner.next();

                if (studentNum == null || studentNum.trim().isEmpty()) {
                    System.out.println("유효하지 않은 입력입니다. 학번을 다시 입력하세요");
                    continue;
                }

                List<StudentDetailsDTO> list = service.findStudentGrade(studentNum);
                if (list.isEmpty()) {
                    System.out.println("해당 학번의 학생 정보를 찾을 수 없습니다.");
                } else {
                    for (StudentDetailsDTO detail : list) {
                        String gradeCategory;
                        double grade = detail.getPoint();

                        if (grade >= 4.0) {
                            gradeCategory = "A 학점";
                        } else if (grade >= 3.5) {
                            gradeCategory = "B 학점";
                        } else if (grade >= 3.0) {
                            gradeCategory = "C 학점";
                        } else if (grade >= 2.0) {
                            gradeCategory = "D 학점";
                        } else {
                            gradeCategory = "F 학점";
                        }

                        System.out.println(detail);
                        System.out.println("학점 카테고리: " + gradeCategory);
                    }
                }
            } else if ("8".equals(input_num)) {
                int curPage = 1;
                System.out.print("페이지당 보여줄 레코드 개수를 입력하세요 =>");
                int perPage = scanner.nextInt();

                while (true) {
                    List<StudentDTO> paginatedList = service.findWithPaging(curPage, perPage);

                    if (paginatedList.isEmpty()) {
                        System.out.println("더 이상 페이지가 없습니다");
                        break;
                    }

                    System.out.println("현재 페이지: " + curPage);
                    for (StudentDTO page : paginatedList) {
                        System.out.println(page);
                    }

                    System.out.println("N: 다음 페이지, B: 이전 페이지, Q: 종료");
                    String navigation = scanner.next();

                    if ("N".equalsIgnoreCase(navigation)) {
                        curPage++;
                    } else if ("B".equalsIgnoreCase(navigation) && curPage > 1) {
                        curPage--;
                    } else if ("Q".equalsIgnoreCase(navigation)) {
                        break;
                    } else {
                        System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                    }


                }
            }
        }
    }
}

