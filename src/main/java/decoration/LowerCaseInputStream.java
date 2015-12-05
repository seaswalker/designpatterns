package decoration;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自己实现过滤流
 * @author skywalker
 *
 */
public class LowerCaseInputStream extends FilterInputStream {

	protected LowerCaseInputStream(InputStream in) {
		super(in);
	}
	
	@Override
	public int read() throws IOException {
		int i = super.read();
		if(i != -1) {
			char c = (char) i;
			c = Character.toLowerCase(c);
			return c;
		}
		return i;
	}
	
	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		int result = super.read(b, off, len);
		for(int i = 0;i < off + result;i ++) {
			b[i] = (byte) Character.toLowerCase((char) b[i]);
		}
		return result;
	}

}
