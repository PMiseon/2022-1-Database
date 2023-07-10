import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

class FirstInit {
	static Connection con;

	FirstInit() {
		MySQLConnect();
		//Admin.resetDB();
	}
	
	public void MySQLConnect() {
		String Driver="";
		String url="jdbc:mysql://localhost:3306/madang?&serverTimezone=Asia/Seoul"; 
		String userid="madang";
		String pwd="madang";
   
		try { /* 드라이버를 찾는 과정 */
			Class.forName("com.mysql.cj.jdbc.Driver");   
			System.out.println("드라이버 로드 성공");
	     } catch(ClassNotFoundException e) {
	    	 e.printStackTrace();
	      }    
		try { /* 데이터베이스를 연결하는 과정 */
			System.out.println("데이터베이스 연결 준비...");	
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("데이터베이스 연결 성공");
	     } catch(SQLException e) {
	    	 e.printStackTrace();
	       }
	}
}

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener {
	public Home homePanel = new Home(); 
	public Admin adminPanel = new Admin();
	public ShowAll showPanel = new ShowAll();
	public CRUD crudPanel = new CRUD();
	public Member memberPanel = new Member();
	
	Main() {
		setTitle("15011015 박미선 17012269 김가은");
		setSize(1270, 450); // 필수. 윈도우 창 사이즈
		setLocationRelativeTo(null); // 프레임을 가운데에 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		homePanel.admin.addActionListener(this);
		homePanel.member.addActionListener(this);

		adminPanel.showAll.addActionListener(this);
		adminPanel.crud.addActionListener(this);

		add(homePanel); // Main 프레임에  home 패널 추가
		setVisible(true); // 필수
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String btnStr = e.getActionCommand();
		
		change(btnStr);
	}
	
	
	// 프레임 Main에 하나의 패널씩만 추가해서 보여줌 
	public void change(String btnStr) {
		if (btnStr.equals("관리자 모드")) {
			getContentPane().removeAll(); // 현재 패널을 찾아 지움
			getContentPane().add(adminPanel);
			revalidate();
			repaint();
		}
		else if (btnStr.equals("회원 모드")) {
			getContentPane().removeAll();
			getContentPane().add(memberPanel);
			revalidate();
			repaint();
		}
		else if (btnStr.equals("전체 테이블 보기")) {
			getContentPane().removeAll(); // 현재 패널을 찾아 지움
			getContentPane().add(showPanel);
			revalidate();
			repaint();
		}
		else if (btnStr.equals("입력  /  삭제  /  변경")) {
			getContentPane().removeAll(); // 현재 패널을 찾아 지움
			getContentPane().add(crudPanel);
			revalidate();
			repaint();
		}
	}


	public static void main(String args[]){
		new FirstInit();
		new Main();
	 }
}
