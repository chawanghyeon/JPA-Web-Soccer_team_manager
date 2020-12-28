# WEB_JPA MINI PROJECT : Controller



꿀단지님께 날라온 메일:massage: <br>
토트넘을 소유하고 있는 00기업이 이번에 유벤투스를 인수하게 되었습니다.<br>
클라이언트는 한 프로그램을 사용하여 두 기업을 관리하고 싶어합니다.<br>
두팀을 관리할 있는 프로그램을 만들어주세요.<br>


<b>Controller</b>는 <br>
:soccer: 선수, 감독, 트레이너, 의료진의 정보를 <br>
         팀별로 사용할 수 있으며,  <br>
         팀의 정보보안을 위해 다른팀으로의 접근은 차단하며,  <br>
         모든 정보를 확인할 수 있는  <br>
         관리 프로그램입니다. :computer:  <br>

<p><p>
	
## TOPIC SELECT PROCESS<br><br>

### topic <br>

<div>

#### 선수관리프로그램 및 선수 페이지  <br>
:player: 선수의 정보를 등록, 확인하고 업데이트 및 삭제를 할 수 있습니다.<br>
<p><p></p>
	
#### 감독 관리 및 감독 페이지 <br>
:user: 감독의 정보를 등록, 확인하고 이력을 확인할 수 있습니다.  <br>

<p><p></p>

#### 트레이너 관리 및 감독 페이지 <br>
:clock8: 감독의 정보를 등록, 확인하고 이력을 확인할 수 있습니다. <br>
<p><p></p>

#### Dear.Diary<br>
:no_mouth: 이렇게 메말라 가는 현대인의 감정을 돌보기 위해<br> 
셀프 멘탈 헬스케어 체크 SNS 플랫폼
Dear.Diary가 탄생했습니다!!<p></p>
<img align="left" height="300" src = "https://github.com/Heart-and-heart/Heart-and-Heart/blob/mergetest/by%EC%A1%B0%EC%9C%A4%EC%98%81.jpg?raw=true"> 
<img height="300" src = "https://github.com/Heart-and-heart/Heart-and-Heart/blob/mergetest/%EC%BD%94%EB%81%BC%EB%A6%AC.jpg?raw=true">

>#### CASE 1. REGULAR DIARY를 사용 중인 A씨 일기
><img align="left" height="170" img src="https://ohfun.net/contents/article/images/2019/0701/thm200_1561972645906397.jpg">
>오늘은 아침부터 이유없이 기분이 울적했다.<br>
>퇴근 길에 기분전환하려 만난 연인은 지루한지 하품을 해댔다.<br>
>즉석떢볶이 집에서는 맵기 정도를 두고는 싸웠다.<p> 
>연인과 싸우고 돌아오는 골목길,비가 쏟아진다.<p>
>우산도 없는데 서럽다.<br>
>지금 내 얼굴 위 빗방울이 빗물인지 눈물인지 모르겠ㄷㅏ...★ <p></p><br><br>


>#### CASE 2. DEAR DIARY를 사용 중인 B씨 일기
><img align="left" height="238" img src = "https://instagram.ficn4-1.fna.fbcdn.net/v/t51.2885-15/e35/18888791_638450609677681_3614820475483455488_n.jpg?_nc_ht=instagram.ficn4-1.fna.fbcdn.net&_nc_cat=101&_nc_ohc=QDLB95sixEMAX_flfiT&tp=1&oh=05de921064cb026d07b2fea7c5ba94f6&oe=5FF700F1">
>아침에 일어났는데 기분이 울적했다.<br> 
>DEAR DIARY에 누적된 일기데이터 분석에 의하면 나는 비오는 날 <br>평소보다 울적해진다. 일기예보를 보니 역시 비가 올 예정이다.<br> 왜인지 아니까 안 우울하다.<p> 
>퇴근 길엔 연인을 만났는데 자꾸 하품을 했다.<br>
>DD의 커플정보를 보니 요즘 못 자던데 피로한 모양이다. 안쓰럽다.<br>
>연인이 내가 꾸물꾸물한 날 우울해지니까 매운 거 먹자고 하길래,<br>
>잠도 못잤는데 매운 거 먹으면 배탈난다고 죽집에 갔다.<br>
>나는 매운낙지, 그는 전복죽을 먹고 가서 푹 자라고 일찍 헤어졌다.<br>
>골목길에 들어서는데 비가 쏟아졌다. 아침에 우산 챙겼지롱!</p>



