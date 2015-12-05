package chain_of_responsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器链
 * @author skywalker
 *
 */
public class FilterChain implements Filter {

	private List<Filter> filters = new ArrayList<Filter>();
	//位置计数器
	private int index = 0;
	
	public void addFilter(Filter filter) {
		filters.add(filter);
	}

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		if(index >= filters.size()) {
			return;
		}
		Filter filter = filters.get(index ++);
		filter.doFilter(request, response, chain);
	}
	
}
