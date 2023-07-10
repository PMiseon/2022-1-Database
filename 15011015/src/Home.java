import java.awt.*;
import javax.swing.*;

public class Home extends JPanel {
	JLabel title = new JLabel("영화 예매 프로그램");
	JButton admin = new JButton("관리자 모드");
	JButton member = new JButton("회원 모드");
	JPanel btnPanel = new JPanel();
	
	Home() {
		setLayout(null);
		setBackground(new Color(255, 222, 102));

		title.setFont(new Font("SansSerif", Font.BOLD, 30));
		title.setBounds(480,100,400,60); // 가로시작점, 세로시작점, 가로크기, 세로크기
		
		btnPanel.setBounds(465, 200, 300, 50);
		btnPanel.setLayout(new GridLayout(1, 2, 10, 0)); // 행수, 열수, 가로간격, 세로간격
		btnPanel.setBackground(new Color(255, 222, 102));
		btnPanel.add(admin);
		btnPanel.add(member);
		
		add(title);
		add(btnPanel);
	}
}
