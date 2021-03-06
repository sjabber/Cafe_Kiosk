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
	
	public PayPage() {
		super(new PageData.Builder().nextPageType(PageType.COUPON_PAGE).previousPageType(PageType.MENU_PAGE).build());
		initPage();
//		setNextPage();

		
	}

	private void initPage() {
//		this.add(initPaymentPanel());
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
		?????? - ?????? ?????? ?????? ?????? ??????????????? ??????????????? (?????????????????????????????????) 
			?????????????????????3??? ?????????????????? ???????????? ???????????????.
			?????????????????????3?????? ?????? -> ????????? ??????????????? (????????????????????? ??????)
			????????????????????? ??????????????????
		 
		 **/
		
		//???????????? ?????? ??????
		NameTextArea= new JTextArea();
		NameTextArea.setFont(new Font("?????? ??????", Font.PLAIN, 21));
		NameTextArea.setAlignmentX(CENTER_ALIGNMENT);
		NameTextArea.setBounds(10, 10, 400, 300);
		Middle.add(NameTextArea);
		NameTextArea.setColumns(30);
		
		//???????????? ?????? ??????
		QuantityTextArea= new JTextArea();
		QuantityTextArea.setFont(new Font("?????? ??????", Font.PLAIN, 21));
		QuantityTextArea.setAlignmentX(CENTER_ALIGNMENT);
		QuantityTextArea.setBounds(410, 10, 140, 300);
		Middle.add(QuantityTextArea);
		QuantityTextArea.setColumns(30);
		
		//???????????? ?????? ??????
		PriceTextArea= new JTextArea();
		PriceTextArea.setFont(new Font("?????? ??????", Font.PLAIN, 21));
		PriceTextArea.setAlignmentX(CENTER_ALIGNMENT);
		PriceTextArea.setBounds(550, 10, 194, 300);
		Middle.add(PriceTextArea);
		PriceTextArea.setColumns(30);
		//244
		//??? ??????
		TotalamountTextField = new JTextField();
		TotalamountTextField.setFont(new Font("?????? ??????", Font.PLAIN, 21));
		TotalamountTextField.setHorizontalAlignment(SwingConstants.CENTER);
		TotalamountTextField.setBounds(10, 300, 734, 246);
		Middle.add(TotalamountTextField);
		TotalamountTextField.setColumns(40);
		
		
		for(int i=0;i<CheckList.size();i++) {
			name+=CheckList.get(i).getProd_name()+"\n";
			price+=CheckList.get(i).getProd_price()+"???"+"\n";
			quantity+=cart.get(CheckList.get(i))+"???"+"\n";
			totalquantity+=cart.get(CheckList.get(i));
		}
		NameTextArea.setText(name);
		QuantityTextArea.setText(quantity);
		PriceTextArea.setText(price);
		TotalamountTextField.setText("??? ?????? "+totalquantity+"??? ??? ???????????? "+totalamount()+"???");
		return Middle;
	}

	private JPanel initTopPanel() {
		Top.setLayout(null);
		Top.setBounds(0, 0, 754, 94);
		Top.setBackground(new Color(255, 102, 102));
		JLabel lblNewLabel = new JLabel("Easy Kiosk");
		lblNewLabel.setFont(new Font("?????? ??????", Font.BOLD, 24));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 5, 764, 26);
		JLabel lblNewLabel_1 = new JLabel("?????? ?????? ????????? ???????????? ??????????????????.");
		lblNewLabel_1.setFont(new Font("?????? ??????", Font.BOLD, 24));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 31, 764, 57);
		Top.add(lblNewLabel);
		Top.add(lblNewLabel_1);
	
		return Top;
	}
	/**
	 * ??? ???????????? ???????????? ?????? / ?????? ??????
	 * @return
	 */

	private JPanel InorOutP() {
		InorOut.setLayout(null);
		InorOut.setBounds(10, 10, 600, 200);
		InorOut.setBackground(new Color(255, 102, 102));
		
		BacktoMenu=new JButton("????????????"+"\n"+"??????????????????");
        BacktoMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               try {
				loadMenuPage();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
            }
        });
        BacktoMenu.setBounds(0, 0, 200, 200);
        InorOut.add(BacktoMenu);
		
		TakeIn=new JButton("??????");
		TakeIn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		InorOutNumber=1;
	    		InorOut.setVisible(false);
	    		CardorCoupon.setVisible(true);
	    		TotalamountTextField.setText(TotalamountTextField.getText()+" (??????)");
    	   }
	    });
		TakeIn.setBounds(200, 0, 200, 200);
	    InorOut.add(TakeIn);
	        
	    TakeOut=new JButton("??????");	
	    TakeOut.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		InorOutNumber=2;
	    		InorOut.setVisible(false);
	    		CardorCoupon.setVisible(true);
	    		TotalamountTextField.setText(TotalamountTextField.getText()+" (??????)");

	    	}
	    });
	    TakeOut.setBounds(400, 0, 200, 200);
	    InorOut.add(TakeOut);
		return InorOut;
	}
	
	/**
	 * ?????? / ?????? ????????? -> ????????? / ???????????? ??????
	 * @return
	 */
	private JPanel CardorCouponP() {

		CardorCoupon.setLayout(null);
		CardorCoupon.setBounds(10, 10, 600, 200);
		CardorCoupon.setBackground(new Color(255, 102, 102));
		
		BacktoInorOut=new JButton("????????????"+"\n"+"(?????? / ??????)");
		BacktoInorOut.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		CardorCoupon.setVisible(false);
	    		InorOut.setVisible(true);
	    	    TotalamountTextField.setText(TotalamountTextField.getText().substring(0, TotalamountTextField.getText().length()-5));

    	   }
	    });
		BacktoInorOut.setBounds(0, 0, 200, 200);
	    CardorCoupon.add(BacktoInorOut);
	        
	    UseCoupon=new JButton("???????????????");
	    UseCoupon.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {

	   
	    		try {
					loadCouponPage();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    	   }
	    });
	    UseCoupon.setBounds(200, 0, 200, 200);
	    CardorCoupon.add(UseCoupon);
	        
	    PayCard=new JButton("????????????");	
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
	

}
