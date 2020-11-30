resource "aws_security-group" "terra-web-security"{
    vpc_id = aws_vpc.terra-vpc.id
    name = "terra-web-securiy"
    tage{
        Name = "terra-web-security"
    }
}

resource "aws_security-group" "terra-was-security"{
    vpc_id = aws_vpc.terra-vpc.id
    name = "terra-was-securiy"
    tage{
        Name = "terra-was-security"
    }
}

resource "aws_security-group" "terra-db-security"{
    vpc_id = aws_vpc.terra-vpc.id
    name = "terra-db-securiy"
    tage{
        Name = "terra-db-security"
    }
}

resource "aws_security-group" "terra-lb-web-security"{
    vpc_id = aws_vpc.terra-vpc.id
    name = "terra-lb-web-securiy"
    tage{
        Name = "terra-lb-web-security"
    }
}

resource "aws_security-group" "terra-lb-was-security"{
    vpc_id = aws_vpc.terra-vpc.id
    name = "terra-lb-was-securiy"
    tage{
        Name = "terra-lb-was-security"
    }
}

# security rule
resource "aws_security_group_rule" "terra-web-securityrule"{
    type = "ingress"
    from_port = 80
    to_port = 80
    protocol = "TCP"
    cidr_blocks = ["0.0.0.0/0"]
    security_group_id = "${aws_security_group.terra-web-security.id}"
}

resource "aws_security_group_rule" "terra-was-securityrule"{
    type = "ingress"
    from_port = 80
    to_port = 80
    protocol = "TCP"
    cidr_blocks = ["0.0.0.0/0"]
    security_group_id = aws_security_group.terra-was-security.id
}

resource "aws_security_group_rule" "terra-db-securityrule"{
    type = "ingress"
    from_port = 80
    to_port = 80
    protocol = "TCP"
    cidr_blocks = ["0.0.0.0/0"]
    security_group_id = aws_security_group.terra-db-security.id
}

resource "aws_security_group_rule" "terra-lb-web-securityrule"{
    type = "ingress"
    from_port = 80
    to_port = 80
    protocol = "TCP"
    cidr_blocks = ["0.0.0.0/0"]
    security_group_id = aws_security_group.terra-lb-web-security.id
}

resource "aws_security_group_rule" "terra-lb-was-securityrule"{
    type = "ingress"
    from_port = 80
    to_port = 80
    protocol = "TCP"
    cidr_blocks = ["0.0.0.0/0"]
    security_group_id = aws_security_group.terra-lb-was-security.id
}