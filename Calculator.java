import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator{
	public static void main(String[] args){
		JFrame f= new JFrame("Calculator");
		f.setSize(1000,900);
		f.setLayout(new GridLayout(2,1));
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		JPanel p1,p2;

		p1 = new JPanel();
		p1.setLayout(new GridLayout(2,1));
		JPanel head = new JPanel();
		head.setLayout(null);
		JLabel h = new JLabel("Calculator");
		h.setBounds(600,50,300,100);
		h.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		//head.setBackground(Color.red);
 		head.add(h);
		p1.add(head);
	
		//p1.setLayout(new GridLayout(1,1));
		JTextArea jt = new JTextArea();
	        jt.setFont(new Font("Times New Roman", Font.PLAIN,20));
		//jt.setEditable(false);
		p1.add(jt);

		p2 = new JPanel();
		p2.setLayout(new GridLayout(4,4));
		JButton[] but = new JButton[4][4];
		String[] str = {"Del", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "Clr", "+", "-", "*", "/","%"};
		for (int i = 0; i <  but.length(); i++){
			for(int j = 0; j<but[i].length; j++){
				but[i] = new JButton(str[i]);
			        but[i].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						jt.setText(str[i]);
					}
				});
			}
		}
		//p2.setLayout(new GridLayout(4, 4));
		/*JButton one, two, three, four, five, six, seven, eight, nine, zero, add1, sub, mul, div, mod, equ;
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		add1 = new JButton("+");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		sub = new JButton("-");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		mul = new JButton("*");
		div = new JButton("/");
		mod = new JButton("%");
		p2.add(one);
		p2.add(two);
		p2.add(three);
		p2.add(add1);
		p2.add(four);
		p2.add(five);
		p2.add(six);
		p2.add(sub);
		p2.add(seven);
		p2.add(eight);
		p2.add(nine);
		p2.add(mul);
		p2.add(new JButton("0"));
		p2.add(div);
		p2.add(mod);
		p2.add(new JButton("="));
		one.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jt.setText("1");
			}
		});*/
		p2.add(but);
		f.add(p1);
		f.add(p2);
		f.setVisible(true);
	}
}
