package idw.webservices.dto;

import java.awt.Color;
import java.io.Serializable;

@SuppressWarnings("serial")
public class ColorDTO implements Serializable {
	private int r;
	private int g;
	private int b;
	private int rgb;
	
	public ColorDTO(){		
	}
			
	public ColorDTO(Color color){		
		this.rgb = color.getRGB();
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getRgb() {
		return rgb;
	}

	public void setRgb(int rgb) {
		this.rgb = rgb;
	}
	
}
