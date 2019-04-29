package SecondPeriod;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

 /**
 * Shee Interface
 * @autor: Claudia Osorio
 * @author Medina Amayo D. Alonso
 * @version 1.0
 * @date  22/04/2019
 * javac -d Practicas/build/ Practicas/src/SecondPeriod/Schee.java Practicas/src/SecondPeriod/SeshatEngine.java
 * java -cp Practicas/build/ SecondPeriod.Schee
 */

public class Schee extends JFrame implements ActionListener
{

	/**Attributes*/
        private JLabel Title, auc, aua, coin, seshat;
        private JButton rf, ex, srch;

	public Schee()
	{
	}

	public void encGUI ()
        {
		Color cb, ct ;
		cb = Color.BLACK;
		ct = Color.PINK;
                int y = 15;
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                Container ventana = getContentPane();
                ventana.setBackground(cb);
                ventana.setLayout(null);

		/**Title*/
                Title = new JLabel();
                Title.setFont(new Font("Consolas", Font.PLAIN, y));
                Title.setBounds(650, 25, 300, 20);
                Title.setText("Schee");
                Title.setForeground(ct);
                ventana.add(Title);

                /**Start of the authors*/
                auc = new JLabel();
                auc.setFont(new Font("Consolas", Font.PLAIN, y));
                auc.setBounds(110, 45, 300, 20);
                auc.setText("Authors:Claudia Osorio");
                auc.setForeground(ct);
                ventana.add(auc);

                aua = new JLabel();
                aua.setFont(new Font("Consolas", Font.PLAIN, y));
                aua.setBounds(110, 75, 300,20);
                aua.setText("Medina Amayo D. Alonso");
                aua.setForeground(ct);
                ventana.add(aua);
                /**End of the autors*/

		/**Exit button*/
                ex = new JButton("Salir :c");
                ex.setBounds(20, 600, 120, 20);
                ex.addActionListener(this);
                ventana.add(ex);

		/**Read File*/
                rf = new JButton("Nuevo Archivo");
                rf.setBounds(1100, 600, 120, 20);
                rf.addActionListener(this);
                ventana.add(rf);

		/**Title*/
                coin = new JLabel();
                coin.setFont(new Font("Consolas", Font.PLAIN, y));
                coin.setBounds(500, 150, 300, 20);
                coin.setText("Archivos coincidentes: ");
                coin.setForeground(ct);
                ventana.add(coin);

		/** Serch a word or phrase*/
		srch = new JButton("Search");
		srch.setBounds(1100, 660, 120, 20);
                srch.addActionListener(this);
                ventana.add(srch);

		/**Engine name*/
                seshat = new JLabel();
                seshat.setFont(new Font("Consolas", Font.PLAIN, 9));
                seshat.setBounds(20, 690, 200, 20);
                seshat.setText("Seshat Engine");
                seshat.setForeground(ct);
                ventana.add(seshat);

	}

	public void actionPerformed(ActionEvent event)
        {
		Object origen = event.getSource();
		String str;
		if(origen == rf) //Add a file
		{
			//str = JOptionPane.showInputDialog(null, "Please tell me the path to our file since the root ");
		}
                else if (origen == ex)//Exit
                {
                        JOptionPane.showMessageDialog(null, "Gracias por usar Shee word browser");
                        System.exit(0);
                }
		else if(origen == srch) //Search
		{
			str = JOptionPane.showInputDialog(null, "What should i look for?");
			if(str.length() < 201)
			{
				Scanner sc = new Scanner(src);

				sc.close();
			}
			else
				JOptionPane.showMessageDialog(null, "Max query is 200");
		}

	}

	public static void main(String args[])
        {
                Schee enc = new Schee();
                enc.setSize(1366,740);
                enc.encGUI();
                enc.setVisible(true);
        }

}
