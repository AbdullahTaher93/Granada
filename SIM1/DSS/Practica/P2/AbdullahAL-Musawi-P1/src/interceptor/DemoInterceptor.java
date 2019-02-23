package interceptor;
import java.io.IOException;
import java.net.URISyntaxException;
public class DemoInterceptor {

	public static void main(String[] args) throws IOException, URISyntaxException {
		ManagerFilters managerFilters = new ManagerFilters(new Interface());
		ManagerFilters.setFilter(new CalSpeed());
		Client client = new Client();
		client.setGestorFiltros(managerFilters);
		client.Send_request(20);

	}

}
