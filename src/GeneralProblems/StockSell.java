package GeneralProblems;

public class StockSell {

	public static void main(String[] args) {
		 //int stock[] = {100, 80, 120, 130, 70, 60, 100, 125};
        int stock[] = {100, 80, 70, 65, 60, 55, 50};

          int sPrice=stock[0]; //least
          int ePrice=0; //next highest (counting from least)
          int profit=0;
          String match=null;
          for(int i=1; i< stock.length; i++){
               if(stock[i] < sPrice)
                    sPrice = stock[i];

               else if(stock[i] > sPrice) {
                   ePrice = stock[i];
                   String str = "("+sPrice+","+ePrice+")";
                   int prf = (ePrice-sPrice);
                   if(prf > profit) {
                       profit = prf;
                       match = str;
                   }

               }

          }

        System.out.println("sPrice-"+sPrice+" ePrice-"+ePrice);

        System.out.println("..profit.."+profit+"..match.."+match);


	}

}
