# https://programmers.co.kr/learn/courses/30/lessons/60059

# 완전 탐색

key = [[0, 0, 0], [1, 0, 0], [0, 1, 1]]
lock = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]


{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Principal":{
          "Service": "logs.YOUR-REGION.amazonaws.com"
      },
      "Action":
          "s3:GetBucketAcl",
      "Resource": 
        "arn:aws:s3:::BUCKET_NAME_HERE"
    },
    {
      "Effect": "Allow",
      "Principal":{
          "Service": "logs.YOUR-REGION.amazonaws.com"
      },
      "Action":
          "s3:PutObject",
      "Resource": 
        "arn:aws:s3:::BUCKET_NAME_HERE/*",
      "Condition":{
          "StringEquals":{
              "s3:x-amz-acl": "bucket-owner-full-control"
          }
      }
    }
   ]
}
