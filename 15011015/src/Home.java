import java.awt.*;
import javax.swing.*;

public class Home extends JPanel {
	JLabel title = new JLabel("��ȭ ���� ���α׷�");
	JButton admin = new JButton("������ ���");
	JButton member = new JButton("ȸ�� ���");
	JPanel btnPanel = new JPanel();
	
	Home() {
		setLayout(null);
		setBackground(new Color(255, 222, 102));

		title.setFont(new Font("SansSerif", Font.BOLD, 30));
		title.setBounds(480,100,400,60); // ���ν�����, ���ν�����, ����ũ��, ����ũ��
		
		btnPanel.setBounds(465, 200, 300, 50);
		btnPanel.setLayout(new GridLayout(1, 2, 10, 0)); // ���, ����, ���ΰ���, ���ΰ���
		btnPanel.setBackground(new Color(255, 222, 102));
		btnPanel.add(admin);
		btnPanel.add(member);
		
		add(title);
		add(btnPanel);
	}
}
