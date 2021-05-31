package page.payment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DB.Product;
import page.KioskPage;
import page.PageData;
import page.PageType;

public class PayPage extends KioskPage{


	private JPanel Top = new JPanel();
	private JPanel smallTop = new JPanel();
	private JPanel smallTop2 = new JPanel();
	public String Password;

    private JPanel Middle = new JPanel();
    private JPanel Bottom = new JPanel();
    private JPanel InorOut = new JPanel();
    private JPanel CardorCoupon = new JPanel();
    private JPanel Payment = new JPanel();

	private JTextArea NameTextArea;
	private JTextArea QuantityTextArea;
	private JTextArea PriceTextArea;
	private JTextField TotalamountTextField;
	private JButton BacktoMenu;
	private JButton TakeIn;
	private JButton TakeOut;
	private JButton BacktoInorOut;
	private JButton UseCoupon;
	private JButton PayCard;
	private String name="";
	private String quantity="";
	private String price="";
	private int TYPE=0;
//	private Popup Po;
//	private PopupFactory pf;
//	private JPanel CouponP=new JPanel();
	
	public PayPage() {
		super(new PageData.Builder().nextPageType(PageType.COUPON_PAGE).previousPageType(PageType.MENU_PAGE).build());
		initPage();
//		setNextPage();

		
	}

	private void initPage() {
		this.add(initPaymentPanel());
		this.add(initTopPanel());
		this.add(initMiddlePanel());
		this.add(intiBottomPanel());

		}

	private JPanel intiBottomPanel() {
		Bottom.setBounds(0, 600, 754, 238);
        Bottom.setLayout(null);
        Bottom.setBackground(new Color(255, 102, 102));
        Bottom.add(InorOutP());
        Bottom.add(CardorCouponP());
        
        return Bottom;
	}

	private JPanel initMiddlePanel() {
		Middle.setBounds(0, 94, 754, 500);
		Middle.setLayout(null);
		/**
		승환 - 메뉴 수량 가격 각각 가운데정렬 하고싶은데 (카카오오븐에나온것처럼) 
			텍스트에어리어3개 만드는거말고 좋은방법 생각안났음.
			텍스트에어리어3개시 단점 -> 새로줄 그어져있음 (지울방법있으면 변경)
			좋은방법있으면 싹다지워도됨
		 
		 **/
		
		//장바구니 메뉴 이름
		NameTextArea= new JTextArea();
		NameTextArea.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		NameTextArea.setAlignmentX(CENTER_ALIGNMENT);
		NameTextArea.setBounds(10, 10, 400, 300);
		Middle.add(NameTextArea);
		NameTextArea.setColumns(30);
		
		//장바구니 메뉴 수량
		QuantityTextArea= new JTextArea();
		QuantityTextArea.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		QuantityTextArea.setAlignmentX(CENTER_ALIGNMENT);
		QuantityTextArea.setBounds(410, 10, 140, 300);
		Middle.add(QuantityTextArea);
		QuantityTextArea.setColumns(30);
		
		//장바구니 메뉴 가격
		PriceTextArea= new JTextArea();
		PriceTextArea.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		PriceTextArea.setAlignmentX(CENTER_ALIGNMENT);
		PriceTextArea.setBounds(550, 10, 194, 300);
		Middle.add(PriceTextArea);
		PriceTextArea.setColumns(30);
		//244
		//총 가격
		TotalamountTextField = new JTextField();
		TotalamountTextField.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		TotalamountTextField.setHorizontalAlignment(SwingConstants.CENTER);
		TotalamountTextField.setBounds(10, 300, 734, 246);
		Middle.add(TotalamountTextField);
		TotalamountTextField.setColumns(40);
		
		
		System.out.println(CheckList.size());
		for(int i=0;i<CheckList.size();i++) {
			name+=CheckList.get(i).getProd_name()+"\n";
			price+=CheckList.get(i).getProd_price()+"원"+"\n";
			quantity+=cart.get(CheckList.get(i))+"개"+"\n";
			totalquantity+=cart.get(CheckList.get(i));
		}
		NameTextArea.setText(name);
		QuantityTextArea.setText(quantity);
		PriceTextArea.setText(price);
		TotalamountTextField.setText("총 수량 "+totalquantity+"개 총 결제금액 "+totalamount()+"원");
		return Middle;
	}

