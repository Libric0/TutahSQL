import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.ComponentOrientation;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class TableView extends JFrame {

	public TableView(QueryResult q) {
		super("Table");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// preparing the table
		String[][] data = q.getData();
		String[][] tdata = new String[q.getRowCount() + 1][q.getColumnCount()];
		for (int i = 0; i < q.getColumnCount(); i++) {
			tdata[0][i] = q.getColumnNames()[i];
		}

		for (int x = 0; x < q.getRowCount(); x++) {
			for (int y = 0; y < q.getColumnCount(); y++) {
				tdata[x + 1][y] = data[x][y];
			}
		}
		JTable t = new JTable(tdata, q.getColumnNames());
		t.setLocation(0, 0);
		t.setFont(new Font("Dialog", Font.BOLD, 12));
		t.setBackground(new Color(45, 45, 45));
		t.setForeground(new Color(255, 255, 255));

		// preparing the frame according to the table's requirements
		int frameWidth = t.getColumnCount() * 200;
		int frameHeight = ((t.getRowCount() + 1) * 20);
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2, y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setResizable(false);
		// preparing the visualisation of the frame
		Container cp = getContentPane();
		cp.setBackground(new Color(45, 45, 45));
		cp.add(t);
		setVisible(true);

	}

}
