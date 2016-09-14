package GeneralProblems;

public class BuySellStocks {

	public static void main(String[] args) {
		//int stock[] = {100, 80, 70, 65, 60, 55, 50};
		
		int stock[] = {100, 80, 120, 130, 70, 60, 100, 125};
		
		int profit=0;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<stock.length;i++){
			profit = Math.max(profit, stock[i]-min);
			min = Math.min(min, stock[i]);
		}
		
		System.out.println("stock selling..."+ profit);

	}

}
