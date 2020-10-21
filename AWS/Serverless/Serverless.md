# ServerLess

:bookmark: 참고사이트

> Lambda & Gateway 시작 및 연결 https://gun0912.tistory.com/60
>
> SQL vs NoSQL https://medium.com/harrythegreat/aws-%EC%84%9C%EB%B2%84%EB%A6%AC%EC%8A%A4%EB%A5%BC-%EC%9C%84%ED%95%9C-rds-proxy%EC%84%9C%EB%B9%84%EC%8A%A4-fb5815b83cce
>
> Serverless - SQL/NoSQL https://blog.thundra.io/which-database-should-i-choose-for-my-serverless-applications
>
> dynamoDB https://www.slideshare.net/awskorea/aws-database-hands-on-lab-aws-gaming-on-aws-2018
>
> lambda - gateway - dynamodb https://medium.com/@yumenohosi/aws-lambda-api-gateway-dynamodb-node-js-%EC%82%AC%EC%9A%A9%EA%B8%B0-%EC%82%BD%EC%A7%88%EA%B8%B0-b5352e00b396
>
> 연결 실습 https://blog.naver.com/PostView.nhn?blogId=scw0531&logNo=221451926933&parentCategoryNo=&categoryNo=52&viewDate=&isShowPopularPosts=false&from=postView

## 데이터베이스

### SQL

- Scale-Up

  ![image-20201020161813366](C:\Users\jihong.kim\AppData\Roaming\Typora\typora-user-images\image-20201020161813366.png)

  - 테이블이 수평적으로 커짐

  - 기존 DB 시스템 :arrow_right: 고성능의 DB 시스템

- 고정적인 DB Schema

  - 유연 :x:

:star: Lambda에서 SQL을 사용할 때

> ColdStart

- Lambda는 필요할 때만 연결되는 함수
- SQL과 connect가 자주 끊어짐
- connect 연결 시, 새로운 커넥션을 필요하게 됨 -> Scale Up 필요

###### RDS PROXY

> RDS Connect 관리

- AWS Secret Manager 세팅

### NoSQL

- Scale-Out

  ![image-20201020161901606](C:\Users\jihong.kim\AppData\Roaming\Typora\typora-user-images\image-20201020161901606.png)

  - 여러 DB 시스템 추가
    - 무한대로 증설 가능

- 유연한 DB Schema

  > 자주 변하는 데이터 구조



## 삽질

### 1. Lambda - DynamoDB 연결

- DynamoDB 연결 시 에러 발생

  . Cannot access stream arn:aws:dynamodb:ap-northeast-2:527478947915:table/serverless_1/stream/2020-10-21T05:15:39.587. Please ensure the role can perform the GetRecords, GetShardIterator, DescribeStream, and ListStreams Actions on your stream in IAM. (Service: AWSLambda; Status Code: 400; Error Code: InvalidParameterValueException; Request ID: 22d8f50c-d443-4d6c-84e2-c74c04f455f5; Proxy: null)

  > https://stackoverflow.com/questions/46276837/aws-lambda-not-connecting-with-dynamo-db

  - IAM 설정 필요

    IAM에서 액세스 권한을 주지 않으면 기본적으로 접근할 수 없는 듯

    > IAM은 Lambda 함수 생성 후 바꿀 수 없는가?
    >
    > > IAM 창에서 정책 연결로 설정 가능

    > IAM 에서 
    >
    > ```
    > {
    >             "Effect": "Allow",
    >             "Action": [
    >                 "dynamodb:DescribeStream",
    >                 "dynamodb:GetRecords",
    >                 "dynamodb:GetShardIterator",
    >                 "dynamodb:ListStreams"
    >             ],
    >             "Resource": "arn:aws:dynamodb:ap-northeast-2:527478947915:table/*"
    > }
    > ```
    >
    > 해당 정책 설정 -> JSON으로 정책 편집 가능

### 2. Lambda - VPC 설정

- The provided execution role does not have permissions to call CreateNetworkInterface on EC2

  > https://ao.gl/the-provided-execution-role-does-not-have-permissions-to-call-createnetworkinterface-on-ec2/

  - IAM 설정

    > ```
    >  {
    >    "Effect": "Allow",
    >    "Action": [
    >    	"ec2:DescribeNetworkInterfaces",
    >     "ec2:CreateNetworkInterface",
    >     "ec2:DeleteNetworkInterface",
    >     "ec2:DescribeInstances",
    >     "ec2:AttachNetworkInterface"
    >    ],
    >    "Resource": "*"
    >  }
    > ```
