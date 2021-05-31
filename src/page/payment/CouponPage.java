package page.payment;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DB.ConnectDB;
import Main.MainFrame;
import page.KioskPage;
import page.PageData;
import page.PageType;
import page.Button.NumberButton;

public class CouponPage extends KioskPage{

	private JPanel Top = new JPanel();
    private JPanel Bottom = new JPanel();
    private JPanel Middle = new JPanel();
    private JPanel Middle_ID = new JPanel();
    private JPanel Middle_PW = new JPanel();
    private JPanel Bottom_Final = new JPanel();
    private JPanel Bottom_lack= new JPanel();
    private int input=0;
    

	private JLabel PhoneNumberResult;
	private JLabel PasswordInfo;
    private JPanel selectPanel;
	private int TYPE=0;
	public String Password="";
	private int NumberCount=0;
	private int PasswordCount=0;
	ConnectDB DB = new ConnectDB();
	private String query = "SELECT user_Pnum, user_ID, user_PW, user_Stamp FROM user_info WHERE user_Pnum is not null";
	private String ID="";
    private String PW="";
    private int UserStamp=0;
	
	public CouponPage() throws SQLException  {
        super(new PageData.Builder().nextPageType(PageType.START_PAGE).previousPageType(PageType.PAY_PAGE).build());
        mainFrame = new MainFrame();
        mainFrame.setBounds(100, 100, 768, 850);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initPage();
        }
	private void initPage() throws SQLException {

        this.add(initTopPanel());
        this.add(Middle_ID());
        this.add(intiBottomPanel());
    }
	/**
	 Middle_ID() => 회원정보(핸드폰번호 비밀번호) 입력하는 창// 디자인수정필요
	 * @return
	 */
	private JPanel Middle_ID() {
		Middle_ID.setBounds(0, 100, 754, 500);
		Middle_ID.setLayout(null);
		Middle_ID.setBackground(Color.white);
		PhoneNumberResult = new JLabel("핸드폰 번호");
		PhoneNumberResult.setFont(new Font("맑은 고딕", Font.PLAIN, 40));
		PhoneNumberResult.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneNumberResult.setBounds(10, 30, 734, 40);
		PasswordInfo = new JLabel("비밀번호");
		PasswordInfo.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		PasswordInfo.setHorizontalAlignment(SwingConstants.CENTER);
		PasswordInfo.setBounds(10, 80, 734, 40);
		Middle_ID.add(PhoneNumberResult);
		Middle_ID.add(PasswordInfo);
		
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
			Middle_ID.add(ProductButton(x,y,k));
			i++;
			count++;
		}
		Middle_ID.add(Product010Button(120, 400, "010"));
		Middle_ID.add(ProductButton(200, 400, 0));
		Middle_ID.add(DeleteLastOneButton(280, 400, "del"));
		Middle_ID.add(TextResetButton(360, 240, "초기화"));
		Middle_ID.add(OKButton(360, 320, "확인"));
		Middle_ID.add(BackTOPayPageButton(360, 400, "취소"));
		Middle_ID.add(SwitchButton(360, 160,"번호/비번"));

