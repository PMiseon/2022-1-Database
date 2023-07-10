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
   //�α��ο� ����� ���� 
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
   
   //�⺻Ʋ �����ϱ� 
   //���� �߰���� �� ����ߴ� Ʋ�� Ȱ���ؼ� ����߾�� 
   public void member_gui()
   {
        setLayout(null);

        //�α��� �Է�â 
        //�̸��� ��ȭ��ȣ�� �̿��Ͽ����ϴ�. 
        JLabel l1 = new JLabel();
        l1.setSize(100,30);
        l1.setLocation(20,10);
        add(l1);
        l1.setText("�̸�");
        
        JTextField tf1 = new JTextField(); 
        tf1.setSize(100,30);
        tf1.setLocation(60,10);
        add(tf1);
        //tf1.setText("�̸�");
        tf1.setText("�̸�");
        
        JLabel l2 = new JLabel();
        l2.setSize(100,30);
        l2.setLocation(180,10);
        add(l2);
        l2.setText("��ȭ��ȣ");
        
        JTextField tf2 = new JTextField();
        tf2.setSize(200,30);
        tf2.setLocation(240,10);
        add(tf2);
        tf2.setText("010-0000-0000");
        //tf2.setText("��ȭ��ȣ(010-0000-0000)");

        
        //�����Ϸ��� ���� (������ + ���ſ� ����ϴ� �Է�â)
        JLabel info_1 = new JLabel();
        info_1.setLocation(300,120);
        info_1.setSize(500,50);
        add(info_1);
        info_1.setText("�������� ���� �ϴܿ� �Է��ϼ���.");
        
        JLabel l4 = new JLabel();
        l4.setSize(100,30);
        l4.setLocation(20,90);
        add(l4);
        l4.setText("�󿵰���ȣ");
        
        JTextField tf4 = new JTextField(); 
        tf4.setSize(100,30);
        tf4.setLocation(100,90);
        add(tf4);
        tf4.setText("�󿵰���ȣ");
        
        JLabel l5 = new JLabel();
        l5.setSize(100,30);
        l5.setLocation(240,90);
        add(l5);
        l5.setText("�¼���ȣ");
        
        JTextField tf5 = new JTextField(); 
        tf5.setSize(100,30);
        tf5.setLocation(300,90);
        add(tf5);
        tf5.setText("�¼���ȣ");
        
        JLabel l_sch = new JLabel();
        l_sch.setSize(100,30);
        l_sch.setLocation(440,90);
        add(l_sch);
        l_sch.setText("�󿵽�����");
        
        JTextField tf_sch = new JTextField(); 
        tf_sch.setSize(100,30);
        tf_sch.setLocation(510,90);
        add(tf_sch);
        tf_sch.setText("�󿵽�����");
        
        
        //������ ���� �Է��ϱ� (������ ����)
        JLabel c4 = new JLabel();
        c4.setSize(100,30);
        c4.setLocation(20,160);
        add(c4);
        c4.setText("�󿵰���ȣ");
        
        JTextField tf_c4 = new JTextField(); 
        tf_c4.setSize(100,30);
        tf_c4.setLocation(100,160);
        add(tf_c4);
        tf_c4.setText("�󿵰���ȣ");
        
        JLabel c5 = new JLabel();
        c5.setSize(100,30);
        c5.setLocation(240,160);
        add(c5);
        c5.setText("�¼���ȣ");
        
        JTextField tf_c5 = new JTextField(); 
        tf_c5.setSize(100,30);
        tf_c5.setLocation(300,160);
        add(tf_c5);
        tf_c5.setText("�¼���ȣ");
        
        JLabel l_c_sch = new JLabel();
        l_c_sch.setSize(100,30);
        l_c_sch.setLocation(440,160);
        add(l_c_sch);
        l_c_sch.setText("�󿵽�����");
        
        JTextField tf_c_sch = new JTextField(); 
        tf_c_sch.setSize(100,30);
        tf_c_sch.setLocation(510,160);
        add(tf_c_sch);
        tf_c_sch.setText("�󿵽�����");
        
       
        
        //��ȭ ���� ã�� 
        //��ȭ�� ���ؼ� ��ȸ�� ������ �˻��Ѵ�. 
        JLabel l_search = new JLabel();
        l_search.setSize(100,30);
        l_search.setLocation(20,50);
        add(l_search);
        l_search.setText("��ȭ��ȸ");
        
        JTextField tf_search = new JTextField(); 
        tf_search.setSize(200,30);
        tf_search.setLocation(80,50);
        add(tf_search);
        tf_search.setText("��ȭ��ȸ(��ȭ�̸�)");
        
 
        
        JTextArea ta = new JTextArea(); //���â
        JScrollPane jsp = new JScrollPane(ta);
        jsp.setSize(1220,190);
        jsp.setLocation(20,200);
        
        //jframe.add(jsp);
      	add(jsp);
        ta.append("�̸��� ��ȭ��ȣ�� �Է����ּ���. \n");
        jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
        
        //ȸ������ �α����ϱ� 
        //�Է¹�ư
        //�Է¹�ư �ٽ� �ؾ��մϴ�~
        JButton btn_login = new JButton("�α���");
        add(btn_login);
        btn_login.setBounds(450,10,100,30);
        btn_login.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent args) {
            
        	   name = tf1.getText();
        	   phone_num = tf2.getText();
            
        	   //ta.append(name+"���� �α��εǾ����ϴ�.");
        	   String query = "select cid from customer where (name = '"+name+"')and (phone_num = '"+phone_num+"');";
               try 
               {
            	   Statement stmt=FirstInit.con.createStatement();
                   ResultSet rs=stmt.executeQuery(query);
                 
                   
                   while(rs.next()) {
                      
                	   customer_id = rs.getInt(1);
                	
                	  ta.append("customer id:"+customer_id+"\n"+name+"�� ȯ���մϴ�.\n"); 
                	  //�α��ο� ������ ��� ǥ�õ� ���� 
                	  jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
               
                       }
            	   
               }catch(SQLException k) {
                  k.printStackTrace();
               }
 
            }    
           });
        
        //��� 1��
        //��� ��ȭ�� ���� ��ȸ ��� : ��ȭ��, ������, ����, �帣 
        //��ȸ�ϰ��� �ϴ� �˻�� ��ȭ ��ȸĭ�� �Է��� �� ��ȭ��ȸ ��ư�� Ŭ���ϸ� �ش� ������ ���Ե� ���� ���
        JButton b0 = new JButton("��ȭ ��ȸ");
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
                 try { /* �����ͺ��̽��� ���� ����� �������� ���� */
                     Statement stmt=FirstInit.con.createStatement();
                     ResultSet rs=stmt.executeQuery(query_movie);
                     ta.append("��ȭ��\t\t ������\t\t ����\t\t �帣 \n");
                     jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
                     
                     while(rs.next()) {
                        ta.append(rs.getString(2)+"\t\t");
                        ta.append(rs.getString(5)+"\t\t");
                        ta.append(rs.getString(6)+"\t\t");
                        ta.append(rs.getString(7)+"\t\n");                     
                        jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
                     }
                     ta.append("----------------------------------------\n");
                    // ta.append("��ȭ ���� ���\n");
                    // ta.append("��ȭ �̸��� �ְ� �󿵰� �¼� ��ȸ ��ư�� �����ϴ�.\n");
                    // ta.append("�󿵰���ȣ�� �¼���ȣ�� �Է��� �� �����ϱ⸦ �����ϴ�.\n");
                     jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
                     //con.close();
                 } catch(SQLException k) {
                       k.printStackTrace();
                   }
              
             
            }
 
        });
        
        JButton b_ticket = new JButton("Ƽ����ȸ"); //Ƽ�Ͽ� ���� ������ ��ȸ�ϴ� ��� 
        add(b_ticket);
        b_ticket.setBounds(600,50,100, 30);
        
        b_ticket.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent a) {
            	//
            	movie_search = tf_search.getText();
                String query_ticket = "select ti_id, salesprice, schedule_sch_id,theater_th_id, seat_seat_id from ticket where ( reservation_rid = some\r\n"
                		+ "(select rid from reservation where (customer_cid = "+customer_id+")));";
                 try { /* �����ͺ��̽��� ���� ����� �������� ���� */
                     Statement stmt=FirstInit.con.createStatement();
                     ResultSet rs=stmt.executeQuery(query_ticket);
                     ta.append("Ƽ�Ϲ�ȣ\t\t �ǸŰ���\t\t ������\t\t�󿵰� ��ȣ\t\t�¼���ȣ \n");
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
                    // ta.append("��ȭ ���� ���\n");
                    // ta.append("��ȭ �̸��� �ְ� �󿵰� �¼� ��ȸ ��ư�� �����ϴ�.\n");
                    // ta.append("�󿵰���ȣ�� �¼���ȣ�� �Է��� �� �����ϱ⸦ �����ϴ�.\n");
                     jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
                     //con.close();
                 } catch(SQLException k) {
                       k.printStackTrace();
                   }
              
             
            }
 
        });
        //���2�� 
        //������ ��ȸ�� ��ȭ�� ���� ���� ���
       //��ȭ�̸��� �ְ� ��ȸ�ϱ⸦ ������ �󿵰��� �¼��� ��ȸ�� �� �ִ�. 
        JButton b2_1 = new JButton("�󿵰� �¼� ��ȸ");
        add(b2_1);
        b2_1.setBounds(300,50,150,30);
        
        b2_1.addActionListener(new ActionListener() {
            
        	
        	
            @Override
            public void actionPerformed(ActionEvent a) {
            	movieName = tf_search.getText();
                String query_movie = "select sch_id, seat.theater_th_id, seat_id, s_use from seat , schedule \r\n"
                		+ "where (seat.theater_th_id = schedule.theater_th_id) and \r\n"
                		+ "(schedule.movie_mid = (select mid from movie where mname = '"+movieName+"'));";
              
                 try { /* �����ͺ��̽��� ���� ����� �������� ���� */
                     Statement stmt=FirstInit.con.createStatement();
                     ResultSet rs=stmt.executeQuery(query_movie);
                     ta.append("�󿵽�����\t�󿵰�\t �¼���ȣ\t ��뿩�� \n");
                     jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
                
                     while(rs.next()) {
                        ta.append(rs.getInt(1)+"\t");
                        ta.append(rs.getInt(2)+"\t");
                        ta.append(rs.getInt(3)+"\t");
                        {if(rs.getInt(4) == 0)
                        	 ta.append("��밡��\n");
                        //��������� ���� ��� s_use = 0 -> ����� �������� ����Ѵ�.
                        else if(rs.getInt(4)==1)
                        	ta.append("�����\n");}
                        //������� ��� s_use = 1 -> �̹� ���ǰ� ������ ����Ѵ�. 
                        	
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
        
        JButton book_b = new JButton("�����ϱ�");
        add(book_b);
        book_b.setBounds(750, 90,120,30);
        book_b.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent a) {
            	
            	theaterNum = Integer.parseInt(tf4.getText()); //�󿵰���ȣ
            	seatNum = Integer.parseInt(tf5.getText()); //�¼���ȣ
            	 movieName = tf_search.getText(); //��ȭ�̸�
            	 scheduleNum = Integer.parseInt(tf_sch.getText()); //�����ٹ�ȣ
            
            	String book1 = "insert into reservation(pay_price,pay_date,customer_cid,pay_status) "
            			+ "values(5000,Date(sysdate()),"+customer_id+",1);";
            	//reservation ���̺� ���� �Է� 
            	String book2 = "insert into ticket(salesprice,price, schedule_sch_id, theater_th_id,seat_seat_id, reservation_rid)\r\n"
            			+ "values (5000, 5000,"+ scheduleNum +","+theaterNum+","+seatNum+",(select max(rid) from reservation));";
//            	String book3 = "update ticket set reservation_rid = (select max(rid) from reservation) where ti_id = (select max(rid) from reservation);";
            	//ticket ���̺� ���� �Է��Ͽ� Ƽ���� �����. 
            	//ticket_id�� reservation_id�� �����ϹǷ� ���� ������� reservation_id �� ���� �ֱ��� ������ �̿��Ѵ�. 
            	//select max(rid) from reservation 
            	String book4 = "update theater set th_use = th_use -1 where th_id = "
            			+ "(select seat.theater_th_id from seat where seat_id = "+seatNum+");"; 
            	//���ŵǾ����Ƿ� �¼��� ���Ǿ����� ��Ÿ����. 1->0 
            	String book5 = "update seat set s_use = 1 where seat_id = "+seatNum+";";
            	//������ �� �ִ� �¼��� ���� �ϳ� �پ���� ǥ���Ѵ�. 
            	 try { /* �����ͺ��̽��� ���� ����� �������� ���� */
                     Statement stmt=FirstInit.con.createStatement();
                  
                     stmt.executeUpdate(book1);
                     stmt.executeUpdate(book2);
                     //stmt.executeUpdate(book3);
                     stmt.executeUpdate(book4);
                     stmt.executeUpdate(book5);
                     
                 
                     ta.append("���ŵǾ����ϴ�.\n");
                     jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
                     //con.close();
                 } catch(SQLException k) {
                       k.printStackTrace();
                   }
                     }
            
        });

            
        //��� 3��
        //������ ������ ��ȭ�� ���ؼ� ��ȭ��, ����, �󿵰���ȣ, �¼���ȣ �� �ǸŰ��� ������ �����ִ� ���
        JButton b3 = new JButton("������ ��ȭ Ȯ��");
        add(b3);
        b3.setBounds(580,10,200,30);
        
        b3.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent a) {
                String query_movie = "select mname,  start_date, s.theater_th_id,seat_seat_id, salesprice from movie m, reservation r, ticket t, schedule s\r\n"
                		+ "where (t.reservation_rid = r.rid)and(t.schedule_sch_id = s.sch_id)and(s.movie_mid = m.mid)\r\n"
                		+ "and(r.customer_cid = "+ customer_id +"); ";
              
              
                 try { /* �����ͺ��̽��� ���� ����� �������� ���� */
                     Statement stmt=FirstInit.con.createStatement();
                     ResultSet rs=stmt.executeQuery(query_movie);
                     ta.append("��ȭ��\t\t ����\t\t �󿵰���ȣ\t\t �¼���ȣ\t\t �ǸŰ��� \n");
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


        //��� 5�� 
        //������ ������ ��ȭ�� ���Ͽ� ��ȸ�ϰ� �� �� �̻��� ���� ������ �����ϴ� ���
        JButton b5 = new JButton("���ų��� ����");
        add(b5);
        b5.setBounds(620,90,120,30);
        
        b5.addActionListener(new ActionListener() {
            
        	
        	
            @Override
            public void actionPerformed(ActionEvent a) {
            	
            	theaterNum = Integer.parseInt(tf4.getText()); //�󿵰���ȣ
            	seatNum = Integer.parseInt(tf5.getText()); //�¼���ȣ
            	//scheduleNum = Integer.parseInt(tf_sch.getText()); //�����ٹ�ȣ
            
            	String delete_query = "delete from reservation where ( reservation.rid = \r\n"
            			+ "(select ticket.reservation_rid from ticket \r\n"
            			+ "where ((theater_th_id = "+theaterNum+") \r\n"
            			+ "and (seat_seat_id ="+seatNum+"))));";
            	//�����ϰ��� �ϴ� �󿵰� ��ȣ, �¼� ��ȣ, �󿵽������� �Է��� �� �� delete query�� �̿��Ͽ� �����Ѵ�. 
            	//delete from reservation�� ���������� on delete cascade 
            	String delete_seat = "update seat set s_use = 0 where( seat_id =" + seatNum + ");\n";
            	//�¼��� �ٽ� ������ �ǹǷ� ������ �� �ִ� ���°� �Ǿ����� ǥ���Ѵ�. 
            	String update_count = "update theater set th_use = th_use - 1 where (th_id = "+theaterNum+");";
            	//���°� �ִ� �¼��� ���� �ϳ� �پ���. theater ���̺��� �ش� th_id���� ���ǰ� �ִ� �¼��� ���� �ϳ� �پ������� �ݿ��Ѵ�. 
            	
            	 try { /* �����ͺ��̽��� ���� ����� �������� ���� */
                     Statement stmt=FirstInit.con.createStatement();
                  
                    stmt.executeUpdate(delete_query);
                    stmt.executeUpdate(delete_seat);
                    stmt.executeUpdate(update_count);
                     ta.append("�����Ǿ����ϴ�.\n");
                     jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
                     //con.close();
                 } catch(SQLException k) {
                       k.printStackTrace();
                   }
                     }
            
        });
        
        
        //������ ������ ��ȭ�� ���Ͽ� ��ȸ�Ͽ� 
        //�ٸ� ��ȭ �Ǵ� �ٸ� �� �������� ������ �� �ֵ��� �Ѵ�.
        
        JButton changebtn = new JButton("���ų��� �����ϱ�");
        add(changebtn);
        changebtn.setBounds(620,160,200,30);
        
        changebtn.addActionListener(new ActionListener() {
            
        	
        	
            @Override
            public void actionPerformed(ActionEvent a) {
            
            	theaterNum = Integer.parseInt(tf4.getText()); //�󿵰���ȣ
            	seatNum = Integer.parseInt(tf5.getText()); //�¼���ȣ
            	scheduleNum = Integer.parseInt(tf_sch.getText()); //�����ٹ�ȣ
            	
            	change_seat = Integer.parseInt(tf_c5.getText()); //������ �¼���ȣ 
            	change_the = Integer.parseInt(tf_c4.getText()); //������ �󿵰���ȣ
            	change_sch = Integer.parseInt(tf_c_sch.getText()); //������ ������ ��ȣ 
            	
            
            	String change_t = "update ticket \r\n"
            			+ "set schedule_sch_id = "+change_sch+"\r\n"
            			+ ",theater_th_id = "+change_the+" \r\n"
            			+ ",seat_seat_id = "+change_seat+" \r\n"
            			+ "where(ticket.theater_th_id ="+theaterNum+"\r\n"
            			+ ")and (ticket.seat_seat_id = "+seatNum+"\r\n"
            			+ ");";
            	//ticket�� ���뿡�� ������ ������ ������ ������ update���ش�. 
            	
            	String change_th1 = "update theater \r\n"
            			+ "set th_use = th_use + 1\r\n"
            			+ "where th_id = "+change_the+";";
            	String change_th2 = "update theater \r\n"
            			+ "set th_use = th_use - 1\r\n"
            			+ "where th_id = "+theaterNum+";";
            	//������ ����ϴ� �󿵰��� ����ϴ� �¼����� �ϳ� ���ҽ�Ű��, 
            	//���� ���ŵ� �󿵰��� ����ϴ� �¼����� �ϳ� ������Ų��. 
            	
            	String change_s1 = "update seat \r\n"
            			+ "set s_use = 0 \r\n"
            			+ "where seat_id = "+seatNum+";";
            	String change_s2 = "update seat\r\n"
            			+ "set s_use = 1\r\n"
            			+ "where seat_id = "+change_seat+";";
            	//seat ���̺��� ������ �����ߴ� �¼��� 0���� ���� ������ �¼��� 1�� �����Ų��. 
            	
            	
            	 try { /* �����ͺ��̽��� ���� ����� �������� ���� */
                     Statement stmt=FirstInit.con.createStatement();
                  
             
                    stmt.executeUpdate(change_th1);
                    stmt.executeUpdate(change_th2);
                    stmt.executeUpdate(change_s1);
                    stmt.executeUpdate(change_s2);
                    
                    stmt.executeUpdate(change_t);
                   
                     ta.append("����Ǿ����ϴ�.\n");
                     jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
                     //con.close();
                 } catch(SQLException k) {
                       k.printStackTrace();
                   }
            }
           
        });


   }
}
