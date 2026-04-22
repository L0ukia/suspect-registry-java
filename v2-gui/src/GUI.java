	import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
	import javax.swing.JTextField;
	
	public class GUI extends JFrame{
		
			
			private static final String ActionListener = null;
			private JTextField inputField;
			private JButton addButton;
			private JPanel panel;
			private Registry registry;
			
			public GUI(Registry registry) {
				
				inputField = new JTextField("Please enter suspect's name");
				addButton = new JButton("Find");
				
				panel = new JPanel();
				panel.add(inputField);
				panel.add(addButton);
				
				this.setContentPane(panel);
				
				addButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String input = inputField.getText();
						Suspect suspect = registry.findSuspectByName(input);
						
						if(suspect!= null) {
							new SuspectPage(suspect);
							
						}else {
							JOptionPane.showMessageDialog(
					                null,
					                "Suspect " + input,
					                "not found",
					                JOptionPane.ERROR_MESSAGE
					            );
		                }
						}
						
					
				});
				
				this.setVisible(true);
				this.setSize(500, 500);
	
			}
		}