		return Middle_ID;
	}

	//버튼디자인 수정 필요
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
	//텍스트명 수정해야함
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
	private NumberButton OKButton(int x, int y, String k) {
        NumberButton btn = new NumberButton(k);
        btn.setBackground(Color.white);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setBounds(x, y, 80, 80);
        btn.setText(k+"");
        
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//스탬프보유량 안내 => 충분하면 쿠폰사용하시겠습니까 예/아니오 구현
            	//				부족하면 부족하다+현재수량 안내 후 다시 PayPage로
            	if(NumberCount==11&&PasswordCount==4) {
            		System.out.println(PhoneNumberResult.getText());
                	System.out.println(Password);
                	
                	//아이디체크
                	try {
						DateIDCheck(query,DB);
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
	
	private void DateIDCheck(String query, ConnectDB db) throws SQLException{
        ResultSet rs = db.statement.executeQuery(query);
        while(rs.next()) {
        	String tmp=rs.getString("user_ID");
        	if(PhoneNumberResult.getText().equals(tmp)) {
        		ID=rs.getString("user_ID");
            	PW=rs.getString("user_PW");
            	UserStamp=rs.getInt("user_Stamp");
            }
        }
        //끝까지 돌렸을떄 해당 핸드폰번호가 없으면
        if(PhoneNumberResult.getText().equals(ID)) {
        	DataPWcheck(query,db);
        }else {
        	System.out.println(PhoneNumberResult.getText());
        	System.out.println(ID);
        	JOptionPaneID();
        }
	}
	
	private void DataPWcheck(String query, ConnectDB db) throws SQLException{
        if(Password.equals(PW)) {
        	//사용팝업
        	CheckStamp(UserStamp);
        }else {
        	JOptionPanePW();
        }
	}
	
	private void CheckStamp(int userStamp) throws SQLException {
		if(userStamp>=totalquantity*10) {
			JOptionPaneConfirm();
			//스탬프사용하겠냐 => input 0 = ok , 2 = cancel;
			if(input==0) {
				JOptionPaneBill();
				//영수증 뽑겠냐 => input 0 = ok, 2 = cancel;
				JOptionPaneEND();
				StampUpdate(UserStamp,DB);
				PrintBill();
				loadStartPage();
			}
			
		}else {
			JOptionPaneLack();
			System.out.println("불충분");
			loadPayPage();

		}
	}
	private void PrintBill() {
		for(int i=0;i<CheckList.size();i++) {
			System.out.print(CheckList.get(i).getProd_name()+" "+CheckList.get(i).getProd_price()+"원 "+cart.get(CheckList.get(i))+"개"+"\n");
		}
		System.out.println("총 "+totalquantity+"개      "+"총 "+total+"원");
		if(InorOutNumber==1) {
			System.out.println("매장");
		}else if(InorOutNumber==2) {
			System.out.println("포장");
		}
	}
	
	private void StampUpdate(int Stamp,ConnectDB db) throws SQLException{
        ResultSet rs = db.statement.executeQuery(query);
        String query1="UPDATE user_info SET user_Stamp="+(UserStamp-(totalquantity*10))+" WHERE user_ID='"+ID+"';";
        ConnectDB.statement.executeUpdate(query1);
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
					loadPayPage();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
		return btn;
	}
	
	private JPanel initTopPanel() {
		Top.setLayout(null);
		Top.setBounds(0, 0, 754, 94);
		Top.setBackground(new Color(255, 102, 102));
		JLabel lblNewLabel = new JLabel("스탬프 사용");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 5, 764, 26);
		JLabel lblNewLabel_1 = new JLabel("핸드폰 번호와 비밀번호 4자리를 입력하세요");
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
        Bottom.add(Bottom_FinalP());
        Bottom.add(Bottom_lackP());
        return Bottom;
	}
	
	/**
	구상1 => 회원정보 입력하면 바텀(분홍)부분에 정보를 알려줄 계획
		1. 입력한 회원정보에 충분한 스탬프가 있으면 Bottom_FinalP
		2.							 없으면 Bottom_lack
		
			1-1 현재 사용가능한 스탬프 숫자 보여주고 // 취소 사용 버튼생성
												취소누르면 PayPage 리로드
												사용 누르면 결제 끝
			2-1 현재 사용가능한 스탬프 숫자 보여주고 모자르다고 안내 // 확인버튼 생성
														확인 누르면 PayPage 리로
				
	 * @return
	 */
	private JPanel Bottom_FinalP() {
		Bottom_Final.setLayout(null);
		Bottom_Final.setBounds(100, 10, 550, 200);
		Bottom_Final.setBackground(Color.white);
		JLabel lblNewLabel1 = new JLabel("연습");
		lblNewLabel1.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel1.setForeground(new Color(255, 255, 255));
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setBounds(0, 5, 550, 26);
		JLabel lblNewLabel1_1 = new JLabel("연습22");
		lblNewLabel1_1.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1_1.setBounds(0, 31, 550, 57);
		Bottom_Final.add(lblNewLabel1);
		Bottom_Final.add(lblNewLabel1_1);
		
		Bottom_Final.setVisible(false);
		return Bottom_Final;
	}
	private JPanel Bottom_lackP() {
		Bottom_lack.setLayout(null);
		Bottom_lack.setBounds(10, 10, 600, 200);
		Bottom_lack.setBackground(Color.white);
		
		Bottom_lack.setVisible(false);
		return Bottom_lack;
	}
	public void JOptionPaneID() {
		JOptionPane.showMessageDialog(this, "핸드폰 번호를 확인하시오.", "Message", JOptionPane.ERROR_MESSAGE);

    }
	public void JOptionPanePW() {
		JOptionPane.showMessageDialog(this, "비밀번호를 확인하시오.", "Message", JOptionPane.ERROR_MESSAGE);

    }
	public void JOptionPaneLack() {
//		JOptionPane.showConfirmDialog(null, 
//	            "스탬프가 부족하여 사용할 수 없습니다. (현재보유스탬프 : "+UserStamp+"개)", "실패", JOptionPane.DEFAULT_OPTION);
		input = JOptionPane.showConfirmDialog(null, 
	            "스탬프가 부족하여 사용할 수 없습니다. "+"(현재보유스탬프 : "+UserStamp+"개)", "실패", JOptionPane.DEFAULT_OPTION);
		//input 0 => OK
    }
	public void JOptionPaneConfirm() {
//		JOptionPane.showConfirmDialog(null, 
//	            "스탬프를 사용하여 구매하시겠습니까? (현재보유스탬프 : "+UserStamp+"개)", "확인", 
//	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		
		input = JOptionPane.showConfirmDialog(null, 
				 "스탬프를 사용하여 구매하시겠습니까? (현재보유스탬프 : "+UserStamp+"개)", "확인", 
		            JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		//input 0 => OK , 2 => CANCEL
    }
	public void JOptionPaneBill() {
//		JOptionPane.showConfirmDialog(null, 
//	            "구매가 완료되었습니다. 영수증을 출력하시겠습니까? (현재보유스탬프 : "+UserStamp+"개)", "확인", 
//	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		
		input = JOptionPane.showConfirmDialog(null, 
	            "구매가 완료되었습니다. 영수증을 출력하시겠습니까? (현재보유스탬프 : "+UserStamp+"개)", "확인", 
		            JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		//input 0 => OK , 2 => CANCEL
    }
	
	public void JOptionPaneEND() {
		input = JOptionPane.showConfirmDialog(null, 
                "구매가 완료되었습니다.", "완료", JOptionPane.DEFAULT_OPTION);
//		JOptionPane.showConfirmDialog(null, 
//                "구매가 완료되었습니다.", "완료", JOptionPane.DEFAULT_OPTION);
		
		//input 0 => OK
    }
}
