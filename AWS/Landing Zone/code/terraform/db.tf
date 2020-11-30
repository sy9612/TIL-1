resource "aws_db_subnet_group" "terra-db"{
name = "terra-db"
subnet_ids = ["subnet-0584c5ac5387bd3a1", "subnet-099e03f9c414e52f3"]

tags = {
Name = "terraform db"
}
}


resource "aws_db_instance" "terrards" {
  allocated_storage    = 10
  engine = "mysql"
  engine_version = "5.6.35"
  instance_class = "db.t2.micro"
  name = "terrards"
  username = "root"
  password = "rootroot"
  db_subnet_group_name = "terra-db"
}