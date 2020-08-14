package screen;

import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

import data.ElementsDao;
import data.HydrogenContent;
import entity.Elements;

public class FAws extends Composite {
	final private FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtCE;
	private Text txtHContent;
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public FAws(final Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});

		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		toolkit.setBackground(SWTResourceManager.getColor(69, 69, 69));

		Label lblMaterial = new Label(parent, SWT.NONE);
		lblMaterial.setText("Materijal:");
		lblMaterial.setBounds(66, 81, 61, 17);

		toolkit.adapt(lblMaterial, true, true);

		Label lblCE = new Label(parent, SWT.NONE);
		lblCE.setText("CE:");
		lblCE.setBounds(106, 118, 21, 17);
		toolkit.adapt(lblCE, true, true);

		final Combo combo = new Combo(parent, SWT.READ_ONLY);
		combo.setVisibleItemCount(30);
		combo.setBounds(133, 73, 213, 34);
		toolkit.adapt(combo);
		toolkit.paintBordersFor(combo);

		txtCE = new Text(parent, SWT.BORDER);
		txtCE.setEnabled(false);
		txtCE.setEditable(false);
		txtCE.setBounds(133, 113, 213, 30);
		toolkit.adapt(txtCE, true, true);

		final Combo cmbHContent = new Combo(parent, SWT.READ_ONLY);
		cmbHContent.setBounds(549, 73, 205, 34);
		toolkit.adapt(cmbHContent);
		toolkit.paintBordersFor(cmbHContent);

		txtHContent = new Text(parent, SWT.BORDER);
		txtHContent.setEditable(false);
		txtHContent.setEnabled(false);
		txtHContent.setBounds(549, 113, 205, 30);
		toolkit.adapt(txtHContent, true, true);

		Button btnGraph = new Button(parent, SWT.NONE);
		btnGraph.setText("Graf");
		btnGraph.setBounds(652, 148, 102, 34);
		toolkit.adapt(btnGraph, true, true);

		Label lblPercent = new Label(parent, SWT.NONE);
		lblPercent.setText("%");
		lblPercent.setAlignment(SWT.RIGHT);
		lblPercent.setBounds(473, 118, 70, 17);
		toolkit.adapt(lblPercent, true, true);

		final Label lblImage = new Label(parent, SWT.NONE);
		lblImage.setAlignment(SWT.CENTER);
		lblImage.setBounds(67, 191, 686, 356);
		toolkit.adapt(lblImage, true, true);

		Label lblHContent = new Label(parent, SWT.NONE);
		lblHContent.setText("Udio vodika:");
		lblHContent.setBounds(452, 81, 91, 17);
		toolkit.adapt(lblHContent, true, true);
		FormData fd_lblMaterial = new FormData();
		fd_lblMaterial.top = new FormAttachment(35, 57);
		fd_lblMaterial.right = new FormAttachment(375, 57);
		fd_lblMaterial.right = new FormAttachment(370, -723);
		List<String> list = getElements();
		String[] items = new String[list.size()];
		list.toArray(items);

		for (int i = 0; i < items.length; i++) {
			combo.add(items[i]);
		}

		FormData fd_txtCE = new FormData();
		fd_txtCE.top = new FormAttachment(0, 89);
		FormData fd_lblHContent = new FormData();
		fd_lblHContent.left = new FormAttachment(0, 446);
		fd_lblHContent.right = new FormAttachment(100, -307);
		fd_lblHContent.top = new FormAttachment(0, 57);
		FormData fd_cmbHContent = new FormData();
		fd_cmbHContent.left = new FormAttachment(100, -301);
		fd_cmbHContent.top = new FormAttachment(0, 49);
		fd_cmbHContent.right = new FormAttachment(100, -96);

		FormData fd_txtHContent = new FormData();
		fd_txtHContent.right = new FormAttachment(100, -96);
		FormData fd_btnGraph = new FormData();
		fd_btnGraph.left = new FormAttachment(0, 646);
		fd_btnGraph.right = new FormAttachment(100, -96);
		FormData fd_lblPercent = new FormData();
		fd_lblPercent.left = new FormAttachment(0, 467);
		FormData fd_groupImage = new FormData();
		fd_groupImage.left = new FormAttachment(0, 60);
		fd_groupImage.bottom = new FormAttachment(100, -97);

		for (HydrogenContent c : HydrogenContent.values()) {
			cmbHContent.add(c.toString());
		}

		cmbHContent.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void widgetSelected(SelectionEvent arg0) {

				for (HydrogenContent c : HydrogenContent.values()) {
					if (c.toString().equals(cmbHContent.getItem(cmbHContent.getSelectionIndex()))) {
						txtHContent.setText(c.getDescription());
						return;
					}
				}

			}

		});

		lblImage.setAlignment(SWT.CENTER);
		btnGraph.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void widgetSelected(SelectionEvent arg0) {

				if (txtCE.getText().equals("") || txtCE.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Obavezna polja", "Sva polja su obavezna!",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				} else {
					Image image = new Image(parent.getDisplay(), "/home/jlivic/Desktop/Denis/P2.jpg");
					lblImage.setImage(image);
				}
			}

		});

		combo.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Elements selectedElement = ElementsDao.findByName(combo.getItem(combo.getSelectionIndex()));
				txtCE.setText(ElementsDao.calculateAws(selectedElement));
			}

		});

		parent.setVisible(true);
	}

	public static List<String> getElements() {
		return ElementsDao.findAll();
	}

}
