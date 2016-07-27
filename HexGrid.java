package hexGrid2;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HexGrid <T>{
    int row,col;
    int cx,cy;
    T[][] grid;

    public HexGrid(T[] data){
        int n = data.length;
        int r = (int) Math.ceil(Math.sqrt(n));
        LoadData(r, r, data);
    }       
    public HexGrid(int r,T[] data){
        this(r,(int)(Math.ceil(data.length/r)),data);
    }
    public HexGrid(int r){
        this(r,r,null);
    }
    public HexGrid(int r, int c){
        this(r,c,null);
    }
    public HexGrid(int r,int c,T[] data) {
        LoadData(r, c, data);           
    }

    @SuppressWarnings("unchecked")
    public void LoadData(int r, int c, T[] data){
        row     = r;
        col     = c;
        cx 		= row/2;
        cy 		= (col+(int)(Math.floor(row/2.0)))/2;
        
        grid    = (T[][]) Array.newInstance(data.getClass().getComponentType(),r, c+(int) Math.floor(r/2.0));
        if(data!=null)
            AssignValues(data);
    }

    private void AssignValues(T[] data) {
        int dbug=0;
        for(int i=0; i<row; i++)
        {
        	int j;
        	
        	for(j=0;j<(int)(Math.ceil(i/2.0));j++)
        		grid[i][j] = null;
        	
            for(;j<col+(int)(Math.floor(i/2.0)); j++)
            {
                
                if(dbug<data.length)
                     grid[i][j] = data[dbug++];
                else
                	grid[i][j] = null;
            }
            
            for(;j<col+(int)(Math.floor(row/2.0)); j++)
            	grid[i][j] = null;
        }
        //System.out.printf("row=%d col=%d and Total = %d%n",row,col,dbug);
    }
    
    public ArrayList<T> slice(){
    	return slice(-1,-1);
    }
    
    public ArrayList<T>slice(int slice){
    	return slice(slice,-1);
    }
    
    /**
     * ## distance > 0 (-1 indicates full distance)
     * @param slice
     * @param distance
     * @return
     */
    public ArrayList<T> slice(int slice,int distance)
    {
    	ArrayList<T> list = new ArrayList<T>();
    	int r;
    	if(distance==-1)
    		r = (cx>cy?cx:cy); 
    	else r=distance;
    	
    	switch(slice){

    	case -1:
    	case 1:
    		list.add(grid[cx][cy]);
    		for(int i=cx, k =0;i>=0;i--,k++)
    		{
    			for(int j=(int)Math.ceil(i/2.0);j<cy-k;j++)
    			{
    				list.add(grid[i][j]);
    			}
    		}

    		if(slice!=-1)
    			break;
    	case 2:
    		
    		for(int i=cx, k =0;i>=0;i--,k++) // will be same as slice #1
    		{
    			for(int j=cy-k;j<cy;j++) // starts from where slice #1 finish and continue till the center
    			{
    				list.add(grid[i][j]);
    			}
    		}
    		if(slice!=-1)
    			break;
    	case 3:
    		//col+(int) Math.floor(i/2.0)
    		if(slice!=-1)
    			break;
    	case 4:
    		
    		if(slice!=-1)
    			break;
    	case 5:
    		
    		if(slice!=-1)
    			break;
    	case 6:
    		
    		if(slice!=-1)
    			break;
    	}
    	
    	return list;
    	
    }
    
    public ArrayList<T> ring(int diameter)
    {
    	ArrayList<T> list = new ArrayList<T>();
    	
    	
    	
    	return list;
    }
    public Object testMore(int i, int j)
	{
		return grid[i][j];
	}

}