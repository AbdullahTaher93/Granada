package interceptor;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
public class Interface {
private String url = "http://localhost:8080/AbdullahAL-Musawi-P1/home.xhtml";
	
	public void exe(double Number_of_rounds) throws IOException, URISyntaxException {
		System.out.println("Execution InterFace");

		if (Desktop.isDesktopSupported()) {
			Desktop.getDesktop().browse(new URI(url));
		} else {
			Runtime.getRuntime().exec("/usr/bin/firefox -new-window " + url);
		}
	}

}
