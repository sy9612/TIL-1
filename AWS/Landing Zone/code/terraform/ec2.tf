
resource "aws_instance" "terra-web1"{
ami = "ami-06f3207f56dc1ca18"
instance_type = "t2.micro"
subnet_id = aws_subnet.terra-sub-private1.id
tags = {
Name = "terra-web1"
}
}

resource "aws_instance" "terra-web2"{
ami = "ami-06f3207f56dc1ca18"
instance_type = "t2.micro"
subnet_id = aws_subnet.terra-sub-private2.id
tags = {
Name = "terra-web1"
}
}

resource "aws_instance" "terra-was1"{
ami = "ami-06f3207f56dc1ca18"
instance_type = "t2.micro"
subnet_id = aws_subnet.terra-sub-private1.id
tags = {
Name = "terra-was1"
}
}


resource "aws_instance" "terra-was2"{
ami = "ami-06f3207f56dc1ca18"
instance_type = "t2.micro"
subnet_id = aws_subnet.terra-sub-private2.id
tags = {
Name = "terra-was2"
}
}


# ALB

resource "aws_lb" "terra-alb-web"{
name    = "terra-alb-web"
internal = false
load_balancer_type = "application"
subnets = [
aws_subnet.terra-sub-private1.id,
aws_subnet.terra-sub-private2.id
]

tags = {
Name = "terra-alb-web"
}
}

resource "aws_lb_target_group" "terra-alb-web"{
name = "terra-alb-target-web"
port    = 8080
protocol = "HTTP"
vpc_id = aws_vpc.terra-vpc.id

health_check {
interval = 30
path = "/ping"
healthy_threshold = 3
unhealthy_threshold = 3
}

tags = {
Name = "alb web target group"
}
}

resource "aws_alb_target_group_attachment" "terra-alb-web1"{
target_group_arn = aws_lb_target_group.terra-alb-web.arn
target_id = aws_instance.terra-web1.id
port = 8080
}

resource "aws_alb_target_group_attachment" "terra-alb-web2"{
target_group_arn = aws_lb_target_group.terra-alb-web.arn
target_id = aws_instance.terra-web2.id
port = 8080
}

# Listener

resource "aws_alb_listener" "terra-alb-web"{
load_balancer_arn = aws_lb.terra-alb-web.arn
port = "80"
protocol = "HTTP"

default_action{
type = "redirect"

redirect{
port = "443"
protocol = "HTTPS"
status_code = "HTTP_301"
}
}
}


# NLB

resource "aws_lb" "terra-nlb-was" {
name = "terra-nlb-was"
internal = false
load_balancer_type = "application"
subnets = [
aws_subnet.terra-sub-private1.id,
aws_subnet.terra-sub-private2.id
]

tags = {
Name = "terra-alb-was"
}

}


resource "aws_lb_target_group" "terra-nlb-was"{
name = "terra-nlb-target-was"
port = 8080
protocol = "HTTP"
vpc_id = aws_vpc.terra-vpc.id

tags = {
Name = "nlb was target group"
}
}


resource "aws_lb_target_group_attachment" "terra-nlb-was1"{
target_group_arn = aws_lb_target_group.terra-nlb-was.arn
target_id = aws_instance.terra-was1.id
port = 8080
}

resource "aws_lb_target_group_attachment" "terra-nlb-was2"{
target_group_arn = aws_lb_target_group.terra-nlb-was.arn
target_id = aws_instance.terra-was2.id
port = 8080
}

resource "aws_lb_listener" "terra-alb-web"{
load_balancer_arn = aws_lb.terra-nlb-was.arn
port = "80"
protocol = "HTTP"

default_action{
type = "redirect"
redirect{
port = "443"
protocol = "HTTPS"
status_code =  "HTTP_301"
}
}
}
