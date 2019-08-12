import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;


public class AppPension extends JFrame implements ActionListener
{
	private JMenuBar menubar;
	private JButton ButtonPraca, ButtonZlecenie, ButtonDzielo;
	private JMenu mClose, mHelp;
	private JMenuItem miClose, miHelp;
	private UmowaPraca umowapraca;
	private UmowaZlecenie umowazlecenie;
	private UmowaDzielo umowadzielo;
	public AppPension()
	{
		setTitle("Oblicz pensjê");
		setSize(570, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		menubar = new JMenuBar();
		mClose = new JMenu("Plik");
		miClose = new JMenuItem("Zamknij Program", 'Z');
		miClose.addActionListener(this);
		miClose.setAccelerator(KeyStroke.getKeyStroke("ctrl Z"));
		
		mClose.add(miClose);
		
		mHelp = new JMenu("Pomoc");
		miHelp = new JMenuItem("Pomoc i Opis", 'P');
		miHelp.addActionListener(this);
		miHelp.setAccelerator(KeyStroke.getKeyStroke("ctrl P"));
		mHelp.add(miHelp);
		setJMenuBar(menubar);
		menubar.add(mClose);
		menubar.add(mHelp);
		
		ButtonPraca = new JButton("Umowa o pracê");
		ButtonPraca.setBounds(20, 20, 150, 40);
		add(ButtonPraca);
		ButtonPraca.addActionListener(this);
		
		ButtonZlecenie = new JButton("Umowa Zlecenie");
		ButtonZlecenie.setBounds(200, 20, 150, 40);
		add(ButtonZlecenie);
		ButtonZlecenie.addActionListener(this);
		
		ButtonDzielo = new JButton("Umowa o dzie³o");
		ButtonDzielo.setBounds(380, 20, 150, 40);
		add(ButtonDzielo);
		ButtonDzielo.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object stream = e.getSource();
		if(stream == miClose)
		{
			int ask = JOptionPane.showConfirmDialog(null,
					"Czy na pewno chcesz wyjœæ?",
					" Pytanie", JOptionPane.YES_NO_OPTION);
			if(ask == JOptionPane.YES_OPTION)
				dispose();
		}
		if(stream == ButtonPraca)
		{
		if(umowapraca == null)
			umowapraca = new UmowaPraca(this);
		umowapraca.setVisible(true);
		umowapraca.setFocus();
		}
		
		if(stream == ButtonZlecenie)
		{
		if(umowazlecenie == null)
			umowazlecenie = new UmowaZlecenie(this);
		umowazlecenie.setVisible(true);
		umowazlecenie.setFocus();
		}
		if(stream == ButtonDzielo)
		{
		if(umowadzielo == null)
			umowadzielo = new UmowaDzielo(this);
		umowadzielo.setVisible(true);
		umowadzielo.setFocus();
		}
	}
	
	public static void main(String[] args)
	{
		AppPension appMenu = new AppPension();
		appMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
		appMenu.setVisible(true);
	}
}

class UmowaPraca extends JDialog implements ActionListener
{
	
	private JButton ButtonCount;
	private JLabel lPensionNet, lPInsurance,
	lDisInsurance, lMedInsurance, lHealthInsurance,
	lPIT, lPensionGross;
	private JTextField tfPensionGross, tfInsurance,
	tfDisInsurance, tfMedInsurance, tfHealthInsurance,
	tfPIT, tfPensionNet;
	double  wPensionGross, wPensionNet, wInsurance, wDifIndurance,
	wMedInsurance, wHealthInsurance, wPIT, wSums;
	
