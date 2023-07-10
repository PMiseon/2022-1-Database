import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Admin extends JPanel implements ActionListener {
	JLabel title = new JLabel("관리자 모드");
	JPanel btnP1 = new JPanel();
	JButton reset = new JButton("초기화");
	JButton showAll = new JButton("전체 테이블 보기");
	JPanel btnP2 = new JPanel();
	JButton crud = new JButton("입력  /  삭제  /  변경");
	
	Admin() {
		setLayout(null);
		
		title.setFont(new Font("SansSerif", Font.BOLD, 30));
		title.setBounds(185+380-30,110+15,400,50); // 가로시작점, 세로시작점, 가로크기, 세로크기
		
		btnP1.setBounds(95+375, 160+30, 300, 50);
		btnP1.setLayout(new GridLayout(1, 2, 10, 0)); // 행수, 열수, 가로간격, 세로간격
		btnP1.add(reset);
		btnP1.add(showAll);
		
		btnP2.setBounds(95+375, 220+30, 300, 50);
		btnP2.setLayout(new GridLayout(1, 1, 0, 0)); // 행수, 열수, 가로간격, 세로간격
		btnP2.add(crud);
		
		add(title);
		add(btnP1);
		add(btnP2);
	
		reset.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String btnStr = e.getActionCommand();
		
		if (btnStr.equals("초기화")) {
			resetDB();
		}
	}

	static void resetDB() {
		Statement stmt = null;
		ResultSet rs = null;
		String query;
		
			try {
				stmt = FirstInit.con.createStatement();
				
				query = "SET foreign_key_checks = 0;";
				stmt.executeUpdate(query);
				
				query = "DROP TABLE IF EXISTS movie";
				stmt.executeUpdate(query);
				query = "DROP TABLE IF EXISTS ticket";
				stmt.executeUpdate(query);
				query = "DROP TABLE IF EXISTS schedule";
				stmt.executeUpdate(query);
				query = "DROP TABLE IF EXISTS seat";
				stmt.executeUpdate(query);
				query = "DROP TABLE IF EXISTS customer";
				stmt.executeUpdate(query);
				query = "DROP TABLE IF EXISTS reservation";
				stmt.executeUpdate(query);
				query = "DROP TABLE IF EXISTS theater";
				stmt.executeUpdate(query);

				query = "SET foreign_key_checks = 1;";
				stmt.executeUpdate(query);
			
				
				query = "CREATE TABLE IF NOT EXISTS `madang`.`movie` ("
						  + "`mid` INT NOT NULL auto_increment,"
						  + "`mname` VARCHAR(30) NOT NULL,"
						  + "`runtime` INT NULL,"
						  + "`rating` VARCHAR(10) NULL,"
						  + "`director_name` VARCHAR(20) NULL,"
						  + "`actname` VARCHAR(20) NULL,"
						  + "`genre` VARCHAR(10) NULL,"
						  + "`synopsis` VARCHAR(200) NULL,"
						  + "`release_date` DATE NULL,"
						  + "PRIMARY KEY (`mid`))"
						+ "ENGINE = InnoDB;";
				stmt.executeUpdate(query);
				
				query = "CREATE TABLE IF NOT EXISTS `madang`.`theater` ("
						  + "`th_id` INT NOT NULL auto_increment,"
						  + "`seats_num` INT NULL,"
						  + "`th_use` TINYINT NULL,"
						  + "PRIMARY KEY (`th_id`))"
						+ "ENGINE = InnoDB;";
				stmt.executeUpdate(query);
				
				query = "CREATE TABLE IF NOT EXISTS `madang`.`schedule` ("
						  + "`sch_id` INT NOT NULL auto_increment,"
						  + "`start_date` DATE NULL,"
						  + "`day_of_week` VARCHAR(10) NULL,"
						  + "`times` INT NULL,"
						  + "`start_time` TIME NULL,"
						  + "`movie_mid` INT NOT NULL ,"
						  + "`theater_th_id` INT NOT NULL ,"
						  + "PRIMARY KEY (`sch_id`),"
						  + "INDEX `fk_schedule_movie1_idx` (`movie_mid` ASC) VISIBLE,"
						  + "INDEX `fk_schedule_theater1_idx` (`theater_th_id` ASC) VISIBLE,"
						  + "CONSTRAINT `fk_schedule_movie1`"
						  + "FOREIGN KEY (`movie_mid`)"
						  + "REFERENCES `madang`.`movie` (`mid`)"
						  + "ON DELETE cascade\r\n"
						  + "ON UPDATE NO ACTION,\r\n"
						  + "CONSTRAINT `fk_schedule_theater1`\r\n"
						  + "FOREIGN KEY (`theater_th_id`)\r\n"
						  + "REFERENCES `madang`.`theater` (`th_id`)\r\n"
						  + "ON DELETE cascade\r\n"
						  + "ON UPDATE NO ACTION)\r\n"
					   + "ENGINE = InnoDB;";
				stmt.executeUpdate(query);
				
				query = "CREATE TABLE IF NOT EXISTS `madang`.`seat` ("
				  + "`seat_id` INT NOT NULL ,"
				  + "`s_use` TINYINT NULL,"
				  + "`theater_th_id` INT NOT NULL,"
				  + "PRIMARY KEY (`seat_id`),"
				  + "INDEX `fk_seat_theater1_idx` (`theater_th_id` ASC) VISIBLE,"
				  + "CONSTRAINT `fk_seat_theater1`"
				  + "FOREIGN KEY (`theater_th_id`)"
				  + "REFERENCES `madang`.`theater` (`th_id`)"
				  + "ON DELETE cascade\r\n"
				  + "ON UPDATE NO ACTION)\r\n"
				+ "ENGINE = InnoDB;";
				stmt.executeUpdate(query);
				
				query = "CREATE TABLE IF NOT EXISTS `madang`.`customer` ("
				  + "`cid` INT NOT NULL auto_increment,"
				  + "`name` VARCHAR(20) NULL,"
				  + "`phone_num` VARCHAR(15) NULL,"
				  + "`email` VARCHAR(20) NULL,"
				  + "PRIMARY KEY (`cid`))"
				+ "ENGINE = InnoDB;";
				stmt.executeUpdate(query);
		
				query = "CREATE TABLE IF NOT EXISTS `madang`.`reservation` ("
						  + "`rid` INT NOT NULL auto_increment,"
						  + "`pay_option` VARCHAR(10) NULL,"
						  + "`pay_status` TINYINT NULL,"
						  + "`pay_price` INT NULL,"
						  + "`pay_date` DATE NULL,"
						  + "`customer_cid` INT NOT NULL,"
						  + "PRIMARY KEY (`rid`),"
						  + "INDEX `fk_reservation_customer1_idx` (`customer_cid` ASC) VISIBLE,"
						  + "CONSTRAINT `fk_reservation_customer1`"
						  + "FOREIGN KEY (`customer_cid`)"
						  + "REFERENCES `madang`.`customer` (`cid`)"
						  + "ON DELETE cascade\r\n"
						  + "ON UPDATE NO ACTION)\r\n"
						+ "ENGINE = InnoDB;";
				stmt.executeUpdate(query);
				
				query = "CREATE TABLE IF NOT EXISTS `madang`.`ticket` ("
						  + "`ti_id` INT NOT NULL auto_increment,"
						  + "`get_ticket` TINYINT NULL,"
						  + " `price` INT NULL,"
						  + "`salesprice` INT NULL,"
						  + "`schedule_sch_id` INT NOT NULL,"
						  + "`theater_th_id` INT NOT NULL,"
						  + "`seat_seat_id` INT NOT NULL,"
						  + "`reservation_rid` INT NOT NULL,"
						  + "\r\n"
						  + "PRIMARY KEY (`ti_id`),"
						  + "INDEX `fk_ticket_seat1_idx` (`seat_seat_id` ASC) VISIBLE,"
						  + "INDEX `fk_ticket_schedule1_idx` (`schedule_sch_id` ASC) VISIBLE,"
						  + "INDEX `fk_ticket_theater1_idx` (`theater_th_id` ASC) VISIBLE,"
						  + "INDEX `fk_ticket_reservation1_idx` (`reservation_rid` ASC) VISIBLE,"
						  + "CONSTRAINT `fk_ticket_seat1`"
						  + "FOREIGN KEY (`seat_seat_id`)"
						  + "REFERENCES `madang`.`seat` (`seat_id`)"
						  + "ON DELETE cascade\r\n"
						  + "ON UPDATE NO ACTION,\r\n"
						  + "CONSTRAINT `fk_ticket_schedule1`"
						  + "FOREIGN KEY (`schedule_sch_id`)"
						  + "REFERENCES `madang`.`schedule` (`sch_id`)"
						  + "ON DELETE cascade\r\n"
						  + "ON UPDATE NO ACTION,"
						  + "CONSTRAINT `fk_ticket_theater1`"
						  + "FOREIGN KEY (`theater_th_id`)"
						  + "REFERENCES `madang`.`theater` (`th_id`)"
						  + "ON DELETE cascade\r\n"
						  + "ON UPDATE NO ACTION,"
						  + "CONSTRAINT `fk_ticket_reservation1`"
						  + "FOREIGN KEY (`reservation_rid`)"
						  + "REFERENCES `madang`.`reservation` (`rid`)"
						  + "ON DELETE cascade\r\n"
						  + "ON UPDATE NO ACTION)"
						+ "ENGINE = InnoDB;";
				stmt.executeUpdate(query);				
				
				query = "commit;";
				stmt.executeUpdate(query);
				
				
				query = "INSERT INTO customer VALUES"
						+ "(1,'강동원','010-1234-1234','dongwon@magang.com'),"
						+ "(2,'한소희','010-4321-4321','so_hui@madang.com'),"
						+ "(3,'김태희','010-2345-4562','thkim@madang.com'),"
						+ "(4,'이정재','010-2022-0527','leejj@madang.com'),"
						+ "(5,'박해수','010-9874-9658','haesu@madang.com'),"
						+ "(6, '오영수','010-3254-6548','0youngsu@madang.com'),"
						+ "(7, '정호연','010-6532-8654','hoyeon@madang.com'),"
						+ "(8, '김주령','010-2385-6856','kimjr@madang.com'),"
						+ "(9, '허성태','010-9635-2587','heost@hadang.com'),"
						+ "(10, '이유미','010-1478-8524','youme@madang.com')";
				stmt.executeUpdate(query);
				
				query = "INSERT INTO movie VALUES"
						+ "(1, '범죄도시2', 106 , '15세 관람가', '이상용', '마동석', '액션' ,'가리봉동 소탕작전 후 4년 뒤, 금천서 강력반은 베트남으로 도주한 용의자를 인도받아 오라는 미션을 받는다.', '2021-01-01'),"
						+ "(2, '배드 가이즈', 100, '전체 관람가', '피에르 페리펠', '샘 록웰', '애니메이션', '나쁜 녀석들의 사상 초유 바른 생활 갓생 프로젝트가 시작된다!','2021-02-01'),"
						+ "(3,'해리포터', 152,'전체관람가','크리스 콜럼버스','다니엘 래드클리프','판타지','해리는 볼드모트로부터 마법의 돌과 호그와트 마법학교를 지키기 위해 필사의 노력을 하는데...','2021-03-01'),"
						+ "(4,'반지의 제왕',228,'12세 관람가','피터 잭슨','일라이저 우드','판타지','반지원정대는 드디어 거대한 최후의 전쟁을 시작하는데...','2021-04-01'),"
						+ "(5,'기생충',131,'15세 관람가','봉준호','송강호','드라마','전원백수로 살 길 막막하지만 사이는 좋은 기택(송강호) 가족.','2021-05-01'),"
						+ "(6,'타짜',139,'청소년 관람불가','최동훈','조승우','범죄',' 각자의 원한과 욕망, 그리고 덧없는 희망, 이 모든 것이 뒤엉킨 한 판이 시작된다..! ','2021-06-01'),"
						+ "(7,'부산행',118,'15세 관람가','연상호','공유','액션','서울에서 부산까지의 거리 442KM 지키고 싶은, 지켜야만 하는 사람들의 극한의 사투!','2021-07-01'),"
						+ "(8,'어벤저스',142,'12세 관람가','조스 웨던','로버트 다우니 주니어','액션','지구의 운명을 건 거대한 전쟁이 시작된다!','2021-08-01'),"
						+ "(9,'라라랜드',127,'12세 관람가','데이미언 셔젤','라이언 고슬링','드라마','꿈을 꾸는 사람들을 위한 별들의 도시 ‘라라랜드’. ','2021-09-01'),"
						+ "(10,'킹스맨',128,'청소년 관람불가','메튜 본','콜린 퍼스','액션','세상에서 가장 위험한 면접이 시작된다!','2021-10-01')";
				stmt.executeUpdate(query);

				query = "INSERT INTO theater VALUES"
						+ "(1,2,1),"
						+ "(2,2,1),"
						+ "(3,2,1),"
						+ "(4,2,1),"
						+ "(5,2,1),"
						+ "(6,2,1),"
						+ "(7,2,1),"
						+ "(8,2,1),"
						+ "(9,2,1),"
						+ "(10,2,1)";
				stmt.executeUpdate(query);
				
				query = "INSERT INTO seat VALUES"
						+ "(11,1,1),"
						+ "(12,0,1),"
						+ "(21,1,2),"
						+ "(22,0,2),"
						+ "(31,1,3),"
						+ "(32,0,3),"
						+ "(41,1,4),"
						+ "(42,0,4),"
						+ "(51,1,5),"
						+ "(52,0,5),"
						+ "(61,0,6),"
						+ "(62,1,6),"
						+ "(71,0,7),"
						+ "(72,1,7),"
						+ "(81,0,8),"
						+ "(82,1,8),"
						+ "(91,0,9),"
						+ "(92,1,9),"
						+ "(101,0,10),"
						+ "(102,1,10);";
				stmt.executeUpdate(query);
				
				query = "INSERT INTO schedule VALUES"
						+ "(1,'2022-04-01','금요일',1,'10:00',1,1),"
						+ "(2,'2022-04-02','토요일',1,'11:00',2,2),"
						+ "(3,'2022-04-03','일요일',1,'12:00',3,3),"
						+ "(4,'2022-04-04','월요일',1,'13:00',4,4),"
						+ "(5,'2022-04-05','화요일',1,'14:00',5,5),"
						+ "(6,'2022-04-06','수요일',1,'15:00',6,6),"
						+ "(7,'2022-04-07','목요일',1,'16:00',7,7),"
						+ "(8,'2022-04-08','금요일',1,'17:00',8,8),"
						+ "(9,'2022-04-09','토요일',1,'18:00',9,9),"
						+ "(10,'2022-04-10','일요일',1,'19:00',10,10)";
				stmt.executeUpdate(query);
				
				query = "INSERT INTO reservation VALUES"
						+ "(1,'현금',1,10000,'2022-04-01',1),"
						+ "(2,'카드',1,8000,'2022-04-02',2),"
						+ "(3,'현금',1,12000,'2022-04-03',3),"
						+ "(4,'현금',1,8000,'2022-04-04',4),"
						+ "(5,'현금',1,14000,'2022-04-05',5),"
						+ "(6,'카드',1,20000,'2022-04-06',6),"
						+ "(7,'카드',0,10000,'2022-04-07',7),"
						+ "(8,'현금',0,8000,'2022-04-08',8),"
						+ "(9,'카드',0,12000,'2022-04-09',9),"
						+ "(10,'현금',0,8000,'2022-04-10',10)";
				stmt.executeUpdate(query);
				
				query = "INSERT INTO ticket VALUES"
						+ "(1,1,10000,10000,1,1,11,1),"
						+ "(2,1,8000,8000,2,2,21,2),"
						+ "(3,1,12000,12000,3,3,31,3),"
						+ "(4,1,8000,8000,4,4,41,4),"
						+ "(5,1,14000,14000,5,5,51,5),"
						+ "(6,1,20000,20000,6,6,62,6),"
						+ "(7,0,10000,10000,7,7,72,7),"
						+ "(8,0,8000,8000,8,8,82,8),"
						+ "(9,0,12000,12000,9,9,92,9),"
						+ "(10,0,8000,8000,10,10,102,10)";
				stmt.executeUpdate(query);
				
				query = "commit;";
				stmt.executeUpdate(query);
				
				System.out.println("초기화 완료!");
			}
			catch (Exception e1) {
				System.out.println("Error: 초기화 중 오류가 발생했습니다. " + e1 + "\n");
			}
		}
}