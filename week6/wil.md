# <백엔드 스터디 6주차 WIL>
## 유효성 검사
요청으로 들어오는 데이터가 올바른 형식인지 검사하는 것  
Spring: DTO에서 유효성을 검사  
'올바른 형식'에 주목  

### 유효성 검사 하는법
유효성 검사 어노테이션 적용: @NotNull, @Size, @Pattern 사용 -> 제약 사항 & 에러 메시지 명시  
Controller 메서드에 @Valid 추가 -> 제약 조건에 맞는지 "검사"

## 예외 처리
에러가 발생했을 때, 원인을 알려주는 에러 메시지를 담도록 직접 응답 객체 생성

### 1. Global Exception Handler (전역 예외 핸들러)
* 공통 예외 처리 핸들러
* Spring에서 제공, 예외 종류에 따라 response를 설정 가능
* Global Exception을 처리 = 스프링 애플리케이션 전역의 모든 에러 처리 방법을 결정
* 에러 정보 반환용 DTO
* AOP (관점 지향 프로그래밍)
  * 객체 지향 프로그래밍 보완 개념
  * OOP(객체 지향) = 핵심 기능을 모듈화, 비즈니스 로직을 클래스와 메서드로 구조화 (예: 회원 관리, 주문 처리, 상품 관리 등)
  * AOP(관점 지향) = 부가 가능을 모듈화, 여러 클래스에 걸쳐 반복되는 공통 기능을 분리 (예: 로깅, 트랜잭션, 보안, 예외 처리 등)

[일반화]  
@ExceptionHandler(A.class)  
A 타입 에러 발생  
-> 해당 에러 타입을 다루는 핸들러가 Controller 메서드 대신 Response Body를 생성 & 응답


### 2. 커스텀 예외 처리
* 커스텀 예외 클래스, RuntimeException을 상속
* Global Exception Handler에 등록 -> 에러 원인 명확히 알 수 있음

### 3. 에러 메시지 클래스
* 예외 메시지 문자열 중복 사용됨 -> 추가/수정하기 힘들다
* 따라서 상수로 정의 -> 서비스와 DTO에 작성한 메시지를 상수로 변경

## API 문서화
API 사용 설명서 공유  
백엔드 API 명세를 문서로 공유  
클라이언트(프론트엔드)와 소통/협업 시 API 문서를 공유

### Swagger 사용
1. spring doc 사용 -> OpenAPI 규격의 API 문서 생성 (OpenAPI: API 표준 명세)
2. Swagger UI 사용 -> API 문서에 Swagger 디자인 적용

### API 문서화 작업을 위한 어노테이션
* @Tag: API 그룹화 (컨트롤러 레벨)
* @Operation: API의 요약과 설명 (메서드 레벨)
* @ApiResponse: 단일 응답 코드 설명 (메서드 레벨)
