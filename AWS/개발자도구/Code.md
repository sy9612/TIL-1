## 개발자 도구

### AWS CodeCommit

> 팀의 코드 협업을 수월하게 하는 안전하고 확장성이 뛰어난 관리형 소스 제어 서비스

- 자체 소스 제어 시스템 운영:x:
- 인프라 조정 염려 :x:
- 안전하게 저장
- 기존 Git 도구와 원활하게 연동

#### Git

> 오픈 소스 배포 버전 제어 시스템

- Git CLI를 통해 AWS CodeCommit Repository 사용 가능

##### 적합한 사용자

- 코드 저장 및 버전 관리를 위한 안전하고 안정적이며 확장 가능한 소스 제어 시스템을 필요로 하는 소프트웨어 개발자
- 사용이 편리하고 버전 관리 기능을 제공하는 완전 관리형 데이터 스토어

##### Git 기반 소스 제어 시스템과의 차이점

- 완전관리형

  > 자체적으로 소스 제어 서버 호스팅, 유지 관리, 백업, 확장 필요:x:

- 보안

  > 파일 자동 암호화
  >
  > IAM와 통합되어 사용자 리포지토리에 권한 할당

- 고가용성

  > S3, DynamoDB와 같은 AWS 서비스에 구축

- 확장성

  > 파일을 몇 개든 저장

- 개발 수명 주기 단축

##### 버전 관리되는 S3 버킷 비교

:office: S3

- 개별 파일 이전 버전 복구 지원
- 다양한 파일 간 일괄 처리된 변경 사항 추적/협업 소프트웨어 개발에 필요한 기능 :x:

:couple_with_heart_man_man: CodeCommit

- 다양한 파일 간의 변경 사항 배치 관리
- 병렬 분기 생성 기능 제공
- 버전 비교 포함

#### AWS CodeCommit 사용

##### 시작

- Management Console 로그인 :point_right: 리포지토리 생성 :point_right: Git으로 리포지토리 사용

##### 리포지토리 생성

- Management Console, CLI, SDK, CodeCommit API 사용

##### 리포지토리 업데이트

- 콘솔에서 직접 파일 편집
- Git으로 리포지토리 작업 수행
- Git과 동일

##### 기존 리포지토리를 AWS CodeCommit으로 가져오기

- Subversion 및 Perforce 같은 기타 리포지토리

  > Git 가져오기 도구 이용

##### 지원되는 Git

- clone, pull, push, fetch
- 하위 모듈 지원

##### 저장되는 단일 파일 최대 크기: 2GB

##### 리포지토리 백업

- git clone 수행
- 백업 서버에 Git 설치 후 git clone(git pull) 명령을 사용하여 정기적으로 스냅샷을 생성하는 예약 작업 실행

##### 리포지토리 복원

- 리포지토리를 다시 생성 :point_right: 전체 복제를 통한 백업 or 로컬 복사본으로 데이터 업로드

- 삭제

  > 단방향 작업 :x:
  >
  > MFA 보호, IAM 정책 사용 :o:

##### 코드 검토 관리

- 코드 검토 지원
- 코드 분기 권한 설정 기능 제공

##### CI(지속적 통합) 시스템 :heavy_plus_sign: CodeCommit

- CodeCommit :heavy_plus_sign: Jenkins

##### Webhook

- SNS 콘솔에서 HTTP 엔드포인트와 Webhook용 원하는 URL 지정하여 주제 생성
- CodeCommit 콘솔에서 해당 SNS 주제를 트리거로 사용하는 리포지토리 이벤트 구성

##### Git 작업 및 API 호출 기록

- CloudTrail 콘솔

  > Git 작업 및 API 호출, CodeCommit 이벤트 검토 가능

#### 보안

##### IAM으로 CodeCommit 액세스 관리

- 리소스 수준 권한 지원
- MFA(Multi-Factor Authentication) 지정
  - 리포지토리 삭제와 같은 안전하지 않은 작업에 대한 추가적 보호 기능 제공
- Git 클라이언트 액세스 제어

##### CodeCommit이 지원하는 통신 프로토콜

- HTTPS

  > AWS CLI :point_right: Git 자격 증명 헬퍼 설치 :point_right: 모든 HTTPS 요청 자동 서명

- SSH

  > 사용자가 자체 public-privite 키 페어 생성 :point_right: 퍼블릭 키를 IAM 사용자에게 추가, 프라이빗 키는 암호화

##### CodeCoimmit에 액세스하기 위해 개방해야할 포트

- 22(SSH)
- 443(HTTPS)
- 아웃바운드 액세스 개방

##### 리포지토리 암호화

- 리포지토리는 상주 중에 자동으로 암호화 (고객 작업:x:)

- CodeCommit은 Key Management Service(KMS)를 사용하여 리포지토리를 암호화
  - 첫 리포지토리 생성 시 AWS 계정에 CodeCommit 키 생성

