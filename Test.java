package hexGrid2;

import java.util.ArrayList;
import java.util.Collections;

public class Test {

	public static void main(String[] args) {
		
		myClass[] data= new myClass[96];
		
		for(int i=0;i<96;i++)
			data[i] = new myClass(i);

		HexGrid<myClass> objHexGrid = new HexGrid<myClass>(9,11,data);
		int radius = 0;
		ArrayList<myClass> list = objHexGrid.ring(2,3,radius);
		Collections.sort(list);
		for(int i=0;i<list.size();i++)
			list.get(i).print();
		System.out.println("finish");
	
		HexGrid<myClass> objHexGrid2 = new HexGrid<myClass>(9,6,data);
		ArrayList<myClass> list2 = objHexGrid2.ring(7,7,radius);
		Collections.sort(list2);
		for(int i=0;i<list2.size();i++)
			list2.get(i).print();
		System.out.println("finish");
	}
}

class myClass implements Comparable<myClass>
{
	int a;
	myClass(int i)
	{
		a = i+1;
	}
	
	int sqre()
	{
		return a*a;
	}
	void print()
	{
		System.out.println(a+" : "+sqre());
	}
	@Override
	public int compareTo(myClass o) {
		return this.a - o.a;
	}
}