	private JPanel initTopPanel() {
		Top.setLayout(null);
		Top.setBounds(0, 0, 754, 94);
		Top.setBackground(new Color(255, 102, 102));
		JLabel lblNewLabel = new JLabel("Easy Kiosk");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 5, 764, 26);
		JLabel lblNewLabel_1 = new JLabel("주문 세부 내역을 다시한번 확인해주세요.");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 31, 764, 57);
		Top.add(lblNewLabel);
		Top.add(lblNewLabel_1);
	
		return Top;
	}
	/**
	 * 첫 결제화면 하단부에 매장 / 포장 선택
	 * @return
	 */

	private JPanel InorOutP() {
		InorOut.setLayout(null);
		InorOut.setBounds(10, 10, 600, 200);
		InorOut.setBackground(new Color(255, 102, 102));
		
		BacktoMenu=new JButton("돌아가기"+"\n"+"메뉴선택으로");
        BacktoMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               try {
				loadMenuPage();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            }
        });
        BacktoMenu.setBounds(0, 0, 200, 200);
        InorOut.add(BacktoMenu);
		
		TakeIn=new JButton("매장");
		TakeIn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		InorOutNumber=1;
	    		InorOut.setVisible(false);
	    		CardorCoupon.setVisible(true);
	    		TotalamountTextField.setText(TotalamountTextField.getText()+" (매장)");
    	   }
	    });
		TakeIn.setBounds(200, 0, 200, 200);
	    InorOut.add(TakeIn);
	        
	    TakeOut=new JButton("포장");	
	    TakeOut.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		InorOutNumber=2;
	    		InorOut.setVisible(false);
	    		CardorCoupon.setVisible(true);
	    		TotalamountTextField.setText(TotalamountTextField.getText()+" (포장)");

	    	}
	    });
	    TakeOut.setBounds(400, 0, 200, 200);
	    InorOut.add(TakeOut);

		return InorOut;
	}
	
	/**
	 * 매장 / 포장 선택후 -> 스탬프 / 카드결제 선택
	 * @return
	 */
	private JPanel CardorCouponP() {

		CardorCoupon.setLayout(null);
		CardorCoupon.setBounds(10, 10, 600, 200);
		CardorCoupon.setBackground(new Color(255, 102, 102));
		
		BacktoInorOut=new JButton("돌아가기"+"\n"+"(매장 / 포장)");
		BacktoInorOut.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		CardorCoupon.setVisible(false);
	    		InorOut.setVisible(true);
    	   }
	    });
		BacktoInorOut.setBounds(0, 0, 200, 200);
	    CardorCoupon.add(BacktoInorOut);
	        
	    UseCoupon=new JButton("스탬프사용");
	    UseCoupon.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
//	    		Coupon.setVisible(true);
//	    		Coupon.setEnabled(true);
//	    		Coupon.grabFocus();
	   
	    		try {
					loadCouponPage();
					System.out.println(11);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    	   }
	    });
	    UseCoupon.setBounds(200, 0, 200, 200);
	    CardorCoupon.add(UseCoupon);
	        
	    PayCard=new JButton("카드결제");	
	    PayCard.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
					loadPaymentPage();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}
	    });
	    PayCard.setBounds(400, 0, 200, 200);
	    CardorCoupon.add(PayCard);
		return CardorCoupon;
	}
	
	private JPanel initPaymentPanel() {
		Payment.setLayout(null);
		Payment.setBounds(70,100, 600, 600);
		Payment.setBackground(Color.white);
		Payment.setVisible(false);
		Payment.setEnabled(false);
		Payment.add(PaymentPanelTop());
		return Payment;
		
	}
	
	private JPanel CouponPanelTop() {
		smallTop.setLayout(null);
		smallTop.setBounds(0,0, 600, 90);
		smallTop.setBackground(new Color(255, 102, 102));
		JLabel lblNewLabel1 = new JLabel("Easy Kiosk");
		lblNewLabel1.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel1.setForeground(new Color(255, 255, 255));
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setBounds(0, 5, 600, 26);
		JLabel lblNewLabel1_1 = new JLabel("핸드폰 번호와 비밀번호를 입력하세요.");
		lblNewLabel1_1.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1_1.setBounds(0, 31, 600, 57);
		smallTop.add(lblNewLabel1);
		smallTop.add(lblNewLabel1_1);
		return smallTop;
	}
	

	private JPanel PaymentPanelTop() {
		smallTop2.setLayout(null);
		smallTop2.setBounds(0,0, 600, 90);
		smallTop2.setBackground(new Color(255, 102, 102));
		JLabel lblNewLabel1 = new JLabel("Easy Kiosk");
		lblNewLabel1.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel1.setForeground(new Color(255, 255, 255));
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setBounds(0, 5, 600, 26);
		JLabel lblNewLabel1_1 = new JLabel("포인트를 적립하시겠습니까");
		lblNewLabel1_1.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1_1.setBounds(0, 31, 600, 57);
		smallTop2.add(lblNewLabel1);
		smallTop2.add(lblNewLabel1_1);
		return smallTop2;
	}
}
