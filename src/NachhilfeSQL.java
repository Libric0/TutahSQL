import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 13.11.2017
  * @author 
  */

public class NachhilfeSQL extends JFrame {
  // Anfang Attribute
  private JTextField nextApp = new JTextField();
  private JTextField newStudentName = new JTextField();
  private JTextField newStudentGrade = new JTextField();
  private JButton newStudentButton = new JButton();
  private JTextField errorBar = new JTextField();
  private JComboBox studentComboBox = new JComboBox();
    private DefaultComboBoxModel studentComboBoxModel = new DefaultComboBoxModel();
  private JTextField newAppDate = new JTextField();
  private JTextField newAppTopic = new JTextField();
  private JButton newAppButton = new JButton();
  private JTextField sqlCommandLine = new JTextField();
  private JTextField sqlResultLine = new JTextField();
  private JButton newAppButton1 = new JButton();
  // Ende Attribute
  
  public NachhilfeSQL(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 376; 
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    nextApp.setBounds(8, 8, 353, 25);
    nextApp.setToolTipText("Next Appointment");
    nextApp.setBackground(new Color(0x404040));
    nextApp.setForeground(Color.WHITE);
    nextApp.setEditable(false);
    cp.add(nextApp);
    newStudentName.setBounds(8, 48, 169, 25);
    newStudentName.setBackground(new Color(0x404040));
    newStudentName.setForeground(Color.WHITE);
    newStudentName.setToolTipText("Name of new Student");
    cp.add(newStudentName);
    newStudentGrade.setBounds(192, 48, 169, 25);
    newStudentGrade.setBackground(new Color(0x404040));
    newStudentGrade.setForeground(Color.WHITE);
    newStudentGrade.setToolTipText("Grade of new Student");
    cp.add(newStudentGrade);
    newStudentButton.setBounds(128, 80, 113, 25);
    newStudentButton.setText("New Student");
    newStudentButton.setMargin(new Insets(2, 2, 2, 2));
    newStudentButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        newStudentButton_ActionPerformed(evt);
      }
    });
    newStudentButton.setBackground(new Color(0x404040));
    newStudentButton.setForeground(Color.WHITE);
    newStudentButton.setFocusPainted(true);
    newStudentButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    cp.add(newStudentButton);
    cp.setBackground(new Color(0x1B375A));
    errorBar.setBounds(0, 248, 370, 25);
    errorBar.setBackground(new Color(0x404040));
    errorBar.setFont(new Font("Dialog", Font.BOLD, 12));
    errorBar.setForeground(Color.RED);
    errorBar.setEditable(false);
    errorBar.setToolTipText("Errors will be shown here");
    cp.add(errorBar);
    setUndecorated(false);
    studentComboBox.setModel(studentComboBoxModel);
    studentComboBox.setBounds(8, 112, 113, 25);
    studentComboBox.setBackground(new Color(0x404040));
    studentComboBox.setForeground(Color.WHITE);
    studentComboBox.setEditable(false);
    studentComboBox.setEnabled(true);
    studentComboBox.setToolTipText("Student");
    cp.add(studentComboBox);
    newAppDate.setBounds(128, 112, 113, 25);
    newAppDate.setBackground(new Color(0x404040));
    newAppDate.setForeground(Color.WHITE);
    newAppDate.setToolTipText("Date of the new Appointment");
    cp.add(newAppDate);
    newAppTopic.setBounds(248, 112, 113, 25);
    newAppTopic.setBackground(new Color(0x404040));
    newAppTopic.setForeground(Color.WHITE);
    newAppTopic.setToolTipText("Topic of the new Appointment");
    cp.add(newAppTopic);
    newAppButton.setBounds(128, 144, 113, 25);
    newAppButton.setText("New Appointment");
    newAppButton.setMargin(new Insets(2, 2, 2, 2));
    newAppButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        newAppButton_ActionPerformed(evt);
      }
    });
    newAppButton.setBackground(new Color(0x404040));
    newAppButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    newAppButton.setFocusPainted(true);
    newAppButton.setForeground(Color.WHITE);
    cp.add(newAppButton);
    sqlCommandLine.setBounds(8, 176, 273, 25);
    sqlCommandLine.setBackground(new Color(0x404040));
    sqlCommandLine.setEditable(true);
    sqlCommandLine.setForeground(Color.WHITE);
    sqlCommandLine.setToolTipText("Type SQL Commands here");
    cp.add(sqlCommandLine);
    sqlResultLine.setBounds(8, 208, 353, 25);
    sqlResultLine.setBackground(new Color(0x404040));
    sqlResultLine.setEditable(false);
    sqlResultLine.setForeground(Color.WHITE);
    sqlResultLine.setToolTipText("The SQL Queryresult will be shown here");
    cp.add(sqlResultLine);
    newAppButton1.setBounds(288, 176, 73, 25);
    newAppButton1.setText("Go");
    newAppButton1.setMargin(new Insets(2, 2, 2, 2));
    newAppButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        newAppButton1_ActionPerformed(evt);
      }
    });
    newAppButton1.setBackground(new Color(0x404040));
    newAppButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    newAppButton1.setFocusPainted(true);
    newAppButton1.setForeground(Color.WHITE);
    cp.add(newAppButton1);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public NachhilfeSQL
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new NachhilfeSQL("NachhilfeSQL");
  } // end of main
  
  public void newStudentButton_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of newStudentButton_ActionPerformed

  public void newAppButton_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of newAppButton_ActionPerformed

  public void newAppButton1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of newAppButton1_ActionPerformed

  // Ende Methoden
} // end of class NachhilfeSQL