##### 리포지토리 교차 계정 액세스 활성화

- AWS 계정에서 IAM 역할 생성 :point_right:리포지토리에 대한 액세스 위임
- IAM 사용자는 CLI를 구성하여 AWS Security Token Service(STS)를 사용하여 명령 실행 시 역할 담당

#### 결제

##### 사용료

- 사용자당 1 USD

##### 활성 사용자

- 해당 달에 Git 요청 or AWS Management Console을 사용해 AWS CodeCommit 리포지토리에 액세스한 고유 AWS 자격 증명
- 고유 AWS 자격 증명 사용



### AWS CodeBuild

> 클라우드에서 제공되는 완전관리형의 지속적 통합 서비스

- 소스 코드 커파일
- 테스트 실행
- 배포 준비가 완료된 소프트웨어 패키지 생성
- 자체 빌드 서버를 프로비저닝, 관리, 확장 :x: :point_right: 자동으로 확장 및 축소, 여러 빌드 동시에 처리

##### 이유

- 완전 관리형 환경
  - 빌드 서버 소프트웨어 직접 설정 :x:
  - 패치 및 유지 관리 :x:
- 빌드 작업을 CodeBuild에 제출
  - 모든 빌드에서 새로 생성된 후에 완료 시 삭제되는 임시 컴퓨팅 컨테이너에서 작업 실행
- 빌드 서버 하드웨어/소프트웨어 관리 :x:
- 빌드 볼륨에 맞게 자동으로 확장 :o:
- 사용자가 제출한 각각의 빌드를 처리하고 별개의 빌드를 동시에 실행
  - 빌드가 대기열에서 대기 :x:

##### 릴리스 프로세스 자동 실행

- CodePipeline과 통합
  - 빌드 작업 추가
  - 클라우드에서 실행되는 Ci/CD 프로세스 설정

#### 사용

##### :globe_with_meridians: 빌드 프로젝트

> CodeBuild에서 빌드를 실행하는 방법 정의에 사용
>
> 소스 코드를 가져올 위치, 사용할 빌드 환경, 실행할 빌드 명령 및 빌드 출력을 저장할 위치와 같은 정보 포함

- 빌드 환경
  - 운영 체제, 프로그래밍 언어 실행 시간 및 CodeBuild에서 빌드 실행하는 데 사용되는 도구 조합

##### 구성

- 콘솔
- AWS CLI

> 소스 리포지토리 위치, 실행 시간 환경, 빌드 명령, 컨테이너가 담당하는 IAM 역할 및 빌드 실행에 필요한 컴퓨팅 클래스 지정
>
> buildspec.yml 파일 빌드 명령 지정

##### 레파지토리

- CodeCommit, S3, GitHub, GitHub Enterprise, Bitbucket

##### 프레임워크

- Java, Ruby, Python, Go, Node.js, Android, NET Core, PHP, Docker
- 현재 환경 사용자 지정 :point_right: Docker 이미지 생성 후 이미지를 EC2 Container Registry 또는 Docker Hub Registry에 업로드

##### Windows 빌드 런타임

- .Net Core 2.0을 위해 사전 구성된 Windows 빌드 환경 제공
- Docker 이미지 생성 :point_right: EC2 Container Registry 또는 Docker Hub Registry에 업로드 하는 환경을 직접 사용자 지정하여 .NET 프레임워크와 같은 다른 빌드 대상 지원

##### 빌드 실행

- 빌드 프로젝트에 정의된 클래스의 임시 컴퓨팅 컨테이너 생성
- 컨테이너에 지정된 런타임 환경으로 로드, 소스 코드 다운
- 프로젝트에 구성된 명령 실행, 생성된 아티팩트를 S3 버킷에 업로드 :arrow_right: 컴퓨팅 컨테이너 삭제

##### 첫 번째 빌드

- 콘솔 로그인 :point_right: 빌드 프로젝트 생성 :point_right: 빌드 실행

##### 이전 빌드 결과

- 콘솔, CloudWatch, API로 액세스

##### 이전 빌드 실패 디버깅

- 상세 로그 검사
- CodeBuild Local

##### 이베트에 대한 알림 또는 경고 수신

- Amazon SNS 알림



### CloudFormation

#### 일반

:globe_with_meridians: CloudFormation

> 개발자와 기업이 손쉽게 관련 AWS 및 타사 리소스의 모음을 쉽게 생성
>
> 순서에 따라 예측 가능한 방식으로 프로비저닝할 수 있는 방법 제공
>
> 기존 엔터프라이즈 애플리케이션, 레거시, 다양한 AWS 리소스 및 컨테이너 기반 솔루션 사용
>
> :point_right: 구축된 애플리케이션 인프라 요구 지원
>
> Elastic Beanstalk 애플리케이션 환경 지원
>
> 애플리케이션 데이터 저장하는 RDS 데이터 베이스와 함께 AWS Elastic Beanstalk에 호스팅되는 애플리케이션을 생성하고 관리

