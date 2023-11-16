# Directory Guide 

## 도메인형 디렉토리 구조

### 전체적인 구조

```
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── spring
    │   │           └── guide
    │   │               ├── ApiApp.java
    │   │               ├── SampleApi.java
    │   │               ├── domain
    │   │               │   ├── coupon
    │   │               │   │   ├── controller
    │   │               │   │   ├── service
    │   │               │   │   │   └── mapper
    │   │               │   │   ├── repository
    │   │               │   │   ├── model
    │   │               │   │   ├── dto
    │   │               │   │   └── exception
    │   │               │   ├── member
    │   │               │   │   ├── controller
    │   │               │   │   ├── service
    │   │               │   │   │   └── mapper
    │   │               │   │   ├── repository
    │   │               │   │   ├── model
    │   │               │   │   ├── dto
    │   │               │   │   └── exception
    │   │               │   └── model
    │   │               │       ├── Address.java
    │   │               │       ├── Email.java
    │   │               │       └── Name.java
    │   │               ├── global
    │   │               │   ├── common
    │   │               │   │   ├── request
    │   │               │   │   └── response
    │   │               │   ├── config
    │   │               │   │   ├── SwaggerConfig.java
    │   │               │   │   ├── properties
    │   │               │   │   ├── resttemplate
    │   │               │   │   └── security
    │   │               │   ├── error
    │   │               │   │   ├── ErrorResponse.java
    │   │               │   │   ├── GlobalExceptionHandler.java
    │   │               │   │   └── exception
    │   │               │   └── util
    │   │               └── external
    │   │                   ├── email
    │   │                   └── sms
    │   │                       ├── AmazonSmsClient.java
    │   │                       ├── SmsClient.java
    │   │                       └── dto
    │   └── resources
    │       ├── application-dev.yml
    │       ├── application-local.yml
    │       ├── application-prod.yml
    │       └── application.yml

```


* 전체적인 구조는 도메인을 담당하는 디렉터리 domain
* 전체적인 공통설정을 관리하는 global
* 외부 연계 시스템을 관리하는 external

### domain (도메인)

```
├── domain
│   ├── member
│   │   ├── controller
│   │   │   └── MemberController.java
│   │   ├── service
│   │   │   ├── MemberProfileService.java
│   │   │   ├── MemberSearchService.java
│   │   │   ├── MemberSignUpRestService.java
│   │   │   └── MemberSignUpService.java
│   │   ├── repository
│   │   │   ├── MemberFindDao.java
│   │   │   ├── MemberPredicateExecutor.java
│   │   │   ├── MemberRepository.java
│   │   │   ├── MemberSupportRepository.java
│   │   │   └── MemberSupportRepositoryImpl.java
│   │   ├── model
│   │   │   ├── Member.java
│   │   │   └── ReferralCode.java
│   │   ├── dto
│   │   │   ├── MemberExistenceType.java
│   │   │   ├── MemberProfileUpdate.java
│   │   │   ├── MemberResponse.java
│   │   │   └── SignUpRequest.java
│   │   └── exception
│   │       ├── EmailDuplicateException.java
│   │       ├── EmailNotFoundException.java
│   │       └── MemberNotFoundException.java
│   └── model
│       ├── Address.java
│       ├── Email.java
│       └── Name.java

```

* controller : 외부에서 요청을 받고 응답을 처리, URL Mapping 및 Parameter 의 유효성 체크
* dto : 주로 Request, Response 객체들로 구성
* service : 비지니스 로직을 처리
* mapper : service에서 dto <=> model 간에 데이터 매핑하기 위한 매퍼 객체로 구성
* repository : 실제로 DB에 접근하는 객체
* model : Entity Class - 실제 DB 테이블과 매칭되는 클래스
* type : Enum 이나 Constant를 정의
* exception : 해당 도메인이 발생시키는 Exception으로 구성.


### global (전역설정)

```
├── global
│   ├── common
│   │   ├── request
│   │   └── response
│   │       └── Existence.java
│   ├── config
│   │   ├── SwaggerConfig.java
│   │   ├── properties
│   │   ├── resttemplate
│   │   │   ├── RestTemplateClientHttpRequestInterceptor.java
│   │   │   ├── RestTemplateConfig.java
│   │   │   └── RestTemplateErrorHandler.java
│   │   └── security
│   ├── error
│   │   ├── ErrorResponse.java
│   │   ├── GlobalExceptionHandler.java
│   │   └── exception
│   │       ├── BusinessException.java
│   │       ├── EntityNotFoundException.java
│   │       ├── ErrorCode.java
│   │       └── InvalidValueException.java
│   └── util
```

global은 프로젝트 전방위적으로 사용되는 객체들로 구성

* common : 공통으로 사용되는 Value 객체들로 구성 페이징 처리를 위한 Request, 공통된 응답을 주는 Response 객체들이 존재
* config : 스프링 각종 설정들로 구성
* error : 예외 핸들링을 담당하는 클래스로 구성
* util : 유틸성 클래스들이 위치


### external (외부연계)

```
└── external
    ├── email
    └── sms
        ├── AmazonSmsClient.java
        ├── KtSmsClient.java
        ├── SmsClient.java
        └── dto
            └── SmsRequest.java
```
external 외부 연계 시스템관련 객체들로 구성
