# Back End 기본 설정

1. Spring Boot Initializr로 Spring Boot + Gradle 프로젝트 생성   
![Spring Boot 기본 설정 + 의존성 설정](./img/Spring_Boot_initializr.png)


2. Annotaion Processor 활성화   
![Annotation 설정](./img/annotation_processor.png)

3. Database 생성
   ```sql
   -- mysql workbench 또는 mysql shell에서
   create database test_web_db;
   ```