	public UmowaPraca(JFrame owner)
	{
		super(owner, "Umowa o pracê", true);
		setSize(800, 450);
		setLayout(null);

		tfPensionGross = new JTextField();
		tfPensionGross.setBounds(300, 50, 300, 20);
		add(tfPensionGross);
		tfPensionNet = new JTextField();
		tfPensionNet.setBounds(300, 150, 300, 20);
		add(tfPensionNet);
		tfInsurance = new JTextField();
		tfInsurance.setBounds(300, 180, 300, 20);
		add(tfInsurance);
		tfDisInsurance = new JTextField();
		tfDisInsurance.setBounds(300, 210, 300, 20);
		add(tfDisInsurance);
		tfMedInsurance = new JTextField();
		tfMedInsurance.setBounds(300, 240, 300, 20);
		add(tfMedInsurance);
		tfHealthInsurance = new JTextField();
		tfHealthInsurance.setBounds(300, 270, 300, 20);
		add(tfHealthInsurance);
		tfPIT = new JTextField();
		tfPIT.setBounds(300, 300, 300, 20);
		add(tfPIT);
		lPensionGross = new JLabel("Pensja Brutto");
		lPensionGross.setBounds(30, 50, 290, 20);
		add(lPensionGross);
		lPensionNet = new JLabel("Pensja Netto");
		lPensionNet.setBounds(30, 150, 290, 20);
		add(lPensionNet);
		lPInsurance = new JLabel("Ubezpieczenie emerytalne - 9,76%");
		lPInsurance.setBounds(30, 180, 290, 20);
		add(lPInsurance);
		lDisInsurance = new JLabel("Ubezpieczenie rentowe - 1,5%");
		lDisInsurance.setBounds(30, 210, 290, 20);
		add(lDisInsurance);
		lMedInsurance = new JLabel("Ubezpieczenie chorobowe - 2,45%");
		lMedInsurance.setBounds(30, 240, 290, 20);
		add(lMedInsurance);
		lHealthInsurance = new JLabel("Ubezpieczenie zdrowotne - 7,77%");
		lHealthInsurance.setBounds(30, 270, 290, 20);
		add(lHealthInsurance);
		lPIT = new JLabel("Zaliczka na PIT - 7,52%");
		lPIT.setBounds(30, 300, 290, 20);
		add(lPIT);

		ButtonCount = new JButton("Przelicz");
		ButtonCount.setBounds(210, 80, 300, 60);
		add(ButtonCount);
		ButtonCount.addActionListener(this);
		tfInsurance.addActionListener(this);
		tfDisInsurance.addActionListener(this);
		tfMedInsurance.addActionListener(this);
		tfHealthInsurance.addActionListener(this);
		tfPIT.addActionListener(this);
		tfPensionNet.addActionListener(this);
	}
	public void setFocus()
	{
		tfPensionGross.requestFocusInWindow();
	}
	
	@Override
	public void actionPerformed(ActionEvent ep) 
	{
		Object str = ep.getSource();
		wPensionGross = Double.parseDouble(tfPensionGross.getText());
		if(str == ButtonCount)
		{
			if(wPensionGross > 0)
			{
				wInsurance = wPensionGross * 0.0976;
				wDifIndurance = wPensionGross * 0.015;
				wMedInsurance = wPensionGross * 0.0245;
				wHealthInsurance = wPensionGross * 0.0777;
				wPIT = wPensionGross * 0.0752;
				wSums = (wInsurance + wDifIndurance + wMedInsurance +
						wHealthInsurance + wPIT); 
				wPensionNet = wPensionGross - wSums;
				
				wInsurance = Math.round(wInsurance);
				wDifIndurance = Math.round(wDifIndurance);
				wMedInsurance = Math.round(wMedInsurance);
				wHealthInsurance = Math.round(wHealthInsurance);
				wPIT = Math.round(wPIT);
				wPensionNet = Math.round(wPensionNet);
				tfInsurance.setText(String.valueOf(wInsurance));
				tfDisInsurance.setText(String.valueOf(wDifIndurance));
				tfMedInsurance.setText(String.valueOf(wMedInsurance));
				tfHealthInsurance.setText(String.valueOf(wHealthInsurance));
				tfPIT.setText(String.valueOf(wPIT));
				tfPensionNet.setText(String.valueOf(wPensionNet));
				tfPensionNet.setForeground(Color.GREEN);
				tfInsurance.setForeground(Color.RED);
				tfDisInsurance.setForeground(Color.RED);
				tfMedInsurance.setForeground(Color.RED);
				tfHealthInsurance.setForeground(Color.RED);
				tfPIT.setForeground(Color.RED);
			}
			if(wPensionGross <= 0)
			{
				JOptionPane.showMessageDialog(null, "Wprowadz poprawnie wartoœæ. Pensja Brutto nie mo¿e byæ mniejsza lub równa 0.");
			}
	}
	}
}


class UmowaZlecenie extends JDialog implements ActionListener
{
	
