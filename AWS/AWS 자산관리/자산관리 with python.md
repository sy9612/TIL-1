AWS의 자산을 Python으로 관리하기

> 📌 환경
>
> - Windows 10
> - Visual Studio Code
> - AWS, AWS CLI



### 1. Python 및 Boto3 설치

#### Python 설치

> https://www.python.org/

1. 위의 python 홈페이지에서 Downloads 👉 Python 3.x.x (최신 버전)으로 다운로드 진행

	> 필요한 라이브러리가 최신 버전을 지원하지 않는 경우
	>
	> - View the full list of donwloads를 통해 낮은 버전으로 다운로드 진행

![image-20210118162653629](..\image\image-20210118162653629.png)



2. exe 파일 실행 👉 Install Now

	> ❗ Add Python 3.9 to PATH를 반드시 체크해준다. 환경변수의 PATH 설정을 자동으로 해줌

![image-20210118162825027](..\image\image-20210118162825027.png)



#### Boto3 다운로드

1. Windows 키 👉 CMD

2. CMD 창에서 ***python -m pip install Boto3*** 입력 > 설치

	```
	python -m pip install Boto3
	```

![image-20210118162301023](..\image\image-20210118162301023.png)

3. AWS CLI도 같이 설치해주자

	```
	pip install awscli
	```





🚀 설치됐는지 확인

```
pip list
```

![image-20210118171809372](..\image\image-20210118171809372.png)

설치 확인 완료



### 2. AWS CLI 설정

1. AWS Console 로그인

2. 로그인 이름(오른쪽 상단에서 지역 선택 옆에 설정한 이름 클릭) > 내 보안 자격 증명 > 새 엑세스키 만들기

   ![image-20210118173124267](..\image\image-20210118173124267.png)

   > 액세스 키는 매우 중요하다. 오픈된 공간에 올리게 되면 해킹의 위험이 있다. 그것도 모르고 github에 실수로 키와 비번을 업로드 하는 바람에 50만원이 청구되었다. 그러니 매우 조심!

   

3. AWS CLI에 해당 키 등록

   ```
   aws configure				//cmd창에 바로 치면 된다.
   ```

![image-20210118172332714](..\image\image-20210118172332714.png)

- 기본 설정

  | AWS Access Key ID | AWS Secret Acess Key | Default region name        | Default output foramt |
  | ----------------- | -------------------- | -------------------------- | --------------------- |
  | 액세스 키 ID 입력 | 액세스 키 PW 입력    | 기본 지역 설정             | 기본 포맷 설정        |
  |                   |                      | ap-northeadst-2: 서울 리전 |                       |

  

### 3. Boto3 with Python

> 공식 사이트 https://boto3.amazonaws.com/v1/documentation/api/latest/index.html

공식 사이트를 참고하면 사용법이 나와있다.

#### boto3.resource와 boto3.client 차이

> 한글 blog https://planbs.tistory.com/entry/boto3resource%EC%99%80-boto3client%EC%9D%98-%EC%B0%A8%EC%9D%B4
>
> stackoverflow https://stackoverflow.com/questions/42809096/difference-in-boto3-between-resource-client-and-session

##### Client

```python
import boto3

BUCKET_NAME = 'board-s3'									#가지고 올 bucket 이름
client = boto3.client('s3')									#s3를 가지고 옴
response = client.list_objects(Bucket=BUCKET_NAME)			#BUCKET_NAME과 이름이 같은 bucket object를 가져옴

for content in response['Contents']:						#response의 contents 불러오기
    obj_dic = client.get_object(Bucket = BUCKET_NAME, Key = content['Key'])
    print(content['Key'], obj_dict['LastModified'])
```

- AWS 서비스 API와 1:1 매핑

- low level 인터페이스

- botocore 수준의 client 공개

  > botocore: AWS CLI와 boto3의 기초가 되는 라이브러리

##### Resource

```python
import boto3

BUCKET_NAME = 'board-s3'
s3 = boto3.resource('s3')									#s3를 가지고 옴
bucket = s3.Bucket(BUCKET_NAME)								#BUCKET_NAME의 bucket 정보 가지고 옴

for obj in bucket.objects.all():							
    print(obj.key, obj.last_modified)
```

- 객체지향적 인터페이스

- 식별자와 속성 사용

- 자원 조작 위주

  > 자원에 대해 직관적인 구문

##### 결론

- Client에서 사용되는 함수 중 Resource에서는 매핑이 안되어 있는 것도 있다.
- Resource가 자원 조작하기에 더 직관적이다.



#### 내가 가진 S3 Name 불러오기

> test.py

```python
import boto3

# 자격 증명 별도 명시시 사용
	# ACCESS_KEY = "..."
	# SECRET_KEY = "..."
	# SESSION_TOKEN = "..."

s3 = boto3.resource('s3') 			#s3 resource 불러오기
for bucket in s3.buckets.all():
    print(bucket.name)
```

해당 파일이 존재하는 cmd 창에서 **test.py**를 입력하면 내가 가진 S3 버킷의 Name 결과가 출력된다.



#### VPC

- vpc 확인하기

```python
import boto3

ec2 = boto3.client('ec2')

response = ec2.describe_vpcs()
for vpc in response["Vpcs"]:
    print(vpc["VpcId"] + " " + vpc["CidrBlock"])
```

