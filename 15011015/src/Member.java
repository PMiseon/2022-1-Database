import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("serial")
public class Member extends JPanel { 
   //로그인에 사용할 정보 
   public String name;
   public String phone_num;
   public String movieName;
   public int seatNum;
   public int theaterNum;
   public int scheduleNum;
   public String movie_search;
   public int change_seat;
   public int change_sch;
   public int change_the;
   public int customer_id = 0;
   
   Member () {
	   member_gui();
   }
   
   //기본틀 구현하기 
   //저는 중간고사 때 사용했던 틀을 활용해서 사용했어요 
   public void member_gui()
   {
        setLayout(null);

        //로그인 입력창 
        //이름과 전화번호를 이용하였습니다. 
        JLabel l1 = new JLabel();
        l1.setSize(100,30);
        l1.setLocation(20,10);
        add(l1);
        l1.setText("이름");
        
        JTextField tf1 = new JTextField(); 
        tf1.setSize(100,30);
        tf1.setLocation(60,10);
        add(tf1);
        //tf1.setText("이름");
        tf1.setText("이름");
        
        JLabel l2 = new JLabel();
        l2.setSize(100,30);
        l2.setLocation(180,10);
        add(l2);
        l2.setText("전화번호");
        
        JTextField tf2 = new JTextField();
        tf2.setSize(200,30);
        tf2.setLocation(240,10);
        add(tf2);
        tf2.setText("010-0000-0000");
        //tf2.setText("전화번호(010-0000-0000)");

        
        //변경하려는 내용 (변경전 + 예매에 사용하는 입력창)
        JLabel info_1 = new JLabel();
        info_1.setLocation(300,120);
        info_1.setSize(500,50);
        add(info_1);
        info_1.setText("변경후의 값을 하단에 입력하세요.");
        
        JLabel l4 = new JLabel();
        l4.setSize(100,30);
        l4.setLocation(20,90);
        add(l4);
        l4.setText("상영관번호");
        
        JTextField tf4 = new JTextField(); 
        tf4.setSize(100,30);
        tf4.setLocation(100,90);
        add(tf4);
        tf4.setText("상영관번호");
        
        JLabel l5 = new JLabel();
        l5.setSize(100,30);
        l5.setLocation(240,90);
        add(l5);
        l5.setText("좌석번호");
        
        JTextField tf5 = new JTextField(); 
        tf5.setSize(100,30);
        tf5.setLocation(300,90);
        add(tf5);
        tf5.setText("좌석번호");
        
        JLabel l_sch = new JLabel();
        l_sch.setSize(100,30);
        l_sch.setLocation(440,90);
        add(l_sch);
        l_sch.setText("상영스케줄");
        
        JTextField tf_sch = new JTextField(); 
        tf_sch.setSize(100,30);
        tf_sch.setLocation(510,90);
        add(tf_sch);
        tf_sch.setText("상영스케줄");
        
        
        //변경할 내용 입력하기 (변경후 내용)
        JLabel c4 = new JLabel();
        c4.setSize(100,30);
        c4.setLocation(20,160);
        add(c4);
        c4.setText("상영관번호");
        
        JTextField tf_c4 = new JTextField(); 
        tf_c4.setSize(100,30);
        tf_c4.setLocation(100,160);
        add(tf_c4);
        tf_c4.setText("상영관번호");
        
        JLabel c5 = new JLabel();
        c5.setSize(100,30);
        c5.setLocation(240,160);
        add(c5);
        c5.setText("좌석번호");
        
        JTextField tf_c5 = new JTextField(); 
        tf_c5.setSize(100,30);
        tf_c5.setLocation(300,160);
        add(tf_c5);
        tf_c5.setText("좌석번호");
        
        JLabel l_c_sch = new JLabel();
        l_c_sch.setSize(100,30);
        l_c_sch.setLocation(440,160);
        add(l_c_sch);
        l_c_sch.setText("상영스케줄");
        
        JTextField tf_c_sch = new JTextField(); 
        tf_c_sch.setSize(100,30);
        tf_c_sch.setLocation(510,160);
        add(tf_c_sch);
        tf_c_sch.setText("상영스케줄");
        
       
        
        //영화 정보 찾기 
        //영화에 대해서 조회할 내용을 검색한다. 
        JLabel l_search = new JLabel();
        l_search.setSize(100,30);
        l_search.setLocation(20,50);
        add(l_search);
        l_search.setText("영화조회");
        
        JTextField tf_search = new JTextField(); 
        tf_search.setSize(200,30);
        tf_search.setLocation(80,50);
        add(tf_search);
        tf_search.setText("영화조회(영화이름)");
        
 
        
        JTextArea ta = new JTextArea(); //출력창
        JScrollPane jsp = new JScrollPane(ta);
        jsp.setSize(1220,190);
        jsp.setLocation(20,200);
        
        //jframe.add(jsp);
      	add(jsp);
        ta.append("이름과 전화번호를 입력해주세요. \n");
        jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
        
        //회원정보 로그인하기 
        //입력버튼
        //입력버튼 다시 해야합니다~
        JButton btn_login = new JButton("로그인");
        add(btn_login);
        btn_login.setBounds(450,10,100,30);
        btn_login.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent args) {
            
        	   name = tf1.getText();
        	   phone_num = tf2.getText();
            
        	   //ta.append(name+"님이 로그인되었습니다.");
        	   String query = "select cid from customer where (name = '"+name+"')and (phone_num = '"+phone_num+"');";
               try 
               {
            	   Statement stmt=FirstInit.con.createStatement();
                   ResultSet rs=stmt.executeQuery(query);
                 
                   
                   while(rs.next()) {
                      
                	   customer_id = rs.getInt(1);
                	
                	  ta.append("customer id:"+customer_id+"\n"+name+"님 환영합니다.\n"); 
                	  //로그인에 성공한 경우 표시될 문구 
                	  jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
               
                       }
            	   
               }catch(SQLException k) {
                  k.printStackTrace();
               }
 
            }    
           });
        
        //기능 1번
        //모든 영화에 대한 조회 기능 : 영화명, 감독명, 배우명, 장르 
        //조회하고자 하는 검색어를 영화 조회칸에 입력한 후 영화조회 버튼을 클릭하면 해당 정보가 포함된 내용 출력
        JButton b0 = new JButton("영화 조회");
        add(b0);
        b0.setBounds(480,50,100, 30);
        
        b0.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent a) {
            	//
            	movie_search = tf_search.getText();
                String query_movie = "select * from movie \r\n"
                		+ "where (mname = '"+movie_search+"' ) or \r\n"
                		+ "( director_name = '"+movie_search+"') or \r\n"
                		+ "(actname = '"+movie_search+"') or \r\n"
                		+ "(genre = '"+movie_search+"');";
                 try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
                     Statement stmt=FirstInit.con.createStatement();
                     ResultSet rs=stmt.executeQuery(query_movie);
                     ta.append("영화명\t\t 감독명\t\t 배우명\t\t 장르 \n");
                     jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
                     
                     while(rs.next()) {
                        ta.append(rs.getString(2)+"\t\t");
                        ta.append(rs.getString(5)+"\t\t");
                        ta.append(rs.getString(6)+"\t\t");
                        ta.append(rs.getString(7)+"\t\n");                     
                        jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
                     }
                     ta.append("----------------------------------------\n");
                    // ta.append("영화 예매 방법\n");
                    // ta.append("영화 이름을 넣고 상영관 좌석 조회 버튼을 누릅니다.\n");
                    // ta.append("상영관번호와 좌석번호를 입력한 후 예매하기를 누릅니다.\n");
                     jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
                     //con.close();
                 } catch(SQLException k) {
                       k.printStackTrace();
                   }
              
             
            }
 
        });
        
        JButton b_ticket = new JButton("티켓조회"); //티켓에 대한 정보를 조회하는 기능 
        add(b_ticket);
        b_ticket.setBounds(600,50,100, 30);
        
        b_ticket.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent a) {
            	//
            	movie_search = tf_search.getText();
                String query_ticket = "select ti_id, salesprice, schedule_sch_id,theater_th_id, seat_seat_id from ticket where ( reservation_rid = some\r\n"
                		+ "(select rid from reservation where (customer_cid = "+customer_id+")));";
                 try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
                     Statement stmt=FirstInit.con.createStatement();
                     ResultSet rs=stmt.executeQuery(query_ticket);
                     ta.append("티켓번호\t\t 판매가격\t\t 스케줄\t\t상영관 번호\t\t좌석번호 \n");
                     jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
                     
                     while(rs.next()) {
                        ta.append(rs.getString(1)+"\t\t");
                        ta.append(rs.getString(2)+"\t\t");
                        ta.append(rs.getString(3)+"\t\t");
                        ta.append(rs.getString(4)+"\t\t");
                        ta.append(rs.getString(5)+"\t\n");
                        jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
                     }
                     ta.append("----------------------------------------\n");
                    // ta.append("영화 예매 방법\n");
                    // ta.append("영화 이름을 넣고 상영관 좌석 조회 버튼을 누릅니다.\n");
                    // ta.append("상영관번호와 좌석번호를 입력한 후 예매하기를 누릅니다.\n");
                     jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
                     //con.close();
                 } catch(SQLException k) {
                       k.printStackTrace();
                   }
              
             
            }
 
        });
        //기능2번 
        //위에서 조회한 영화에 대한 예매 기능
       //영화이름을 넣고 조회하기를 누르면 상영관과 좌석을 조회할 수 있다. 
        JButton b2_1 = new JButton("상영관 좌석 조회");
        add(b2_1);
        b2_1.setBounds(300,50,150,30);
        
        b2_1.addActionListener(new ActionListener() {
            
        	
        	
            @Override
            public void actionPerformed(ActionEvent a) {
            	movieName = tf_search.getText();
                String query_movie = "select sch_id, seat.theater_th_id, seat_id, s_use from seat , schedule \r\n"
                		+ "where (seat.theater_th_id = schedule.theater_th_id) and \r\n"
                		+ "(schedule.movie_mid = (select mid from movie where mname = '"+movieName+"'));";
              
                 try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
                     Statement stmt=FirstInit.con.createStatement();
                     ResultSet rs=stmt.executeQuery(query_movie);
                     ta.append("상영스케줄\t상영관\t 좌석번호\t 사용여부 \n");
                     jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
                
                     while(rs.next()) {
                        ta.append(rs.getInt(1)+"\t");
                        ta.append(rs.getInt(2)+"\t");
                        ta.append(rs.getInt(3)+"\t");
                        {if(rs.getInt(4) == 0)
                        	 ta.append("사용가능\n");
                        //사용중이지 않은 경우 s_use = 0 -> 사용이 가능함을 출력한다.
                        else if(rs.getInt(4)==1)
                        	ta.append("사용중\n");}
                        //사용중인 경우 s_use = 1 -> 이미 사용되고 있음을 출력한다. 
                        	
                        jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
                     }
                     ta.append("----------------------------------------\n");
                     jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
                     //con.close();
                 } catch(SQLException k) {
                       k.printStackTrace();
                   }
              
             
            }
 
        });
        
        JButton book_b = new JButton("예매하기");
        add(book_b);
        book_b.setBounds(750, 90,120,30);
        book_b.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent a) {
            	
            	theaterNum = Integer.parseInt(tf4.getText()); //상영관번호
            	seatNum = Integer.parseInt(tf5.getText()); //좌석번호
            	 movieName = tf_search.getText(); //영화이름
            	 scheduleNum = Integer.parseInt(tf_sch.getText()); //스케줄번호
            
            	String book1 = "insert into reservation(pay_price,pay_date,customer_cid,pay_status) "
            			+ "values(5000,Date(sysdate()),"+customer_id+",1);";
            	//reservation 테이블에 정보 입력 
            	String book2 = "insert into ticket(salesprice,price, schedule_sch_id, theater_th_id,seat_seat_id, reservation_rid)\r\n"
            			+ "values (5000, 5000,"+ scheduleNum +","+theaterNum+","+seatNum+",(select max(rid) from reservation));";
//            	String book3 = "update ticket set reservation_rid = (select max(rid) from reservation) where ti_id = (select max(rid) from reservation);";
            	//ticket 테이블에 정보 입력하여 티켓을 만든다. 
            	//ticket_id와 reservation_id는 동일하므로 먼저 만들어진 reservation_id 중 가장 최근의 정보를 이용한다. 
            	//select max(rid) from reservation 
            	String book4 = "update theater set th_use = th_use -1 where th_id = "
            			+ "(select seat.theater_th_id from seat where seat_id = "+seatNum+");"; 
            	//예매되었으므로 좌석이 사용되었음을 나타낸다. 1->0 
            	String book5 = "update seat set s_use = 1 where seat_id = "+seatNum+";";
            	//예매할 수 있는 좌석의 수가 하나 줄어듦을 표시한다. 
            	 try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
                     Statement stmt=FirstInit.con.createStatement();
                  
                     stmt.executeUpdate(book1);
                     stmt.executeUpdate(book2);
                     //stmt.executeUpdate(book3);
                     stmt.executeUpdate(book4);
                     stmt.executeUpdate(book5);
                     
                 
                     ta.append("예매되었습니다.\n");
                     jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
                     //con.close();
                 } catch(SQLException k) {
                       k.printStackTrace();
                   }
                     }
            
        });

            
        //기능 3번
        //본인이 예매한 영화에 대해서 영화명, 상영일, 상영관번호, 좌석번호 및 판매가격 정보를 보여주는 기능
        JButton b3 = new JButton("예매한 영화 확인");
        add(b3);
        b3.setBounds(580,10,200,30);
        
        b3.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent a) {
                String query_movie = "select mname,  start_date, s.theater_th_id,seat_seat_id, salesprice from movie m, reservation r, ticket t, schedule s\r\n"
                		+ "where (t.reservation_rid = r.rid)and(t.schedule_sch_id = s.sch_id)and(s.movie_mid = m.mid)\r\n"
                		+ "and(r.customer_cid = "+ customer_id +"); ";
              
              
                 try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
                     Statement stmt=FirstInit.con.createStatement();
                     ResultSet rs=stmt.executeQuery(query_movie);
                     ta.append("영화명\t\t 상영일\t\t 상영관번호\t\t 좌석번호\t\t 판매가격 \n");
                     jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
                     
                     while(rs.next()) {
                    	
                        ta.append(rs.getString(1)+"\t\t");
                        ta.append(rs.getString(2)+"\t\t");
                        ta.append(rs.getString(3)+"\t\t");
                        ta.append(rs.getString(4)+"\t\t");
                        ta.append(rs.getString(5)+"\t\n");
                        //if(rs.getString(5) == null)
                        	//ta.append("null\t\n");
                        jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
                     }
                     ta.append("----------------------------------------\n");
                     jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
                     //con.close();
                 } catch(SQLException k) {
                       //k.printStackTrace();
                   }
              
              
            }
 
        });


        //기능 5번 
        //본인이 예매한 영화에 대하여 조회하고 한 개 이상의 예매 정보를 삭제하는 기능
        JButton b5 = new JButton("예매내역 삭제");
        add(b5);
        b5.setBounds(620,90,120,30);
        
        b5.addActionListener(new ActionListener() {
            
        	
        	
            @Override
            public void actionPerformed(ActionEvent a) {
            	
            	theaterNum = Integer.parseInt(tf4.getText()); //상영관번호
            	seatNum = Integer.parseInt(tf5.getText()); //좌석번호
            	//scheduleNum = Integer.parseInt(tf_sch.getText()); //스케줄번호
            
            	String delete_query = "delete from reservation where ( reservation.rid = \r\n"
            			+ "(select ticket.reservation_rid from ticket \r\n"
            			+ "where ((theater_th_id = "+theaterNum+") \r\n"
            			+ "and (seat_seat_id ="+seatNum+"))));";
            	//삭제하고자 하는 상영관 번호, 좌석 번호, 상영스케줄을 입력한 한 후 delete query를 이용하여 삭제한다. 
            	//delete from reservation만 수행했지만 on delete cascade 
            	String delete_seat = "update seat set s_use = 0 where( seat_id =" + seatNum + ");\n";
            	//좌석이 다시 공석이 되므로 예매할 수 있는 상태가 되었음을 표시한다. 
            	String update_count = "update theater set th_use = th_use - 1 where (th_id = "+theaterNum+");";
            	//사용돠고 있는 좌석의 수가 하나 줄어든다. theater 테이블에서 해당 th_id에서 사용되고 있는 좌석의 수가 하나 줄어들었음을 반영한다. 
            	
            	 try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
                     Statement stmt=FirstInit.con.createStatement();
                  
                    stmt.executeUpdate(delete_query);
                    stmt.executeUpdate(delete_seat);
                    stmt.executeUpdate(update_count);
                     ta.append("삭제되었습니다.\n");
                     jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
                     //con.close();
                 } catch(SQLException k) {
                       k.printStackTrace();
                   }
                     }
            
        });
        
        
        //본인이 예매한 영화에 대하여 조회하여 
        //다른 영화 또는 다른 상영 일정으로 변경할 수 있도록 한다.
        
        JButton changebtn = new JButton("예매내역 변경하기");
        add(changebtn);
        changebtn.setBounds(620,160,200,30);
        
        changebtn.addActionListener(new ActionListener() {
            
        	
        	
            @Override
            public void actionPerformed(ActionEvent a) {
            
            	theaterNum = Integer.parseInt(tf4.getText()); //상영관번호
            	seatNum = Integer.parseInt(tf5.getText()); //좌석번호
            	scheduleNum = Integer.parseInt(tf_sch.getText()); //스케줄번호
            	
            	change_seat = Integer.parseInt(tf_c5.getText()); //변경할 좌석번호 
            	change_the = Integer.parseInt(tf_c4.getText()); //변경할 상영관번호
            	change_sch = Integer.parseInt(tf_c_sch.getText()); //변경할 스케줄 번호 
            	
            
            	String change_t = "update ticket \r\n"
            			+ "set schedule_sch_id = "+change_sch+"\r\n"
            			+ ",theater_th_id = "+change_the+" \r\n"
            			+ ",seat_seat_id = "+change_seat+" \r\n"
            			+ "where(ticket.theater_th_id ="+theaterNum+"\r\n"
            			+ ")and (ticket.seat_seat_id = "+seatNum+"\r\n"
            			+ ");";
            	//ticket의 내용에서 예전의 값에서 변경할 값으로 update해준다. 
            	
            	String change_th1 = "update theater \r\n"
            			+ "set th_use = th_use + 1\r\n"
            			+ "where th_id = "+change_the+";";
            	String change_th2 = "update theater \r\n"
            			+ "set th_use = th_use - 1\r\n"
            			+ "where th_id = "+theaterNum+";";
            	//이전에 사용하던 상영관의 사용하는 좌석수를 하나 감소시키고, 
            	//새로 예매된 상영관의 사용하는 좌석수를 하나 증가시킨다. 
            	
            	String change_s1 = "update seat \r\n"
            			+ "set s_use = 0 \r\n"
            			+ "where seat_id = "+seatNum+";";
            	String change_s2 = "update seat\r\n"
            			+ "set s_use = 1\r\n"
            			+ "where seat_id = "+change_seat+";";
            	//seat 테이블에서 이전에 예매했던 좌석을 0으로 새로 예매한 좌석을 1로 변경시킨다. 
            	
            	
            	 try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
                     Statement stmt=FirstInit.con.createStatement();
                  
             
                    stmt.executeUpdate(change_th1);
                    stmt.executeUpdate(change_th2);
                    stmt.executeUpdate(change_s1);
                    stmt.executeUpdate(change_s2);
                    
                    stmt.executeUpdate(change_t);
                   
                     ta.append("변경되었습니다.\n");
                     jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
                     //con.close();
                 } catch(SQLException k) {
                       k.printStackTrace();
                   }
            }
           
        });


   }
}
