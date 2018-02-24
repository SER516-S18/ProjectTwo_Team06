package server;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The ServerControlPanel class
 * 
 * @author Team 06
 * @version 1.0
 */
public class ServerPanelHighest extends JPanel implements ActionListener {

	JPanel highestValuePanel;
	JLabel highLabel;
	JFormattedTextField highTxt;
	int highestValue;

	public ServerPanelHighest() {
		highestValuePanel = new JPanel();
		highLabel = new JLabel(ServerConstants.HIGHEST_LABEL);
		highLabel.setFont(ServerConstants.TEXT_FONT);
		highLabel.setSize(85, 60);
		highestValuePanel.setPreferredSize(new Dimension(120, 60));
		highestValuePanel.setBackground(ServerConstants.LIGHT_BLUE);
		highestValuePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		highTxt = new JFormattedTextField(ServerHelper.formatter());
		highTxt.setText("1024");
		highTxt.addActionListener(this);
		highTxt.setBorder(BorderFactory.createLineBorder(Color.black));
		highTxt.setBackground(ServerConstants.PINK);
		highTxt.setPreferredSize(new Dimension(120, 60));
		highTxt.setEditable(true);
		add(highestValuePanel);
		highestValuePanel.add(highLabel);
		add(highTxt);
	}

	public int getHighestValue() {
		highestValue = Integer.parseInt(highTxt.getText());
		return highestValue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFormattedTextField highText = (JFormattedTextField) e.getSource();
		Long high = (Long) highText.getValue();
		ServerDataManager.getInstance();
		ServerDataManager.setHighestValue(high);
	}
}