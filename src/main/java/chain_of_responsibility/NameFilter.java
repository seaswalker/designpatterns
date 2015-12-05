package chain_of_responsibility;

/**
 * skywalker�ĵ�
 * @author skywalker
 *
 */
public class NameFilter implements Filter {

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		request.setRequestStr(request.getRequestStr().replaceAll("skywalker", "����"));
		chain.doFilter(request, response, chain);
		response.setResponseStr(response.getResponseStr() + "\r\n---NameFilter");
	}

}
