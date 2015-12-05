package chain_of_responsibility;

/**
 * �����ֹ�����
 * @author skywalker
 *
 */
public class SensiFilter implements Filter {

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		request.setRequestStr(request.getRequestStr().replaceAll("����", "��г"));
		chain.doFilter(request, response, chain);
		response.setResponseStr(response.getResponseStr() + "\r\n---SensiFilter");
	}

}
