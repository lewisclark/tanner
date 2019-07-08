package org.doubt.tanner;

import java.awt.Dialog.ModalityType;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public final class Gui {
	private JDialog dialog;
	private JComboBox<Hide> hideCombo;
	private JComboBox<Location> locationCombo;
	private boolean isReady = false;

	public Gui() {
		isReady = false;

        dialog = new JDialog();
		dialog.setTitle(Global.SCRIPT_NAME);
		dialog.setSize(200, 120);
		dialog.setModalityType(ModalityType.APPLICATION_MODAL);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		dialog.getContentPane().add(panel);

		hideCombo = new JComboBox<>(Hide.values());
		panel.add(hideCombo);

		locationCombo = new JComboBox<>(Location.values());
		panel.add(locationCombo);

		JButton startBtn = new JButton();
		startBtn.setText("Start");
		startBtn.addActionListener(e -> {
			isReady = true;
			close();
		});
		panel.add(startBtn);
	}

	public void open() {
		dialog.setVisible(true);
	}

	public void close() {
		dialog.setVisible(false);
	}

	public boolean isOpen() {
		return dialog.isVisible();
	}

	public boolean isReady() {
		return isReady;
	}

	public Hide getSelectedHide() {
		return (Hide)hideCombo.getSelectedItem();
	}

	public Location getSelectedLocation() {
		return (Location)locationCombo.getSelectedItem();
	}
}