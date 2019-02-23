package interceptor;
import java.io.IOException;
import java.net.URISyntaxException;
public class ManagerFilters {
	private static  ChainFilters chainFilters;
	

	
	public ManagerFilters(Interface obj) {
		chainFilters = new ChainFilters();
		chainFilters.setObj(obj);
	}
	
	public static void setFilter(Filter filter) {
		chainFilters.addFilter(filter);
	}
	
	public void exe(double petition) throws IOException, URISyntaxException {
		chainFilters.Exe(petition);
		}
}
