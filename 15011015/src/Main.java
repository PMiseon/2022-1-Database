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
   
		try { /* ����̹��� ã�� ���� */
			Class.forName("com.mysql.cj.jdbc.Driver");   
			System.out.println("����̹� �ε� ����");
	     } catch(ClassNotFoundException e) {
	    	 e.printStackTrace();
	      }    
		try { /* �����ͺ��̽��� �����ϴ� ���� */
			System.out.println("�����ͺ��̽� ���� �غ�...");	
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("�����ͺ��̽� ���� ����");
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
		setTitle("15011015 �ڹ̼� 17012269 �谡��");
		setSize(1270, 450); // �ʼ�. ������ â ������
		setLocationRelativeTo(null); // �������� ����� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		homePanel.admin.addActionListener(this);
		homePanel.member.addActionListener(this);

		adminPanel.showAll.addActionListener(this);
		adminPanel.crud.addActionListener(this);

		add(homePanel); // Main �����ӿ�  home �г� �߰�
		setVisible(true); // �ʼ�
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String btnStr = e.getActionCommand();
		
		change(btnStr);
	}
	
	
	// ������ Main�� �ϳ��� �гξ��� �߰��ؼ� ������ 
	public void change(String btnStr) {
		if (btnStr.equals("������ ���")) {
			getContentPane().removeAll(); // ���� �г��� ã�� ����
			getContentPane().add(adminPanel);
			revalidate();
			repaint();
		}
		else if (btnStr.equals("ȸ�� ���")) {
			getContentPane().removeAll();
			getContentPane().add(memberPanel);
			revalidate();
			repaint();
		}
		else if (btnStr.equals("��ü ���̺� ����")) {
			getContentPane().removeAll(); // ���� �г��� ã�� ����
			getContentPane().add(showPanel);
			revalidate();
			repaint();
		}
		else if (btnStr.equals("�Է�  /  ����  /  ����")) {
			getContentPane().removeAll(); // ���� �г��� ã�� ����
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
