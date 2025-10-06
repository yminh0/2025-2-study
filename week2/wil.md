# <백엔드 스터디 2주차 WIL>
## 스프링 계층형 아키텍쳐
<img width="1470" height="538" alt="Image" src="https://github.com/user-attachments/assets/dc7de648-dce5-4b4b-bcad-a7bd611c7fe6" />

스프링 계층형 아키텍처(Layered Architecture): 레스토랑

Browser: 손님

Controller: 웨이터 / 고기 굽는법 모름 (비즈니스 로직 X)

Service: 주방장 / 재료가 없음

DAO: 창고 관리인

DB: 냉장/냉동 창고

DTO: 주문서, 영수증 / 데이터 전송 객체, 필요한 정보만 전달

Entity: 원재료 / 모든 정보 포함, 외부 직접 노출 금지

## Controller

HTTP 요청/응답

특정 endpoint로 요청을 가장 먼저 처리

DTO를 사용하여 서비스 계층과 데이터 주고받음

## 패키지 구조: 계층형 vs 도메인형

### 계층형 구조: 애플리케이션을 기능별로 나눈다.
<img width="632" height="560" alt="Image" src="https://github.com/user-attachments/assets/55f5141f-656e-4d98-aa13-4a56be233b96" />

### 도메인형 구조: 도메인 관련 모든 클래스를 포함
<img width="609" height="663" alt="Image" src="https://github.com/user-attachments/assets/bf7bda60-d925-4f2e-90e2-3d0929c2f82c" />

특정 도메인의 코드를 한 곳에-> 코드 탐색 쉽다.

도메인 단위 개발,유지보수하기 용이

New 도메인 추가 시 다른 곳에 영향 없음

## ResponseEntity의 메서드
<img width="775" height="589" alt="Image" src="https://github.com/user-attachments/assets/1cdb7f50-5024-4ccc-9172-a7e2fbbc14a4" />

## 빈&스프링 컨테이너

### Spring Container

스프링 빈 저장소 

어플리케이션 컨텍스트

### 스프링 빈(Spring Bean)

어플리케이션 전역에서 사용할 공용 객체

스프링 컨테이너(공용 창고)에 빈을 저장, 필요한 빈을 컨테이너에서 받아 사용한다.

## 빈 등록 방법: 컴포넌트 스캔 (자동 등록)

@Component, @ComponentScan

1. 컴포넌트 스캔 (@ComponentScan)

“어떤 클래스들이 Spring Bean인지 찾아서 등록”

2. 컴포넌트(@Component)

“이 클래스가 SpringBean이야!” 라고 표시

-> 빈으로 등록하고 싶은 클래스에 @Component 붙이면 된다.

## 의존성 주입(Dependency Injection, DI)

내가 의존하는 객체를 직접 생성하지 않고 밖에서 주입 받는 것

매번 필요한 객체를 생성하는 대신, 생성해둔 객체를 사용하므로 메모리를 효율적으로 사용

## 의존성 주입 방법
### 생성자 주입 방법

1. 안전하게 final로 선언 / final: 변수에 한 번만 값을 할당할 수 있게 하여 변경을 막음.

2. 생성자에 @Autowired을 사용하면, 생성자를 통해 빈을 주입한다.

3. 만약 생성자가 하나만 있다면, @Autowired를 생략할 수 있다.

#### 간단 ver

1. 필요한 의존성을 final 키워드를 사용해 추가.

2. @RequiredArgsConstructor를 사용해 생성자를 추가한다.







