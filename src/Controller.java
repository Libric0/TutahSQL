import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;

public class Controller {
	private String controllerErrorMessage;
	private DatabaseConnector dc;
	private Gui g;

	public Controller() {
		// Initialising the gui
		g = new Gui(this);

		// connecting to database
		File f = new File("./res/Datenbank.db");
		if (f.exists()) {
			dc = new DatabaseConnector("12", 0, f.getAbsolutePath(), "Ich", "Du");
		} else {
			controllerErrorMessage = "The Database doesn't exist on your Hard Drive";
		}

		// feeding the gui the database's information
		update();
	}

	/*
	 * Gui-update related Methods
	 */

	// feeds the newest information to the gui
	private void update() {
		updateErrorBar();
		updateNextAppointment();
		updateStudentComboBox();
	}

	// Puts all students in the database into the StudentComboBox
	private void updateStudentComboBox() {
		g.deleteStudentComboBoxElements();
		dc.executeStatement("select StudentName from Student");
		for (int i = 0; i < dc.getCurrentQueryResult().getRowCount(); i++) {
			g.addStudentToComboBox(dc.getCurrentQueryResult().getData()[i][0]);
		}

	}

	// prints the next appointment if there is one. If there is none, it prints
	// "No Appointments in the near future"
	private void updateNextAppointment() {
		String a = getNextAppointment();
		if (a.equals(""))
			g.setNextAppsText("No Appointments in the Near Future");
		else
			g.setNextAppsText(a);
	}

	// Prints an errormessage if needed
	private void updateErrorBar() {
		if (dc.getErrorMessage() != null) {
			g.setErrorBarsText(dc.getErrorMessage());
		} else if (controllerErrorMessage != null) {
			g.setErrorBarsText(controllerErrorMessage);
			controllerErrorMessage = null;
		} else
			g.setErrorBarsText("");
	}

	// returns the appointment with the lowest row-number in the database
	public String getNextAppointment() {
		String r = "";
		dc.executeStatement(
				"select StudentName, Date, Topic, Money from Student inner join Appointments on ID=StudentID where Appointments.rowID=(select MIN(Appointments.rowID) from Appointments)");
		QueryResult qr = dc.getCurrentQueryResult();
		for (int i = 0; i < qr.getColumnCount(); i++) {
			r = r + qr.getData()[0][i] + " ";
		}
		return r;
	}

	/*
	 * SQL- Command-line command-execution related methods
	 */

	// executes an SQL Statement of the user to view or edit data out of the
	// range of the gui.
	// If the command requests a table, it will be viewable in a new
	// Window containing the requested Table
	public void execsqlstatement(String statement) {
		if (queryResultChanged(statement))
			// System.out.println(queryResultToString(dc.getCurrentQueryResult()));
			new TableView(dc.getCurrentQueryResult());
		update();
	}

	// this method converts a queryresult to a string. It helps to compare 2
	// queryresults in
	// queryResultChanged
	private String queryResultToString(QueryResult p) {
		String r = "";
		r = r + Arrays.toString(p.getColumnNames());
		r = r + Arrays.deepToString(p.getData());
		return r;
	}

	// Executes a statement and Tests if a queryresult changed after the
	// execution
	public boolean queryResultChanged(String statement) {
		String a = queryResultToString(dc.getCurrentQueryResult());
		dc.executeStatement(statement);
		try {
			String b = queryResultToString(dc.getCurrentQueryResult());
			return !a.equals(b);
		} catch (java.lang.NullPointerException e) {

		}
		return false;

	}

	/*
	 * appointment-management related methods
	 */
	public void deleteNextApp() {
		dc.executeStatement(
				"delete from Appointments where Appointments.rowID = (select MIN(Appointments.rowID) from Appointments)");
		update();

	}

	public void addAppointment(String StudentName, String nAD, String nAT) {
		String sid;
		dc.executeStatement("select ID from Student where StudentName='" + StudentName + "'");
		sid = dc.getCurrentQueryResult().getData()[0][0];

		if (nAD.equalsIgnoreCase("") || nAD == null) {
			controllerErrorMessage = "You should type in a date";
		}

		else if (nAT.equalsIgnoreCase("") || nAD == null) {
			controllerErrorMessage = "You should type in a Topic";
		} else
			dc.executeStatement("insert into Appointments values('" + nAD + "','" + nAT + "','" + sid + "','10')");
		update();
	}

	/*
	 * Student-Management related methods
	 */
	public void addStudent(String nSN, String nSL) {
		dc.executeStatement("select * from Student");
		String newID = (dc.getCurrentQueryResult().getRowCount() + 1) + "";
		if (nSN.equalsIgnoreCase("") || nSN == null)
			controllerErrorMessage = "You should type in a name for your student";
		dc.executeStatement("insert into Student" + " values('" + nSN + "','" + nSL + "','" + newID + "')");
		g.addStudentToComboBox(nSN);
		update();
	}

	/*
	 * Main method, starting everything
	 */
	public static void main(String args[]) {
		new Controller();
	}
}
