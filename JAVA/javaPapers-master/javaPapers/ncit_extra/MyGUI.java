import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class MyGUI implements ActionListener{
  JFrame f1;
  JTextField t1;
  JButton b1;
  MyGUI(){
    f1=new JFrame("My First GUI Application");
    f1.setLayout(new FlowLayout());
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    t1=new JTextField(10);
    b1=new JButton("Click Me");
    f1.add(t1);
    f1.add(b1);
 //   b1.addActionListener(this);
    f1.setSize(200,200);
   f1.setVisible(true);
  }
  public static void main(String args[]){
    new MyGUI();
  }
  public void actionPerformed(ActionEvent e) {
    if(e.getSource()==b1){
      t1.setText("Button is clicked");
    }
  }
}