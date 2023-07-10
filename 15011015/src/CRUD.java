import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class CRUD extends JPanel {
	JPanel TopPanel;
	
	JLabel mtname, ml1, ml2, ml3, ml4, ml5, ml6, ml7, ml8, ml9;
	static JTextField mf1, mf2, mf3, mf4, mf5, mf6, mf7, mf8, mf9;
	static JButton minsert, mdelete, mupdate;
	
	JLabel schtname, schl1, schl2, schl3, schl4, schl5, schl6, schl7;
	static JTextField schf1, schf2, schf3, schf4, schf5, schf6, schf7;
	static JButton schinsert, schdelete, schupdate;
	
	JLabel thtname, thl1, thl2, thl3;
	static JTextField thf1, thf2, thf3;
	static JButton thinsert, thdelete, thupdate;
	
	JLabel titname, til1, til2, til3, til4, til5, til6, til7, til8;
	static JTextField tif1, tif2, tif3, tif4, tif5, tif6, tif7, tif8;
	static JButton tiinsert, tidelete, tiupdate;
	
	JLabel setname, sel1, sel2, sel3;
	static JTextField sef1, sef2, sef3;
	static JButton seinsert, sedelete, seupdate;
	
	JLabel ctname, cl1, cl2, cl3, cl4;
	static JTextField cf1, cf2, cf3, cf4;
	static JButton cinsert, cdelete, cupdate;
	
	JLabel rtname, rl1, rl2, rl3, rl4, rl5, rl6;
	static JTextField rf1, rf2, rf3, rf4, rf5, rf6;
	static JButton rinsert, rdelete, rupdate;

	static JTextArea textResult;
	static JScrollPane BottomPanel;
	

	CRUD() {
		setLayout(null); // Ư�� ���̾ƿ� ��밡��, �̰ž���  �� ������Ʈ setBounds ����� ����.

		TopPanel = new JPanel(new GridLayout(0, 13));
		
		Font font1 = new Font("Dialog", Font.BOLD, 12); // 8
		Font font2 = new Font("Dialog", Font.BOLD, 12); // 10
		
		// ���̺� ������Ʈ ����  ======================================================
		// ��ȭ: ��ȭ��ȣ, ��ȭ��, �󿵽ð�, �󿵵��, ������, ����, �帣, ��ȭ�Ұ�, ������
		ml1 = new JLabel("��ȭ��ȣ", JLabel.CENTER);	
		ml2 = new JLabel("��ȭ��", JLabel.CENTER);
		ml3 = new JLabel("�󿵽ð�", JLabel.CENTER);
		ml4 = new JLabel("�󿵵��", JLabel.CENTER);
		ml5 = new JLabel("������", JLabel.CENTER);
		ml6 = new JLabel("����", JLabel.CENTER);
		ml7 = new JLabel("�帣", JLabel.CENTER);
		ml8 = new JLabel("��ȭ�Ұ�", JLabel.CENTER);
		ml9 = new JLabel("������", JLabel.CENTER);
		mtname = new JLabel("��ȭ", JLabel.CENTER);
		mf1 = new JTextField();
		mf2 = new JTextField();
		mf3 = new JTextField();
		mf4 = new JTextField();
		mf5 = new JTextField();
		mf6 = new JTextField();
		mf7 = new JTextField();
		mf8 = new JTextField();
		mf9 = new JTextField();
		minsert = new JButton("�Է�");
		mdelete = new JButton("����");
		mupdate = new JButton("����");
		
		// ������: ��������ȣ, ��ȭ��ȣ(FK), �󿵰���ȣ(FK), �󿵽�����, �󿵿���, ��ȸ��, �󿵽��۽ð�
		schl1 = new JLabel("��������ȣ", JLabel.CENTER);
		schl1.setFont(font2);
		schl2 = new JLabel("��ȭ��ȣ(FK)", JLabel.CENTER);
		schl2.setFont(font2);
		schl3 = new JLabel("�󿵰���ȣ(FK)", JLabel.CENTER);
		schl3.setFont(font1);
		schl4 = new JLabel("�󿵽�����", JLabel.CENTER);
		schl5 = new JLabel("�󿵿���", JLabel.CENTER);
		schl6 = new JLabel("��ȸ��", JLabel.CENTER);
		schl7 = new JLabel("�󿵽��۽ð�", JLabel.CENTER);
		schl7.setFont(font2);
		schtname = new JLabel("������", JLabel.CENTER);
		schf1 = new JTextField();
		schf2 = new JTextField();
		schf3 = new JTextField();
		schf4 = new JTextField();
		schf5 = new JTextField();
		schf6 = new JTextField();
		schf7 = new JTextField();
		schinsert = new JButton("�Է�");
		schdelete = new JButton("����");
		schupdate = new JButton("����");
		
		// �󿵰�: �󿵰���ȣ, �¼���, �󿵰���뿩��
		thl1 = new JLabel("�󿵰���ȣ", JLabel.CENTER);
		thl2 = new JLabel("�¼���", JLabel.CENTER);
		thl3 = new JLabel("�󿵰���뿩��", JLabel.CENTER);
		thl3.setFont(font1);
		thtname = new JLabel("�󿵰�", JLabel.CENTER);
		thf1 = new JTextField();
		thf2 = new JTextField();
		thf3 = new JTextField();
		thinsert = new JButton("�Է�");
		thdelete = new JButton("����");
		thupdate = new JButton("����");
		
		// Ƽ��: Ƽ�Ϲ�ȣ, ��������ȣ(FK), �󿵰���ȣ(FK), �¼���ȣ(FK), ���Ź�ȣ(FK), �߱ǿ���, ǥ�ذ���, �ǸŰ���
		til1 = new JLabel("Ƽ�Ϲ�ȣ", JLabel.CENTER);
		til2 = new JLabel("��������ȣ(FK)", JLabel.CENTER);
		til2.setFont(font1);
		til3 = new JLabel("�󿵰���ȣ(FK)", JLabel.CENTER);
		til3.setFont(font1);
		til4 = new JLabel("�¼���ȣ(FK)", JLabel.CENTER);
		til4.setFont(font2);
		til5 = new JLabel("���Ź�ȣ(FK)", JLabel.CENTER);
		til5.setFont(font2);
		til6 = new JLabel("�߱ǿ���", JLabel.CENTER);
		til7 = new JLabel("ǥ�ذ���", JLabel.CENTER);
		til8 = new JLabel("�ǸŰ���", JLabel.CENTER);
		titname = new JLabel("Ƽ��", JLabel.CENTER);
		tif1 = new JTextField();
		tif2 = new JTextField();
		tif3 = new JTextField();
		tif4 = new JTextField();
		tif5 = new JTextField();
		tif6 = new JTextField();
		tif7 = new JTextField();
		tif8 = new JTextField();
		tiinsert = new JButton("�Է�");
		tidelete = new JButton("����");
		tiupdate = new JButton("����");
		
		// �¼�: �¼���ȣ, �󿵰���ȣ(FK), �¼���뿩��
		sel1 = new JLabel("�¼���ȣ", JLabel.CENTER);
		sel2 = new JLabel("�󿵰���ȣ(FK)", JLabel.CENTER);
		sel2.setFont(font1);
		sel3 = new JLabel("�¼���뿩��", JLabel.CENTER);
		sel3.setFont(font2);
		setname = new JLabel("�¼�", JLabel.CENTER);
		sef1 = new JTextField();
		sef2 = new JTextField();
		sef3 = new JTextField();
		seinsert = new JButton("�Է�");
		sedelete = new JButton("����");
		seupdate = new JButton("����");
		
		// ȸ����: ȸ�����̵�, ����, �޴�����ȣ, ���ڸ����ּ�
		cl1 = new JLabel("ȸ�����̵�", JLabel.CENTER);
		cl2 = new JLabel("����", JLabel.CENTER);
		cl3 = new JLabel("�޴�����ȣ", JLabel.CENTER);
		cl4 = new JLabel("���ڸ����ּ�", JLabel.CENTER);
		cl4.setFont(font2);
		ctname = new JLabel("ȸ����", JLabel.CENTER);
		cf1 = new JTextField();
		cf2 = new JTextField();
		cf3 = new JTextField();
		cf4 = new JTextField();
		cinsert = new JButton("�Է�");
		cdelete = new JButton("����");
		cupdate = new JButton("����");
		
		// ��������: ���Ź�ȣ, �������, ��������, �����ݾ�, ȸ�����̵�(FK), ��������
		rl1 = new JLabel("���Ź�ȣ", JLabel.CENTER);
		rl2 = new JLabel("�������", JLabel.CENTER);
		rl3 = new JLabel("��������", JLabel.CENTER);
		rl4 = new JLabel("�����ݾ�", JLabel.CENTER);
		rl5 = new JLabel("ȸ�����̵�(FK)", JLabel.CENTER);
		rl5.setFont(font1);
		rl6 = new JLabel("��������", JLabel.CENTER);
		rtname = new JLabel("��������", JLabel.CENTER);
		rf1 = new JTextField();
		rf2 = new JTextField();
		rf3 = new JTextField();
		rf4 = new JTextField();
		rf5 = new JTextField();
		rf6 = new JTextField();
		rinsert = new JButton("�Է�");
		rdelete = new JButton("����");
		rupdate = new JButton("����");
		
		// �гο� ������Ʈ �߰�  ===================================================
		// ��ȭ
		TopPanel.add(new JLabel(""));
		TopPanel.add(ml1);
		TopPanel.add(ml2);
		TopPanel.add(ml3);
		TopPanel.add(ml4);
		TopPanel.add(ml5);
		TopPanel.add(ml6);
		TopPanel.add(ml7);
		TopPanel.add(ml8);
		TopPanel.add(ml9);
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(mtname);
		TopPanel.add(mf1);
		TopPanel.add(mf2);
		TopPanel.add(mf3);
		TopPanel.add(mf4);
		TopPanel.add(mf5);
		TopPanel.add(mf6);
		TopPanel.add(mf7);
		TopPanel.add(mf8);
		TopPanel.add(mf9);
		TopPanel.add(minsert);
		TopPanel.add(mdelete);
		TopPanel.add(mupdate);
		
		// ������
		TopPanel.add(new JLabel(""));
		TopPanel.add(schl1);
		TopPanel.add(schl2);
		TopPanel.add(schl3);
		TopPanel.add(schl4);
		TopPanel.add(schl5);
		TopPanel.add(schl6);
		TopPanel.add(schl7);
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(schtname);
		TopPanel.add(schf1);
		TopPanel.add(schf2);
		TopPanel.add(schf3);
		TopPanel.add(schf4);
		TopPanel.add(schf5);
		TopPanel.add(schf6);
		TopPanel.add(schf7);
		TopPanel.add(schinsert);
		TopPanel.add(schdelete);
		TopPanel.add(schupdate);
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		
		// �󿵰�
		TopPanel.add(new JLabel(""));
		TopPanel.add(thl1);
		TopPanel.add(thl2);
		TopPanel.add(thl3);
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(thtname);
		TopPanel.add(thf1);
		TopPanel.add(thf2);
		TopPanel.add(thf3);
		TopPanel.add(thinsert);
		TopPanel.add(thdelete);
		TopPanel.add(thupdate);
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		
		// Ƽ��
		TopPanel.add(new JLabel(""));
		TopPanel.add(til1);
		TopPanel.add(til2);
		TopPanel.add(til3);
		TopPanel.add(til4);
		TopPanel.add(til5);
		TopPanel.add(til6);
		TopPanel.add(til7);
		TopPanel.add(til8);
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(titname);
		TopPanel.add(tif1);
		TopPanel.add(tif2);
		TopPanel.add(tif3);
		TopPanel.add(tif4);
		TopPanel.add(tif5);
		TopPanel.add(tif6);
		TopPanel.add(tif7);
		TopPanel.add(tif8);
		TopPanel.add(tiinsert);
		TopPanel.add(tidelete);
		TopPanel.add(tiupdate);
		TopPanel.add(new JLabel(""));
		
		// �¼�
		TopPanel.add(new JLabel(""));
		TopPanel.add(sel1);
		TopPanel.add(sel2);
		TopPanel.add(sel3);
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(setname);
		TopPanel.add(sef1);
		TopPanel.add(sef2);
		TopPanel.add(sef3);
		TopPanel.add(seinsert);
		TopPanel.add(sedelete);
		TopPanel.add(seupdate);
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		
		// ȸ����
		TopPanel.add(new JLabel(""));
		TopPanel.add(cl1);
		TopPanel.add(cl2);
		TopPanel.add(cl3);
		TopPanel.add(cl4);
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(ctname);
		TopPanel.add(cf1);
		TopPanel.add(cf2);
		TopPanel.add(cf3);
		TopPanel.add(cf4);
		TopPanel.add(cinsert);
		TopPanel.add(cdelete);
		TopPanel.add(cupdate);
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		
		// ��������
		TopPanel.add(new JLabel(""));
		TopPanel.add(rl1);
		TopPanel.add(rl2);
		TopPanel.add(rl3);
		TopPanel.add(rl4);
		TopPanel.add(rl5);
		TopPanel.add(rl6);
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(rtname);
		TopPanel.add(rf1);
		TopPanel.add(rf2);
		TopPanel.add(rf3);
		TopPanel.add(rf4);
		TopPanel.add(rf5);
		TopPanel.add(rf6);
		TopPanel.add(rinsert);
		TopPanel.add(rdelete);
		TopPanel.add(rupdate);
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		TopPanel.add(new JLabel(""));
		
		
		// ��� ���â �߰�
		textResult = new JTextArea();
		BottomPanel = new JScrollPane(textResult);
		
		// �г� ��ġ�� ũ�� ����, �г� �߰�  ============================================
		TopPanel.setBounds(0,0,1250,280); // �� ���̺�� ���� 40��  // ����ũ�� 1250(������â ���ο��� -20)
		add(TopPanel);
		BottomPanel.setBounds(20,300,1220,100);
		add(BottomPanel);

		// �Է�,����,���� ��ư�� �̺�Ʈ �߰� ============================================
		minsert.addActionListener(new CRUDAction());
		mdelete.addActionListener(new CRUDAction());
		mupdate.addActionListener(new CRUDAction());
		schinsert.addActionListener(new CRUDAction());
		schdelete.addActionListener(new CRUDAction());
		schupdate.addActionListener(new CRUDAction());
		thinsert.addActionListener(new CRUDAction());
		thdelete.addActionListener(new CRUDAction());
		thupdate.addActionListener(new CRUDAction());	
		tiinsert.addActionListener(new CRUDAction());
		tidelete.addActionListener(new CRUDAction());
		tiupdate.addActionListener(new CRUDAction());		
		seinsert.addActionListener(new CRUDAction());
		sedelete.addActionListener(new CRUDAction());
		seupdate.addActionListener(new CRUDAction());		
		cinsert.addActionListener(new CRUDAction());
		cdelete.addActionListener(new CRUDAction());
		cupdate.addActionListener(new CRUDAction());		
		rinsert.addActionListener(new CRUDAction());
		rdelete.addActionListener(new CRUDAction());
		rupdate.addActionListener(new CRUDAction());
	}
}