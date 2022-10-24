# 📖 WAS Practice
> WAS를 직접 구현해보며 HTTP Protocol의 이해와 Web Application Server를 이해한다.

- 사용자 요청을 메인 Thread가 처리하도록 한다.
- 사용자 요청이 들어올 때마다 Thread를 새로 생성하여 요청을 처리 하도록 한다.
- Thread Pool을 적용해 안정적인 서비스가 가능하도록 한다
<br>

## 📓 Study Summary
### 👉 HTTP 프로토콜 이해
서버와 클라이언트가 웹에서 데이터를 주고받기 위한 통신 규약
- HTTP/1.1 , HTTP/2는 TCP 기반 위에서 동작
- HTTP/3는 UDP 기반 위에서 동작

### 👉 HTTP 요청/응답 메시지 구조
#### 1️⃣ HttpRequest
- RequestLine
- Header
- BlankLine
- Body

#### 2️⃣ HttpResponse
- StatusLine
- Header
- BlankLine
- Body
