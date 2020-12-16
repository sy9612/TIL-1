# Serverless

- 서버 관리가 내재되어 있는 환경
  - 서버 준비, 관리 불필요
  - 미 실행시 과금 X
  - 사용량 기반 자동 확장
  - 가용성 및 장애 방지
  
- ### AWS Amplify Console

  지속적 배포를 통해 풀 스택 서버리스 웹 앱 호스팅

- ### API Gateway

  모든 규모의 API 생성, 유지 관리 및 보호

  - REST API 및 WebSocket API 지원
  - SDK 생성
  - Edge optimized: 글로벌 인터넷 상의 모든 위치에 존재하는 클라이언트에게 최소 지연시간으로 응답을 제공하도록 설계
  - Regional: 같은 리전 내의 클라이언트로부터 API를 호출 시 최소 지연시간으로 응답을 제공하도록 설계

- ### Lambda

  서버 없이 코드 실행

  - Handler(): 호출시 실행될 함수
  - 이벤트 오브젝트: Lambda 함수 호출 시 전달되는 데이타
  - 컨텍스트 오브젝트:  Lambda 함수 호출 시 전달되는 데이타로 Lambda 런타임과 상호작용하는 Method 제공

  ###### :x:

  - TCP/IP 소켓 통신 해결
  - Response 후 Lambda처리
  - 실행시간 5분 이상

  ###### 실행 모델

  - 동기

    /order

  - 비동기

    reqs

  - 스트림기반

    changes

  ###### 릴리즈 프로세스

  소스(CodeCommit) > 빌드(CodeBuild) > 테스트(CodePieline) > 프로덕션(Code Deploy)

  ###### 배포 툴

  - AWS Cloudformation

    AWS 리소스 프로비저닝

    클라우드 인프라 템플릿 정의 언어 (JSON, YAML)

  - AWS Serverless Application Model (SAM)

    서버리스 최적화 CloudFormation

    - 함수, API, 테이블

    - 별칭

      > Lambda 함수 별칭과 함께 사용하면 여러 환경 단계에 대해 단일 API 구성 및 Lambda 함수 관리 :o:

  - AWS CodeDeploy + Lambda

    - 자동 배포(EC2), 롤링 배포(Blue/green) 정지와 롤백 지원, 람다 지원
    - SAM 사용
    - 람다 별칭을 사용한 트래픽 이동 지원

  - API Gateway Canary

    Canary 릴리즈 배포를 사용하여 API Gateway에서 새로운 API를 점차적으로 출시

    - API 백엔드에 새로운 기술 적용
      - 새로운 언어, 프레임워크
      - 특정 기능 구현 후 연결
    - 개별 로그 지표로 성능 비교/대조
    - VPC에서 엔드포인트 통합을 통해 온프레미스에서 AWS로 API 마이그레이션

  ###### 배포 파이프라인

  - CodePipeline

    신속하고 신뢰할 수 있는 앱 업데이트를 위한 지속적인 전달 서비스

    소프트웨어 릴리즈 프로세스 모델링 및 시각화

    코드 변경 시 빌드, 테스트, 배포

  ###### 운영

  - SAM Local

    - 테스트 및 디버깅
    - Lambda 함수 및 프록시 형태의 API로 작동

  - CodeBuild

    높은 수준의 lambda 테스트

    Docker 이미지를 사용해 빌드/테스트 환경 구성

  - CloudWatch

    사용자 정의 지표 기록

    상세한 지표 집계

- ### Cognito

  사용자 풀 및 자격 증명 풀 제공

  - 가입 및 로그인, 소셜 로그인, 이메일 혹은 전화번호, 패스워드 분실 등