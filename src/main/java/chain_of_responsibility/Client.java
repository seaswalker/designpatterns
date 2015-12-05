package chain_of_responsibility;

public class Client {

	public static void main(String[] args) {
		FilterChain chain = new FilterChain();
		chain.addFilter(new SensiFilter());
		chain.addFilter(new NameFilter());
		
		Request request = new Request();
		request.setRequestStr("√Ù∏–£¨ skywalker");
		Response response = new Response();
		response.setResponseStr("");
		
		chain.doFilter(request, response, chain);
		
		System.out.println(request.getRequestStr());
		System.out.println(response.getResponseStr());
	}
	
}
