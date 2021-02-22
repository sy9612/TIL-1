# CloudEndure

- 마이그레이션을 간소화하고 신속하게 처리
- 비용 절감

> 기존 레거시 시스템을 AWS로 무료로 이전
>
> Left & Shift



###### 방법

1. Agent 설치

   > Replication Settings 설정 내용대로 CloudEndure Manager Console을 통해 Replication Server 자동 생성

2. 복제

3. 복제본 테스트

   1. Cut Over

      > 운영중이던 Service Application을 내리고 다른 시스템으로 이관하는 일련의 행위 
      >
      > +) Backout: 시스템 적용 중에 문제 등이 발생하여 더이상 적용 진행이 불가능한 경우 원래의 시스템으로 되돌리는 것

   - Replication 서버: 복제 서버

     > 원본 서버가 켜있을 경우 복제가 지속적으로 이루어짐

   - Converter 서버 : 테스트 또는 Cutover시 Replication 서버에서 Donverter 서버로 데이터 이관이 이루어지고 최종적으로 BluePrint 세팅값에 따라 Target 서버가 생성됨 Converter 서버는 생성되었다가 종료됨

   - Target 서버: BluePrint 셋팅값에 따라 생성된 Target 서버




---



###### TEST Mode

- Migration 솔루션 테스트 -> 소스 시스템이 대상 환경에서 제대로 작동하는 지 확인 :o:
- CloudEndure 사용자 콘솔 -> 소스 머신이 테스트 되었는지 여부와 테스트 성공 여부를 알려 줌



###### Cut Over

