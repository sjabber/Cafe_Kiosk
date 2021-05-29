package page.payment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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

import page.KioskPage;
import page.PageData;
import page.PageType;

public class PayPage extends KioskPage{


	private JPanel Top = new JPanel();
    private JPanel Middle = new JPanel();
    private JPanel Bottom = new JPanel();
	private JTextArea NameTextArea;
	private JTextArea QuantityTextArea;
	private JTextArea PriceTextArea;
	private JTextField TotalamountTextField;
	private JButton BacktoMenu;

	private String name="";
	private String quantity="";
	private String price="";
	private int totalquantity=0;
	public PayPage() {
		super(new PageData.Builder().previousPageType(PageType.MENU_PAGE).build());
		initPage();
//		setNextPage();
	}

	private void initPage() {
		// TODO Auto-generated method stub
		this.add(initTopPanel());
		this.add(initMiddlePanel());
		this.add(intiBottomPanel());
		}

	private JPanel intiBottomPanel() {
		Bottom.setBounds(0, 660, 754, 238);
        Bottom.setLayout(null);

        Bottom.setBackground(Color.red);

        BacktoMenu=new JButton("button");
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
        BacktoMenu.setBounds(20, 680, 100, 100);
        Bottom.add(BacktoMenu);
        
        return Bottom;
	}

	private JPanel initMiddlePanel() {
		Middle.setBounds(0, 94, 754, 566);
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
		TotalamountTextField.setBounds(10, 300, 734, 244);
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
}
