### Mybatis 회원관리 프로젝트 
![스크린샷 2025-02-20 094312](https://github.com/user-attachments/assets/fb7a88d0-99fc-41de-af33-626bb7833317)




**개요**

서버에서 DB에 접근할 때 커넥션 연결, SQL문을 전달하고 서버로부터 결과를 받는 과정을 거친다. 과거에 이 과정에서 문제가 발생한다. 각각의 데이터베이스마다 커넥션을 연결하는 방법, SQL을 전달하는 방법 응답받는 방법이 달랐다. 그래서 등장한 것이 JDBC이다. 
JDBC 표준 인터페이스는 각각의 DB를 연결할 때 차이를 극복하는 역할을 한다. MySQL 드라이버, Oracle을 사용하면 Oracle 드라이브를 사용하면 된다. 
 하지만 RDBMS에 데이터를 저장하기 위해 영속화 하는 과정에 개발자가 해야하는 일이 너무 많은 단점이 명확했다. 이에 등장한게 영속성 프레임워크이다.  영속성 프레임워크에는 SQL Mapper와 ORM 방법이 있는데 가장 보편적으로 사용하는 SQL Mapper의 Mybatis를 배우고 ORM의 JPA로 넘어도록 하겠다. 


- **기간**: 총 5일  (2024.12.02 ~ 2024.12.06)
- **팀 구성**: 1인 미니 프로젝트 
- **기술 스택**: Java, Mybatis, MySQL  

**구현 기능**

- DAO,DTO 패턴을 사용하여 구현 

- SQL Mapping을 활용하여 유연한 SQL 관리  

- CRUD 사용하여 회원 관리 기능 구현 




**기술 학습 및 사후 관리 역량**

 - ORM 바탕으로하는 JPA에 대해서 배워보자 
    
    
    

**참고 링크**
- **Inflearn**: [마이바티스 공식홈페이지](https://mybatis.org/mybatis-3/)
- **MySQL**: [MySQL](https://www.mysql.com/)
