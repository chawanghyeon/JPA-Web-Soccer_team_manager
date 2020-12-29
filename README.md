# WEB_JPA MINI PROJECT : Control하다



꿀단지님께 날라온 메일:memo: <br>


<p><p></p>


토트넘을 소유하고 있는 00기업이 이번에 유벤투스를 인수하게 되었습니다.<br>
클라이언트는 한 프로그램을 사용하여 두 기업을 관리하고 싶어합니다.<br>
두팀을 관리할 있는 프로그램을 만들어주세요.<br>

<p><p></p>
팀 꿀단지는 'Control하다'를 만들었습니다. 


<b>Control하다</b>는 <br>
:soccer: 선수, 감독, 트레이너, 의료진의 정보를 <br>
         확인할 수 있고,  <br>
         한 프로그램이지만 <br>
	 팀의 정보보안을 위해 다른팀으로의 접근은 차단하는  <br>
         관리 프로그램입니다. :computer:  <br>

<p><p>
	
## TOPIC SELECT PROCESS<br><br>

### topic <br>

<div>

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

#### Control<br>


>#### CASE 1. 토트넘선수관리팀에 입사한 왕현씨 
>CASE 1.
>연말은 FA가 많다.<br>
>이번년도에는 권희성선수가 팀을 나가게 되었고, 김민수선수가 입단하게 되었다.<br>
>선수관리 프로그램에서 권희성선수를 삭제하고 김민수선수를 등록해야한다. .<p> <br>
><br>	

<br>
>#### CASE 2. 유벤투스의료관리팀에 입사한 윤혜씨 	
>이번년도에 부상으로 부진했던 최지원선수의 데이터를 담당의료진들에게 보내야합니다. <p>
>우산도 없는데 서럽다.<br>
>지금 내 얼굴 위 빗방울이 빗물인지 눈물인지 모르겠ㄷㅏ...★ <p></p><br><br>



##STRUCTURE


<div>
<img width="1000" src=https://user-images.githubusercontent.com/73386460/103197067-b6d71300-4928-11eb-907f-65809a582553.PNG>

	

## MODELING 	

## Service 
<div>	

### 1. CASE1.관리자 행동 시나리오		1
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;:key: 로그인 <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;:ballot_box_with_check: 카테고리 고르기 <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;:couplekiss: 선수 정보 확인 <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;:pencil: 선수 정보 수정   <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;:x: 선수 삭제 <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;:memo: 선수 명단 확인하기 <br>
<br>


</br></p>

## SQL TABLE 

+ Soccer Management DDL 

```SQL

CREATE TABLE team(
	t_name	         varchar2(25)    NOT NULL,
	user_id	         varchar2(50)	NOT NULL
);


CREATE TABLE  players (
	p_number           number(20)		NOT NULL,
	t_name             varchar2(25)		NOT NULL,
	p_name 	           varchar2(50)		NOT NULL,
	p_age	           number(20)		NOT NULL,
    p_position         varchar2(50)		NOT NULL
);


CREATE TABLE  managers (
	 m_number	 number(20)		    NOT NULL,
	 t_name	     varchar2(25)		NOT NULL,
	 m_name  	 varchar2(50)		NOT NULL,
	 m_age	     number(20)		    NOT NULL,
	 m_position	 varchar2(50)		NOT NULL
);



CREATE TABLE medical_staff (
	d_number	      number(20)		    NOT NULL,
	t_name	          varchar2(25)		NOT NULL,
	d_name	          varchar2(50)		NOT NULL,
	d_age	          number(20)		    NOT NULL,
	d_position	      varchar2(50)		    NOT NULL
);



CREATE TABLE trainers (
	tr_number	 number(20)		    NOT NULL,
	t_name	     varchar2(25)		NOT NULL,
	tr_name	     varchar2(50)		NOT NULL,
	tr_age	     number(20)		    NOT NULL,
	tr_position	 varchar2(50)		    NOT NULL
);



CREATE TABLE logins (
	user_id	           varchar2(50)	      NOT NULL,
	user_pw	           varchar2(50)	      NOT NULL
);


ALTER TABLE logins ADD CONSTRAINT PK_LOGINS PRIMARY KEY (userid);

ALTER TABLE players ADD CONSTRAINT PK_PLAYERS PRIMARY KEY (p_number);

ALTER TABLE team ADD CONSTRAINT PK_TEAM PRIMARY KEY (t_name);

ALTER TABLE team ADD CONSTRAINT FK_logins_TO_team_1 FOREIGN KEY (userid)
REFERENCES logins (userid);

ALTER TABLE managers ADD CONSTRAINT PK_MANAGERS PRIMARY KEY (m_number);

ALTER TABLE medical_staff ADD CONSTRAINT PK_MEDICAL_STAFF PRIMARY KEY (d_number);

ALTER TABLE trainers ADD CONSTRAINT PK_TRAINERS PRIMARY KEY (tr_number);

ALTER TABLE players ADD CONSTRAINT FK_team_TO_players_1 FOREIGN KEY (t_name)
REFERENCES team (t_name);

ALTER TABLE managers ADD CONSTRAINT FK_team_TO_managers_1 FOREIGN KEY (t_name)
REFERENCES team (t_name);

ALTER TABLE medical_staff ADD CONSTRAINT FK_team_TO_medical_staff_1 FOREIGN KEY (t_name)
REFERENCES team (t_name);

ALTER TABLE trainers ADD CONSTRAINT FK_team_TO_trainers_1 FOREIGN KEY (t_name)
REFERENCES team (t_name);

DROP TABLE players CASCADE CONSTRAINTS;

DROP TABLE team CASCADE CONSTRAINTS;

DROP TABLE managers CASCADE CONSTRAINTS;

DROP TABLE medical_staff CASCADE CONSTRAINTS;

DROP TABLE trainers CASCADE CONSTRAINTS;

DROP TABLE logins CASCADE CONSTRAINTS;

```

