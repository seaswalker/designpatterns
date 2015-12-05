package composite;

/**
 * �������
 * @author skywalker
 *
 */
public class Client {

	public static void main(String[] args) {
		MenuComponent top = new Menu("�˵�", "�ܲ˵�");
		MenuComponent breakfast = new Menu("���", "ֻ�����");
		breakfast.add(new MenuItem("����", "", 12));
		breakfast.add(new MenuItem("����", "����", 1));
		top.add(breakfast);
		
		Menu lanch = new Menu("���", "ֻ�����");
		lanch.add(new MenuItem("��ͷ", "����ͷ", 0.5));
		lanch.add(new MenuItem("�׷�", "", 1.0));
		top.add(lanch);
		
		Menu sweet = new Menu("���", "");
		sweet.add(new MenuItem("�����", "", 2.0));
		lanch.add(sweet);
		
		//top.print();
		
		//������ϵ�����(�ⲿ������)
		ComponentIterator iterator = new ComponentIterator(top.iterator());
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getName());
		}
	}
	
}
