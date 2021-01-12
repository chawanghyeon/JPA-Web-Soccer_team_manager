# WEB_JPA MINI PROJECT : Control하다


꿀단지님께 날라온 메일:memo: <br>
<p><p></p>


토트넘을 소유하고 있는 00기업이 이번에 유벤투스를 인수하게 되었습니다.<br>
클라이언트는 한 프로그램을 사용하여 두 기업을 관리하고 싶어합니다.<br>
두팀을 관리할 있는 프로그램을 만들어주세요.<br>

[PROTOTYPE LINK](https://ovenapp.io/project/Bw3y8pT5PFoud5JYHMvDrt6okzKgig7T#bavCk)

## Project 주제

<p><p></p>
팀 꿀단지는 'Control하다'를 만들었습니다. 


<b>Control하다</b>는 <br>
:soccer: 선수, 감독, 트레이너, 의료진의 정보를 확인할 수 있고,  <br>
         수정 할 수 있는<br>
         관리 프로그램입니다. :computer:  <br>

<p><p>

## Project 주제 선정 과정

Web과 데이터베이스의 연결을 학습하고 간단한 CSS와 Javascript 응용을 위해 간단한 관리 프로그램을 만들었습니다.

## 기술 스택

- HTML
- CSS
- Javascript
- Lombok
- Java
- Oracle
- Slf4j
- SQL
- servlet
- JSP

## STRUCTURE

![image](https://user-images.githubusercontent.com/53591258/103433644-6e756900-4c38-11eb-8c58-37fe0e4d236c.png)

### CASE1.관리자 행동 시나리오		
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;:key: 로그인 <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;:ballot_box_with_check: 카테고리 고르기 <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;:couplekiss: 선수 정보 확인 <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;:pencil: 선수 등록   <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;:x: 선수 삭제 <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;:memo: 선수 명단 확인하기 <br>
<br>

### CASE2.관리자 행동 시나리오		
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;:key: 로그인 <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;:ballot_box_with_check: 카테고리 고르기 <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;:couplekiss: 감독 정보 확인 <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;:pencil: Giovanni Cerra 코치의 정보 수정   <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;:pencil: 모든 감독 정보 확인하기  <br>
<br>

## Service

#### 선수관리 및 선수 페이지  <br>
:clock8: 선수의 정보를 등록, 확인하고 업데이트 및 삭제를 할 수 있습니다.<br>

<p><p></p>

#### 감독 관리 및 감독 페이지 <br>
:clock8: 감독의 정보를 등록, 확인하고 이력을 확인할 수 있습니다.  <br>

<p><p></p>

#### 트레이너 관리 및 트레이너 페이지 <br>
:clock8: 트레이너의 정보를 등록, 확인하고 이력을 확인할 수 있습니다. <br>
<p><p></p>

#### 의료진 관리 및 의료진 페이지 <br>
:clock8: 트레이너의 정보를 등록, 확인하고 이력을 확인할 수 있습니다. <br>
<p><p></p>

## 시나리오

>#### CASE 1. 토트넘선수관리팀에 입사한 왕현씨 <br>
>연말은 FA가 많다.<br>
>이번년도에는 권희성선수가 팀을 나가게 되었고, 김민수선수가 입단하게 되었다.<br>
>선수관리 프로그램에서 권희성선수를 삭제하고 김민수선수를 등록해야한다.<p> <br>
><br>	


>#### CASE 2. 유벤투스감독관리팀에 입사한 윤혜씨 <br>	
>꾸준히 팀의 신임을 받은 Giovanni Cerra 코치는 내년부터 감독으로 승진하게 되었다.<br>
>Giovanni Cerra 코치의 포지션을 변경해야한다.<p><br>
><br>

<details>
<summary>How to use?</summary>
<div markdown="1">

1. 우선 회원가입 후 로그인합니다  
	![로그인](https://user-images.githubusercontent.com/53591258/104253961-11d84080-54b9-11eb-8885-d086e4f05d64.PNG)  
	![loginDetail](https://user-images.githubusercontent.com/53591258/104253968-17358b00-54b9-11eb-9083-47176b834b1f.PNG)  
2. 팀 생성 후 팀 상세보기로 이동 후 감독, 선수, 의료진, 트레이너 중 하나를 선택해 이동합니다  
	![teamDetail](https://user-images.githubusercontent.com/53591258/104253973-1bfa3f00-54b9-11eb-8ff8-a92abd71e209.PNG)  
	![medical](https://user-images.githubusercontent.com/53591258/104253981-21f02000-54b9-11eb-946b-c9e2b2f48dd7.PNG)  
	![add](https://user-images.githubusercontent.com/53591258/104253984-2583a700-54b9-11eb-9179-1e9418acec7a.PNG)  
3. 팀 내의 해당 구성원 리스트에서 번호를 클릭하거나 새로운 구성원을 생성하면 구성원 상세보기로 이동합니다  
	![medicalDetail](https://user-images.githubusercontent.com/53591258/104253990-29afc480-54b9-11eb-860d-ace65609c034.PNG)  
4. 구성원 상세보기 안에서 수정 삭제 가능합니다  
	![update](https://user-images.githubusercontent.com/53591258/104254001-3207ff80-54b9-11eb-9ade-237fa4f46322.PNG)  
	![afterDelete](https://user-images.githubusercontent.com/53591258/104254009-37654a00-54b9-11eb-828b-d07d4272c36f.PNG)  
    삭제한 후 구성원 리스트  
5. 오른쪽 상단에 위치한 로그아웃 버튼을 누르면 로그아웃 후 로그인 페이지로 이동합니다  
6. 자유롭게 즐기기!  
</div>
</details>

## ISSUE

1. 구조  
	- 맨처음 sql table구조를 설계할 때 제약 조건을 잘 못 설정했습니다.
	- ERDCLOUD에서 sql문장을 자동으로 생성해주는 기능을 썼는데 오류가 많았습니다.
	- Entity mapping하는 과정에서 JoinColumn과 mappedBy를 헷갈려 오류가 생겼습니다.

2. 깃허브  
코딩을 하다보면 이클립스 설정 파일이나 class파일 등이 자동으로 변경되는데 이것들을 깃허브에 같이 올려 소스파일을 확실하게 분리해서 작업해도 충돌이 일어나는 경우가 빈번했습니다.
.gitignore파일을 만들어서 커밋시 제외할 파일들을 설정해 해결했습니다.

3. 코드
```jsp
<td>${requestScope.team.tName}</td>
 		
 		
<td>
<% TeamDTO t = (TeamDTO)request.getAttribute("team"); 
	if(t != null){
%>
		<%=t.getTName()%>		
<%			
	}
%>
</td>
```
같은 코드지만 el태그를 사용한 부분은 인식을 하지 못하는 문제가 있었습니다. 원인을 찾아보니 대소문자 문제였습니다.  
ex) tName(X), tname(O)

```java
em.remove(em.find(LoginEntity.class, userID));
```
context에 저장하지 않고 바로 삭제하려 해서 에러가 발생했습니다.

<details>
<summary>English</summary>
<div markdown="1">

[PROTOTYPE LINK](https://ovenapp.io/project/Bw3y8pT5PFoud5JYHMvDrt6okzKgig7T#bavCk)


## Project topic

It is a program that can manage players, coaches, medical staff, and trainers by creating a soccer team.

## Reason for selecting a topic

We have created a simple administrative program to learn the connection between the Web and the database.

## Technical stack

- HTML
- CSS
-Javascript
- Lombok
- Java
- Oracle
- Slf4j
- SQL
- servlet
- JSP

<details>
<summary>STRUCTURE</summary>
<div markdown="1">

![image](https://user-images.githubusercontent.com/53591258/103433644-6e756900-4c38-11eb-8c58-37fe0e4d236c.png)
</div>
</details>

<details>
<summary>How to use?</summary>
<div markdown="1">

1. First, sign in after signing up for membership.  
    ![로그인](https://user-images.githubusercontent.com/53591258/104253961-11d84080-54b9-11eb-8885-d086e4f05d64.PNG)  
	![loginDetail](https://user-images.githubusercontent.com/53591258/104253968-17358b00-54b9-11eb-9083-47176b834b1f.PNG)  
2. After creating a team, go to the Team Details view and select one of the coaches, athletes, medics, or trainers to move.  
    ![teamDetail](https://user-images.githubusercontent.com/53591258/104253973-1bfa3f00-54b9-11eb-8ff8-a92abd71e209.PNG)  
	![medical](https://user-images.githubusercontent.com/53591258/104253981-21f02000-54b9-11eb-946b-c9e2b2f48dd7.PNG)  
	![add](https://user-images.githubusercontent.com/53591258/104253984-2583a700-54b9-11eb-9179-1e9418acec7a.PNG)  
3. Click a number in the list of appropriate members within a team, or create a new member, and you will be taken to the Members Details view.  
    ![medicalDetail](https://user-images.githubusercontent.com/53591258/104253990-29afc480-54b9-11eb-860d-ace65609c034.PNG)  
4. You can modify and delete it in the Membership Details view.  
    ![update](https://user-images.githubusercontent.com/53591258/104254001-3207ff80-54b9-11eb-9ade-237fa4f46322.PNG)  
	![afterDelete](https://user-images.githubusercontent.com/53591258/104254009-37654a00-54b9-11eb-828b-d07d4272c36f.PNG)  
    List of members after deletion  
5. Press the Logout button located in the upper right corner to logout and go to the login page.
6. Enjoy Yourself Freely!  
</div>
</details>

<details>
<summary>ISSUE</summary>
<div markdown="1">

1. Structure  
	- The constraint was set incorrectly when designing the first sql table structure.
	- we used the function of automatically generate sql sentences in ERDCLOUD , but there were many errors.
	- An error occurred because we were confused between JoinColumn and MappedBy.  

2. Git  
despite of we separate the source file, when coding, the Eclipse settings file or class file are automatically changed, so there were often conflicts.  
Created and resolved the .gitignore file by setting the files to be excluded when committed.

3. Code
```jsp
<td>${requestScope.team.tName}</td>
 		
 		
<td>
<% TeamDTO t = (TeamDTO)request.getAttribute("team"); 
	if(t != null){
%>
		<%=t.getTName()%>		
<%			
	}
%>
</td>
```
There was a problem that the same code but the use of the el-tag was not recognized. When I looked up the cause, it was a case-sensitive problem.  
ex) tName(X), tname(O)

```java
em.remove(em.find(LoginEntity.class, userID));
```
An error occurred because I tried to delete it right away without saving it in context.
</div>
</details>

</div>
</details>
