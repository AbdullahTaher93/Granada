package Motor;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "MotorControl", eager = true)
@SessionScoped
public class MotorControl implements Serializable {
private static final long serialVersionUID = 1L;
	
	

	
	
	private int Status = 0;
	@ManagedProperty(value = "#{TitelText}")
	private String TitelText;

	@ManagedProperty(value = "#{TitelColor}")
	private String TitelColor;
    
	@ManagedProperty(value = "#{Textbut}")
	private String Textbut;
    
	@ManagedProperty(value = "#{colorbut}")
	private String colorbut;
    
	@ManagedProperty(value = "#{coloroffbut}")
	private String coloroffbut;
	
	
	private void ON() {
		Status = 1;
		TitelText = "ON";
		TitelColor = "green";
		Textbut = "OFF";
		colorbut = "red";
		coloroffbut="gray";
		
	}
	
	
	private void OFF() {
		Status = 0;
		TitelText = "OFF";
		TitelColor = "red";
		Textbut = "ON";
		colorbut = "green";
		coloroffbut="gray";
		
	}
	
	private void Speeding_UP() {
		Status = 2;
		TitelText = "Speed_UP";
		TitelColor = "blue";
		
		
	}
	
	
	private void updateButNOOFF(ActionEvent e) {
		if(Status==0) {
			ON();
		}else if(Status==1) {
			OFF();
		}else
		{
			Speeding_UP();	
		}
	}
	
	private void updateButTurnOFF(ActionEvent e) {
		if(Status==0) {
			//do nothing
		}else if(Status==1) {
			Speeding_UP();	
		}else
		{
			
			Speeding_UP();	
		}
		
	}
	
	public String getTitelText() {
		if (TitelText != null) {
			return TitelText;
		} else {
			return "OFF";
		}
	}

	public void setTitelText(String TitelText) {
		this.TitelText = TitelText;
	}

	public String getTitleColor() {
		if (TitelColor != null) {
			return TitelColor;
		} else {
			return "red";
		}
	}

	public void setTitleColor(String TitelColor) {
		this.TitelColor = TitelColor;
	}

	public String getTextBtnOnOff() {
		if (Textbut != null) {
			return Textbut;
		} else {
			return "ON";
		}
	}

	public void setTextBtnOnOff(String Textbut) {
		this.Textbut = Textbut;
	}

	public String getColorBtnOnOff() {
		if (colorbut != null) {
			return colorbut;
		} else {
			return "green";
		}
	}

	public void setColorBtnOnOff(String colorBtnOnOff) {
		this.colorbut = colorBtnOnOff;
	}
	
	public String getColorOFFBtn() {
		if (coloroffbut != null) {
			return coloroffbut;
		} else {
			return coloroffbut;
		}
	}

	public void setColorOFFBtn(String coloroffbut) {
		this.coloroffbut = coloroffbut;
	}
	

}
