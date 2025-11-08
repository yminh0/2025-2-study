# <백엔드 스터디 4주차 WIL>
## ERD
ERD = 데이터 청사진  
Entity: 데이터를 가진 대상
 (ex. 회원, 상품, 주문 내역은 어떤 속성, 데이터를 가지고 있는지)  
Relation: 개체 사이의 연관성
 (ex. 어떤 회원이 어떤 상품을 주문했는지)  
개체-관계 중심의 모델링 기법: ER Model(Entity-Relationship Model)  

## DB 설계

엔티티: 관리해야 할 데이터의 주체 (ex. 회원, 상품, 주문)  

속성: 각 엔티티가 가지는 구체적 정보 (ex. 회원: id, name, address)  

기본 키(Primary Key): 고유하게 식별하는 데 사용되는 하나 이상의 컬럼(필드)  

외래 키(Foreign Key): 다른 테이블의 PK를 참조(저장)하는 속성(컬럼) / 테이블 간 연결고리  

관계: 개체 사이의 연관성, 업무 규칙  
* 일대다 (1:N) : 1명의 회원은 여러 개의 주문 내역을 가진다 -> member와 order의 관계는 1:N  
* 다대다 (N:M) :
1. 1명의 학생은 여러 개의 강의를 수강할 수 있다.
2. 하나의 강의는 여러 명의 학생이 수강할 수 있다.

중간 테이블(연결 엔티티) 도입해야함.

## ERD 식별관계 vs 비식별 관계
식별: 강한 연관 관계  
관계 대상의 PK를 자신의 PK로도 사용  

비식별: 느슨한 연관 관계  
관계 대상의 PK를 자신의 FK로만 사용  

보통 비식별 선택.

## JPA
### JPA & DB 의존성 추가  
H2 데이터베이스: 자바로 작성된 관계형 데이터베이스 / 가볍고, 빠르고 , 별도로 설치할 필요 없음

### 엔티티 클래스
@Entity, @Id 어노테이션 필요  
Id(고유 식별자) 값을 자동 생성: @GeneratedValue를 사용  
* strategy는 IDENTITY로 설정
* 키 값 결정을 DB에게 위임

@Column으로 컬럼 명, 컬럼 타입 등을 지정

### 외래 키(FK)
엔티티 객체를 필드로 넣은 후 @JoinColumn, @ManyToOne 사용. 
* @JoinColumn: FK 컬럼 정보를 명시(name 등)
* @ManyToOne @OneToOne @OneToMany @ManyToMany: 해당 외래키로 생기는 연관관계 종류를 나타내는 어노테이션  

@ManyToOne에 사용된 fetch type
* EAGER: 즉시 로딩, Order 객체 정보를 가져올 때 연결된 Member 객체의 모든 정보를 함께 한번에 가져온다.
* LAZY: 지연 로딩, Order 객체 정보를 가져올 때 연결된 Member 객체의 정보는 필요할 때 가져온다.

### 엔티티 생성자
보통 id 필드를 제외하고 생성.  
JPA가 엔티티를 사용하려면 인자 없는 생성자가 필요 -> @NoArgsConstructor 어노테이션으로 만들 수 있음.  
access 속성을 통해 접근 제한자를 protected로 설정 -> JPA는 사용 가능, 외부 사용 차단  
추가로 엔티티 객체에 @Getter를 추가 -> 모든 필드에 getter를 생성.









