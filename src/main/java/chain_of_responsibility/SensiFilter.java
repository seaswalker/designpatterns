package chain_of_responsibility;

/**
 * 敏感字过滤器
 * @author skywalker
 *
 */
public class SensiFilter implements Filter {

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		request.setRequestStr(request.getRequestStr().replaceAll("敏感", "和谐"));
		chain.doFilter(request, response, chain);
		response.setResponseStr(response.getResponseStr() + "\r\n---SensiFilter");
	}

}
