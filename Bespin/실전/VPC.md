---
typora-root-url: ..\..\AWS\image
---

## VPC

사용자가 정의한 가상의 네트워크 환경(논리적 격리)

- 자체 IP 주소 범위
- Subnet
- Routing Tables
- Security
- Gateway

#### VPC 생성

1. Region, IP 대역 설정

2. 가용영역(AZ)에 Subnet 생성

   ###### CIDR(Classless Inter-Domain Roluting)

   - 172.31.0.0/16

     = 172.31.0.0 ~ 172.31.255.255 (2^16개)

     ![image-20201207153758766](..\image\image-20201207153758766.png)

3. Routing 설정

4. Traffic 통제