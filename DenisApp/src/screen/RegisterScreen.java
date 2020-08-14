package screen;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;

import entity.AppUser;
import logIn.Register;

import org.eclipse.swt.widgets.Button;

public class RegisterScreen {

	protected Shell shlRegistration;
	private Text txtFirstName;
	private Text txtLastName;
	private Text txtUserName;
	private Text txtEmail;
	private Text txtPassword;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RegisterScreen window = new RegisterScreen();
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
		shlRegistration.open();
		shlRegistration.layout();
		while (!shlRegistration.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlRegistration = new Shell();
		shlRegistration.setSize(450, 300);
		shlRegistration.setText("Registration");
		shlRegistration.setLayout(new GridLayout(4, false));
		new Label(shlRegistration, SWT.NONE);
		new Label(shlRegistration, SWT.NONE);
		new Label(shlRegistration, SWT.NONE);
		new Label(shlRegistration, SWT.NONE);
		new Label(shlRegistration, SWT.NONE);
		new Label(shlRegistration, SWT.NONE);
		new Label(shlRegistration, SWT.NONE);
		new Label(shlRegistration, SWT.NONE);
		new Label(shlRegistration, SWT.NONE);
		
		Label lblFirstName = new Label(shlRegistration, SWT.NONE);
		lblFirstName.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1));
		lblFirstName.setText("First name:");
		new Label(shlRegistration, SWT.NONE);
		
		txtFirstName = new Text(shlRegistration, SWT.BORDER);
		txtFirstName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shlRegistration, SWT.NONE);
		
		Label lblLastName = new Label(shlRegistration, SWT.NONE);
		lblLastName.setText("Last name:");
		new Label(shlRegistration, SWT.NONE);
		
		txtLastName = new Text(shlRegistration, SWT.BORDER);
		txtLastName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shlRegistration, SWT.NONE);
		
		Label lblEmail = new Label(shlRegistration, SWT.NONE);
		lblEmail.setText("E-mail:");
		new Label(shlRegistration, SWT.NONE);
		
		txtEmail = new Text(shlRegistration, SWT.BORDER);
		txtEmail.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shlRegistration, SWT.NONE);
		
		Label lblUserName = new Label(shlRegistration, SWT.NONE);
		lblUserName.setText("User name:");
		new Label(shlRegistration, SWT.NONE);
		
		txtUserName = new Text(shlRegistration, SWT.BORDER);
		txtUserName.setText("");
		txtUserName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shlRegistration, SWT.NONE);
		
		Label lblPassword = new Label(shlRegistration, SWT.NONE);
		lblPassword.setText("Password:");
		new Label(shlRegistration, SWT.NONE);
		
		txtPassword = new Text(shlRegistration, SWT.BORDER);
		txtPassword.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shlRegistration, SWT.NONE);
		
		Button btnBack = new Button(shlRegistration, SWT.NONE);
		btnBack.setToolTipText("Back to login screen");
		btnBack.setText("Back");
		new Label(shlRegistration, SWT.NONE);
		
		Button btnRegister = new Button(shlRegistration, SWT.NONE);
		btnRegister.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnRegister.setText("Register");
		
		btnRegister.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				AppUser user = new AppUser();
				user.setFirstName(txtFirstName.getText());
				user.setLastName(txtLastName.getText());
				user.setEmail(txtEmail.getText());
				user.setUserName(txtUserName.getText());
				user.setPassword(txtPassword.getText());
				
				Register.registerUser(user);
				
				shlRegistration.dispose();
				LogInScreen l = new LogInScreen();
				l.open();
				l.setTxtUserName(txtUserName);
				
				JOptionPane.showMessageDialog(null, "E-mail obavijest", "Username and password will be sent to your email",
						JOptionPane.PLAIN_MESSAGE);
			}
			  
		  });
		
		
		btnBack.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shlRegistration.dispose();
				LogInScreen l = new LogInScreen();
				l.open();
				
			}
			
		});
	}

}
