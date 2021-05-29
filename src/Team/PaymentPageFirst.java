package Team;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaymentPageFirst extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PaymentPageFirst dialog = new PaymentPageFirst();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PaymentPageFirst() {
		
		//��ü ũ��
		setBounds(60, 60, 634, 720);
		getContentPane().setLayout(new BorderLayout());
	
		//��ü �г�
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		{
		//Top ��û�� / �ֹ��� �ٽ� �� �� Ȯ���� �ּ��� ���� ����
			JLabel TopRequest = new JLabel("\uC8FC\uBB38 \uC138\uBD80 \uB0B4\uC5ED\uC744 \uB2E4\uC2DC \uD55C \uBC88 \uD655\uC778\uD574 \uC8FC\uC138\uC694.");
			TopRequest.setForeground(Color.WHITE);
			TopRequest.setFont(new Font("���� ���", Font.BOLD, 20));
			TopRequest.setOpaque(true);
			TopRequest.setBackground(new Color(255, 102, 102));
			TopRequest.setHorizontalAlignment(SwingConstants.CENTER);
			TopRequest.setBounds(0, 0, 620, 72);
			contentPanel.add(TopRequest);
		}
		{
			//����+��ư ��ü �г� 
			JPanel EntirePanel = new JPanel();
			EntirePanel.setBackground(Color.WHITE);
			EntirePanel.setBounds(0, 70, 620, 613);
			contentPanel.add(EntirePanel);
			EntirePanel.setLayout(null);
			
			
			{
				//���� ����Ʈ + �����ݾ� 
				JPanel CountList = new JPanel();
				CountList.setBackground(Color.LIGHT_GRAY);
				CountList.setBounds(43, 52, 532, 421);
				EntirePanel.add(CountList);
				CountList.setLayout(null);
				
				//�ֹ�����Ʈ �޾ƿ��� 
				
				{
					JLabel MenuLabel = new JLabel("(ICE)");
					MenuLabel.setHorizontalAlignment(SwingConstants.CENTER);
					MenuLabel.setFont(new Font("���� ���", Font.PLAIN, 25));
					MenuLabel.setBounds(12, 10, 508, 64);
					CountList.add(MenuLabel);
				}
				
				{
					JLabel CountResult = new JLabel("\uCD1D \uC218\uB7C9 n\uAC1C ");
					CountResult.setHorizontalAlignment(SwingConstants.CENTER);
					CountResult.setFont(new Font("���� ���", Font.PLAIN, 30));
					CountResult.setBounds(12, 309, 225, 64);
					CountList.add(CountResult);
				}
			
				{
					JLabel lblM = new JLabel("\uCD1D \uACB0\uC81C\uAE08\uC561 m\uC6D0");
					lblM.setHorizontalAlignment(SwingConstants.CENTER);
					lblM.setFont(new Font("���� ���", Font.PLAIN, 30));
					lblM.setBounds(204, 309, 316, 64);
					CountList.add(lblM);
				}
			}
			{
				
				//��ư �г� 
				JPanel ButtonPane = new JPanel();
				ButtonPane.setBackground(Color.WHITE);
				ButtonPane.setBounds(0, 498, 620, 115);
				EntirePanel.add(ButtonPane);
				ButtonPane.setLayout(null);
				
				//������ ��ư, actionlistener �̱��� 
				{
					JButton okButton = new JButton("\uACB0\uC81C\uD558\uAE30");
					okButton.setForeground(Color.WHITE);
					okButton.setBackground(new Color(255, 102, 102));
					okButton.setFont(new Font("���� ���", Font.PLAIN, 25));
					okButton.setVerticalAlignment(SwingConstants.BOTTOM);
					okButton.setBounds(406, 8, 166, 95);
					okButton.setActionCommand("OK");
					okButton.setBorder(null);
					ButtonPane.add(okButton);
					
					getRootPane().setDefaultButton(okButton);
				}
				
				//���ư��� ��ư. ��ư Ŭ���ϸ� �˾� ���� 
				{
					JButton cancelButton = new JButton("\uB3CC\uC544\uAC00\uAE30");
					cancelButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						setVisible(false);
						}
					});
					cancelButton.setVerticalAlignment(SwingConstants.BOTTOM);
					cancelButton.setForeground(Color.WHITE);
					cancelButton.setFont(new Font("���� ���", Font.PLAIN, 25));
					cancelButton.setBounds(42, 8, 142, 95);
					cancelButton.setBackground(Color.black);
					cancelButton.setActionCommand("Cancel");
					cancelButton.setBorder(null);
					ButtonPane.add(cancelButton);
				}
				//������� ��ư 
				{
					JButton CouponButton = new JButton("\uCFE0\uD3F0\uC0AC\uC6A9");
					CouponButton.setForeground(Color.WHITE);
					CouponButton.setBackground(new Color(232,137,60));
					CouponButton.setFont(new Font("���� ���", Font.PLAIN, 25));
					CouponButton.setVerticalAlignment(SwingConstants.BOTTOM);
					CouponButton.setBounds(212, 7, 166, 97);
					CouponButton.setBorder(null);
					ButtonPane.add(CouponButton);
				}
			}
		}
	}

}
