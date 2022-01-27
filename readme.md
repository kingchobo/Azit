# 프로젝트 4주차

```shell
# git commit template 지정
git config --global commit.template .\.gitmessage.txt
```

front-end 프로젝트는 front-end 폴더에 작성   
back-end 프로젝트는 back-end 폴더에 작성

# Git Flow 및 프로젝트 version

> 프로젝트 버전은 [sementic versioning](https://velog.io/@slaslaya/Semantic-Versioning-2.0.0-MAJOR-MINOR-PATCH%EC%99%80-%EB%AA%85%EC%84%B8%EC%97%90-%EA%B4%80%ED%95%98%EC%97%AC) 전략을 따르도록 함   
> git commit message는 [gitmessage](./.gitmessage.txt)에 적힌 내용을 따르도록 함.

### branch 설명
1. master : 메인 branch, merge만 가능 (push 제한)
    - 0.1.0 과 같이 sementic version 적용  
2. release : master branch에 merge하기 전, 최종 확인
    - release/0.1.0 과 같이 sementic version 적용
    - 프로젝트 배포 전 최종적인 bug나 문제점 확인 후 master에 merge
3. develop : release branch에 merge하기 전, 프로젝트 통합
4. 각자 branch에서 기능 구현 및 버그 수정, 이후 develop branch에 merge
    - 각자의 branch는 이름 이니셜로 정함
    - 기능 구현 후, develop branch로 merge한 후 버그 수정