## STRUCTURE 


<div>
<img width="1000" src=https://user-images.githubusercontent.com/73386460/103197067-b6d71300-4928-11eb-907f-65809a582553.PNG>

	

## MODELING 	

## Service 
<div>	

### 1. USER 행동 시나리오		
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;:key: 로그인 <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;:ballot_box_with_check: 내 다이어리 보기 <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;:couplekiss: 커플 이용자 다이어리 보기 <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;:pencil: 다이어리 쓰기  <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;:calendar: 다이어리 수정 <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;:x: 다이어리 삭제 <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;:speech_balloon: 오늘 내 기분과 같은 기분인 사람들의 한줄 코멘트 보기 <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp; &nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;:bar_chart: 나의 감정상태 측정 <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp; &nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;① 자신이 지금까지 기록했던 기분점수 평균과<br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp; &nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;② 최근 7일간의 기분점수 평균 비교 <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp; &nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;id님,  <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp; &nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;:heavy_plus_sign: (감정상태가 평균과 같거나 더 높을 경우)  <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp; &nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;이번주도 해피해피하게 아주 잘 보내고 있어요!  <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp; &nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;:heavy_minus_sign: (감정상태가 평소보다 낮을 경우)  <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp; &nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;이번주는 평소보다 우울하신가요? 오늘 간식으로 달콤한 케이크 한 조각 어때요? <br> <p></p>
				
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;:sleeping: 9) 나의 수면상태 측정  <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp; &nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;① 지금까지 기록했던 수면시간 평균과 <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp; &nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;② 최근 7일간의 수면시간 평균 비교  <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp; &nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;id님,  <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp; &nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;:heavy_plus_sign: id님, 푹 쉬셨네요 ! 주말엔 등산처럼 활기찬 야외활동을 해보는 게 어떨까요 ~?! <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp; &nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;:heavy_minus_sign: 이번주는 평소보다 덜 주무셨어요. 주말엔 꼭 포근한 이불 속에서 푹 쉬세요!  <br>
				 <br>

### 2. 관리자 행동 시나리오
<div>	
	</br</p>
	
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;:wrench: 1) 모든 다이어리 정보 CRUD  <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;:busts_in_silhouette: 2) 감정 테이블에 감정 추가/수정 (향후 Update용) <br>
&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;:droplet: 3) 날씨 테이블에 날씨 추가/수정 (향후 Update용) <br>


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



## INSPRATION 
<div>
1. 구조
	
	1) 버전 오류
 	- git에 올린 초기 버전에 맞지 않게 다운로드하고 수정하다보니 push, pull에 문제가 있었는데, 인터넷으로 버전 정리를 하면서 해결했다.
	2) denied 되는 문제
 	- window 자격증명 삭제로 해결했다.

2. 깃허브

1) LOGIN
2) 구조 짜기
- MVC를 위해 CONTROLLER, VIEW, SERVICE, DAO, DTO 등 여러 개로 클래스를 나눠서 개발했다.
- 덕분에 수정과정에서 에러가 발생할 때마다 어느 지점으로 가서 손을 볼 지 파악할 수 있어 유용했다
3) SEQUENCE 기능의 활용
- 관리자가 개발자와 다를 경우를 고려해 감정, 날씨 등의 정보를 추가할 때 따로 일련번호를 확인할 필요가 없도록
  각 테이블의 일련번호를 SEQUENCE로 매겨지게 했다.



