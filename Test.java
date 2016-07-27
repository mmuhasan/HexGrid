package hexGrid2;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		myClass[] data= new myClass[96];
		
		for(int i=0;i<96;i++)
			data[i] = new myClass(i);

		HexGrid<myClass> objHexGrid = new HexGrid<myClass>(9,11,data);
		int slice = -1;
		ArrayList<myClass> list = objHexGrid.slice(slice);
		for(int i=0;i<list.size();i++)
			list.get(i).print();
		System.out.println("finish");
	
		HexGrid<myClass> objHexGrid2 = new HexGrid<myClass>(9,6,data);
		
		ArrayList<myClass> list2 = objHexGrid2.slice(slice);
		for(int i=0;i<list2.size();i++)
			list2.get(i).print();
		System.out.println("finish");
	}
	
	

}

class myClass
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
}