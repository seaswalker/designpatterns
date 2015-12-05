package chain_of_responsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������
 * @author skywalker
 *
 */
public class FilterChain implements Filter {

	private List<Filter> filters = new ArrayList<Filter>();
	//λ�ü�����
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
