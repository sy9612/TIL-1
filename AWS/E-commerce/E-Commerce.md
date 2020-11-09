---
typora-root-url: ..\image
---

# E-Commerce

![AWS Web Application Hosting](https://d2slcw3kip6qmk.cloudfront.net/marketing/blog/2019Q1/aws/aws-web-application-hosting.png)

> https://www.lucidchart.com/blog/how-to-build-aws-architecture-diagrams

![img](https://blog.ezrabowman.com/content/images/2020/06/xUnwordpress_ref_arch-Add-NAT.png.pagespeed.ic.K1iafMbUFD.webp)

> https://blog.ezrabowman.com/cost-effective-aws-architectures-for-wordpress-and-other-websites/



### AWS 웹 구축

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

  