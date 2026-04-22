import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SuspectPage extends JFrame {

	
	public SuspectPage(Suspect suspect) {
		
		JList suspectNumber;
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(400, 300);
        this.setTitle("SuspectPage");

        
        JTextArea infoArea = new JTextArea();
        infoArea.setEditable(false);  

        
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + suspect.getName() + "\n");
        sb.append("Codename: " + suspect.getCodeName() + "\n");
        sb.append("Phone Numbers:\n");
        if (!suspect.getPhoneNumbers().isEmpty()) {
        	for (String phoneNumber : suspect.getPhoneNumbers()) {
        		sb.append("  - " + phoneNumber + "\n");
        	}
        } else 
        	sb.append("  No phone numbers available.\n");
			
        infoArea.setText(sb.toString());

        JScrollPane scrollPane = new JScrollPane(infoArea);
        this.add(scrollPane, BorderLayout.CENTER);
		
        JButton backButton = new JButton("Back to Search Screen");
        
        backButton.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
        });

        this.add(backButton, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}
		
		
  
	

	


