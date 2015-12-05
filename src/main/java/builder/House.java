package builder;

/**
 * ����
 * @author skywalker
 *
 */
public class House {

	private final String name;
	private final String address;
	private final int price;
	//����
	private final String master;
	
	public House(HouseBuilder builder) {
		this.name = builder.name;
		this.address = builder.address;
		this.price = builder.price;
		this.master = builder.master;
	}
	
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public int getPrice() {
		return price;
	}

	public String getMaster() {
		return master;
	}
	
	@Override
	public String toString() {
		return "House [name=" + name + ", address=" + address + ", price="
				+ price + ", master=" + master + "]";
	}

	/**
	 * ���ݽ�����
	 * @author skywalker
	 *
	 */
	public static class HouseBuilder {
		private String name;
		private String address;
		private int price;
		private String master;
		
		public HouseBuilder(String name) {
			if (name == null) {
				throw new IllegalArgumentException("the name can't be null");
			}
			this.name = name;
		}
		
		public HouseBuilder withAddress(String address) {
			this.address = address;
			return this;
		}
		
		public HouseBuilder withPrice(int price) {
			this.price = price;
			return this;
		}
		
		public HouseBuilder withMaster(String master) {
			this.master = master;
			return this;
		}
		
		/**
		 * ע���������������ǰ������ôд��
		 * @return ����
		 */
		public House build() {
			return new House(this);
		}
		
	}
	
}
