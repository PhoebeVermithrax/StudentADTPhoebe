/*
 * Created by: Phoebe Vermithrax
 * Created on: 01-March-2018
 * Created for: ICS4U
 * Daily Assignment – Day #14
 * This program uses a class (struct) to store the user's name, grade and whether they're identified. Then, it outputs
 * this to the user in a message box.
*/

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

//Import javax swing to get the message box.
import javax.swing.*;

public class StudentADT {

	protected Shell shell;
	private Text txtFirst;
	private Text txtLast;
	private Text txtMiddle;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			StudentADT window = new StudentADT();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	//Create the java equivalent to a struct.
	static class Student
	{
		//Declare the variables that are stored in the struct, like the first, middle and last name.
		public static String firstName;
		public static String lastName;
		public static String middleInitial;
		public static String grade;
		public static int identified;
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Student ADT");
		
		Label lblFirstName = new Label(shell, SWT.NONE);
		lblFirstName.setBounds(22, 37, 90, 15);
		lblFirstName.setText("First Name:");
		
		Label lblLastName = new Label(shell, SWT.NONE);
		lblLastName.setBounds(22, 76, 90, 15);
		lblLastName.setText("Last Name:");
		
		Label lblMiddleInitial = new Label(shell, SWT.NONE);
		lblMiddleInitial.setBounds(22, 109, 90, 15);
		lblMiddleInitial.setText("Middle Initial:");
		
		txtFirst = new Text(shell, SWT.BORDER);
		txtFirst.setBounds(172, 37, 204, 21);
		
		txtLast = new Text(shell, SWT.BORDER);
		txtLast.setBounds(172, 73, 204, 21);
		
		txtMiddle = new Text(shell, SWT.BORDER);
		txtMiddle.setBounds(172, 109, 204, 21);
		
		Label lblGrade = new Label(shell, SWT.NONE);
		lblGrade.setBounds(22, 145, 90, 15);
		lblGrade.setText("Grade:");
		
		Combo comboGrade = new Combo(shell, SWT.NONE);
		comboGrade.setBounds(172, 145, 204, 23);
		//Set the items within the box.
		comboGrade.setItems("7", "8", "9", "10", "11", "12");
		//Set the text to 7, as a starting point.
		comboGrade.setText("7");
		//comboGrade.select(7);
		
		Label lblIdentified = new Label(shell, SWT.NONE);
		lblIdentified.setBounds(22, 182, 90, 15);
		lblIdentified.setText("Identified:");
		
		Button btnIdentified = new Button(shell, SWT.CHECK);
		btnIdentified.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//If the user clicks this, call the struct Student.identified to set it to 1, as a true.
				Student.identified = 1;
			}
		});
		btnIdentified.setBounds(172, 181, 93, 16);
		
		Button btnEnter = new Button(shell, SWT.NONE);
		btnEnter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e)
			{

				//Get the input from the user.
				Student.firstName = txtFirst.getText();
				Student.lastName = txtLast.getText();
				Student.middleInitial = txtMiddle.getText();
				
				//Try and catch to see if the user entered a grade.
				try
				{
					//Get the item from the combo box and input that into the grade.
					Student.grade = comboGrade.getItem(comboGrade.getSelectionIndex());
				}
				catch (Exception ref)
				{
					Student.grade = "7";
				}
				
				//To check if the user left anything blank.
				if (Student.firstName == "" && Student.lastName == "" && Student.middleInitial == "")
				{
					//Open a message box telling the user to not leave anything blank.
					JOptionPane.showMessageDialog(null, "Please enter in first and last name as well as middle initial");
				}
				else
				{
					//Set a variable to hold the students information.
					String studentID;
					
					//Set the variable to the first, last and middle name, grade and whether they were identified or not.
					if (Student.identified == 1)
					{
						studentID = "Name: " + Student.firstName + " " + Student.middleInitial + " " +
						Student.lastName + "  Grade: " + Student.grade + " and is identified.";
						
						//Display a message box displaying the studentID.
						JOptionPane.showMessageDialog(null, studentID);
					}
					else
					{
						studentID = "Name: " + Student.firstName + " " + Student.middleInitial + " " +
						Student.lastName + "  Grade: " + Student.grade + " and is not identified.";
						
						//Display a message box displaying the studentID.
						JOptionPane.showMessageDialog(null, studentID);
					}
					
				}
				
			}
		});
		
		btnEnter.setBounds(172, 203, 75, 25);
		btnEnter.setText("Enter");

	}
}