	private JButton ButtonCount;
	private JLabel lPensionNet, lPInsurance,
	lDisInsurance, lMedInsurance, lHealthInsurance,
	lPIT, lPensionGross, lFGSP;
	private JTextField tfPensionGross, tfInsurance,
	tfDisInsurance, tfMedInsurance, tfHealthInsurance,
	tfPIT, tfPensionNet, tfFGSP;
	double  wPensionGross, wPensionNet, wInsurance, wDifIndurance,
	wMedInsurance, wHealthInsurance, wPIT, wSums, wFGSP;
	
	public UmowaZlecenie(JFrame owner)
	{
		super(owner, "Umowa zlecenie", true);
		setSize(800, 450);
		setLayout(null);

		tfPensionGross = new JTextField();
		tfPensionGross.setBounds(300, 50, 300, 20);
		add(tfPensionGross);
		tfPensionNet = new JTextField();
		tfPensionNet.setBounds(300, 150, 300, 20);
		add(tfPensionNet);
		tfInsurance = new JTextField();
		tfInsurance.setBounds(300, 180, 300, 20);
		add(tfInsurance);
		tfDisInsurance = new JTextField();
		tfDisInsurance.setBounds(300, 210, 300, 20);
		add(tfDisInsurance);
		tfMedInsurance = new JTextField();
		tfMedInsurance.setBounds(300, 240, 300, 20);
		add(tfMedInsurance);
		tfHealthInsurance = new JTextField();
		tfHealthInsurance.setBounds(300, 270, 300, 20);
		add(tfHealthInsurance);
		tfPIT = new JTextField();
		tfPIT.setBounds(300, 300, 300, 20);
		add(tfPIT);
		tfFGSP = new JTextField();
		tfFGSP.setBounds(300, 330, 300, 20);
		add(tfFGSP);
		lPensionGross = new JLabel("Pensja Brutto");
		lPensionGross.setBounds(30, 50, 290, 20);
		add(lPensionGross);
		lPensionNet = new JLabel("Pensja Netto");
		lPensionNet.setBounds(30, 150, 290, 20);
		add(lPensionNet);
		lPInsurance = new JLabel("Ubezpieczenie emerytalne - 9,76%");
		lPInsurance.setBounds(30, 180, 290, 20);
		add(lPInsurance);
		lDisInsurance = new JLabel("Ubezpieczenie rentowe - 1,5%");
		lDisInsurance.setBounds(30, 210, 290, 20);
		add(lDisInsurance);
		lMedInsurance = new JLabel("Ubezpieczenie chorobowe - 2,45%");
		lMedInsurance.setBounds(30, 240, 290, 20);
		add(lMedInsurance);
		lHealthInsurance = new JLabel("Ubezpieczenie zdrowotne - 7,77%");
		lHealthInsurance.setBounds(30, 270, 290, 20);
		add(lHealthInsurance);
		lPIT = new JLabel("Zaliczka na PIT - 5,74%");
		lPIT.setBounds(30, 300, 290, 20);
		add(lPIT);
		lFGSP = new JLabel("Fundusz Pracy i FGŒP - 2,45%");
		lFGSP.setBounds(30, 330, 290, 20);
		add(lFGSP);
		
		ButtonCount = new JButton("Przelicz");
		ButtonCount.setBounds(210, 80, 300, 60);
		add(ButtonCount);
		ButtonCount.addActionListener(this);
		tfInsurance.addActionListener(this);
		tfDisInsurance.addActionListener(this);
		tfMedInsurance.addActionListener(this);
		tfHealthInsurance.addActionListener(this);
		tfPIT.addActionListener(this);
		tfPensionNet.addActionListener(this);
		tfFGSP.addActionListener(this);
	}
	public void setFocus()
	{
		tfPensionGross.requestFocusInWindow();
	}
	
