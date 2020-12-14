# ElastiCache

###### Redis

- RDS 부하 줄이기
- Latency 줄이기
- Rate limiting

### ElastiCache

- RDS 부하 감소
- Latency 감소
- Rate limiting
- 높은 가용성
- 모니터링

- 사용볍

	> EC2 --> ElastiCache --> RDS
	>
	> EC2에서 cache안에 데이터가 있는지 check, 없으면 RDS에서 check

### Scalability

- 스케일 향상

  1. Read Replica를 더 많이 사용하기

     > write 불가능

  2. Redis Cluster Mode 사용

     > Python 환경 불가능

  3. Hash table을 이용해 캐쉬하고 싶은 데이터의 고유 번호를 지정, 해쉬 값을 매핑하여 Redis Node에 정보 저장

     > Super Node: 특정 노드에 부하가 몰림
     >
     > > App의 Memory를 locally cache하여 해결
     >
     > 가용성: Reader Node가 죽었을 대 복구 시간이 느림