package hexGrid2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Test {

	public static void main(String[] args) {

		myClass[] data= new myClass[96];
		
		for(int i=0;i<96;i++)
			data[i] = new myClass(i);

		HexGrid<myClass> objHexGrid = new HexGrid<myClass>(9,11,data);
		int slice = -1;
		ArrayList<myClass> list = objHexGrid.slice(slice);
		Collections.sort(list);
		
		myClass A;
		for(int i=0;i<list.size();i++)
		{
			A = list.get(i);
			if(i+1 != A.a)
			{ 	
				System.out.printf("%d. ",i+1);
				A.print();
			}
		}
		System.out.println("finish");
	

		HexGrid<myClass> objHexGrid2 = new HexGrid<myClass>(9,6,data);
		ArrayList<myClass> list2 = objHexGrid2.slice(slice);
		Collections.sort(list2);
		
		for(int i=0;i<list2.size();i++)
		{
			A = list2.get(i);
			if(i+1 != A.a)
			{ 	
				System.out.printf("%d. ",i+1);
				A.print();
			}
		}
		System.out.println("finish");

		HexGrid<myClass> objHexGrid3 = new HexGrid<myClass>(10,10,data);
		ArrayList<myClass> list3 = objHexGrid2.slice(slice);
		Collections.sort(list3);
		
		for(int i=0;i<list3.size();i++)
		{
			A = list3.get(i);
			if(i+1 != A.a)
			{ 	
				System.out.printf("%d. ",i+1);
				A.print();
			}
		}
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