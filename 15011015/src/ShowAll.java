import java.sql.*;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ShowAll extends JPanel {
	JLabel la = new JLabel("전체 테이블 보기");
	JTextArea tarea = new JTextArea();
	JScrollPane scroll = new JScrollPane(tarea);
	
	ShowAll() {
		setLayout(null);
		
		la.setFont(new Font("SansSerif", Font.BOLD, 18));
		la.setBounds(172+380,25,200,15);
		scroll.setBounds(22,35+25,1220,320);
		
		add(la);
		add(scroll, BorderLayout.SOUTH);
		
		
		Statement stmt = null;
		ResultSet rs = null;
		
		String query1 = "select * from movie;";
		String query2 = "select * from schedule;";
		String query3 = "select * from theater;"; 
		String query4 = "select * from ticket;"; 
		String query5 = "select * from seat;";
		String query6 = "select * from customer;";
		String query7 = "select * from reservation;";
		
		try {
			stmt = FirstInit.con.createStatement();
			
			rs = stmt.executeQuery(query1);
			tarea.append("movie table\n");
			tarea.append("mid \t mname \t runtime \t rating \t director_name actname \t genre \t synopsis \t\t\t\t release_date\n");
			tarea.append("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
			while (rs.next()) {
				String line = rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getDate(9)+"\n";
				tarea.append(line);
			}
			
			rs = stmt.executeQuery(query2);
			tarea.append("\nschedule table\n");
			tarea.append("sch_id \t start_date \t day_of_week \t times \t start_time \t mid(FK) \t th_id(FK)\n");
			tarea.append("----------------------------------------------------------------------------------------------------------------------------------------\n");
			while (rs.next()) {
				String line = rs.getInt(1)+"\t"+rs.getDate(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getTime(5)+"\t"+rs.getInt(6)+"\t"+rs.getInt(7)+"\n";
				tarea.append(line);
			}
			
			rs = stmt.executeQuery(query3);
			tarea.append("\ntheater table\n");
			tarea.append("th_id \t seats_num \t th_use\n");
			tarea.append("-----------------------------------------------------------------------------\n");
			while (rs.next()) {
				String line = rs.getInt(1) + "\t" +  rs.getInt(2) + "\t" +  rs.getInt(3) + "\n";
				tarea.append(line);
			}
			
			rs = stmt.executeQuery(query4);
			tarea.append("\nticket table\n");
			tarea.append("ti_id \t get_ticket \t price \t salesprice \t sch_id(FK) \t th_id(FK) \t seat_id(FK) \t rid(FK)\n");
			tarea.append("-----------------------------------------------------------------------------------------------------------------------------------------------\n");
			while (rs.next()) {
				String line = rs.getInt(1)+"\t"+rs.getInt(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t"+rs.getInt(6)+"\t"+rs.getInt(7)+"\t"+rs.getInt(8)+"\n";
				tarea.append(line);
			}
			
			rs = stmt.executeQuery(query5);
			tarea.append("\nseat table\n");
			tarea.append("seat_id \t s_use \t th_id(FK)\n");
			tarea.append("-----------------------------------------------------------------\n");
			while (rs.next()) {
				String line = rs.getInt(1) + "\t" +  rs.getInt(2) + "\t" +  rs.getInt(3) + "\n";
				tarea.append(line);
			}
			
			rs = stmt.executeQuery(query6);
			tarea.append("\ncustomer table\n");
			tarea.append("cid \t name \t phone_num \t\t email\n");
			tarea.append("-----------------------------------------------------------------------------------------------------------------\n");
			while (rs.next()) {
				String line = rs.getInt(1) + "\t" +  rs.getString(2) + "\t" +  rs.getString(3) + "\t" +  rs.getString(4) + "\n";
				tarea.append(line);
			}
			
			rs = stmt.executeQuery(query7);
			tarea.append("\nreservation table\n");
			tarea.append("rid \t pay_option \t pay_status \t pay_price \t pay_date \t cid(FK)\n");
			tarea.append("---------------------------------------------------------------------------------------------------------------------------\n");
			while (rs.next()) {
				String line = rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getDate(5)+"\t"+rs.getInt(6)+"\n";
				tarea.append(line);
			}

		} catch (Exception e){
			System.out.println("Error: 테이블 출력 중 오류가 발생했습니다. " + e + "\n");
		}
	}
}
