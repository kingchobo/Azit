# **📸AZit - 감정분석 단체 영상일기 서비스**

### 프로젝트 구조
----

front-end 프로젝트는 [front-end](./front-end) 디렉토리에 작성  
back-end 프로젝트는 [back-end](./back-end) 디렉토리에 작성  
build 산출물은 [build](./build) 디렉토리에 정리  
기타 산출물/사용법은 [exec](./exec) 디렉토리에 정리

### Git Flow 및 프로젝트 version
---
> 프로젝트 버전은 [sementic versioning](https://velog.io/@slaslaya/Semantic-Versioning-2.0.0-MAJOR-MINOR-PATCH%EC%99%80-%EB%AA%85%EC%84%B8%EC%97%90-%EA%B4%80%ED%95%98%EC%97%AC) 전략을 따르도록 함  
> git commit message는 [gitmessage](./.gitmessage.txt)에 적힌 내용을 따르도록 함.

### **목차**

1. 프로젝트 개요
2. 기술스택 및 핵심 기술
3. 형상관리
4. 시연영상
5. 실행방법

## **🍤1. 프로젝트 개요**

- **서비스명** : Azit
- **서비스 주제** : 감정분석 단체 영상일기
- 하루 동안 있었던 일을 다양한 사람들과 함께 공유할 수 있는 공간을 만들어드립니다.
- **개발인원 : 장성태, 조용구, 오은진, 김유정, 김민현, 길기호**
    - Back-end : 조용구, 오은진
    - front-end: 김민현, 김유정, 길기호
    - WebRTC : 장성태
- **개발 기간 2021.01.10 ~ 2022.02.18 ( 6주 )**
    
    2022.01.10 ~ 2022.01.14  ㅡ 아이디어 기획 및 프로젝트 설계
    
    2022.01.17 ~ 2022.01.21  ㅡ 프로젝트 설계 및 와이어프레임,명세서 작성, DB설계
    
    2022.01.24 ~ 2022.01.28  ㅡ 명세서 작성, DB설계, jira구체화 및 역할 분배
    
    2022.02.03 ~ 2022.02.04  ㅡ faceAPI 및 webRTC, 메인,상세페이지
    
    2022.02.07 ~ 2022.02.11  ㅡ 서버배포 및 테스트, 기능구현, front- back 연동
    
    2022.01.14 ~ 2022.02.18  ㅡ frontend 디자인 마무리 및 UCC 제작
    
- [**프로젝트명세서**](https://www.notion.so/b78208a8c4cd4c1494ba718c802fec3f)
- **[와이어프레임](https://www.figma.com/file/EhvAmvRj5Yuso4a4OcAKnk/%EC%95%84%EC%A7%80%ED%8A%B8-%EA%B5%AC%EC%A1%B0-%EC%84%A4%EA%B3%84?node-id=0%3A1)**
- **[ERD 설계](https://www.erdcloud.com/d/XCzc4FJJhKMQe68i2)**

## **🍤2. 기술스택 및 핵심 기술**

### **기술스택**

Front-end :

![https://img.shields.io/badge/HTML5-339933?style=for-the-badge&logo=HTML5&logoColor=white](https://img.shields.io/badge/HTML5-339933?style=for-the-badge&logo=HTML5&logoColor=white)

![https://img.shields.io/badge/vue.js-4FC08D?style=for-the-badge&logo=vue.js&logoColor=white](https://img.shields.io/badge/vue.js-4FC08D?style=for-the-badge&logo=vue.js&logoColor=white)

![https://img.shields.io/badge/javascript-FFFF33?style=for-the-badge&logo=javascript&logoColor=white](https://img.shields.io/badge/javascript-FFFF33?style=for-the-badge&logo=javascript&logoColor=white)

![https://img.shields.io/badge/css-3333ff?style=for-the-badge&logo=CSS3&logoColor=white](https://img.shields.io/badge/css-3333ff?style=for-the-badge&logo=CSS3&logoColor=white)

Back-end :

![https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white)

![https://img.shields.io/badge/mysql-9999FF?style=for-the-badge&logo=mysql&logoColor=white](https://img.shields.io/badge/mysql-9999FF?style=for-the-badge&logo=mysql&logoColor=white)

![https://img.shields.io/badge/JPA-6DB33F?style=for-the-badge&logo=JPA&logoColor=white](https://img.shields.io/badge/JPA-6DB33F?style=for-the-badge&logo=JPA&logoColor=white)

![https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white](https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white)

Tool :

![https://img.shields.io/badge/aws-232F3E?style=for-the-badge&logo=aws&logoColor=white](https://img.shields.io/badge/aws-232F3E?style=for-the-badge&logo=aws&logoColor=white)

![https://img.shields.io/badge/nginx-000066?style=for-the-badge&logo=nginx&logoColor=white](https://img.shields.io/badge/nginx-000066?style=for-the-badge&logo=nginx&logoColor=white)

![https://img.shields.io/badge/github-FF0066?style=for-the-badge&logo=github&logoColor=white](https://img.shields.io/badge/github-FF0066?style=for-the-badge&logo=github&logoColor=white)

![https://img.shields.io/badge/Docker-6699FF?style=for-the-badge&logo=Docker&logoColor=white](https://img.shields.io/badge/Docker-6699FF?style=for-the-badge&logo=Docker&logoColor=white)

![https://img.shields.io/badge/jira-3333FF?style=for-the-badge&logo=jira&logoColor=white](https://img.shields.io/badge/jira-3333FF?style=for-the-badge&logo=jira&logoColor=white)

##

### **핵심 기술**

webRTC를 사용한 화면 공유 일기 저장

FaceApi를 이용한 사용자 별 감정분석

음성인식Api를 이용한 영상일기 기록

## **🍤3. 형상관리**

### **git**

### **notion**

### **jira**

## **🍤4.시연 영상**

1. 메인 화면
    
    ![메인 화면](./README.assets/Azit_메인 화면.gif)
    

2. 회원가입 및 로그인 모달
    
    
    ![회원가입 및 로그인 모달](./README.assets/Azit_회원가입 및 로그인 모달.gif)
    

3. 일기장 목록 및 내용,감정
    
    ![일기장 목록 및 내용, 감정](./README.assets/Azit_일기장 목록 및 내용, 감정.gif)
    

4. 방검색 및 새로운 일기쓰기
    
    ![방검색 및 새로운 일기 작성](./README.assets/Azit_방검색 및 새로운 일기 작성.gif)
    

5.  방 참여

![그룹일기 참여](./README.assets/Azit_그룹일기 참여.gif)

1. 일기작성 참여(4인 참여 녹화시작 버튼 활성화) 및 채팅가능
    
    ![그룹일기 녹화 및 채팅 화면](./README.assets/Azit_그룹일기 녹화 및 채팅 화면.gif)
    

2. 자신의 차례에 toss버튼 활성화(다음 사람 녹음) 
    
    ![toss 버튼을 이용한 다음 사람 녹음](./README.assets/Azit_toss 버튼을 이용한 다음 사람 녹음.gif)
    

3. 마지막 사람 녹화종료 버튼 활성화
    
    ![마지막 사람이 녹화 종료](./README.assets/Azit_마지막 사람이 녹화 종료.gif)
    

4. 저장된 일기 확인창

![저장된 일기 확인](./README.assets/Azit_저장된 일기 확인.gif)

1.  내용 수정 가능

![저장된 일기 내용 수정](./README.assets/Azit_저장된 일기 내용 수정.gif)

## **🍤5. 실행 방법**

## 소감 및 배운점

- 장성태 :

- 김민현 :
    
    
- 김유정 :
    
    
- 길기호 :

- 조용구 :

- 오은진 :