package chain_of_responsibility;

/**
 * ¹ıÂËÆ÷½Ó¿Ú
 * @author skywalker
 *
 */
public interface Filter {

	public void doFilter(Request request, Response response, FilterChain chain);
	
}
