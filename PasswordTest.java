import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PasswordTest extends JFrame implements ActionListener
{
	private JTextArea notatnik;
	private PanelHas�a panelHas�a;
	private JScrollPane scrollPane;
	private JButton bDodajU�ytkownika;
	
	public PasswordTest()
	{
		setTitle("Demonstracja okna dialogowego");
		setSize(400, 400);
		setLayout(null);
		
		notatnik = new JTextArea();
		notatnik.setWrapStyleWord(true); // Powoduje ze jak bedziemy dochodzic do konca linii bedziemy przechodzic do nowej
		scrollPane = new JScrollPane(notatnik);
		scrollPane.setBounds(0, 0, 300, 200);
		add(scrollPane);
		
		bDodajU�ytkownika = new JButton("Dodaj U�ytkownika");
		bDodajU�ytkownika.setBounds(0, 250, 150, 20);
		add(bDodajU�ytkownika);
		bDodajU�ytkownika.addActionListener(this);
		
	}
	
	
	public static void main(String[] args)
	{
		PasswordTest app = new PasswordTest();
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
		app.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(panelHas�a == null)
			panelHas�a = new PanelHas�a(this);
		panelHas�a.setVisible(true);
		panelHas�a.setFocus();
		
		if(panelHas�a.isOK())
		{
			notatnik.append(panelHas�a.getUser() + " , ");
			notatnik.append(panelHas�a.getPassword() + "\n");
		}
	}
	
}

class PanelHas�a extends JDialog implements ActionListener
{
	private JLabel lUser, lHas�o;
	private JTextField tUser;
	private JPasswordField pHas�o;
	private JButton bOk, bCancel;
	private boolean okData;
	
	public PanelHas�a(JFrame owner)
	{
		super(owner , "Wprowadzanie has�a", true);
		setSize(300, 200);
		setLayout(null);
		
		lUser = new JLabel("U�ytkownik", JLabel.RIGHT);
		lUser.setBounds(0, 10, 100, 20);
		add(lUser);
		
		tUser = new JTextField();
		tUser.setBounds(150, 10, 100, 20);
		add(tUser);
		
		lHas�o = new JLabel("Has�o", JLabel.RIGHT);
		lHas�o.setBounds(0, 50, 100, 20);
		add(lHas�o);
		
		pHas�o = new JPasswordField();
		pHas�o.setBounds(150, 50, 100, 20);
		add(pHas�o);
		
		bOk = new JButton("OK");
		bOk.setBounds(10, 100, 100, 20);
		add(bOk);
		bOk.addActionListener(this);
		
		bCancel = new JButton("Cancel");
		bCancel.setBounds(160, 100, 100, 20);
		add(bCancel);
		bCancel.addActionListener(this);
		
	}
	
	public String getUser()
	{
		return tUser.getText();
	}
	
	public String getPassword()
	{
		return new String(pHas�o.getPassword());
	}
	
	public boolean isOK()
	{
		return okData;
	}
	
	public void setFocus()
	{
		tUser.requestFocusInWindow();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object z = e.getSource();
		if (z == bOk)
			okData = true;
		else
			okData = false;
		
		setVisible(false);
	}
	
}