##### 가능한 작업

- 애플리케이션을 실행하는 반복적이고 예측 가능한 관련 리소스의 그룹 생성 작업을 자동화 및 간소화
- 간단하게 애플리케이션 실행에 필요한 모든 리소스 생성, 상호 연결

:globe_with_meridians: Elastic Beanstalk

> 클라우드에서 손쉽게 애플리케이션을 배포하고 실행하는 환경 제공
>
> 개발자 도구와 통합
>
> 애플리케이션 수명 주기 한 곳에서 관리

##### 새로운 개념

- 애플리케이션을 실행하기 위해 배포해야 하는 모든 AWS 리소스를 설명
  - JSON, YAML

- AWS CloudFormation에서 템플릿을 인스턴스화할 때 단일 유닛으로 생성 및 관리되는 AWS 리소스 세트인 스택

##### CloudFormation 스택의 일부인 개별 AWS 리소스 관리

- 사용자는 인프라의 모든 요소에 대한 전체 권한을 그대로 유지할 수 있음

##### 템플릿 요소

- JSON :open_hands: YAML
  - 템플릿 파라미터의 선택적 목록(스택 생성 시 입력 값 제공)
  - 출력 값의 선택적 목록(웹 애플리케이션에 대한 전체 URL)
  - 정적 구성 값을 조회하는 데 사용되는 데이터 테이블의 선택적 목록(AMI 이름)
  - AWS 리소스 및 해당 구성 값 목록
  - 템플릿 파일 형식 버전 번호

- 스택이 구축될 때, 파라미터를 사용 :point_right: 런타임 시 템플릿 요소를 사용자 지정 가능
- 출력값: Management Console 또는 명령줄 도구
  - 스택의 주요 리소스(Elastic Load Balancing, RDS 데이터베이스 주소)를 사용자에게 제공

##### 리소스 이름 선택

- 템플릿에서 AWS 리소스에 논리적 이름 할당 :point_right: 스택 생성 :point_right: 논리적 이름을 실제 AWS 리소스 이름에 바인딩
- 하나의 템플릿에서 여러 스택 생성
  - 이름 충돌 :x:

##### 모든 리소스에 이름 지정 :x:

- 리소스에 이름을 지정하면 템플릿을 재사용하기 힘듦
- 업데이트를 위해 리소스 교체 시 이름에 충돌 발생

##### 스택 생성 시 소프트웨어 설치

- 애플리케이션 부트스트랩 스크립트 세트 제공
- CloudFormation 템플릿에 EC2 인스턴스 패키지, 파일 및 서비스 설치

##### Chef/Puppet

- EC2 인스턴스에서 Chef Server 및 Chef Client 소프트웨어를 부트스트랩하는 데 사용
- Puppet Master 및 Puppet Clinet 소프트웨어 부트스트랩하는 데 사용

##### EC2 태그 지정 지원

- 태그 지정 기능을 지원하는 EC2 리소스에 AWS 템플릿에서 태그 지정 :o:

##### EC2 인스턴스 또는 Auto Scaling 시작 구성 사용자 데이터 필드 액세스

- 단순한 하뭇를 사용해 AWS 리소스의 문자열 리터럴과 속성 값 연결 :point_right: 템플릿 사용자 데이터 필드에 전달

##### 스택의 리소스 중 하나가 성공적으로 생성되지 않은 경우

- Automatic rollback on error 기능 활성화
  - 오류가 발생한 시점까지 CloudFormation이 스택에 대해 성공적으로 생성한 모든 AWS 리소스 삭제

- 스택이 완전히 생성되거나 전혀 생성되지 않는 점 이용
  - 시스템 관리, 계층형 솔루션 간소화

##### 스택이 삭제된 경우 데이터 저장

- 템플릿 리소스에 대한 삭제 정책 정의
- EBS 볼륨, RDS 데이터베이스 인스턴스가 삭제되기 전 스냅샷 지정
- 스택 삭제 시, 리소스 삭제 :x: 보존 :o:

##### 스택 생성 후 업데이트

- 예측 가능한 제어 방식으로 기존 스택의 리소스 수정 및 업데이트
- 템플릿을 사용해 스택 변경 사항 관리

##### VPC 스택 생성

- 다양한 리소스 생성 가능



### CodeDeploy

#### 일반

:globe_with_meridians: CodeDeploy

> EC2 인스턴스 및 온프레미스에서 실행 중인 인스턴스를 비롯하여 모든 인스턴스에 대한 **코드 배포 자동화 서비스**

- 새로운 기능 빠르게 공개
- 배포 동안 가동 중지 시간을 줄임
- 복잡한 앱 업데이트 작업 처리
- 오류가 발생하기 쉬운 수동 작업 필요성 :x:
- 수천 개의 인스턴스에 손쉽게 배포 :o:

