# 📖 OOP Practice
> Connection, PreparedStatement, ResultSet을 이용하여 JDBC를 구현해보고 JDBC, DBCP, DataSource 등에 대해 학습한다.

  <br>

## 🧰 Library Usage
- HikariCP : 가벼운 용량과 빠른 속도를 가지는 JDBC의 커넥션 풀 프레임워크이다.
  > SpringBoot는 커넥션 풀 관리를 위해 HikariCP를 사용한다.
    - version 5.9.0
    - [상세자료](https://code-lab1.tistory.com/209)
- H2 : H2DB는 자바 기반의 오픈소스 관계형 데이터 베이스이다.
  > 어플리케이션 개발 단계의 테스트 DB로서 많이 이용된다.
    - version 1.6.2

  <br>

## 📓 Study Summary
### 👉 JDBC, Connection Pool
#### 1️⃣ JDBC(Java Database Connectivity)
- 자바 애플리케이션에서 DB 프로그래밍을 할 수 있도록 도와주는 표준 인터페이스이다.
- JDBC 인터페이스들을 구현한 구현체들은 각 데이터베이스 벤더사들이 제공한다.

#### 2️⃣ DBCP (Database Connection Pool)
- 미리 일정량의 DB 커넥션을 생성해서 풀에 저장해 두고 있다가 HTTP 요청에 따라 필요할 때 풀에서 커넥션을 가져다 사용하는 기법이다.
- 스프링 부트 2.0 부터는 디폴트 커넥션 풀로 HikariCP 사용한다.

#### 3️⃣ 커넥션 풀 사용 시 유의 사항
- 커넥션의 사용 주체는 WAS 스레드이므로 커넥션 개수는 WAS 스레드 수와 함께 고려해야 한다.
- 커넥션 수를 크게 설정하면 메모리 소모가 큰 대신 동시 접속자 수가 많아지더라도 사용자 대기 시간이 상대적으로 줄어들게 되고, 
- 반대로 커넥션 개수를 작게 설정하면 메모리 소모는 적은 대신 그만큼 대기시간이 길어질 수 있음. 따라서 적정량의 커넥션 객체를 생성해 두어야 함

#### 4️⃣ DataSource
- 커넥션 획득하기 위한 표준 인터페이스

