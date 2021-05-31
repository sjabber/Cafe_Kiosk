package page.payment;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import DB.ConnectDB;
import Main.MainFrame;
import page.KioskPage;
import page.PageData;
import page.PageType;
import page.Button.NumberButton;

public class PaymentPage extends KioskPage{

	ConnectDB DB = new ConnectDB();
	private JPanel Top = new JPanel();
    private JPanel Bottom = new JPanel();
    private JPanel Middle = new JPanel();
    private JPanel Point = new JPanel();
    private JPanel PointYes = new JPanel();
    private JPanel PayFinal = new JPanel();
	private JLabel PhoneNumberResult;
	private JLabel PasswordInfo;
	private int TYPE=0;
	public String Password="";
	private int NumberCount=0;
	private int PasswordCount=0;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private String USER_INFO=""; //커피 구매시 스탬프 증가시켜줄 유저정보 스트링
	private String query = "SELECT user_Pnum, user_ID, user_PW, user_Stamp FROM user_info WHERE user_Pnum is not null";
    public PaymentPage() throws SQLException  {
        super(new PageData.Builder().previousPageType(PageType.PAY_PAGE).build());
        mainFrame = new MainFrame();
        mainFrame.setBounds(100, 100, 768, 850);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initPage();
        }
    private void initPage() throws SQLException {

        this.add(initTopPanel());
        this.add(initPointPanel());
        this.add(initPointYesPanel());
        this.add(initPayFinalPanel());

        this.add(intiBottomPanel());
    }
   
