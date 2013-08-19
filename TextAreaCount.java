/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class TextAreaCount  extends JFrame implements KeyListener, ActionListener{
    /**
     *
     */
    JTextArea txtArea = new JTextArea(5, 25);
    JLabel countValue = new JLabel();
    public TextAreaCount(){   
    	txtArea.addKeyListener(this);
    }
    	//ActionListener Interface
	public void actionPerformed(ActionEvent e) {
		//if (e.getSource() == btnSend) {
		//	lblDisplay.setText(txtArea.getText());
			txtArea.setText("");
			txtArea.requestFocus();
		//}
	}
    
    	//KeyListener Interface
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {
        if (e.getSource() == txtArea) {
                    System.out.print("txtArea.getText() : "+txtArea.getText().length()); 
                    String count=txtArea.getText().length()+"";
                    countValue.setText(count);
                    if(txtArea.getText().length() == 5){
                      System.out.print("MAX LIMIT : "+txtArea.getText().length()); 
                       CustomDialog myDialog = new CustomDialog("Max Limit set already..");
            System.err.println("After opening dialog.");
            if(myDialog.getAnswer()) {
                System.err.println("user clicked yes button.)");
                return;
            }
            else {
                System.err.println("user clicked no button.)");
                return;
            }
                     // return;
                    }
			
		}
        }
	public void keyPressed(KeyEvent e) {
		
	}
  public static void main(String[] args) {
     
TextAreaCount objTextAreaCount = new TextAreaCount();
    JFrame f = new JFrame("Text Area Examples");
    JPanel lowerPanel = new JPanel();
    lowerPanel.setPreferredSize(new Dimension(300, 200));
    f.getContentPane().add(lowerPanel, "South"); 
   // JTextArea ta = new JTextArea(content, 5, 25);
   
    objTextAreaCount.txtArea.setLineWrap(true);
    objTextAreaCount.txtArea.addKeyListener(null);
    lowerPanel.add(new JScrollPane(objTextAreaCount.txtArea));
    lowerPanel.add(new JLabel("COUNT:"));
    lowerPanel.add(objTextAreaCount.countValue);
    f.pack();
    f.setVisible(true);
  }

}

class CustomDialog extends JDialog implements ActionListener {
    private JPanel myPanel = null;
    private JButton yesButton = null;
    private JButton noButton = null;
    private boolean answer = false;
    public boolean getAnswer() { return answer; }

    public CustomDialog(String myMessage) {
       
        myPanel = new JPanel();
        getContentPane().add(myPanel);
        myPanel.add(new JLabel(myMessage));
        yesButton = new JButton("Yes");
        yesButton.addActionListener(this);
        myPanel.add(yesButton); 
        noButton = new JButton("No");
        noButton.addActionListener(this);
        myPanel.add(noButton);  
        pack();
      
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(yesButton == e.getSource()) {
            System.err.println("User chose yes.");
            answer = true;
            setVisible(false);
        }
        else if(noButton == e.getSource()) {
            System.err.println("User chose no.");
            answer = false;
            setVisible(false);
        }
    }
    
}
