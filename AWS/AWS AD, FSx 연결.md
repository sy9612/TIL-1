

순서는 AD 생성 -> FSx 생성 -> EC2 생성 및 연결이다.

AD 생성에 약 20분, FSx 생성에 약 20분이 걸린다.





## AWS Directory Service



\> 다른 AWS 서비스에서 Microsoft Active Directory(AD)를 사용할 수 있는 관리형 서비스

FSx를 이용하기 위해서는 먼저 AD가 존재해야 한다.





### 생성방법

\- 단계별로 캡쳐를 해놓았기 때문에 사진에 따라서 진행하면 AD는 쉽게 생성할 수 있다.



![img](https://blog.kakaocdn.net/dn/cr3me2/btqZDO07DpK/Wfxb4hPq6DWMKioZ22A4Pk/img.png)



![img](https://blog.kakaocdn.net/dn/cx45hy/btqZGlK1NOP/M9lAYtOPYbtLGPfkBujKk1/img.png)

\- DNS 이름이 중요한데, 실제로 존재하지 않는 도메인이라도 상관 없다. 대충 형식정도만 지켜주면 된다.

\- 관리자 암호는 까먹다 하더라도 Console에서 쉽게 변경이 가능하다.



![img](https://blog.kakaocdn.net/dn/bCzafP/btqZtAivenR/yXKoKVDt5jdixoMfzkaKs0/img.png)

\- 미리 AD를 생성 할 VPC & Subnet 생성

\- 이후 해당 VPC에 FSx, EC2를 모두 생성할 예정



![img](https://blog.kakaocdn.net/dn/RLUd1/btqZBey5ayr/3hPx5TPNUewPtJK4aQyTok/img.png)

\- 생성이 완료되면 세부 정보를 해당과 같이 확인할 수 있다.

\- 이후 암호 까먹으면 사용자 암호 재설정을 통해서 변경 가능



###### NetBIOS

- DNS 이름 대신 사용
- 내부에서만 사용 가능





## FSx



[honeywater97.tistory.com/25](https://honeywater97.tistory.com/25)

[
AWS File System - EFS, FSx참고 블로그 https://aws-diary.tistory.com/88 AWS Storage Intro - EFS / FSx (File Storage) EFS 먼저 알아보도록 하겠습니다. 공식다큐가 한번 정리되고나서 너무 깔끔하게 설명을 잘해주고 있으니 같이 참고..honeywater97.tistory.com](https://honeywater97.tistory.com/25)

\- 완전 관리형 파일 스토리지 서비스

\- Windows에서 AD를 관리를 돕는 서비스





### 생성방법

![img](https://blog.kakaocdn.net/dn/XQ7vB/btqZvOBgag5/a4eK8bTB6yLJGR8IelFzgK/img.png)





![img](https://blog.kakaocdn.net/dn/8yRF9/btqZvMDanti/SQtReAegurrtPXvZquoJdK/img.png)

\- 테스트를 위해서 단일 AZ로 구성 (다중 AZ의 경우 요금 🔺)

\- VPC는 AD와 같은 위치에 설정

\- 기존에 생성했던 AD 선택

\- 백업은 잠시 꺼둔다.



![img](https://blog.kakaocdn.net/dn/cVK6X3/btqZJ6TQLP7/GJ1MTHFtk2Bsc5iqL6jHw0/img.png)최종 생성 전 확인



![img](https://blog.kakaocdn.net/dn/bbMc7l/btqZGm33brw/kL8bXJ0uNkHlwbWBkrRDAk/img.png)



\- 이후 EC2에서 DNS 이름으로 접근한다.

\- DSN 이름은 랜덤 생성





## EC2 Windows



EC2 생성 방법은 쉬우니까 중요한 부분만 캡쳐했다.

이후 EC2에서 AD, FSx 등록까지 이어진다.







### 생성방법



![img](https://blog.kakaocdn.net/dn/cZIacw/btqZvNvkNpm/Yn9IzkpaFeVoStF3kWQIw1/img.png)

\- EC2 생성 시 Windows 선택



![img](https://blog.kakaocdn.net/dn/rw90P/btqZyvVyfUL/YFdpX9o40g1yMfnY6WMsr0/img.png)

\- EC2 VPC도 AD, FSx와 같은 VPC에 위치

\- 퍼블릭 IP를 자동으로 할당 -> VPC에 Internet Gateway와 Route Table 설정 필수



![img](https://blog.kakaocdn.net/dn/GQVV4/btqZIyXunVg/EB3zqgdIRtz05YI4MwwkFK/img.png)

\- 원격 데스크톱에 Public IP:3389를 입력하여서 접속

\- 3389는 Windows의 Port Number다.







### EC2 Windows에 AD 연결



![img](https://blog.kakaocdn.net/dn/U3Zdr/btqZKBl2be6/wRiDkKzk6zkpKZIHuYWFok/img.png)

\- 사용할 FSx를 Console에서 누르게 되면 [연결] 버튼이 오른쪽 상단에 존재한다.

\- [docs.aws.amazon.com/ko_kr/directoryservice/latest/admin-guide/join_windows_instance.html](https://docs.aws.amazon.com/ko_kr/directoryservice/latest/admin-guide/join_windows_instance.html)

[
Windows 인스턴스를 수동으로 조인 - AWS Directory Service인스턴스의 명령 프롬프트에서 다음을 실행하여 [Network Connections\] 대화 상자를 직접 열 수 있습니다. %SystemRoot%\system32\control.exe ncpa.cpldocs.aws.amazon.com](https://docs.aws.amazon.com/ko_kr/directoryservice/latest/admin-guide/join_windows_instance.html)

\- 이미 EC2와 AD를 모두 만들어 둔 상태이므로 수동으로 조인한다.

\- 모두 생성되어 있을 때, 추가적으로 연결하기위해 사용



**CMD in EC2 Windows**



![img](https://blog.kakaocdn.net/dn/c0HfOD/btqZtzxrPBj/P7Mkev9gn6uVHKlWkE0kT0/img.png)

\- 위 사진은 안되는 경우이다.

\- EC2를 생성한 후 바로 CMD에서 FSx를 연결하기 위해 사전 작업을 하지 않고 연결을 진행하면 network path를 찾을 수 없다고 나온다.

\- EC2에 AD를 먼저 등록해야한다.



**EC2에 AD 등록**

![img](https://blog.kakaocdn.net/dn/zWRXc/btqZDONQQgS/viOzn7QqU4uw3y8U5Gvqw1/img.png)Netwrok Connections

![img](https://blog.kakaocdn.net/dn/dBlvJM/btqZJ5gucTQ/tof8wnKzA0L5VRD2AokQfk/img.png)

```
%SystemRoot%\system32\control.exe ncpa.cpl
```

\- cmd에 해당 명령어를 치면 [Network Connections] 대화 상자가 나온다.

\- 네트워크에 [마우스 우클릭] -> [Properties]



![img](https://blog.kakaocdn.net/dn/blOJ8C/btqZDQdMuKQ/fHTbxtI9rr9LMtujkF2imK/img.png)Properties

\- [Internet Protocol Version 4(TCP/IPv4)] 더블클릭



![img](https://blog.kakaocdn.net/dn/41jxM/btqZDOf2rBE/jBK1QtrRfywlQYsjJTDSkK/img.png)

\- [Use the following DNS server addresses]를 클릭하여 DNS를 설정한다.

\- 두 개의 설정한 DNS는 AD에서 네트워크 정보를 확인할 수 있다.

![img](https://blog.kakaocdn.net/dn/brMSSc/btqZGlK7ROy/hTiz5tHwlqsQpQvGTfAKtK/img.png)AD의 네트워크 정보

\- OK를 눌러 설정 종료



![img](https://blog.kakaocdn.net/dn/tFUgj/btqZJ5ANHlE/Akm1OkxidREJGn8YQvBet0/img.png)

```
%SystemRoot%\system32\control.exe sysdm.cpl
```

\- cmd에 해당 명령어를 쳐서 [System Properties] 창을 연다.

![img](https://blog.kakaocdn.net/dn/kZAAs/btqZDO8aTBb/J7GwV8nK6zzSe0s41moFKK/img.png)System Properties

\- [Change] 클릭



![img](https://blog.kakaocdn.net/dn/cRK9J9/btqZvM4nBhJ/nn1Dy8Z64t3lnCel3QfFF1/img.png)[System Properties] - [Change]

\- Member of에서 Domain 선택

\- AD의 Domain을 넣어주면 된다. (주의! FSx의 Domain이 아님)



![img](https://blog.kakaocdn.net/dn/dEC40J/btqZBdAobiV/2s3VL2KRzGFkHETutJ6N51/img.png)

\- [OK]를 누르면 Name/Password를 입력하는 창이 나오는 데, 위에 AD를 만들 때 지정했던 Password를 입력하면 된다. (계정 이름은 admin)



![img](https://blog.kakaocdn.net/dn/dn2jme/btqZyv2ngMA/45A7GWjsjgi0O9ZqzwGa4K/img.png)완료

\- 변경 사항 완료 후 Restart를 하게 되면 적용된다.





### EC2에 FSx 연결

\- FSx에 있는 문서대로 하면 System error 86 has occurred를 만날 수 있다.

\- 왜 뜨는 지 이유는 모른다.



[superuser.com/questions/1150911/system-error-86-has-occurred](https://superuser.com/questions/1150911/system-error-86-has-occurred)

[
System error 86 has occurredI have a windows7 machine where I connect the network drives with the following command: > net use t: \\pathname\foldername /user:Username password However, although this was working for years...superuser.com](https://superuser.com/questions/1150911/system-error-86-has-occurred)

위 링크대로 문제를 해결하니까 연결이 완료되었다.



![img](https://blog.kakaocdn.net/dn/l8EQj/btqZFuVFMeQ/Y7ZoNFTf7QuiPFakAiORk1/img.png)

\- 파일 탐색기의 주소창에 연결 할 FSx의 DNS 이름을 넣어준다.



![img](https://blog.kakaocdn.net/dn/brrtri/btqZEBgszSq/ExeunuSEFxkQZlRLYOJ5zk/img.png)

\- AD 접속과 마찬가지로 로그인을 진행



![img](https://blog.kakaocdn.net/dn/bUOPeA/btqZFtJefKY/DQYyoTy9BV93GaEMpyv4e0/img.png)

\- 공유가 가능한 AD 폴더가 나타난다.



![img](https://blog.kakaocdn.net/dn/bqGoX1/btqZBdAp5up/gakksHPtlHiaw7F6Co8wT1/img.png)

\- [마우스 우클릭] -> [Map network drive] 선택

![img](https://blog.kakaocdn.net/dn/VlAKu/btqZKAm3ONw/hSbBgrw1AaTKzFblPQk8XK/img.png)

\- 연결할 수 있는 창이 나타난다. Mapping할 Drive를 선택해주고 Finish를 누르면 완료



![img](https://blog.kakaocdn.net/dn/zyYy1/btqZywtwasP/PkVSVUwcIBjDxPsDUGb2qK/img.png)끝!!!!!!!!!





끝





WIndows에서 도메인 정보

Hosts 파일에 도메인 매칭

DNS 정보만