	private JPanel initPointPanel() {
		Point.setBounds(0, 100, 754, 500);
		Point.setLayout(null);
		Point.setBackground(Color.white);
		
		JLabel AskingStamp = new JLabel("스탬프 적립을 하시겠습니까?");
		AskingStamp.setFont(new Font("맑은 고딕", Font.PLAIN, 40));
		AskingStamp.setHorizontalAlignment(SwingConstants.CENTER);
		AskingStamp.setBounds(10, 30, 734, 40);
		Point.add(AskingStamp);
		
		JButton PointY=new JButton("YES");
		PointY.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Point.setVisible(false);
	    		PointYes.setVisible(true);
	    		lblNewLabel.setText("회원 정보");
	    		lblNewLabel_1.setText("핸드폰 번호와 비밀번호를 입력하세요.");

    	   }
	    });
		PointY.setBounds(170, 200, 200, 200);
	    Point.add(PointY);
	        
	    JButton PointN=new JButton("NO");	
	    PointN.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Point.setVisible(false);
	    		PayFinal.setVisible(true);
	    		lblNewLabel.setText("Easy Kiosk");
	    		lblNewLabel_1.setText("카드 결제");
	    	}
	    });
	    PointN.setBounds(370, 200, 200, 200);
	    Point.add(PointN);
		return Point;
	}
	
	/**
	포인트 입력하는창//디자인 수정 필요
	 
	 */
	private JPanel initPointYesPanel() {
		PointYes.setBounds(0, 100, 754, 500);
		PointYes.setLayout(null);
		PointYes.setBackground(Color.white);
		
		PhoneNumberResult = new JLabel("핸드폰 번호");
		PhoneNumberResult.setFont(new Font("맑은 고딕", Font.PLAIN, 40));
		PhoneNumberResult.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneNumberResult.setBounds(10, 30, 734, 40);
		PasswordInfo = new JLabel("비밀번호");
		PasswordInfo.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		PasswordInfo.setHorizontalAlignment(SwingConstants.CENTER);
		PasswordInfo.setBounds(10, 80, 734, 40);
		PointYes.add(PhoneNumberResult);
		PointYes.add(PasswordInfo);
		
		int i = 0;
		int j = 0;
		int count = 0;
		
		for(int k=1;k<10;k++) {
			if(count==3) {
				count=0;
				i=0;
				j++;
			}
			int x=120+(80*i);
			int y=160+(80*j);
			PointYes.add(ProductButton(x,y,k));
			i++;
			count++;
		}
		PointYes.add(Product010Button(120, 400, "010"));
		PointYes.add(ProductButton(200, 400, 0));
		PointYes.add(DeleteLastOneButton(280, 400, "del"));
		PointYes.add(TextResetButton(360, 240, "초기화"));
		PointYes.add(OKButton(360, 320, "확인"));
		PointYes.add(BackTOPayPageButton(360, 400, "취소"));
		PointYes.add(SwitchButton(360, 160,"번호/비번"));
		
		PointYes.setVisible(false);
		return PointYes;
	}
	private NumberButton BackTOPayPageButton(int x, int y, String k) {
        NumberButton btn = new NumberButton(k);
        btn.setBackground(Color.white);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setBounds(x, y, 80, 80);
        btn.setText(k+"");
        
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
					loadPaymentPage();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
		return btn;
	}
	private NumberButton OKButton(int x, int y, String k) {
        NumberButton btn = new NumberButton(k);
        btn.setBackground(Color.white);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setBounds(x, y, 80, 80);
        btn.setText(k+"");
        
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(NumberCount==11&&PasswordCount==4) {
            		System.out.println(PhoneNumberResult.getText());
                	System.out.println(Password);
                	try {
						DataIDcheck(query, DB);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    	    		
            	}else {
            		//팝업
                	System.out.println("다시 입력하시오");
                	System.out.println(NumberCount);
                	System.out.println(PasswordCount);
            	}
            }
        });
		return btn;
	}
	
	private void DataIDcheck(String query, ConnectDB db) throws SQLException{
        ResultSet rs = db.statement.executeQuery(query);
        String ID="";
        while(rs.next()) {
            ID=rs.getString("user_ID");
            //디비에서 핸드폰번호와 맞는 정보를 매칭한다
            if(PhoneNumberResult.getText().equals(ID)) {
            	System.out.println("아이디확인");
            	DataPWcheck(query,db);
            	break;
            }
        }
        //끝까지 돌려서 데이터에 해당핸드폰번호가 없을시
        if(PhoneNumberResult.getText()!=ID) {
        	//데이터에 자동으로회원가입
        	CreateID(query, db);
        }
	}
	private void CreateID(String query, ConnectDB db) throws SQLException{
        ResultSet rs = db.statement.executeQuery(query);
        //Info테이블 마지막 번호 찾기
        int lastNumber=0;
        while(rs.next()) {
        	lastNumber=rs.getInt("user_Pnum");
        }
        lastNumber++;
        System.out.println(lastNumber);
        String query2="INSERT INTO user_info (user_Pnum, user_ID, user_PW, user_Stamp) values ('"+lastNumber+"', '"+PhoneNumberResult+"', '"+Password+"', '0');";
        ConnectDB.statement.executeUpdate(query2);
        System.out.println("회원가입완료");
	}
	
	
	private void DataPWcheck(String query, ConnectDB db) throws SQLException{
        ResultSet rs = db.statement.executeQuery(query);
        String PW="";
        while(rs.next()) {
            PW=rs.getString("user_PW");
            //디비에서 핸드폰번호와 비밀번호를 매칭한다
            if(Password.equals(PW)) {
            	System.out.println("비밀번호확인");
            	PointYes.setVisible(false);
            	PayFinal.setVisible(true);
	    		lblNewLabel.setText("Easy Kiosk");
	    		lblNewLabel_1.setText("카드 결제");
            	break;
            }
        }
	}
	private NumberButton TextResetButton(int x, int y, String k) {
        NumberButton btn = new NumberButton(k);
        btn.setBackground(Color.white);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setBounds(x, y, 80, 80);
        btn.setText(k+"");
        
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
					loadCouponPage();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            }
        });
		return btn;
	}
	private NumberButton DeleteLastOneButton(int x, int y, String k) {
        NumberButton btn = new NumberButton(k);
        btn.setBackground(Color.white);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setBounds(x, y, 80, 80);
        btn.setText(k+"");
        
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//TYPE==0 핸드폰번호입력 /  TYPE==1 비밀번호입력
            	if(TYPE==0&&NumberCount>0) {
            		String tmp=PhoneNumberResult.getText();
            		tmp=tmp.substring(0,tmp.length()-1);
            		if(NumberCount==3||NumberCount==7) {
                		tmp=tmp.substring(0,tmp.length()-1);
            		}
            		PhoneNumberResult.setText(tmp);
            		NumberCount--;
            	}
            		else if(TYPE==1&&PasswordCount>0) {
            		String tmp=PasswordInfo.getText();
            		tmp=tmp.substring(0,tmp.length());
            		PasswordInfo.setText(tmp);
            		Password=Password.substring(0,Password.length()-1);
            		PasswordCount--;
            	}
            }
        });
		return btn;
	}
	private NumberButton Product010Button(int x, int y, String k) {
        NumberButton btn = new NumberButton(k);
        btn.setBackground(Color.white);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setBounds(x, y, 80, 80);
        btn.setText(k+"");
        
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(TYPE==0&&NumberCount==0) {
            		PhoneNumberResult.setText("010-");
            		NumberCount=3;
            	}
            }
        });
		return btn;
	}
	private NumberButton SwitchButton(int x, int y, String k) {
        NumberButton btn = new NumberButton(k);
        btn.setBackground(Color.white);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setBounds(x, y, 80, 80);
        btn.setText("비밀번호입력");
        
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//TYPE==0 핸드폰번호입력 /  TYPE==1 비밀번호입력
            	if(TYPE==0) {
            		TYPE=1;
            		btn.setText("휴대폰번호입력");
            	}else if(TYPE==1) {
            		TYPE=0;
            		btn.setText("비밀번호입력");
            	}
            }
        });
		return btn;
	}
	private NumberButton ProductButton(int x, int y, int k) {
        NumberButton btn = new NumberButton(k);
        btn.setBackground(Color.white);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setBounds(x, y, 80, 80);
        btn.setText(k+"");
        
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//TYPE==0 핸드폰번호입력 /  TYPE==1 비밀번호입력
            	if(TYPE==0&&NumberCount<11) {
            		if(PhoneNumberResult.getText().equals("핸드폰 번호")) {
            			PhoneNumberResult.setText("");
            		}
            		PhoneNumberResult.setText(PhoneNumberResult.getText()+btn.getText());
            		NumberCount++;
            		if(NumberCount==3||NumberCount==7) {
            			PhoneNumberResult.setText(PhoneNumberResult.getText()+"-");
            		}
            			
            	}else if(TYPE==1&&PasswordCount<4) {
            		if(PasswordInfo.getText().equals("비밀번호")) {
            			PasswordInfo.setText("");
            		}
            		Password+=btn.getText();
            		PasswordInfo.setText(PasswordInfo.getText()+"*");
            		PasswordCount++;
            	
            	}
            }
        });
		return btn;
	}
	
	
	/**
	 맨 마지막장 가운데에 카드 이미지 박고
	 총금액이랑 카드번호// 취소 승인요청 버튼 있는창
	 * @return
	 */
	private JPanel initPayFinalPanel() {
		PayFinal.setBounds(0, 100, 754, 500);
		PayFinal.setLayout(null);
		PayFinal.setBackground(Color.white);
		
		
		PayFinal.setVisible(false);
		return PayFinal;
	}
	private JPanel initTopPanel() {
		Top.setLayout(null);
		Top.setBounds(0, 0, 754, 94);
		Top.setBackground(new Color(255, 102, 102));
		lblNewLabel = new JLabel("Easy Kiosk");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 5, 764, 26);
		lblNewLabel_1 = new JLabel("결제 페이지");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 31, 764, 57);
		Top.add(lblNewLabel);
		Top.add(lblNewLabel_1);
	
		return Top;
	}
    private JPanel intiBottomPanel() {
		Bottom.setBounds(0, 600, 754, 238);
        Bottom.setLayout(null);
        Bottom.setBackground(new Color(255, 102, 102));

        return Bottom;
	}
    
}
