# 💻 날씨 일기 프로젝트
[OpenWeatherMap API](https://openweathermap.org/)를 활용하여 일기를 작성/조회/수정/삭제하는 프로젝트

# ⚙ 개발 환경
- Project : `Gradle - Groovy`
- Language : `Java`
- Spring Boot : `2.6.4`
- Packaging : `Jar`
- Java : `17`
- Dependencies : `Lombok`, `Spring Web`
- IDEA : `IntelliJ`
- DB : `MySQL`

# ⚙ 기술 스택
- Spring Boot
- Java
- JPA
- MySql
- Docker
- logback
- swagger


# 🔎 주요 기능
- `POST / create / diary` : 외부 API에서 받아온 날씨 데이터와 글을 DB에 저장
- `GET / read / diary` : 해당 날짜의 일기를 List 형태로 반환
- `GET / read / diaries` : 해당 기간의 일기를 List 형태로 반환
- `PUT / update / diary` : 해당 날짜의 첫번째 일기를 새로 받아온 일기로 수정
- `DELETE / delete / diary` : 해당 날짜의 모든 일기 삭제

# 🔎 추가 기능
- DB와 관련된 함수 트랙잭션 처리
- 매일 새벽 1시에 날씨 데이터를 DB에 저장
- Logback을 이용한 로그 설정
- ExceptionHandler를 이용한 예외처리
- Swagger를 이용한 API documentation
