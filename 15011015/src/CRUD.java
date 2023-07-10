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
		setLayout(null); // 특정 레이아웃 사용가능, 이거쓰면  각 컴포넌트 setBounds 해줘야 보임.

		TopPanel = new JPanel(new GridLayout(0, 13));
		
		Font font1 = new Font("Dialog", Font.BOLD, 12); // 8
		Font font2 = new Font("Dialog", Font.BOLD, 12); // 10
		
		// 테이블별 컴포넌트 선언  ======================================================
		// 영화: 영화번호, 영화명, 상영시간, 상영등급, 감독명, 배우명, 장르, 영화소개, 개봉일
		ml1 = new JLabel("영화번호", JLabel.CENTER);	
		ml2 = new JLabel("영화명", JLabel.CENTER);
		ml3 = new JLabel("상영시간", JLabel.CENTER);
		ml4 = new JLabel("상영등급", JLabel.CENTER);
		ml5 = new JLabel("감독명", JLabel.CENTER);
		ml6 = new JLabel("배우명", JLabel.CENTER);
		ml7 = new JLabel("장르", JLabel.CENTER);
		ml8 = new JLabel("영화소개", JLabel.CENTER);
		ml9 = new JLabel("개봉일", JLabel.CENTER);
		mtname = new JLabel("영화", JLabel.CENTER);
		mf1 = new JTextField();
		mf2 = new JTextField();
		mf3 = new JTextField();
		mf4 = new JTextField();
		mf5 = new JTextField();
		mf6 = new JTextField();
		mf7 = new JTextField();
		mf8 = new JTextField();
		mf9 = new JTextField();
		minsert = new JButton("입력");
		mdelete = new JButton("삭제");
		mupdate = new JButton("변경");
		
		// 상영일정: 상영일정번호, 영화번호(FK), 상영관번호(FK), 상영시작일, 상영요일, 상영회차, 상영시작시간
		schl1 = new JLabel("상영일정번호", JLabel.CENTER);
		schl1.setFont(font2);
		schl2 = new JLabel("영화번호(FK)", JLabel.CENTER);
		schl2.setFont(font2);
		schl3 = new JLabel("상영관번호(FK)", JLabel.CENTER);
		schl3.setFont(font1);
		schl4 = new JLabel("상영시작일", JLabel.CENTER);
		schl5 = new JLabel("상영요일", JLabel.CENTER);
		schl6 = new JLabel("상영회차", JLabel.CENTER);
		schl7 = new JLabel("상영시작시간", JLabel.CENTER);
		schl7.setFont(font2);
		schtname = new JLabel("상영일정", JLabel.CENTER);
		schf1 = new JTextField();
		schf2 = new JTextField();
		schf3 = new JTextField();
		schf4 = new JTextField();
		schf5 = new JTextField();
		schf6 = new JTextField();
		schf7 = new JTextField();
		schinsert = new JButton("입력");
		schdelete = new JButton("삭제");
		schupdate = new JButton("변경");
		
		// 상영관: 상영관번호, 좌석수, 상영관사용여부
		thl1 = new JLabel("상영관번호", JLabel.CENTER);
		thl2 = new JLabel("좌석수", JLabel.CENTER);
		thl3 = new JLabel("상영관사용여부", JLabel.CENTER);
		thl3.setFont(font1);
		thtname = new JLabel("상영관", JLabel.CENTER);
		thf1 = new JTextField();
		thf2 = new JTextField();
		thf3 = new JTextField();
		thinsert = new JButton("입력");
		thdelete = new JButton("삭제");
		thupdate = new JButton("변경");
		
		// 티켓: 티켓번호, 상영일정번호(FK), 상영관번호(FK), 좌석번호(FK), 예매번호(FK), 발권여부, 표준가격, 판매가격
		til1 = new JLabel("티켓번호", JLabel.CENTER);
		til2 = new JLabel("상영일정번호(FK)", JLabel.CENTER);
		til2.setFont(font1);
		til3 = new JLabel("상영관번호(FK)", JLabel.CENTER);
		til3.setFont(font1);
		til4 = new JLabel("좌석번호(FK)", JLabel.CENTER);
		til4.setFont(font2);
		til5 = new JLabel("예매번호(FK)", JLabel.CENTER);
		til5.setFont(font2);
		til6 = new JLabel("발권여부", JLabel.CENTER);
		til7 = new JLabel("표준가격", JLabel.CENTER);
		til8 = new JLabel("판매가격", JLabel.CENTER);
		titname = new JLabel("티켓", JLabel.CENTER);
		tif1 = new JTextField();
		tif2 = new JTextField();
		tif3 = new JTextField();
		tif4 = new JTextField();
		tif5 = new JTextField();
		tif6 = new JTextField();
		tif7 = new JTextField();
		tif8 = new JTextField();
		tiinsert = new JButton("입력");
		tidelete = new JButton("삭제");
		tiupdate = new JButton("변경");
		
		// 좌석: 좌석번호, 상영관번호(FK), 좌석사용여부
		sel1 = new JLabel("좌석번호", JLabel.CENTER);
		sel2 = new JLabel("상영관번호(FK)", JLabel.CENTER);
		sel2.setFont(font1);
		sel3 = new JLabel("좌석사용여부", JLabel.CENTER);
		sel3.setFont(font2);
		setname = new JLabel("좌석", JLabel.CENTER);
		sef1 = new JTextField();
		sef2 = new JTextField();
		sef3 = new JTextField();
		seinsert = new JButton("입력");
		sedelete = new JButton("삭제");
		seupdate = new JButton("변경");
		
		// 회원고객: 회원아이디, 고객명, 휴대폰번호, 전자메일주소
		cl1 = new JLabel("회원아이디", JLabel.CENTER);
		cl2 = new JLabel("고객명", JLabel.CENTER);
		cl3 = new JLabel("휴대폰번호", JLabel.CENTER);
		cl4 = new JLabel("전자메일주소", JLabel.CENTER);
		cl4.setFont(font2);
		ctname = new JLabel("회원고객", JLabel.CENTER);
		cf1 = new JTextField();
		cf2 = new JTextField();
		cf3 = new JTextField();
		cf4 = new JTextField();
		cinsert = new JButton("입력");
		cdelete = new JButton("삭제");
		cupdate = new JButton("변경");
		
		// 예매정보: 예매번호, 결제방법, 결제상태, 결제금액, 회원아이디(FK), 결제일자
		rl1 = new JLabel("예매번호", JLabel.CENTER);
		rl2 = new JLabel("결제방법", JLabel.CENTER);
		rl3 = new JLabel("결제상태", JLabel.CENTER);
		rl4 = new JLabel("결제금액", JLabel.CENTER);
		rl5 = new JLabel("회원아이디(FK)", JLabel.CENTER);
		rl5.setFont(font1);
		rl6 = new JLabel("결제일자", JLabel.CENTER);
		rtname = new JLabel("예매정보", JLabel.CENTER);
		rf1 = new JTextField();
		rf2 = new JTextField();
		rf3 = new JTextField();
		rf4 = new JTextField();
		rf5 = new JTextField();
		rf6 = new JTextField();
		rinsert = new JButton("입력");
		rdelete = new JButton("삭제");
		rupdate = new JButton("변경");
		
		// 패널에 컴포넌트 추가  ===================================================
		// 영화
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
		
		// 상영일정
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
		
		// 상영관
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
		
		// 티켓
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
		
		// 좌석
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
		
		// 회원고객
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
		
		// 예매정보
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
		
		
		// 결과 출력창 추가
		textResult = new JTextArea();
		BottomPanel = new JScrollPane(textResult);
		
		// 패널 위치와 크기 설정, 패널 추가  ============================================
		TopPanel.setBounds(0,0,1250,280); // 한 테이블당 세로 40씩  // 가로크기 1250(윈도우창 가로에서 -20)
		add(TopPanel);
		BottomPanel.setBounds(20,300,1220,100);
		add(BottomPanel);

		// 입력,삭제,변경 버튼에 이벤트 추가 ============================================
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