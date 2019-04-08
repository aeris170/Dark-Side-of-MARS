package doga.engine;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class ColorSelectButton extends JButton {

	private static final long serialVersionUID = -860345856671104382L;
	
	public static final Border ColorSelectButtonEnabledBorder = new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.GRAY);
	public static final Border ColorSelectButtonDisabledBorder = new LineBorder(Color.GRAY, 2);
	
	public ColorSelectButton() {
		super();
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(38, 23);
	}
	
	public void setEnabled(boolean status) {
       super.setEnabled(status);
       this.setBorder( status ? ColorSelectButtonEnabledBorder : ColorSelectButtonDisabledBorder );
   }
}