	@Override
	public void actionPerformed(ActionEvent ep) 
	{
		Object str = ep.getSource();
		wPensionGross = Double.parseDouble(tfPensionGross.getText());
		if(str == ButtonCount)
		{
			if(wPensionGross > 0)
			{
				wInsurance = wPensionGross * 0.0976;
				wDifIndurance = wPensionGross * 0.015;
				wMedInsurance = wPensionGross * 0.0245;
				wHealthInsurance = wPensionGross * 0.07766;
				wPIT = wPensionGross * 0.0574;
				wFGSP = wPensionGross * 0.0245;
				wSums = (wInsurance + wDifIndurance + wMedInsurance +
						wHealthInsurance + wPIT + wFGSP); 
				wPensionNet = wPensionGross - wSums;
				
				wInsurance = Math.round(wInsurance);
				wDifIndurance = Math.round(wDifIndurance);
				wMedInsurance = Math.round(wMedInsurance);
				wHealthInsurance = Math.round(wHealthInsurance);
				wPIT = Math.round(wPIT);
				wPensionNet = Math.round(wPensionNet);
				wFGSP = Math.round(wFGSP);
				tfInsurance.setText(String.valueOf(wInsurance));
				tfDisInsurance.setText(String.valueOf(wDifIndurance));
				tfMedInsurance.setText(String.valueOf(wMedInsurance));
				tfHealthInsurance.setText(String.valueOf(wHealthInsurance));
				tfFGSP.setText(String.valueOf(wFGSP));
				tfPIT.setText(String.valueOf(wPIT));
				tfPensionNet.setText(String.valueOf(wPensionNet));
				tfPensionNet.setForeground(Color.GREEN);
				tfInsurance.setForeground(Color.RED);
				tfDisInsurance.setForeground(Color.RED);
				tfMedInsurance.setForeground(Color.RED);
				tfHealthInsurance.setForeground(Color.RED);
				tfPIT.setForeground(Color.RED);
				tfFGSP.setForeground(Color.RED);
			}
			if(wPensionGross <= 0)
			{
				JOptionPane.showMessageDialog(null, "Wprowadz poprawnie wartoœæ. Pensja Brutto nie mo¿e byæ mniejsza lub równa 0.");
			}
	}
	}
}

class UmowaDzielo extends JDialog implements ActionListener
{
	
	private JButton ButtonCount;
	private JLabel lPensionNet, lPInsurance,
	lDisInsurance, lMedInsurance, lHealthInsurance,
	lPIT, lPensionGross, lFGSP;
	private JTextField tfPensionGross, tfInsurance,
	tfDisInsurance, tfMedInsurance, tfHealthInsurance,
	tfPIT, tfPensionNet, tfFGSP;
	double  wPensionGross, wPensionNet, wInsurance, wDifIndurance,
	wMedInsurance, wHealthInsurance, wPIT, wSums, wFGSP;
	
