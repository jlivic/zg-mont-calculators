package screen;

import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import dbUtils.ConnectionUtils;
import logIn.LogIn;

public class LogInScreen {

	protected Shell shlZagrebmontaza;
	protected Shell RegisterScreen;
	public Text txtUserName;
	public Text txtPassword;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LogInScreen window = new LogInScreen();

			Connection conn = ConnectionUtils.getConnection();
			if (conn == null) {
				JOptionPane.showMessageDialog(null, "Database is not connected!", "Check database conectivity!",
						JOptionPane.PLAIN_MESSAGE);
				return;
			}

			conn.close();
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
		shlZagrebmontaza.open();
		shlZagrebmontaza.layout();
		while (!shlZagrebmontaza.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlZagrebmontaza = new Shell();
		shlZagrebmontaza.setSize(450, 300);
		shlZagrebmontaza.setText("Zagreb Montaža");
		shlZagrebmontaza.setLayout(new GridLayout(6, false));
		new Label(shlZagrebmontaza, SWT.NONE);
		new Label(shlZagrebmontaza, SWT.NONE);
		new Label(shlZagrebmontaza, SWT.NONE);
		new Label(shlZagrebmontaza, SWT.NONE);
		new Label(shlZagrebmontaza, SWT.NONE);

		Button btnRegister = new Button(shlZagrebmontaza, SWT.NONE);
		btnRegister.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnRegister.setText("Register");
		new Label(shlZagrebmontaza, SWT.NONE);
		new Label(shlZagrebmontaza, SWT.NONE);
		new Label(shlZagrebmontaza, SWT.NONE);
		new Label(shlZagrebmontaza, SWT.NONE);
		new Label(shlZagrebmontaza, SWT.NONE);
		new Label(shlZagrebmontaza, SWT.NONE);
		new Label(shlZagrebmontaza, SWT.NONE);
		new Label(shlZagrebmontaza, SWT.NONE);
		new Label(shlZagrebmontaza, SWT.NONE);

		Label lblUserName = new Label(shlZagrebmontaza, SWT.NONE);
		lblUserName.setText("Username:");
		new Label(shlZagrebmontaza, SWT.NONE);

		txtUserName = new Text(shlZagrebmontaza, SWT.BORDER | SWT.CENTER);
		txtUserName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shlZagrebmontaza, SWT.NONE);
		new Label(shlZagrebmontaza, SWT.NONE);
		new Label(shlZagrebmontaza, SWT.NONE);

		Label lblPassword = new Label(shlZagrebmontaza, SWT.NONE);
		lblPassword.setText("Password");
		new Label(shlZagrebmontaza, SWT.NONE);

		txtPassword = new Text(shlZagrebmontaza, SWT.BORDER | SWT.PASSWORD | SWT.CENTER);
		txtPassword.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shlZagrebmontaza, SWT.NONE);
		new Label(shlZagrebmontaza, SWT.NONE);
		new Label(shlZagrebmontaza, SWT.NONE);
		new Label(shlZagrebmontaza, SWT.NONE);
		new Label(shlZagrebmontaza, SWT.NONE);

		Button btnLogin = new Button(shlZagrebmontaza, SWT.NONE);
		btnLogin.setGrayed(true);
		btnLogin.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnLogin.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnLogin.setText("Login");

		btnLogin.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				boolean b = LogIn.checkIfUserExist(txtUserName.getText(), txtPassword.getText());
				if (b == false) {
					JOptionPane.showMessageDialog(null, "Wrong user!", "Wrong username/password!",
							JOptionPane.PLAIN_MESSAGE);
					return;
				}else {
					shlZagrebmontaza.dispose();
					MainScreen m = new MainScreen();
					m.open();
				}
			}
		});

		btnRegister.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shlZagrebmontaza.dispose();
				RegisterScreen r = new RegisterScreen();
				r.open();
			}

		});
	}

	public Text getTxtUserName() {
		return txtUserName;
	}

	public void setTxtUserName(Text txtUserName) {
		this.txtUserName = txtUserName;
	}

	public Text getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(Text txtPassword) {
		this.txtPassword = txtPassword;
	}

}
