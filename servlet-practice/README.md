# 📖 Servlet Practice
> 계산기 서블릿을 만들어 보면서 Servlet, GenericServlet, HttpServlet을 이해한다.
<br>

## 🧰 Library Usage
- Junit5
  - version 5.9.0
- Jakarta 자카르타는 자바8에서 하드포크된 새로운 플랫폼
  - version 10.1.0
- Logback
  - version 1.4.4
  
<br>

## 📓 Study Summary
### 👉 Servlet
#### 1️⃣ Servlet
- 서블릿 컨테이너가 서블릿 인터페이스에 있는 메소드들을 호출함
  - 서블릿 생명주기와 관련된 메소드
    - init(), service(), destroy() ...
  - 서블릿 기타 메소드
    - getServletConfig(), getServletInfo() ...
- Servlet (Interface)
  - 모든 메서드 구현이 강제된다.
- GenericServlet (Abstract Class)
  - Service만 구현해주면 된다.
  - Generic Protocol을 사용할 수 있다.
  - Servlet Interface에서 필요한 메서드만 재정의하여 사용가능하다.
- HttpServlet (Abstract Class)
  - doGet(), doPost(), Service()를 구현한다.
  - Http Protocol만 사용가능하다.
#### 2️⃣ Annotation
- @WebServlet
  - xml기반으로 servlet mapping을 작성하였던 것을 어노테이션 기반으로 간편하게 작성 가능하다.
- @SuppressWarnings("serial")
  - private static final long serialVersionUID=1L;
  - 버전 체크를 사용하지 않을때 선언한다.