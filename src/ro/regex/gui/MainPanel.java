package ro.regex.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	private JTextField regexField;
	private JTextField wordField;

	public MainPanel() {
		super(new GridBagLayout());
		initialize();
		this.setPreferredSize(new Dimension(500, 200));
	}

	private void initialize() {
		GridBagConstraints gbc = new GridBagConstraints();

		regexField = new JTextField(30);
		wordField = new JTextField(30);
		JLabel regexLabel = new JLabel("Regex: ");
		regexLabel.setLabelFor(regexField);
		JLabel wordLabel = new JLabel("Word: ");
		wordLabel.setLabelFor(wordField);
		JButton verifyButton = new JButton("Verifica");

		verifyButton.addActionListener(createVerifyListener(this));
		
		// add components
		gbc.gridx=0;
		gbc.gridy=0;
		
		this.add(regexLabel, gbc);
		gbc.gridx++;
		this.add(regexField, gbc);
		
		gbc.gridy++;
		gbc.gridx=0;
		this.add(wordLabel, gbc);
		gbc.gridx++;
		this.add(wordField, gbc);
		
		gbc.gridx=0;
		gbc.gridy++;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(10, 0, 10, 0);
		this.add(verifyButton, gbc);
	}

	private ActionListener createVerifyListener(JPanel panel) {
		return e -> {
			String regexText = regexField.getText();
			String wordText = wordField.getText();
			String popUpText = null;
			boolean matches = false;
			try {
				matches = wordText.matches(regexText);
			} catch (Exception exception) {
				popUpText = "Regex-ul nu este corect";
			}
			
			if (popUpText == null) {
				if (matches) {
					popUpText = "Cuvantul respecta regex-ul";
				} else {
					popUpText = "Cuvantul nu respecta regex-ul";
				}
			}
			JOptionPane.showMessageDialog(panel, popUpText, "RegexDialog", JOptionPane.INFORMATION_MESSAGE);
		};
	}

}
