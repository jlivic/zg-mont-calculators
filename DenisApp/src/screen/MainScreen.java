package screen;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;

public class MainScreen {

	protected Shell shell;
	

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainScreen window = new MainScreen();
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

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(1200, 1100);
		shell.setText("Zagreb Montaža d.o.o");

		final Composite cmpMenu = new Composite(shell, SWT.NONE);
		cmpMenu.setBackground(SWTResourceManager.getColor(119, 136, 153));
		cmpMenu.setBounds(0, 0, 359, 1061);
		
		FormToolkit formToolkit = new FormToolkit(Display.getDefault());
		final Section sctnCalculator = formToolkit.createSection(cmpMenu, Section.TWISTIE | Section.TITLE_BAR);
		sctnCalculator.setExpanded(false);
		sctnCalculator.setBounds(10, 160, 339, 23);
		formToolkit.paintBordersFor(sctnCalculator);
		sctnCalculator.setText("Kalkulator temperature preddgrijavanja");

		final Section sctn10112ce = formToolkit.createSection(cmpMenu, Section.TREE_NODE | Section.TITLE_BAR);
		sctn10112ce.setBounds(45, 189, 304, 23);
		formToolkit.paintBordersFor(sctn10112ce);
		sctn10112ce.setText("1011-2 CE");
		sctn10112ce.setVisible(false);

		final Section sctn10112cet = formToolkit.createSection(cmpMenu, Section.TREE_NODE | Section.TITLE_BAR);
		sctn10112cet.setBounds(45, 218, 304, 23);
		formToolkit.paintBordersFor(sctn10112cet);
		sctn10112cet.setText("1011-2 CET");
		sctn10112cet.setVisible(false);

		final Section sctnAws = formToolkit.createSection(cmpMenu, Section.TREE_NODE | Section.TITLE_BAR);
		sctnAws.setBounds(45, 247, 304, 23);
		formToolkit.paintBordersFor(sctnAws);
		sctnAws.setText("AWS");
		sctnAws.setVisible(false);
		
		final Composite composite10112ce = new Composite(shell, SWT.COLOR_DARK_GRAY);
		//composite10112ce.setBackground(SWTResourceManager.getColor(255, 255, 255));
		composite10112ce.setBounds(365, 0, 829, 1061);
		composite10112ce.setVisible(false);
		
		final Composite composite10112cet = new Composite(shell, SWT.COLOR_DARK_GRAY);
		//composite10112ce.setBackground(SWTResourceManager.getColor(255, 255, 255));
		composite10112cet.setBounds(365, 0, 829, 1061);
		composite10112cet.setVisible(false);
		
		final Composite compositeAws = new Composite(shell, SWT.COLOR_DARK_GRAY);
		//composite10112ce.setBackground(SWTResourceManager.getColor(255, 255, 255));
		compositeAws.setBounds(365, 0, 829, 1061);
		compositeAws.setVisible(false);
		
		sctnCalculator.addExpansionListener(new IExpansionListener() {

			@Override
			public void expansionStateChanged(ExpansionEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void expansionStateChanging(ExpansionEvent arg0) {

				if (sctnCalculator.isExpanded() == false) {
					sctn10112ce.setVisible(true);
					sctn10112cet.setVisible(true);
					sctnAws.setVisible(true);

				} else {
					sctn10112ce.setVisible(false);
					sctn10112cet.setVisible(false);
					sctnAws.setVisible(false);

				}

			}

		});

		sctn10112ce.addExpansionListener(new IExpansionListener() {
			@Override
			public void expansionStateChanging(ExpansionEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void expansionStateChanged(ExpansionEvent arg0) {
				if (sctn10112ce.isExpanded() == true) {
					sctn10112cet.setVisible(false);
					compositeAws.setVisible(false);
					new F10112ce(composite10112ce, cmpMenu.getStyle());
				}
				else
					composite10112ce.setVisible(false);
				
				
			}
		});
		
		sctn10112cet.addExpansionListener(new IExpansionListener() {
			@Override
			public void expansionStateChanging(ExpansionEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void expansionStateChanged(ExpansionEvent arg0) {
				if (sctn10112cet.isExpanded() == true) {
					sctn10112ce.setVisible(false);
					compositeAws.setVisible(false);
					new F10112cet(composite10112cet, cmpMenu.getStyle());
				}
				else
					composite10112ce.setVisible(false);
			}
		});
		
		sctnAws.addExpansionListener(new IExpansionListener() {
			@Override
			public void expansionStateChanging(ExpansionEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void expansionStateChanged(ExpansionEvent arg0) {
				if (sctnAws.isExpanded() == true) {
					sctn10112ce.setVisible(false);
					sctn10112cet.setVisible(false);
					new FAws(compositeAws, cmpMenu.getStyle());
				}
				else
					compositeAws.setVisible(false);
			}
		});
	}
}
