import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Gui extends JFrame {
	// Anfang Attribute
	private Controller c;
	private JTextField nextApp = new JTextField();
	private JTextField newStudentName = new JTextField();
	private JTextField newStudentLevel = new JTextField();
	private JButton newStudentButton = new JButton();
	private JTextField errorBar = new JTextField();
	private JComboBox studentComboBox = new JComboBox();
	private DefaultComboBoxModel studentComboBoxModel = new DefaultComboBoxModel();
	private JTextField newAppDate = new JTextField();
	private JTextField newAppTopic = new JTextField();
	private JButton newAppButton = new JButton();
	private JTextField sqlCommandLine = new JTextField();
	private JButton sqlButton = new JButton();
	private JButton nextAppDone = new JButton();
	// Ende Attribute

	public Gui(Controller pc) {
		// Frame-Initialisierung
		super("Private Tutoring");
		c = pc;
		int frameWidth;
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		// for some odd reason the Windows version of Java produces a narrower
		// window than on a linux based os
		if (System.getProperty("os.name").equalsIgnoreCase("linux"))
			frameWidth = 370;
		else
			frameWidth = 376;
		int frameHeight = 262;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setResizable(false);
		Container cp = getContentPane();
		cp.setLayout(null);
		// Anfang Komponenten

		nextApp.setBounds(8, 8, 273, 25);
		nextApp.setToolTipText("Next Appointment");
		nextApp.setBackground(new Color(45, 45, 45));
		nextApp.setForeground(Color.WHITE);
		nextApp.setEditable(false);
		cp.add(nextApp);
		nextAppDone.setBounds(288, 8, 73, 25);
		nextAppDone.setText("Done");
		nextAppDone.setMargin(new Insets(2, 2, 2, 2));
		nextAppDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				nextAppDone_ActionPerformed(evt);
			}
		});
		nextAppDone.setBackground(new Color(45, 45, 45));
		nextAppDone.setCursor(new Cursor(Cursor.HAND_CURSOR));
		nextAppDone.setFocusPainted(true);
		nextAppDone.setForeground(Color.WHITE);
		cp.add(nextAppDone);
		newStudentName.setBounds(8, 48, 169, 25);
		newStudentName.setBackground(new Color(45, 45, 45));
		newStudentName.setForeground(Color.WHITE);
		newStudentName.setToolTipText("Name of new Student");
		cp.add(newStudentName);
		newStudentLevel.setBounds(192, 48, 169, 25);
		newStudentLevel.setBackground(new Color(45, 45, 45));
		newStudentLevel.setForeground(Color.WHITE);
		newStudentLevel.setToolTipText("Level of new Student");
		cp.add(newStudentLevel);
		newStudentButton.setBounds(108, 80, 153, 25);
		newStudentButton.setText("New Student");
		newStudentButton.setMargin(new Insets(2, 2, 2, 2));
		newStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				newStudentButton_ActionPerformed(evt);
			}
		});
		newStudentButton.setBackground(new Color(45, 45, 45));
		newStudentButton.setForeground(Color.WHITE);
		newStudentButton.setFocusPainted(true);
		newStudentButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cp.add(newStudentButton);
		cp.setBackground(new Color(0x1B375A));
		errorBar.setBounds(0, 209, 370, 25);
		errorBar.setBackground(new Color(45, 45, 45));
		errorBar.setFont(new Font("Dialog", Font.BOLD, 12));
		errorBar.setForeground(new Color(255, 20, 20));
		errorBar.setEditable(false);
		errorBar.setToolTipText("Errors will be shown here");
		cp.add(errorBar);
		setUndecorated(false);
		studentComboBox.setModel(studentComboBoxModel);
		studentComboBox.setBounds(8, 112, 113, 25);
		studentComboBox.setBackground(new Color(45, 45, 45));
		studentComboBox.setForeground(Color.WHITE);
		studentComboBox.setEditable(false);
		studentComboBox.setEnabled(true);
		studentComboBox.setToolTipText("Student");
		cp.add(studentComboBox);
		newAppDate.setBounds(128, 112, 113, 25);
		newAppDate.setBackground(new Color(45, 45, 45));
		newAppDate.setForeground(Color.WHITE);
		newAppDate.setToolTipText("Date of the new Appointment");
		cp.add(newAppDate);
		newAppTopic.setBounds(248, 112, 113, 25);
		newAppTopic.setBackground(new Color(45, 45, 45));
		newAppTopic.setForeground(Color.WHITE);
		newAppTopic.setToolTipText("Topic of the new Appointment");
		cp.add(newAppTopic);
		newAppButton.setBounds(108, 144, 153, 25);
		newAppButton.setText("New Appointment");
		newAppButton.setMargin(new Insets(2, 2, 2, 2));
		newAppButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				newAppButton_ActionPerformed(evt);
			}
		});
		newAppButton.setBackground(new Color(45, 45, 45));
		newAppButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		newAppButton.setFocusPainted(true);
		newAppButton.setForeground(Color.WHITE);
		cp.add(newAppButton);
		sqlCommandLine.setBounds(8, 176, 273, 25);
		sqlCommandLine.setBackground(new Color(45, 45, 45));
		sqlCommandLine.setEditable(true);
		sqlCommandLine.setForeground(Color.WHITE);
		sqlCommandLine.setToolTipText("Type SQL Commands here");
		cp.add(sqlCommandLine);
		sqlButton.setBounds(288, 176, 73, 25);
		sqlButton.setText("Go");
		sqlButton.setMargin(new Insets(2, 2, 2, 2));
		sqlButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				sqlButton_ActionPerformed(evt);
			}
		});
		sqlButton.setBackground(new Color(45, 45, 45));
		sqlButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sqlButton.setFocusPainted(true);
		sqlButton.setForeground(Color.WHITE);
		cp.add(sqlButton);
		// Ende Komponenten

		setVisible(true);
	}

	/*
	 * Methods related to the addition of a new student
	 */
	// returns the newStudentName-Textfield's contents and emptys it
	private String getNewStudentName() {
		String r = newStudentName.getText();
		newStudentName.setText("");
		return r;
	}

	// returns the newStudentLevel-Textfield's contents and emptys it
	private String getNewStudentLevel() {
		String r = newStudentLevel.getText();
		newStudentLevel.setText("");
		return r;
	}

	// adds a new student to the database if the newStudentButton is pressed
	private void newStudentButton_ActionPerformed(ActionEvent evt) {
		c.addStudent(getNewStudentName(), getNewStudentLevel());
	}

	/*
	 * Methods related to the addition of an appointment
	 */
	// returns the newAppData-Textfield's contents and emptys it
	private String getNewAppDate() {
		String r = newAppDate.getText();
		newAppDate.setText("");
		return r;
	}

	// returns the newAppTopic-Textfield's contents and emptys it
	private String getNewAppTopic() {
		String r = newAppTopic.getText();
		newAppTopic.setText("");
		return r;
	}

	// adds a new appointment to the database if the newAppButton is pressed
	private void newAppButton_ActionPerformed(ActionEvent evt) {
		c.addAppointment(studentComboBoxModel.getSelectedItem().toString(), getNewAppDate(), getNewAppTopic());
	}

	/*
	 * Methods related to sql command executions
	 */
	// executes the sql-statement in the sqlCommandLine if the sqlButton with
	// the title "go" is pressed
	private void sqlButton_ActionPerformed(ActionEvent evt) {
		c.execsqlstatement(sqlCommandLine.getText());
		sqlCommandLine.setText("");

	}

	/*
	 * Unrelated Methods
	 */
	private void nextAppDone_ActionPerformed(ActionEvent evt) {
		c.deleteNextApp();

	}

	// permits related classes to delete all elements of StudentComboBox
	public void deleteStudentComboBoxElements() {
		studentComboBoxModel.removeAllElements();
	}

	// permits related classes to set the manipulate of nextAPP
	public void setErrorBarsText(String m) {
		errorBar.setText(m);
	}

	// permits related classes to set the manipulate of nextAPP
	public void setNextAppsText(String m) {
		nextApp.setText(m);
	}

	// adds the name of a student to the studentComboBox
	public void addStudentToComboBox(String name) {
		studentComboBoxModel.addElement(name);
	}
	// Ende Methoden
} // end of class gui
