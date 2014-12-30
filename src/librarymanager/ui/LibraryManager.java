package librarymanager.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import librarymanager.entity.BookEntry;
import librarymanager.fileaccess.FileAccessor;
import librarymanager.util.StatusEnum;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LibraryManager extends JFrame {
	private static final long serialVersionUID = 7883131229846543386L;
	private static final Log log = LogFactory.getLog(LibraryManager.class);
	public static final String APPLICATION_NAME = "LibraryManager";
	
	private JLabel statusLabel;
	private JComboBox<StatusEnum> statusComboBox;
	private JPanel comboPanel;
	private JLabel isbnLabel;
	private JTextField isbnTextField;
	private JLabel bookNameLabel;
	private JTextField bookNameTextField;
	private JLabel userLabel;
	private JTextField userTextField;

	public static void main (String args[]) {
		log.info(APPLICATION_NAME + " starting");
		LibraryManager app = new LibraryManager();
		app.create();
		app.addComponents();
		app.addSubmitButton();
	}
	
	public LibraryManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Library Manager - Your one stop shop");
		setSize(600, 300);
		setLocationRelativeTo(null);
		setVisible(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void create() {
		GridLayout layout = new GridLayout(0,2);
		comboPanel = new JPanel(layout);

		isbnLabel = new JLabel("ISBN: ");
		isbnTextField = new JTextField(20);
		bookNameLabel = new JLabel("Book Name: ");
		bookNameTextField = new JTextField(20);
		statusLabel = new JLabel("Status Options:");
		statusComboBox = new JComboBox<StatusEnum>(StatusEnum.values());
		userLabel = new JLabel("User: ");
		userTextField = new JTextField(20);
	}
	
	public void addComponents() {
		comboPanel.add(isbnLabel);
		comboPanel.add(isbnTextField);
		comboPanel.add(bookNameLabel);
		comboPanel.add(bookNameTextField);
		comboPanel.add(statusLabel);
		comboPanel.add(statusComboBox);
		comboPanel.add(userLabel);
		comboPanel.add(userTextField);
	}
	
	public void addSubmitButton() {
		JButton submitButton = new JButton("Submit");

		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String[] dataSet = {
				isbnTextField.getText(), 
				bookNameTextField.getText(),
				((StatusEnum) statusComboBox.getSelectedItem()).getSymbol(),
				userTextField.getText()
				};
				
				start(dataSet);
			}
		});

		add(comboPanel, BorderLayout.NORTH);
		add(submitButton, BorderLayout.SOUTH);
	}
	
	public void start(String... dataSet) {
		BookEntry newEntry = new BookEntry(); 
		newEntry = newEntry.createBookEntry(dataSet);
		
		String branch = System.getProperties().getProperty("branch");
		FileAccessor fileAccessor = new FileAccessor();
		fileAccessor.setupFileAccess(branch);
		fileAccessor.updateEntry(newEntry, branch);		
	}

}
