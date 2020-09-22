0922

---

# Docker Compose 및 CI 기초

###### gitlab 주소

https://gitlab.com/44bits.io/docker-workshop/-/blob/master/labs/03-docker-compose.md

docker run

--detach: server를 백그라운드로 실행 될 수 있도록 하기 위해 (Demon 모드)

-e: 환경 변수 입력

--link: container 여러 개 연결

--rm: 컨테이너를 run 할 때 해당 컨테이너 종료 시 바로 삭제

-w: 도커파일 작성 시 workdir를 run 하면서 변경 가능

## Docker Compose

Dockerfile --(build)--> Image --(run)--> Container

​										|	 config  :arrow_upper_right: 

> Image run과 config를 묶어서 Compose



###### 이유

1. Docker 실행 명령어를 입력하기 복잡

   ```
   docker run -it nginx
   ```

   ```
   docker run -it -p 8080:80 nginx
   ```

   ```
   docker run -it -p 8080:80 --rm -v $(pwd):/usr/share/nginx/html/ nginx
   ```

   > 복잡함 증가

2. 컨테이너끼리 연결하기 편함

   postgres 컨테이너 + django 컨테이너 연결

   1) django -> postgres

   ```
   docker run --rm -d --name django \
     -p 8000:8000 \
     django-sample
   
   docker run --rm -d --name postgres \
     -e POSTGRES_DB=djangosample \
     -e POSTGRES_USER=sampleuser \
     -e POSTGRES_PASSWORD=samplesecret \
     postgres
   
   ```

   ![img](https://gitlab.com/44bits.io/docker-workshop/-/raw/master/labs/imgs/containers-02.png)

   > 장고를 실행 후 Postgres를 실행
   >
   > 장고가 Postgres를 찾지 못함

   2) postgres -> django

   ```
   docker run --rm -d --name postgres \
     -e POSTGRES_DB=djangosample \
     -e POSTGRES_USER=sampleuser \
     -e POSTGRES_PASSWORD=samplesecret \
     postgres
   
   docker run -d --rm \
     -p 8000:8000 \
     -e DJANGO_DB_HOST=db \ #이름지정
     --link postgres:db \
     django-sample
   
   ```

   ![img](https://gitlab.com/44bits.io/docker-workshop/-/raw/master/labs/imgs/bridge-network-01.png)

   > 실행 순서가 중요

3. 특정 컨테이너끼리만 통신할 수 있는 가상 네트워크 환경을 편리하게 관리하고 싶어서

   postgres 컴테이너는 호스트의 다른 컨테이너들이 모두 접근 가능

   ![img](https://gitlab.com/44bits.io/docker-workshop/-/raw/master/labs/imgs/bridge-network-02.png)

   ```
   docker network ls
   
   #도커 네트워크 생성
   docker network create --driver bridge web-service
   ```

   ![img](https://gitlab.com/44bits.io/docker-workshop/-/raw/master/labs/imgs/bridge-network-03.png)

   > 내부에서는 서로 가능 but 외부에서 접근하기 어려움

   ```
   # 컨테이너 실행하기
   docker run --rm -d --name postgres \
     --network web-service \
     -e POSTGRES_DB=djangosample \
     -e POSTGRES_USER=sampleuser \
     -e POSTGRES_PASSWORD=samplesecret \
     postgres
   
   docker run -d --rm --name django1 \
     --network web-service \ #네트워크 연결
     -p 8000:8000 \
     -e DJANGO_DB_HOST=db \
     --link postgres:db \ 
     django-sample
   
   docker run -d --rm --name django2 \
     -p 8001:8000 \
     -e DJANGO_DB_HOST=db \
     --link postgres:db \
     django-sample
   
   ```

   ![img](https://gitlab.com/44bits.io/docker-workshop/-/raw/master/labs/imgs/bridge-network-04.png)

#### YAML 사용

```yaml
version: '3'

volumes:
  postgres_data: {}

services:
  db:
    image: postgres
    volumes:
      - postgres_data:/var/lib/postgres/data
    environment:
      - POSTGRES_DB=djangosample
      - POSTGRES_USER=sampleuser
      - POSTGRES_PASSWORD=samplesecret

  django:
    build:
      context: .
      dockerfile: ./compose/django/Dockerfile-dev
    volumes:
      - ./:/app/
    command: ["./manage.py", "runserver", "0:8000"]
    environment:
     - DJANGO_DB_HOST=db
    depends_on:
      - db
    restart: always
    ports:
      - 8000:8000
```

> 설정 등록

```
docker-compose -d up

docker-compose down
```

> 간편하게 사용

###### EX

```yaml
version: '3' #docerk-compose 규격

services: #container == services 실행할 컨테이너 정의
  nginx: #service 이름
    image: nginx #태그 생략 시 latest, 이미지가 없으면 자동으로 pull
    ports: #연결할 포트들
    #post in port:container port
      - 60080:80 #port 연결
      
    # -v
    # 마운트 하려는 디렉터리들
    volumes: #. == $(pwd)
      - ./:/usr/share/nginx/html/
      
    #---------#
    #이미지를 자체 빌드 후 사용
    #이미지 속성 대신 사용
    build:
      context: . 
      dockerfile: ./compose/django/Dockerfile-dev #별도의 도커파일 필요
     
     #현재 위치의 Dockerfile 사용
      dockerfile: ./Dockerfile
     
    #환경 설정
    environment:
      - MYSQL_ ...
    
    #다른 컨테이너와 연결
    link:
      - mysql:db
   
    #컨테이너 의존성 추가
    depends_on:
      - mysql
      
    #볼륨 이름 추가
    volumes:
      postgres_data:{}
      
      #볼륨 이름연결
    	#volumes:
      	#	- postgres_data:/~~~~
      	
```

##### nginx

![img](https://gitlab.com/44bits.io/docker-workshop/-/raw/master/labs/imgs/ghost-03-nginx.png)

local에다가 nginx 설정

--> 가상의 컨테이너가 nginx랑 ghost를 묶고 있음

​	nginx와 ghost 순서 상관X

:star: nginx를 쓰는 이유

> nginx는 캐쉬를 가지고 있음
>
> 사용자가 늘어나도 어느정도 웹 서버가 앞에 존재하여 대응을 할 수 있음
>
> 웹서버들은 기본적인 캐쉬 기능을 가지고 있지 않음



:gear:run vs exec

- run: run 후 container가 끝나면 status -> exited (1회성)

## CI/CD

- 커밋/브랜치/Pull Request

  의미 있는 코드 조각 모음

  > 머지
  >
  > ![img](https://gitlab.com/44bits.io/docker-workshop/-/raw/master/labs/imgs/git-merge.png)

  - 협업

###### 자동 배포

![img](https://gitlab.com/44bits.io/docker-workshop/-/raw/master/labs/imgs/ci-cd-2.png)

![img](https://gitlab.com/44bits.io/docker-workshop/-/raw/master/labs/imgs/ci-cd-3.png)

- Lint: 코드 검증

- Docker image build

  > Image Build -> Image Push

- Deploy 자동 배포

### CD 자동화

> 배포(Deploy)

- 지속적 배포: 코드를 추가할 때마다 직접 배포하지 않고 자동화
