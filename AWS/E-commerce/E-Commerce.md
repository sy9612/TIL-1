---
typora-root-url: ..\image
---

# E-Commerce

![AWS Web Application Hosting](https://d2slcw3kip6qmk.cloudfront.net/marketing/blog/2019Q1/aws/aws-web-application-hosting.png)

> https://www.lucidchart.com/blog/how-to-build-aws-architecture-diagrams

![img](https://blog.ezrabowman.com/content/images/2020/06/xUnwordpress_ref_arch-Add-NAT.png.pagespeed.ic.K1iafMbUFD.webp)

> https://blog.ezrabowman.com/cost-effective-aws-architectures-for-wordpress-and-other-websites/



## AWS 웹 구축

> NDS https://tech.cloud.nongshim.co.kr/techblog/



####  Nat

![image-20201109095327044](/../../../../AppData/Roaming/Typora/typora-user-images/image-20201109095327044.png)

- NAT(Network Address Translation): 네트워크 주소 변환

  > IP 패킷의 TCP/UDP 포트 숫자와 소스 및 목적지의 IP 주소 등을 재기록하면서 라우터를 통해 네트워크 트래픽을 주고 받는 기술

  - 사설 네트워크에 속한 여러 개의 호스트가 하나의 공인 IP 주소를 사용하여 인터넷에 접속하기 위함

  - 인터넷 공인 IP 주소 절약

  - 침입자로부터 고유한 사설망 보호

    > 방화벽

- AWS NAT

  | NAT Gateway            | NAT Instance               |
  | ---------------------- | -------------------------- |
  | VPC의 NAT Gateway 이용 | EC2에서 NAT 설치, AMI 존재 |
  | 비쌈 = 월 10만원       | EC2 가격                   |



#### Bastion Host

> 하루 3분 IT https://m.blog.naver.com/PostView.nhn?blogId=pentamkt&logNo=221034903499&proxyReferer=https:%2F%2Fwww.google.com%2F

> 내부와 외부 네트워크 사이에서 일종의 게이트 역할을 수행하는 호스트



#### Route Table

> 패킷이 목적지, 목적지까지의 거리와 가는 방법을 명시하는 테이블

##### Routing

> 한 네트워크에서 다른 네트워크로 패킷을 이동시키는 과정, 네트워크 안의 호스트에게 패킷을 전달하는 과정

**:question: Nat와 Gateway를 하나의 VPC에서 연결하려고 할 때, Route Table을 따로 설정해야 하는가?**



### EC2 연결

**VPN**

> 외부 :x: 단체 통신 :o: 사설통신망

**OpenVPN**

> 오픈소스 VPN, 세계 각지의 VPN, **오픈 소스 프로토콜**

#### Private Instacne에 접근

- 외부에서 접근 :x:

  :exclamation: 터널링으로 해결

##### 터널링

> 외부와 내부의 특정 지점을 통로로 만들어 줌

- **Putty**

  > https://dgoh.tistory.com/118
  >
  > Nat를 이용한 터널링 https://cloud.hosting.kr/aws-ec2/

  Connection > SSH > Tunnels









## 삽질

### 1. cannot find a valid baseurl for repo: amzn2-core/2/x86_64

> NAT Gateway가 설정되어 있지 않아서 발생하는 문제