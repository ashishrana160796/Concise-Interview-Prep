public class CocktailSort{
	
	public static void cocktailSort(int[] a){
		boolean swap = true;
		int st = 0;
		int ed = a.length;
		
		while(swap == true){
			
			swap = false;
			
			for(int i=st;i<ed-1;i++){
				if(a[i] > a[i+1]){
					
					a[i] = a[i+1]^a[i];
					a[i+1] = a[i+1]^a[i];
					a[i] = a[i+1]^a[i];
					swap = true;
				}
			
			}
			
			if(swap = false)
				break;
			
			swap = false;
			
			ed--;
			
			for(int i=ed-1;i>=st;i--){
				if(a[i] > a[i+1]){
					
					a[i] = a[i+1]^a[i];
					a[i+1] = a[i+1]^a[i];
					a[i] = a[i+1]^a[i];
					swap = true;
				}
			}
				
			st++;
		
		}
		
	}
	
	
	public static void printA(int[] a){
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();	
	}
	
	public static void main(String[] args){
		int[] a = {11,45,14,22,17,1,11,0,55,4,6,88,15,49,12,88,2,3,9,3,7,8,10};
		cocktailSort(a);
		printA(a);
	}
	
}