+ Soccer Management DML 

```SQL

insert into logins values ('cwh', '1234');
insert into logins values ('yoon1234', '4567');

insert into team values ('토트넘', 'cwh');
insert into team values ('유벤투스', 'yoon1234');


insert into players values(1,'토트넘','권오민',23,'골키퍼');	
insert into players values(2,'토트넘','권희성',25,'수비수');	
insert into players values(3,'토트넘','김민건',27,'수비수');	
insert into players values(4,'토트넘','김성호',29,'수비수');	
insert into players values(5,'토트넘','김연식',28,'수비수');	
insert into players values(6,'토트넘','김재웅',27,'공격수');	
insert into players values(7,'토트넘','김준형',30,'공격수');	
insert into players values(8,'토트넘','김창훈',25,'공격수');	
insert into players values(9,'토트넘','김혜경',24,'미드필더');	
insert into players values(10,'토트넘','김혜성',21,'미드필더');	
insert into players values(11,'토트넘','박다영',22,'미드필더');	
insert into players values(12,'유벤투스','염아정',24,'골키퍼');	
insert into players values(13,'유벤투스','김연지',26,'수비수');	
insert into players values(14,'유벤투스','박민영',28,'수비수');	
insert into players values(15,'유벤투스','고은비',27,'수비수');	
insert into players values(16,'유벤투스','장종욱',25,'수비수');	
insert into players values(17,'유벤투스','이정민',24,'공격수');	
insert into players values(18,'유벤투스','조윤혜',26,'공격수');	
insert into players values(19,'유벤투스','최지수',24,'공격수');	
insert into players values(20,'유벤투스','최지원',27,'미드필더');	
insert into players values(21,'유벤투스','최태열',26,'미드필더');	
insert into players values(22,'유벤투스','양호준',25,'미드필더');	
	
				


insert into trainers values(301,'토트넘','배수지',34,'재활');
insert into trainers values(302,'토트넘','김태연',50,'재활');
insert into trainers values(303,'유벤투스','한소희',40,'재활');
insert into trainers values(304,'토트넘','김준면',30,'PT');
insert into trainers values(305,'유벤투스','김선호',36,'PT');
insert into trainers values(306,'유벤투스','남주혁',37,'PT');	



insert into managers values (100, '토트넘', 'José Mourinho', 60, 'Manager');
insert into managers values (101, '토트넘', 'João Sacramento', 50, 'Coach');
insert into managers values (102, '토트넘', 'Nuno Santos', 40, 'Coach');
insert into managers values (103, '유벤투스', 'Ledley King', 46, 'Coach');
insert into managers values (104, '유벤투스', 'Carlos Lalin', 48, 'Coach');
insert into managers values (105, '유벤투스', 'Giovanni Cerra', 57, 'Coach');
				


insert into medical_staff values (200, '토트넘', '차의사', 30, '정신과');			
insert into medical_staff values (201, '토트넘', '조의사', 40, '정형외과');			
insert into medical_staff values (202, '토트넘', '김의사', 32, '내과');			
insert into medical_staff values (203, '유벤투스', '박의사', 43, '정형외과');			
insert into medical_staff values (204, '유벤투스', '이의사', 50, '정형외과');			
insert into medical_staff values (205, '유벤투스', '최의사', 53, '정형외과');			
					
				
commit;

```





## PROTOTYPE LINK
https://ovenapp.io/project/Bw3y8pT5PFoud5JYHMvDrt6okzKgig7T#bavCk



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
같은 코드지만 el태그를 사용한 부분은 인식을 하지 못하는 문제가 있었습니다.

```java
em.remove(em.find(LoginEntity.class, userID));
em.createNativeQuery("DELETE FROM logins WHERE user_id="+"'"+userID+"'").executeUpdate();
```
em.remove가 실행되지 않는 문제가 발생해 createNativeQuery로 해결했습니다.
