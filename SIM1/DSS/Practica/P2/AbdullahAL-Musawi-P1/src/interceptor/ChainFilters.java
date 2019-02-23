package interceptor;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
public class ChainFilters {
	private Interface obj;
	private List<Filter> filters;

	public ChainFilters() {
		filters=new ArrayList<Filter>();
		
	}
	
	public void addFilter(Filter filter) {
		filters.add(filter);
	}
	
	public void Exe(double petition) throws IOException, URISyntaxException {
		for (Filter filter: filters) {
			System.out.println("New speed (m/s) " + filter.Exe(petition));
		}
		obj.exe(petition);
	}
	public void setObj(Interface obj) {
		this.obj = obj;
	}
	
}
