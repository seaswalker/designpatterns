package chain_of_responsibility;

/**
 * �������ӿ�
 * @author skywalker
 *
 */
public interface Filter {

	public void doFilter(Request request, Response response, FilterChain chain);
	
}
