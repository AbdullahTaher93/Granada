package interceptor;
import java.io.IOException;
import java.net.URISyntaxException;
public class Client {

private ManagerFilters managerFilters;
	
	public void setGestorFiltros(ManagerFilters managerFilters) {
		this.managerFilters = managerFilters;
	}
	
	public void Send_request(double Number_of_rounds) throws IOException, URISyntaxException {
		managerFilters.exe(Number_of_rounds);
	}
}
