package chain_of_responsibility;

/**
 * skywalker¸Äµô
 * @author skywalker
 *
 */
public class NameFilter implements Filter {

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		request.setRequestStr(request.getRequestStr().replaceAll("skywalker", "Èø±È"));
		chain.doFilter(request, response, chain);
		response.setResponseStr(response.getResponseStr() + "\r\n---NameFilter");
	}

}
