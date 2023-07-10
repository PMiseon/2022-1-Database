SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS madang;
DROP USER IF EXISTS madang@localhost;

create user madang@localhost identified WITH mysql_native_password  by 'madang';
create database madang;
grant all privileges on madang.* to madang@localhost with grant option;
commit;

USE madang;

-- -----------------------------------------------------
-- Table `madang`.`movie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `madang`.`movie` (
  `mid` INT NOT NULL auto_increment,
  `mname` VARCHAR(30) NOT NULL,
  `runtime` INT NULL,
  `rating` VARCHAR(10) NULL,
  `director_name` VARCHAR(20) NULL,
  `actname` VARCHAR(20) NULL,
  `genre` VARCHAR(10) NULL,
  `synopsis` VARCHAR(200) NULL,
  `release_date` DATE NULL,
  PRIMARY KEY (`mid`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `madang`.`theater`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `madang`.`theater` (
  `th_id` INT NOT NULL auto_increment,
  `seats_num` INT NULL,
  `th_use` TINYINT NULL,
  PRIMARY KEY (`th_id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `madang`.`schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `madang`.`schedule` (
  `sch_id` INT NOT NULL auto_increment,
  `start_date` DATE NULL,
  `day_of_week` VARCHAR(10) NULL,
  `times` INT NULL,
  `start_time` TIME NULL,
  `movie_mid` INT NOT NULL ,
  `theater_th_id` INT NOT NULL ,
  PRIMARY KEY (`sch_id`),
  INDEX `fk_schedule_movie1_idx` (`movie_mid` ASC) VISIBLE,
  INDEX `fk_schedule_theater1_idx` (`theater_th_id` ASC) VISIBLE,
  CONSTRAINT `fk_schedule_movie1`
    FOREIGN KEY (`movie_mid`)
    REFERENCES `madang`.`movie` (`mid`)
    ON DELETE cascade
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_schedule_theater1`
    FOREIGN KEY (`theater_th_id`)
    REFERENCES `madang`.`theater` (`th_id`)
    ON DELETE cascade
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `madang`.`seat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `madang`.`seat` (
  `seat_id` INT NOT NULL ,
  `s_use` TINYINT NULL,
  `theater_th_id` INT NOT NULL,
  PRIMARY KEY (`seat_id`),
  INDEX `fk_seat_theater1_idx` (`theater_th_id` ASC) VISIBLE,
  CONSTRAINT `fk_seat_theater1`
    FOREIGN KEY (`theater_th_id`)
    REFERENCES `madang`.`theater` (`th_id`)
    ON DELETE cascade
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `madang`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `madang`.`customer` (
  `cid` INT NOT NULL auto_increment,
  `name` VARCHAR(20) NULL,
  `phone_num` VARCHAR(15) NULL,
  `email` VARCHAR(20) NULL,
  PRIMARY KEY (`cid`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `madang`.`reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `madang`.`reservation` (
  `rid` INT NOT NULL auto_increment,
  `pay_option` VARCHAR(10) NULL,
  `pay_status` TINYINT NULL,
  `pay_price` INT NULL,
  `pay_date` DATE NULL,
  `customer_cid` INT NOT NULL,
  PRIMARY KEY (`rid`),
  INDEX `fk_reservation_customer1_idx` (`customer_cid` ASC) VISIBLE,
  CONSTRAINT `fk_reservation_customer1`
    FOREIGN KEY (`customer_cid`)
    REFERENCES `madang`.`customer` (`cid`)
    ON DELETE cascade
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `madang`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `madang`.`ticket` (
  `ti_id` INT NOT NULL auto_increment,
  `get_ticket` TINYINT NULL,
  `price` INT NULL,
  `salesprice` INT NULL,
  `schedule_sch_id` INT NOT NULL,
  `theater_th_id` INT NOT NULL,
  `seat_seat_id` INT NOT NULL,
  `reservation_rid` INT NOT NULL,
  
  PRIMARY KEY (`ti_id`),
  INDEX `fk_ticket_seat1_idx` (`seat_seat_id` ASC) VISIBLE,
  INDEX `fk_ticket_schedule1_idx` (`schedule_sch_id` ASC) VISIBLE,
  INDEX `fk_ticket_theater1_idx` (`theater_th_id` ASC) VISIBLE,
  INDEX `fk_ticket_reservation1_idx` (`reservation_rid` ASC) VISIBLE,
  CONSTRAINT `fk_ticket_seat1`
    FOREIGN KEY (`seat_seat_id`)
    REFERENCES `madang`.`seat` (`seat_id`)
    ON DELETE cascade
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_schedule1`
    FOREIGN KEY (`schedule_sch_id`)
    REFERENCES `madang`.`schedule` (`sch_id`)
    ON DELETE cascade
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_theater1`
    FOREIGN KEY (`theater_th_id`)
    REFERENCES `madang`.`theater` (`th_id`)
    ON DELETE cascade
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_reservation1`
    FOREIGN KEY (`reservation_rid`)
    REFERENCES `madang`.`reservation` (`rid`)
    ON DELETE cascade
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

commit;

-- -----------------------------------------------------
-- sample data 입력 
-- -----------------------------------------------------
##INSERT CUSTOMER 
INSERT INTO customer VALUES (1,'강동원','010-1234-1234','dongwon@magang.com');
INSERT INTO customer VALUES (2,'한소희','010-4321-4321','so_hui@madang.com');
INSERT INTO customer VALUES (3,'김태희','010-2345-4562','thkim@madang.com');
INSERT INTO customer VALUES (4,'이정재','010-2022-0527','leejj@madang.com');
INSERT INTO customer VALUES (5,'박해수','010-9874-9658','haesu@madang.com');
INSERT INTO customer VALUES (6, '오영수','010-3254-6548','0youngsu@madang.com');
INSERT INTO customer VALUES (7, '정호연','010-6532-8654','hoyeon@madang.com');
INSERT INTO customer VALUES (8, '김주령','010-2385-6856','kimjr@madang.com');
INSERT INTO customer VALUES (9, '허성태','010-9635-2587','heost@hadang.com');
INSERT INTO customer VALUES (10, '이유미','010-1478-8524','youme@madang.com');

##insert movie
INSERT INTO movie VALUES(1, '범죄도시2', 106 , '15세 관람가', '이상용', '마동석', '액션' ,'가리봉동 소탕작전 후 4년 뒤, 금천서 강력반은 베트남으로 도주한 용의자를 인도받아 오라는 미션을 받는다.', '2021-01-01');
INSERT INTO movie VALUES(2, '배드 가이즈', 100, '전체 관람가', '피에르 페리펠', '샘 록웰', '애니메이션', '나쁜 녀석들의 사상 초유 바른 생활 갓생 프로젝트가 시작된다!','2021-02-01');
INSERT INTO movie VALUES(3,'해리포터', 152,'전체관람가','크리스 콜럼버스','다니엘 래드클리프','판타지','해리는 볼드모트로부터 마법의 돌과 호그와트 마법학교를 지키기 위해 필사의 노력을 하는데...','2021-03-01');
INSERT INTO movie VALUES(4,'반지의 제왕',228,'12세 관람가','피터 잭슨','일라이저 우드','판타지','반지원정대는 드디어 거대한 최후의 전쟁을 시작하는데...','2021-04-01');
INSERT INTO movie VALUES(5,'기생충',131,'15세 관람가','봉준호','송강호','드라마','전원백수로 살 길 막막하지만 사이는 좋은 기택(송강호) 가족.','2021-05-01');
INSERT INTO movie VALUES(6,'타짜',139,'청소년 관람불가','최동훈','조승우','범죄',' 각자의 원한과 욕망, 그리고 덧없는 희망, 이 모든 것이 뒤엉킨 한 판이 시작된다..! ','2021-06-01');
INSERT INTO movie VALUES(7,'부산행',118,'15세 관람가','연상호','공유','액션','서울에서 부산까지의 거리 442KM 지키고 싶은, 지켜야만 하는 사람들의 극한의 사투!','2021-07-01');
INSERT INTO movie VALUES(8,'어벤저스',142,'12세 관람가','조스 웨던','로버트 다우니 주니어','액션','지구의 운명을 건 거대한 전쟁이 시작된다!','2021-08-01');
INSERT INTO movie VALUES(9,'라라랜드',127,'12세 관람가','데이미언 셔젤','라이언 고슬링','드라마','꿈을 꾸는 사람들을 위한 별들의 도시 ‘라라랜드’. ','2021-09-01');
INSERT INTO movie VALUES(10,'킹스맨',128,'청소년 관람불가','메튜 본','콜린 퍼스','액션','세상에서 가장 위험한 면접이 시작된다!','2021-10-01');

##상영관
INSERT INTO theater VALUES (1,2,1);
INSERT INTO theater VALUES (2,2,1);
INSERT INTO theater VALUES (3,2,1);
INSERT INTO theater VALUES (4,2,1);
INSERT INTO theater VALUES (5,2,1);
INSERT INTO theater VALUES (6,2,1);
INSERT INTO theater VALUES (7,2,1);
INSERT INTO theater VALUES (8,2,1);
INSERT INTO theater VALUES (9,2,1);
INSERT INTO theater VALUES (10,2,1);

##좌석
INSERT INTO seat VALUES (11,1,1);
INSERT INTO seat VALUES (12,0,1);
INSERT INTO seat VALUES (21,1,2);
INSERT INTO seat VALUES (22,0,2);
INSERT INTO seat VALUES (31,1,3);
INSERT INTO seat VALUES (32,0,3);
INSERT INTO seat VALUES (41,1,4);
INSERT INTO seat VALUES (42,0,4);
INSERT INTO seat VALUES (51,1,5);
INSERT INTO seat VALUES (52,0,5);
INSERT INTO seat VALUES (61,0,6);
INSERT INTO seat VALUES (62,1,6);
INSERT INTO seat VALUES (71,0,7);
INSERT INTO seat VALUES (72,1,7);
INSERT INTO seat VALUES (81,0,8);
INSERT INTO seat VALUES (82,1,8);
INSERT INTO seat VALUES (91,0,9);
INSERT INTO seat VALUES (92,1,9);
INSERT INTO seat VALUES (101,0,10);
INSERT INTO seat VALUES (102,1,10);

##상영일정
INSERT INTO schedule VALUES (1,'2022-04-01','금요일',1,'10:00',1,1);
INSERT INTO schedule VALUES (2,'2022-04-02','토요일',1,'11:00',2,2);
INSERT INTO schedule VALUES (3,'2022-04-03','일요일',1,'12:00',3,3);
INSERT INTO schedule VALUES (4,'2022-04-04','월요일',1,'13:00',4,4);
INSERT INTO schedule VALUES (5,'2022-04-05','화요일',1,'14:00',5,5);
INSERT INTO schedule VALUES (6,'2022-04-06','수요일',1,'15:00',6,6);
INSERT INTO schedule VALUES (7,'2022-04-07','목요일',1,'16:00',7,7);
INSERT INTO schedule VALUES (8,'2022-04-08','금요일',1,'17:00',8,8);
INSERT INTO schedule VALUES (9,'2022-04-09','토요일',1,'18:00',9,9);
INSERT INTO schedule VALUES (10,'2022-04-10','일요일',1,'19:00',10,10);

##예매정보
INSERT INTO reservation VALUES (1,'현금',1,10000,'2022-04-01',1);
INSERT INTO reservation VALUES (2,'카드',1,8000,'2022-04-02',2);
INSERT INTO reservation VALUES (3,'현금',1,12000,'2022-04-03',3);
INSERT INTO reservation VALUES (4,'현금',1,8000,'2022-04-04',4);
INSERT INTO reservation VALUES (5,'현금',1,14000,'2022-04-05',5);
INSERT INTO reservation VALUES (6,'카드',1,20000,'2022-04-06',6);
INSERT INTO reservation VALUES (7,'카드',0,10000,'2022-04-07',7);
INSERT INTO reservation VALUES (8,'현금',0,8000,'2022-04-08',8);
INSERT INTO reservation VALUES (9,'카드',0,12000,'2022-04-09',9);
INSERT INTO reservation VALUES (10,'현금',0,8000,'2022-04-10',10);

##티켓 
INSERT INTO ticket VALUES (1,1,10000,10000,1,1,11,1);
INSERT INTO ticket VALUES (2,1,8000,8000,2,2,21,2);
INSERT INTO ticket VALUES (3,1,12000,12000,3,3,31,3);
INSERT INTO ticket VALUES (4,1,8000,8000,4,4,41,4);
INSERT INTO ticket VALUES (5,1,14000,14000,5,5,51,5);
INSERT INTO ticket VALUES (6,1,20000,20000,6,6,62,6);
INSERT INTO ticket VALUES (7,0,10000,10000,7,7,72,7);
INSERT INTO ticket VALUES (8,0,8000,8000,8,8,82,8);
INSERT INTO ticket VALUES (9,0,12000,12000,9,9,92,9);
INSERT INTO ticket VALUES (10,0,8000,8000,10,10,102,10);

commit;
