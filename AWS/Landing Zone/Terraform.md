

# Terraform

> Infrastructure as Code 도구
>
> 안전하고 반복 가능한 방식으로 인프라를 구축, 변경 및 관리하기 위한 도구
>
> 사람이 읽을 수 있는 자동화 된 배포를 위해 HCL(HashiCorp Configuration Language) 구성 언어로 환경 관리

**장점**

1. #### 플랫폼 중립접(Platform Agnostic)

   > 프로젝트 또는 조직의 요구에 맞는 configuration 파일 작성하여 동일한 workflow로 이기종 환경 관리

2. #### 상태 관리

   > 프로젝트가 처음 초기화 될 때 상태 파일 생성
   >
   > 로컬 상태를 사용하여 계획을 작성하고 인프라 변경

3. #### 운영자 신뢰

   > workflow는 사용자가 쉽게 반복 가능한 작업을 수행하고 Terraform이 취한 조치로 인해 환경이 중단되지 않도록 계회 단계 계획



### WorkFlow

- Scope

  > 특정 프로젝트에 필요한 리소스 확인

- Author

  > Scope이 지정된 매개변수를 기바능로 HCL을 사용해 configuration 파일 작성

- Initialize

  > configuration 파일이 있는 프로젝트 디렉토리에서 **'terraform init' 명령** 실행
  >
  > 적합한 플러그인 다운로드

- Plan & Apply

  > 'terraform plan' 명령을 통해 생성 프로세스 확인
  >
  > 'terraform apply' 명령으로 configuration 파일 내용을 실제 배포 환경과 비교하여 변경된 내용에 따라 실제 리소스 생성



### 설치

> https://practice.hooniworld.io/entry/Terraform-With-Windows-%EC%84%A4%EC%B9%98

```yaml
provider "aws" {
 profile = "default"
 region = "us-east-1"
}

resource "aws_instance" "example" {
 ami = "ami-2757f631"
 instance_type = "te.micro"
}
```

1. provider 블록

   > aws를 구성하는 데 사용

   공급자: 리소스를 만들고 관리

2. resource

   > 인프라 정의



### 명령어

###### 초기화

```
terraform init
```

###### 자동 업데이트

```
terraform fmt
```

###### 모듈, 속성 이름 및 값 유형 내의 오류 확인

```
terraform valid
```

###### 변경 사항 적용

```
terraform paln
```

실행 계획 적용

###### 버전 확인

```
terraform version
```

###### 변경사항적용

```
terraform apply
```

configuration에 맞게 실제 인프라를 변경하기 위해 Terraform이 수행할 작업 설명

###### 현재 상태 검사

```
terraform show
```

###### 수동 상태 관리

```
terraform state
```

###### 인프라 삭제

```
terraform destory
```



##### 리소스 종속성

- 여러 리소스 유형 포함



###### Elastic IP 할당

```yaml
resource "aws_eip" "ip"{
	vpc = true
	instance = aws_instance.example.id
}
```

###### 비종속 리소스

```yaml
resource "aws_instance" "another" {
	ami = "ami-b374d5a5"
	instance_type = "t2.micro"
}
```

> 다른 리소스에 의존하지 않음



### Provision

> 인스턴스가 생성될 때 인스턴스를 초기화하는 방법

```yaml
provider "aws"{
	profile = "default"
	region = "us-east-1"
}

resource "aws_key_pair" "example" {
	key_name = "examplekey"
	public_key = file("~/.ssh/terraform.pub")
}

resource "aws_instance" "example"{
	ami = "ami-b374d5a5"
	instance_type = "t2.micro"
	
	provisioner "local-exec"{
		command = "echo ${aws_instance.example.public_ip} > ip_address.txt"
	}
	
	connection{
		type = "ssh"
		user = "ec2-user"
		private_key = file('~/.ssh/terraform')
		host = sel.public_ip
	}
	
	provisioner "remote-exec"{
		inline=[
			"sudo amazon-linux-extras enable nginx1.12",
            "sudo yum -y install nginx",
            "sudo systemctl start nginx"
		]
	}
}


```

```
terraform init
terraform apply
```

- local-exec provisioner 확인



### 변수 정의

```yaml
variable "region"{
	default = "us-east-1"
}
```

- Terraform configuration에 지역 변수 정의
- default  == 선택 사항



```yaml
provider "aws"{
	region = var.region
}
```

- var: 변수에 액세스 하고 있음을 알려줌
- command line에서 변수 설정



### List

```yaml
# 묵시적 정의
variable "cidrs" { default = [] }

# 명시적 정의
variable "cidrs" { type = list }

# terraform.tfvars 파일에서 목록 지정
cdrs = [ "10.0.0.0/16", "10.1.0.0/16" ]
```



### map

```yaml
variable "amis" {
	type = "map"
	default - {
		"us-east-1" = "ami-b374d5a5"
		"us-west-2" = "ami-4b32be2b"
	}
}

resource "aws_instance" "example"{
	ami = var.amis[var.region]
	instance_type = "t2.micro"
}

amis = {
	"us-east-1" = "ami-abc123"
	"us-west-2" = "ami-def456"
}

output "ami"{
	value = aws_instance.example.ami
}
```

```
terrform apply -var region=us-west-2
```



### 출력 변수

```
output "ip"{
	value = aws_eip.ip.public_ip
}
```

```
terraform apply
terraform output ip
```



### 모듈

그룹으로 관리되는 내장된 Terraform configuration 패키지

- Organize onfiguration

  모듈을 사용하면 configruation의 관련 부분을 함께 유지하여 configuration을 보다 쉽게 탐색, 이해 및 업데이트

  논리적 구성 요소로 구성

- Encapsulate configruation

  configuration을 개별 논리 구성 요소로 캡슐화

- Re-use onfiguration

  Terraform 실무자가 작성한 configuration을 재사용하여 시간을 절약하고 비용이 많이 드는 오류를 감소

- 일관성 및 모범 사례 보장

```yaml
module "consul" {
	source = "hashicorp/consul/aws"
	num_servers = "3"
}
```

###### output

```
output "consul_server_asg_name" {
	value = "${module.consul.asg_name_servers}"
}
```

###### 삭제

```
terraform destory
```

#### Terraform 모듈

단일 디렉토리에 있는 Terraform configuration 파일 세트

```
tree minimal-module/
```

> 루트 디렉토리 내에서 terraform 명령을 실행하면 해당 디렉토리의 내용이 루트 모델로 간주



### State 원격 저장

> 원격 백엔드 기능
>
> 팀 기반 워크 플로우 지원
>
> 상태 데이터 공유 스토리지 공간 사용 -> 동일 인프라 관리
>
> Terraform Cloud 사용 권장 (백엔드)

Terraform Cloud Backend

```yaml
terraform {
	backend "remote" {
		organization = "<ORG_NAME>"
		
		worksapces{
			name = "Example-Workspace"
		}
	}
}

#토큰 붙여넣기
credentials "app.terraform.io" {
	token = "REPLACE_ME"
}
```



//13 모듈 사용 부터