import java.sql.*;
import java.awt.event.*;

public class CRUDAction implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query;

		try {
			stmt = FirstInit.con.createStatement();
			
			if (e.getSource() == CRUD.minsert) {
				query = "INSERT INTO movie VALUES (?,?,?,?,?,?,?,?,?)";
				pstmt = FirstInit.con.prepareStatement(query);
				
				int 	mid = CRUD.mf1.getText().length()==0 ? 0 : Integer.parseInt(CRUD.mf1.getText());
				String	mname = CRUD.mf2.getText().length()==0 ? "NULL" : CRUD.mf2.getText();
				int 	runtime = CRUD.mf3.getText().length()==0 ? 0 : Integer.parseInt(CRUD.mf3.getText());;
				String	rating = CRUD.mf4.getText().length()==0 ? "NULL" : CRUD.mf4.getText();
				String	director_name = CRUD.mf5.getText().length()==0 ? "NULL" : CRUD.mf5.getText();
				String	actname = CRUD.mf6.getText().length()==0 ? "NULL" : CRUD.mf6.getText();
				String	genre = CRUD.mf7.getText().length()==0 ? "NULL" : CRUD.mf7.getText();
				String	synopsis = CRUD.mf8.getText().length()==0 ? "NULL" : CRUD.mf8.getText();
				String	release_date = CRUD.mf9.getText().length()==0 ? "2022-6-6" : CRUD.mf9.getText();
				
				pstmt.setInt(1, mid);
				pstmt.setString(2, mname);
				pstmt.setInt(3, runtime);
				pstmt.setString(4, rating);
				pstmt.setString(5, director_name);
				pstmt.setString(6, actname);
				pstmt.setString(7, genre);
				pstmt.setString(8, synopsis);
				pstmt.setString(9, release_date);
				
				pstmt.executeUpdate();
				
				CRUD.textResult.append("��ȭ �Է� �Ϸ�!\n");
				
				CRUD.mf1.setText("");
				CRUD.mf2.setText("");
				CRUD.mf3.setText("");
				CRUD.mf4.setText("");
				CRUD.mf5.setText("");
				CRUD.mf6.setText("");
				CRUD.mf7.setText("");
				CRUD.mf8.setText("");
				CRUD.mf9.setText("");
			}
			
			else if (e.getSource() == CRUD.mupdate) {
				query = "UPDATE movie SET mname=?, runtime=?, rating=?, director_name=?, actname=?, genre=?, synopsis=?, release_date=? WHERE mid=?";
				pstmt = FirstInit.con.prepareStatement(query);
				
				int 	mid = CRUD.mf1.getText().length()==0 ? 0 : Integer.parseInt(CRUD.mf1.getText());
				String	mname = CRUD.mf2.getText().length()==0 ? "NULL" : CRUD.mf2.getText();
				int 	runtime = CRUD.mf3.getText().length()==0 ? 0 : Integer.parseInt(CRUD.mf3.getText());;
				String	rating = CRUD.mf4.getText().length()==0 ? "NULL" : CRUD.mf4.getText();
				String	director_name = CRUD.mf5.getText().length()==0 ? "NULL" : CRUD.mf5.getText();
				String	actname = CRUD.mf6.getText().length()==0 ? "NULL" : CRUD.mf6.getText();
				String	genre = CRUD.mf7.getText().length()==0 ? "NULL" : CRUD.mf7.getText();
				String	synopsis = CRUD.mf8.getText().length()==0 ? "NULL" : CRUD.mf8.getText();
				String	release_date = CRUD.mf9.getText().length()==0 ? "2022-6-6" : CRUD.mf9.getText();
				
				pstmt.setInt(9, mid);
				pstmt.setString(1, mname);
				pstmt.setInt(2, runtime);
				pstmt.setString(3, rating);
				pstmt.setString(4, director_name);
				pstmt.setString(5, actname);
				pstmt.setString(6, genre);
				pstmt.setString(7, synopsis);
				pstmt.setString(8, release_date);
				
				if (pstmt.executeUpdate() <= 0)
					CRUD.textResult.append("�����Ϸ��� ��ȭ��ȣ�� �Է��ϼ���. �����ϴ� ��ȣ�� �Է��ϼ���.\n");
				else {
					CRUD.textResult.append("��ȭ ���� �Ϸ�!\n");
					CRUD.mf1.setText("");
					CRUD.mf2.setText("");
					CRUD.mf3.setText("");
					CRUD.mf4.setText("");
					CRUD.mf5.setText("");
					CRUD.mf6.setText("");
					CRUD.mf7.setText("");
					CRUD.mf8.setText("");
					CRUD.mf9.setText("");	
				}
			}
			
			else if (e.getSource() == CRUD.mdelete) {
				query = "DELETE FROM movie WHERE mid=?";
				pstmt = FirstInit.con.prepareStatement(query);
				
				int 	mid = CRUD.mf1.getText().length()==0 ? 0 : Integer.parseInt(CRUD.mf1.getText());
				
				pstmt.setInt(1, mid);
				
				if (pstmt.executeUpdate() <= 0)
					CRUD.textResult.append("�����Ϸ��� ��ȭ��ȣ�� �Է��ϼ���. �����ϴ� ��ȣ�� �Է��ϼ���.\n");
				else {
					CRUD.textResult.append("��ȭ ���� �Ϸ�!\n");
					CRUD.mf1.setText("");
					CRUD.mf2.setText("");
					CRUD.mf3.setText("");
					CRUD.mf4.setText("");
					CRUD.mf5.setText("");
					CRUD.mf6.setText("");
					CRUD.mf7.setText("");
					CRUD.mf8.setText("");
					CRUD.mf9.setText("");
				}
			}
			
			else if (e.getSource() == CRUD.schinsert) {
				int 	sch_id = CRUD.schf1.getText().length()==0 ? 0 : Integer.parseInt(CRUD.schf1.getText());
				int 	movie_mid = CRUD.schf2.getText().length()==0 ? 0 : Integer.parseInt(CRUD.schf2.getText());
				int 	theater_th_id = CRUD.schf3.getText().length()==0 ? 0 : Integer.parseInt(CRUD.schf3.getText());
				String	start_date = CRUD.schf4.getText().length()==0 ? "2022-6-6" : CRUD.schf4.getText();
				String	day_of_week = CRUD.schf5.getText().length()==0 ? "NULL" : CRUD.schf5.getText();
				int 	times = CRUD.schf6.getText().length()==0 ? 0 : Integer.parseInt(CRUD.schf6.getText());
				String	start_time = CRUD.schf7.getText().length()==0 ? "12:00:00" : CRUD.schf7.getText();
				
				String q = "select count(sch_id) from schedule where movie_mid=?;";
				pstmt = FirstInit.con.prepareStatement(q);
				pstmt.setInt(1, movie_mid);
				rs = pstmt.executeQuery();
    			rs.next();
    			int sch_count = rs.getInt(1); // �ٲٷ��� ��ȭ[�ؽ�Ʈ �ʵ忡 �Է��� mid]�� ������ ����

				if (sch_count >= 4) {
					CRUD.textResult.append("�������� �߰��� �� ���� ��ȭ�Դϴ� (������ 4�� �ʰ�)\n");
				}
				else {					
					query = "INSERT INTO schedule VALUES (?,?,?,?,?,?,?)";
					pstmt = FirstInit.con.prepareStatement(query);
					
					pstmt.setInt(1, sch_id);
					pstmt.setInt(6, movie_mid);
					pstmt.setInt(7, theater_th_id);
					pstmt.setString(2, start_date);
					pstmt.setString(3, day_of_week);
					pstmt.setInt(4, times);
					pstmt.setString(5, start_time);
					
					pstmt.executeUpdate();
					
					CRUD.textResult.append("������ �Է� �Ϸ�!\n");
					
					CRUD.schf1.setText("");
					CRUD.schf2.setText("");
					CRUD.schf3.setText("");
					CRUD.schf4.setText("");
					CRUD.schf5.setText("");
					CRUD.schf6.setText("");
					CRUD.schf7.setText("");
				}
			}
			
			else if (e.getSource() == CRUD.schupdate) {
				int 	sch_id = CRUD.schf1.getText().length()==0 ? 0 : Integer.parseInt(CRUD.schf1.getText());
				int 	movie_mid = CRUD.schf2.getText().length()==0 ? 0 : Integer.parseInt(CRUD.schf2.getText());
				int 	theater_th_id = CRUD.schf3.getText().length()==0 ? 0 : Integer.parseInt(CRUD.schf3.getText());
				String	start_date = CRUD.schf4.getText().length()==0 ? "2022-6-6" : CRUD.schf4.getText();
				String	day_of_week = CRUD.schf5.getText().length()==0 ? "NULL" : CRUD.schf5.getText();
				int 	times = CRUD.schf6.getText().length()==0 ? 0 : Integer.parseInt(CRUD.schf6.getText());
				String	start_time = CRUD.schf7.getText().length()==0 ? "12:00:00" : CRUD.schf7.getText();
				
				
				String q1 = "select movie_mid from schedule where sch_id=?;";
				pstmt = FirstInit.con.prepareStatement(q1);
				pstmt.setInt(1, sch_id);
				rs = pstmt.executeQuery();
    			rs.next();
    			int old_mid = rs.getInt(1); // �ش� sch_id�� ���� mid
				
				String q2 = "select count(sch_id) from schedule where movie_mid=?;";
				pstmt = FirstInit.con.prepareStatement(q2);
				pstmt.setInt(1, old_mid);
				rs = pstmt.executeQuery();
    			rs.next();
    			int old_sch_count = rs.getInt(1); // �ش� sch_id�� ���� mid�� ���� ������ ����
    			
    			String q3 = "select count(sch_id) from schedule where movie_mid=?;";
				pstmt = FirstInit.con.prepareStatement(q3);
				pstmt.setInt(1, movie_mid);
				rs = pstmt.executeQuery();
    			rs.next();
    			int new_sch_count = rs.getInt(1); // �ٲٷ��� ��ȭ[�ؽ�Ʈ �ʵ忡 �Է��� mid]�� ������ ����
    			
    			
    			String q4 = "select theater_th_id from schedule where sch_id=?;";
				pstmt = FirstInit.con.prepareStatement(q4);
				pstmt.setInt(1, sch_id);
				rs = pstmt.executeQuery();
    			rs.next();
    			int old_thid = rs.getInt(1); // �ش� sch_id�� ���� th_id
    			
    			String q5 = "select count(sch_id) from schedule where theater_th_id=?;";
				pstmt = FirstInit.con.prepareStatement(q5);
				pstmt.setInt(1, old_thid);
				rs = pstmt.executeQuery();
    			rs.next();
    			int oldth_sch_count = rs.getInt(1); // �ش� sch_id�� ���� th_id�� ���� ������ ����
    			
    			
    			if (CRUD.schf1.getText().length()==0)
					CRUD.textResult.append("�����Ϸ��� ��������ȣ�� �Է��ϼ���.\n");
    			else {												// old_mid(�ش� sch_id�� ���� mid) != movie_mid(�ؽ�Ʈ�ʵ忡 �Է��� mid)
    				if (((old_sch_count == 1 || new_sch_count >= 4) && (old_mid != movie_mid) && (movie_mid != 0))
    						|| (oldth_sch_count == 1 && old_thid != theater_th_id && theater_th_id != 0)) { 
    					CRUD.textResult.append("�������� ������ �� ���� ��ȭ �Ǵ� �󿵰��Դϴ� (��ȭ ������ 1~4��, �󿵰� ������ 1�� �̻�)\n");
    				}
    				else {
    					query = "UPDATE schedule SET start_date=?, day_of_week=?, times=?, start_time=?, movie_mid=?, theater_th_id=? WHERE sch_id=?"; // SET �ڿ� ��Ű���� ����� �Ӽ� ������� ����� ��
    					pstmt = FirstInit.con.prepareStatement(query);
    					
    					pstmt.setInt(7, sch_id);
    					pstmt.setInt(5, movie_mid);
    					pstmt.setInt(6, theater_th_id);
    					pstmt.setString(1, start_date);
    					pstmt.setString(2, day_of_week);
    					pstmt.setInt(3, times);
    					pstmt.setString(4, start_time);
    					
    					if (pstmt.executeUpdate() <= 0)
    						CRUD.textResult.append("�����Ϸ��� ��������ȣ�� �Է��ϼ���. �����ϴ� ��ȣ�� �Է��ϼ���.\n");
    					else {
	    					CRUD.textResult.append("������ ���� �Ϸ�!\n");
	    					CRUD.schf1.setText("");
	    					CRUD.schf2.setText("");
	    					CRUD.schf3.setText("");
	    					CRUD.schf4.setText("");
	    					CRUD.schf5.setText("");
	    					CRUD.schf6.setText("");
	    					CRUD.schf7.setText("");
    					}
    				}
    			}
			}
			
			else if (e.getSource() == CRUD.schdelete) {
				int 	sch_id = CRUD.schf1.getText().length()==0 ? 0 : Integer.parseInt(CRUD.schf1.getText());
				
				
				String q = "select count(sch_id) from schedule where movie_mid = (select movie_mid from schedule where sch_id=?);";
				pstmt = FirstInit.con.prepareStatement(q);
				pstmt.setInt(1, sch_id);
				rs = pstmt.executeQuery();
    			rs.next();
    			int old_sch_count = rs.getInt(1); // �ش� sch_id�� ���� mid�� ���� ������ ����
    			
    			String q2 = "select count(sch_id) from schedule where theater_th_id=(select theater_th_id from schedule where sch_id=?);";
				pstmt = FirstInit.con.prepareStatement(q2);
				pstmt.setInt(1, sch_id);
				rs = pstmt.executeQuery();
    			rs.next();
    			int oldth_sch_count = rs.getInt(1); // �ش� sch_id�� ���� th_id�� ���� ������ ����
    			
				
    			if (CRUD.schf1.getText().length()==0)
					CRUD.textResult.append("�����Ϸ��� ��������ȣ�� �Է��ϼ���.\n");
    			else {
    				if (old_sch_count <= 1 || oldth_sch_count <= 1) {
    					CRUD.textResult.append("�������� ������ �� ���� ��ȭ �Ǵ� �󿵰� �Դϴ� (������ �ּ� 1��)\n");
    				}	
    				else {
    					query = "DELETE FROM schedule WHERE sch_id=?";
    					pstmt = FirstInit.con.prepareStatement(query);
    	    			
    					pstmt.setInt(1, sch_id);
    					
    					if (pstmt.executeUpdate() <= 0)
    						CRUD.textResult.append("�����Ϸ��� ��������ȣ�� �Է��ϼ���. �����ϴ� ��ȣ�� �Է��ϼ���.\n");
    					else {
    						CRUD.textResult.append("������ ���� �Ϸ�!\n");
    						CRUD.schf1.setText("");
    						CRUD.schf2.setText("");
    						CRUD.schf3.setText("");
    						CRUD.schf4.setText("");
    						CRUD.schf5.setText("");
    						CRUD.schf6.setText("");
    						CRUD.schf7.setText("");
    					}
    				}
    			}
			}
			
			else if (e.getSource() == CRUD.thinsert) {
				query = "INSERT INTO theater VALUES (?,?,?)";
				pstmt = FirstInit.con.prepareStatement(query);
				
				int 	th_id = CRUD.thf1.getText().length()==0 ? 0 : Integer.parseInt(CRUD.thf1.getText());
				int 	seats_num = CRUD.thf2.getText().length()==0 ? 0 : Integer.parseInt(CRUD.thf2.getText());
				int 	th_use = CRUD.thf3.getText().length()==0 ? 0 : Integer.parseInt(CRUD.thf3.getText());
				
				pstmt.setInt(1, th_id);
				pstmt.setInt(2, seats_num);
				pstmt.setInt(3, th_use);
				
				pstmt.executeUpdate();
				
				CRUD.textResult.append("�󿵰� �Է� �Ϸ�!\n");
				
				CRUD.thf1.setText("");
				CRUD.thf2.setText("");
				CRUD.thf3.setText("");
			}
			
			else if (e.getSource() == CRUD.thupdate) {
				query = "UPDATE theater SET seats_num=?, th_use=? WHERE th_id=?"; // SET �ڿ� ��Ű���� ����� �Ӽ� ������� ����� ��
				pstmt = FirstInit.con.prepareStatement(query);
				
				int 	th_id = CRUD.thf1.getText().length()==0 ? 0 : Integer.parseInt(CRUD.thf1.getText());
				int 	seats_num = CRUD.thf2.getText().length()==0 ? 0 : Integer.parseInt(CRUD.thf2.getText());
				int 	th_use = CRUD.thf3.getText().length()==0 ? 0 : Integer.parseInt(CRUD.thf3.getText());
				
				pstmt.setInt(3, th_id);
				pstmt.setInt(1, seats_num);
				pstmt.setInt(2, th_use);
				
				if (pstmt.executeUpdate() <= 0)
					CRUD.textResult.append("�����Ϸ��� �󿵰���ȣ�� �Է��ϼ���. �����ϴ� ��ȣ�� �Է��ϼ���.\n");
				else {
					CRUD.textResult.append("�󿵰� ���� �Ϸ�!\n");
					CRUD.thf1.setText("");
					CRUD.thf2.setText("");
					CRUD.thf3.setText("");
				}	
			}
			
			else if (e.getSource() == CRUD.thdelete) {
				query = "DELETE FROM theater WHERE th_id=?";
				pstmt = FirstInit.con.prepareStatement(query);
				
				int 	th_id = CRUD.thf1.getText().length()==0 ? 0 : Integer.parseInt(CRUD.thf1.getText());
				
				pstmt.setInt(1, th_id);
				
				if (pstmt.executeUpdate() <= 0)
					CRUD.textResult.append("�����Ϸ��� �󿵰���ȣ�� �Է��ϼ���. �����ϴ� ��ȣ�� �Է��ϼ���.\n");
				else {
					CRUD.textResult.append("�󿵰� ���� �Ϸ�!\n");
					CRUD.thf1.setText("");
					CRUD.thf2.setText("");
					CRUD.thf3.setText("");
				}
			}
			
			else if (e.getSource() == CRUD.tiinsert) {
				int 	ti_id = CRUD.tif1.getText().length()==0 ? 0 : Integer.parseInt(CRUD.tif1.getText());
				int 	schedule_sch_id = CRUD.tif2.getText().length()==0 ? 0 : Integer.parseInt(CRUD.tif2.getText());
				int 	theater_th_id = CRUD.tif3.getText().length()==0 ? 0 : Integer.parseInt(CRUD.tif3.getText());
				int 	seat_seat_id = CRUD.tif4.getText().length()==0 ? 0 : Integer.parseInt(CRUD.tif4.getText());
				int 	reservation_rid = CRUD.tif5.getText().length()==0 ? 0 : Integer.parseInt(CRUD.tif5.getText());
				int 	get_ticket = CRUD.tif6.getText().length()==0 ? 0 : Integer.parseInt(CRUD.tif6.getText());
				int 	price = CRUD.tif7.getText().length()==0 ? 0 : Integer.parseInt(CRUD.tif7.getText());
				int 	salesprice = CRUD.tif8.getText().length()==0 ? 0 : Integer.parseInt(CRUD.tif8.getText());
				
				
				String q = "select count(ti_id) from ticket where (schedule_sch_id=? and theater_th_id=? and seat_seat_id=?);";
				pstmt = FirstInit.con.prepareStatement(q);
				pstmt.setInt(1, schedule_sch_id);
				pstmt.setInt(2, theater_th_id);
				pstmt.setInt(3, seat_seat_id);
				rs = pstmt.executeQuery(); // psmt.executeUpdate(); ??
    			rs.next();
    			int ticket_count = rs.getInt(1); // �Է��� �󿵰�,������,�¼���ȣ�� ������ Ƽ�� ���� (���翩�� �Ǵ�)
    			
  
    			if (ticket_count >= 1)
    			{
    				CRUD.textResult.append("�̹� ������� �¼��Դϴ�. �ٸ� �¼���ȣ�� �Է��ϼ���\n");
    			}
    			else {
    				query = "INSERT INTO ticket VALUES (?,?,?,?,?,?,?,?)";
    				pstmt = FirstInit.con.prepareStatement(query);
    				
    				pstmt.setInt(1, ti_id);
    				pstmt.setInt(5, schedule_sch_id);
    				pstmt.setInt(6, theater_th_id);
    				pstmt.setInt(7, seat_seat_id);
    				pstmt.setInt(8, reservation_rid);
    				pstmt.setInt(2, get_ticket);
    				pstmt.setInt(3, price);
    				pstmt.setInt(4, salesprice);
    				
    				pstmt.executeUpdate();
    				
    				CRUD.textResult.append("Ƽ�� �Է� �Ϸ�!\n");
    				
    				CRUD.tif1.setText("");
    				CRUD.tif2.setText("");
    				CRUD.tif3.setText("");
    				CRUD.tif4.setText("");
    				CRUD.tif5.setText("");
    				CRUD.tif6.setText("");
    				CRUD.tif7.setText("");
    				CRUD.tif8.setText("");
    			}
			}
			
			else if (e.getSource() == CRUD.tiupdate) {
				int 	ti_id = CRUD.tif1.getText().length()==0 ? 0 : Integer.parseInt(CRUD.tif1.getText());
				int 	schedule_sch_id = CRUD.tif2.getText().length()==0 ? 0 : Integer.parseInt(CRUD.tif2.getText());
				int 	theater_th_id = CRUD.tif3.getText().length()==0 ? 0 : Integer.parseInt(CRUD.tif3.getText());
				int 	seat_seat_id = CRUD.tif4.getText().length()==0 ? 0 : Integer.parseInt(CRUD.tif4.getText());
				int 	reservation_rid = CRUD.tif5.getText().length()==0 ? 0 : Integer.parseInt(CRUD.tif5.getText());
				int 	get_ticket = CRUD.tif6.getText().length()==0 ? 0 : Integer.parseInt(CRUD.tif6.getText());
				int 	price = CRUD.tif7.getText().length()==0 ? 0 : Integer.parseInt(CRUD.tif7.getText());
				int 	salesprice = CRUD.tif8.getText().length()==0 ? 0 : Integer.parseInt(CRUD.tif8.getText());

				
				String q1 = "select count(ti_id) from ticket where (schedule_sch_id=? and theater_th_id=? and seat_seat_id=?);";
				pstmt = FirstInit.con.prepareStatement(q1);
				pstmt.setInt(1, schedule_sch_id);
				pstmt.setInt(2, theater_th_id);
				pstmt.setInt(3, seat_seat_id);
				rs = pstmt.executeQuery(); // psmt.executeUpdate(); ??
    			rs.next();
    			int ticket_count = rs.getInt(1); // �Է��� �󿵰�,������,�¼���ȣ�� ������ Ƽ�� ���� (���翩�� �Ǵ�)
				
				String q2 = "select seat_seat_id from ticket where ti_id=?;";
				pstmt = FirstInit.con.prepareStatement(q2);
				pstmt.setInt(1, ti_id);
				rs = pstmt.executeQuery();
    			rs.next();
    			int old_seat_id = rs.getInt(1); // Ƽ�Ͽ� ���� ���� �¼���ȣ
	
    			String q3 = "select theater_th_id from ticket where ti_id=?;";
				pstmt = FirstInit.con.prepareStatement(q3);
				pstmt.setInt(1, ti_id);
				rs = pstmt.executeQuery();
    			rs.next();
    			int old_th_id = rs.getInt(1); // Ƽ�Ͽ� ���� ���� �󿵰���ȣ

    			String q4 = "select schedule_sch_id from ticket where ti_id=?;";
				pstmt = FirstInit.con.prepareStatement(q4);
				pstmt.setInt(1, ti_id);
				rs = pstmt.executeQuery();
    			rs.next();
    			int old_sch_id = rs.getInt(1); // Ƽ�Ͽ� ���� ���� ��������ȣ
    			
    			
    			if (CRUD.tif1.getText().length()==0)
					CRUD.textResult.append("�����Ϸ��� Ƽ�Ϲ�ȣ�� �Է��ϼ���.\n");
    			else {
    				if ((ticket_count >= 1) &&
    						((old_seat_id != seat_seat_id && seat_seat_id != 0) || (old_th_id != theater_th_id && theater_th_id != 0) || (old_sch_id != schedule_sch_id && schedule_sch_id != 0) )) {
    					CRUD.textResult.append("�̹� ������� �¼��Դϴ�. �ٸ� �¼���ȣ�� �Է��ϼ���\n");
    				}
    				else {
    					query = "UPDATE ticket SET get_ticket=?, price=?, salesprice=?, schedule_sch_id=?, theater_th_id=?, seat_seat_id=?, reservation_rid=? WHERE ti_id=?"; // SET �ڿ� ��Ű���� ����� �Ӽ� ������� ����� ��
    					pstmt = FirstInit.con.prepareStatement(query);
    					
    					pstmt.setInt(8, ti_id);
    					pstmt.setInt(4, schedule_sch_id);
    					pstmt.setInt(5, theater_th_id);
    					pstmt.setInt(6, seat_seat_id);
    					pstmt.setInt(7, reservation_rid);
    					pstmt.setInt(1, get_ticket);
    					pstmt.setInt(2, price);
    					pstmt.setInt(3, salesprice);
    					
    					if (pstmt.executeUpdate() <= 0)
    						CRUD.textResult.append("�����Ϸ��� Ƽ�Ϲ�ȣ�� �Է��ϼ���. �����ϴ� ��ȣ�� �Է��ϼ���.\n");
    					else {
    						CRUD.textResult.append("Ƽ�� ���� �Ϸ�!\n");
    						CRUD.tif1.setText("");
    						CRUD.tif2.setText("");
    						CRUD.tif3.setText("");
    						CRUD.tif4.setText("");
    						CRUD.tif5.setText("");
    						CRUD.tif6.setText("");
    						CRUD.tif7.setText("");
    						CRUD.tif8.setText("");
    					}	
    				}
    			}
			}
			
			else if (e.getSource() == CRUD.tidelete) {
				query = "DELETE FROM ticket WHERE ti_id=?";
				pstmt = FirstInit.con.prepareStatement(query);
				
				int 	ti_id = CRUD.tif1.getText().length()==0 ? 0 : Integer.parseInt(CRUD.tif1.getText());
				
				pstmt.setInt(1, ti_id);
				
				if (pstmt.executeUpdate() <= 0)
					CRUD.textResult.append("�����Ϸ��� Ƽ�Ϲ�ȣ�� �Է��ϼ���. �����ϴ� ��ȣ�� �Է��ϼ���.\n");
				else {
					CRUD.textResult.append("Ƽ�� ���� �Ϸ�!\n");
					CRUD.tif1.setText("");
					CRUD.tif2.setText("");
					CRUD.tif3.setText("");
					CRUD.tif4.setText("");
					CRUD.tif5.setText("");
					CRUD.tif6.setText("");
					CRUD.tif7.setText("");
					CRUD.tif8.setText("");
				}
			}
			
			else if (e.getSource() == CRUD.seinsert) {
				query = "INSERT INTO seat VALUES (?,?,?)";
				pstmt = FirstInit.con.prepareStatement(query);
				
				int seat_id = CRUD.sef1.getText().length()==0 ? 0 : Integer.parseInt(CRUD.sef1.getText());
				int theater_th_id = CRUD.sef2.getText().length()==0 ? 0 : Integer.parseInt(CRUD.sef2.getText());;
				int s_use = CRUD.sef3.getText().length()==0 ? 0 : Integer.parseInt(CRUD.sef3.getText());
				
				pstmt.setInt(1, seat_id);
				pstmt.setInt(3, theater_th_id);
				pstmt.setInt(2, s_use);
				
				pstmt.executeUpdate();
				
				CRUD.textResult.append("�¼� �Է� �Ϸ�!\n");
				
				CRUD.sef1.setText("");
				CRUD.sef2.setText("");
				CRUD.sef3.setText("");
			}
			
			else if (e.getSource() == CRUD.seupdate) {
				query = "UPDATE seat SET s_use=?, theater_th_id=? WHERE seat_id=?"; // SET �ڿ� ��Ű���� ����� �Ӽ� ������� ����� ��
				pstmt = FirstInit.con.prepareStatement(query);
				
				int seat_id = CRUD.sef1.getText().length()==0 ? 0 : Integer.parseInt(CRUD.sef1.getText());
				int theater_th_id = CRUD.sef2.getText().length()==0 ? 0 : Integer.parseInt(CRUD.sef2.getText());;
				int s_use = CRUD.sef3.getText().length()==0 ? 0 : Integer.parseInt(CRUD.sef3.getText());
				
				pstmt.setInt(3, seat_id);
				pstmt.setInt(2, theater_th_id);
				pstmt.setInt(1, s_use);
				
				if (pstmt.executeUpdate() <= 0)
					CRUD.textResult.append("�����Ϸ��� �¼���ȣ�� �Է��ϼ���. �����ϴ� ��ȣ�� �Է��ϼ���.\n");
				else {
					CRUD.textResult.append("�¼� ���� �Ϸ�!\n");
					CRUD.sef1.setText("");
					CRUD.sef2.setText("");
					CRUD.sef3.setText("");
				}	
			}
			
			else if (e.getSource() == CRUD.sedelete) {
				query = "DELETE FROM seat WHERE seat_id=?";
				pstmt = FirstInit.con.prepareStatement(query);
				
				int seat_id = CRUD.sef1.getText().length()==0 ? 0 : Integer.parseInt(CRUD.sef1.getText());
				
				pstmt.setInt(1, seat_id);
				
				if (pstmt.executeUpdate() <= 0)
					CRUD.textResult.append("�����Ϸ��� �¼���ȣ�� �Է��ϼ���. �����ϴ� ��ȣ�� �Է��ϼ���.\n");
				else {
					CRUD.textResult.append("�¼� ���� �Ϸ�!\n");
					CRUD.sef1.setText("");
					CRUD.sef2.setText("");
					CRUD.sef3.setText("");
				}
			}

			else if (e.getSource() == CRUD.cinsert) {
				query = "INSERT INTO customer VALUES (?,?,?,?)";
				pstmt = FirstInit.con.prepareStatement(query);
				
				int		cid = CRUD.cf1.getText().length()==0 ? 0 : Integer.parseInt(CRUD.cf1.getText());
				String	name = CRUD.cf2.getText().length()==0 ? "NULL" : CRUD.cf2.getText();
				String	phone_num = CRUD.cf3.getText().length()==0 ? "NULL" : CRUD.cf3.getText();
				String	email = CRUD.cf4.getText().length()==0 ? "NULL" : CRUD.cf4.getText();
				
				pstmt.setInt(1, cid);
				pstmt.setString(2, name);
				pstmt.setString(3, phone_num);
				pstmt.setString(4, email);
				
				pstmt.executeUpdate();
				
				CRUD.textResult.append("ȸ�� �Է� �Ϸ�!\n");
				
				CRUD.cf1.setText("");
				CRUD.cf2.setText("");
				CRUD.cf3.setText("");
				CRUD.cf4.setText("");
			}
			
			else if (e.getSource() == CRUD.cupdate) {
				query = "UPDATE customer SET name=?, phone_num=?, email=? WHERE cid=?"; // SET �ڿ� ��Ű���� ����� �Ӽ� ������� ����� ��
				pstmt = FirstInit.con.prepareStatement(query);
				
				int		cid = CRUD.cf1.getText().length()==0 ? 0 : Integer.parseInt(CRUD.cf1.getText());
				String	name = CRUD.cf2.getText().length()==0 ? "NULL" : CRUD.cf2.getText();
				String	phone_num = CRUD.cf3.getText().length()==0 ? "NULL" : CRUD.cf3.getText();
				String	email = CRUD.cf4.getText().length()==0 ? "NULL" : CRUD.cf4.getText();
				
				pstmt.setInt(4, cid);
				pstmt.setString(1, name);
				pstmt.setString(2, phone_num);
				pstmt.setString(3, email);
				
				if (pstmt.executeUpdate() <= 0)
					CRUD.textResult.append("�����Ϸ��� ȸ�����̵� �Է��ϼ���. �����ϴ� ���̵� �Է��ϼ���.\n");
				else {
					CRUD.textResult.append("ȸ�� ���� �Ϸ�!\n");
					CRUD.cf1.setText("");
					CRUD.cf2.setText("");
					CRUD.cf3.setText("");
					CRUD.cf4.setText("");
				}	
			}
			
			else if (e.getSource() == CRUD.cdelete) {
				query = "DELETE FROM customer WHERE cid=?";
				pstmt = FirstInit.con.prepareStatement(query);
				
				int		cid = CRUD.cf1.getText().length()==0 ? 0 : Integer.parseInt(CRUD.cf1.getText());
				
				pstmt.setInt(1, cid);
				
				if (pstmt.executeUpdate() <= 0)
					CRUD.textResult.append("�����Ϸ��� ȸ�����̵� �Է��ϼ���. �����ϴ� ���̵� �Է��ϼ���.\n");
				else {
					CRUD.textResult.append("ȸ�� ���� �Ϸ�!\n");
					CRUD.cf1.setText("");
					CRUD.cf2.setText("");
					CRUD.cf3.setText("");
					CRUD.cf4.setText("");
				}
			}
			
			else if (e.getSource() == CRUD.rinsert) {
				query = "INSERT INTO reservation VALUES (?,?,?,?,?,?)";
				pstmt = FirstInit.con.prepareStatement(query);
				
				int		rid = CRUD.rf1.getText().length()==0 ? 0 : Integer.parseInt(CRUD.rf1.getText());
				String	pay_option = CRUD.rf2.getText().length()==0 ? "NULL" : CRUD.rf2.getText();
				int		pay_status = CRUD.rf3.getText().length()==0 ? 0 : Integer.parseInt(CRUD.rf3.getText());
				int		pay_price = CRUD.rf4.getText().length()==0 ? 0 : Integer.parseInt(CRUD.rf4.getText());
				int		customer_cid = CRUD.rf5.getText().length()==0 ? 0 : Integer.parseInt(CRUD.rf5.getText());
				String	pay_date = CRUD.rf6.getText().length()==0 ? "2022-6-6" : CRUD.rf6.getText();
				
				pstmt.setInt(1, rid);
				pstmt.setString(2, pay_option);
				pstmt.setInt(3, pay_status);
				pstmt.setInt(4, pay_price);
				pstmt.setInt(6, customer_cid);
				pstmt.setString(5, pay_date);
				
				pstmt.executeUpdate();
				
				CRUD.textResult.append("�������� �Է� �Ϸ�!\n");
				
				CRUD.rf1.setText("");
				CRUD.rf2.setText("");
				CRUD.rf3.setText("");
				CRUD.rf4.setText("");
				CRUD.rf5.setText("");
				CRUD.rf6.setText("");
			}
			
			else if (e.getSource() == CRUD.rupdate) {
				query = "UPDATE reservation SET pay_option=?, pay_status=?, pay_price=?, pay_date=?, customer_cid=? WHERE rid=?"; // SET �ڿ� ��Ű���� ����� �Ӽ� ������� ����� ��
				pstmt = FirstInit.con.prepareStatement(query);
				
				int		rid = CRUD.rf1.getText().length()==0 ? 0 : Integer.parseInt(CRUD.rf1.getText());
				String	pay_option = CRUD.rf2.getText().length()==0 ? "NULL" : CRUD.rf2.getText();
				int		pay_status = CRUD.rf3.getText().length()==0 ? 0 : Integer.parseInt(CRUD.rf3.getText());
				int		pay_price = CRUD.rf4.getText().length()==0 ? 0 : Integer.parseInt(CRUD.rf4.getText());
				int		customer_cid = CRUD.rf5.getText().length()==0 ? 0 : Integer.parseInt(CRUD.rf5.getText());
				String	pay_date = CRUD.rf6.getText().length()==0 ? "2022-6-6" : CRUD.rf6.getText();
				
				pstmt.setInt(6, rid);
				pstmt.setString(1, pay_option);
				pstmt.setInt(2, pay_status);
				pstmt.setInt(3, pay_price);
				pstmt.setInt(5, customer_cid);
				pstmt.setString(4, pay_date);
				
				if (pstmt.executeUpdate() <= 0)
					CRUD.textResult.append("�����Ϸ��� ���Ź�ȣ�� �Է��ϼ���. �����ϴ� ��ȣ�� �Է��ϼ���.\n");
				else {
					CRUD.textResult.append("�������� ���� �Ϸ�!\n");
					CRUD.rf1.setText("");
					CRUD.rf2.setText("");
					CRUD.rf3.setText("");
					CRUD.rf4.setText("");
					CRUD.rf5.setText("");
					CRUD.rf6.setText("");	
				}	
			}
			
			else if (e.getSource() == CRUD.rdelete) {
				query = "DELETE FROM reservation WHERE rid=?";
				pstmt = FirstInit.con.prepareStatement(query);
				
				int	rid = CRUD.rf1.getText().length()==0 ? 0 : Integer.parseInt(CRUD.rf1.getText());
				
				pstmt.setInt(1, rid);
				
				if (pstmt.executeUpdate() <= 0)
					CRUD.textResult.append("�����Ϸ��� ���Ź�ȣ�� �Է��ϼ���. �����ϴ� ��ȣ�� �Է��ϼ���.\n");
				else {
					CRUD.textResult.append("�������� ���� �Ϸ�!\n");
					CRUD.rf1.setText("");
					CRUD.rf2.setText("");
					CRUD.rf3.setText("");
					CRUD.rf4.setText("");
					CRUD.rf5.setText("");
					CRUD.rf6.setText("");
				}
			}
		}
		catch (Exception e1) {
			if (e1.toString().contains("Incorrect")) {
				CRUD.textResult.append("Error: ���� �ùٸ��� �Է��ϼ���\n");
			}
			else if (e1.toString().contains("foreign key")) {
				CRUD.textResult.append("Error: �ܷ�Ű �������ǿ� �°� �Է��ϼ���\n");
			}
			else if (e1.toString().contains("PRIMARY")) {
				CRUD.textResult.append("Error: �̹� �����ϴ� �⺻Ű �� �Դϴ�. ù ��° �ʵ忡 �ٸ� ���� �Է��ϼ���\n");
			}
			else if (e1.toString().contains("Format")) {
				CRUD.textResult.append("Error: �ùٸ� �ڷ������� �Է��ϼ���\n");
			}
			else
				CRUD.textResult.append("Error: " + e1 + "\n");
		}
	}
}