	public UmowaDzielo(JFrame owner)
	{
		super(owner, "Umowa o dzie³o", true);
		setSize(800, 450);
		setLayout(null);

		tfPensionGross = new JTextField();
		tfPensionGross.setBounds(300, 50, 300, 20);
		add(tfPensionGross);
		tfPensionNet = new JTextField();
		tfPensionNet.setBounds(300, 150, 300, 20);
		add(tfPensionNet);
		tfInsurance = new JTextField();
		tfInsurance.setBounds(300, 180, 300, 20);
		add(tfInsurance);
		tfDisInsurance = new JTextField();
		tfDisInsurance.setBounds(300, 210, 300, 20);
		add(tfDisInsurance);
		tfMedInsurance = new JTextField();
		tfMedInsurance.setBounds(300, 240, 300, 20);
		add(tfMedInsurance);
		tfHealthInsurance = new JTextField();
		tfHealthInsurance.setBounds(300, 270, 300, 20);
		add(tfHealthInsurance);
		tfPIT = new JTextField();
		tfPIT.setBounds(300, 300, 300, 20);
		add(tfPIT);
		tfFGSP = new JTextField();
		tfFGSP.setBounds(300, 330, 300, 20);
		add(tfFGSP);
		lPensionGross = new JLabel("Pensja Brutto");
		lPensionGross.setBounds(30, 50, 290, 20);
		add(lPensionGross);
		lPensionNet = new JLabel("Pensja Netto");
		lPensionNet.setBounds(30, 150, 290, 20);
		add(lPensionNet);
		lPInsurance = new JLabel("Ubezpieczenie emerytalne - 9,76%");
		lPInsurance.setBounds(30, 180, 290, 20);
		add(lPInsurance);
		lDisInsurance = new JLabel("Ubezpieczenie rentowe - 1,5%");
		lDisInsurance.setBounds(30, 210, 290, 20);
		add(lDisInsurance);
		lMedInsurance = new JLabel("Ubezpieczenie chorobowe - 2,45%");
		lMedInsurance.setBounds(30, 240, 290, 20);
		add(lMedInsurance);
		lHealthInsurance = new JLabel("Ubezpieczenie zdrowotne - 7,77%");
		lHealthInsurance.setBounds(30, 270, 290, 20);
		add(lHealthInsurance);
		lPIT = new JLabel("Zaliczka na PIT - 5,74%");
		lPIT.setBounds(30, 300, 290, 20);
		add(lPIT);
		lFGSP = new JLabel("Fundusz Pracy i FGŒP - 2,45%");
		lFGSP.setBounds(30, 330, 290, 20);
		add(lFGSP);
		
		ButtonCount = new JButton("Przelicz");
		ButtonCount.setBounds(210, 80, 300, 60);
		add(ButtonCount);
		ButtonCount.addActionListener(this);
		tfInsurance.addActionListener(this);
		tfDisInsurance.addActionListener(this);
		tfMedInsurance.addActionListener(this);
		tfHealthInsurance.addActionListener(this);
		tfPIT.addActionListener(this);
		tfPensionNet.addActionListener(this);
		tfFGSP.addActionListener(this);
	}
	public void setFocus()
	{
		tfPensionGross.requestFocusInWindow();
	}
	
	@Override
	public void actionPerformed(ActionEvent ep) 
	{
		Object str = ep.getSource();
		wPensionGross = Double.parseDouble(tfPensionGross.getText());
		if(str == ButtonCount)
		{
			if(wPensionGross > 0)
			{
				wInsurance = wPensionGross * 0.0976;
				wDifIndurance = wPensionGross * 0.015;
				wMedInsurance = wPensionGross * 0.0245;
				wHealthInsurance = wPensionGross * 0.07766;
				wPIT = wPensionGross * 0.0574;
				wFGSP = wPensionGross * 0.0245;
				wSums = (wInsurance + wDifIndurance + wMedInsurance +
						wHealthInsurance + wPIT + wFGSP); 
				wPensionNet = wPensionGross - wSums;
				
				wInsurance = Math.round(wInsurance);
				wDifIndurance = Math.round(wDifIndurance);
				wMedInsurance = Math.round(wMedInsurance);
				wHealthInsurance = Math.round(wHealthInsurance);
				wPIT = Math.round(wPIT);
				wPensionNet = Math.round(wPensionNet);
				wFGSP = Math.round(wFGSP);
				tfInsurance.setText(String.valueOf(wInsurance));
				tfDisInsurance.setText(String.valueOf(wDifIndurance));
				tfMedInsurance.setText(String.valueOf(wMedInsurance));
				tfHealthInsurance.setText(String.valueOf(wHealthInsurance));
				tfFGSP.setText(String.valueOf(wFGSP));
				tfPIT.setText(String.valueOf(wPIT));
				tfPensionNet.setText(String.valueOf(wPensionNet));
				tfPensionNet.setForeground(Color.GREEN);
				tfInsurance.setForeground(Color.RED);
				tfDisInsurance.setForeground(Color.RED);
				tfMedInsurance.setForeground(Color.RED);
				tfHealthInsurance.setForeground(Color.RED);
				tfPIT.setForeground(Color.RED);
				tfFGSP.setForeground(Color.RED);
			}
			if(wPensionGross <= 0)
			{
				JOptionPane.showMessageDialog(null, "Wprowadz poprawnie wartoœæ. Pensja Brutto nie mo¿e byæ mniejsza lub równa 0.");
			}
	}
	}
}
