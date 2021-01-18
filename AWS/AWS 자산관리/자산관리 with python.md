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

- AWS Access Key ID
- AWS Secret Access Key
- Default region name: 지역을 설정해준다.
  - ap-northeast-2 == 서울
- Default output format: 기본 format을 지정해준다.