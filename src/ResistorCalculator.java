import java.util.Scanner;
public class ResistorCalculator {	
	static String[] colors = {"Blk", "Brn", "Red", "Org", "Ylw", "Grn", "Blu", "Vio", "Gry", "Wht", "Gld", "Slv"};
    static int[] colorVals = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0};
    static double[] colorMults = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 0, 0, .1, .01};
    

    public static void main(String args[]){
        Scanner reader = new Scanner(System.in);
        System.out.println("Tolerance is assumed to be 5% due to time limitations if nominal value is unknown.");
        System.out.println("Enter Y if you know nominal value, enter N if you do not");
        String entry = reader.nextLine();
        if (entry.equalsIgnoreCase("Y")){
            nominalKnown();
        } else{
            nominalUnknown();
        }
    }
    public static void nominalKnown(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter resistor tolerance level (%) Ex: Enter 5 for 5%");
        double tolerance = reader.nextDouble();
        double percent = tolerance/100;
        System.out.println("Enter nominal value, no prefix");
        double val = reader.nextDouble();
        double high = val+(val*percent);
        double low = val-(val*percent);
        System.out.println("Low: "+ low+" High: "+high);
    }
    

    public static void nominalUnknown(){
        Scanner reader = new Scanner(System.in);
        for (int i = 0; i < colors.length-1; i++){
            System.out.print(colors[i] + ", " );
        }
        System.out.print(colors[colors.length-1]);
        System.out.println();
        System.out.println("Enter color 1");
        String c1 = reader.nextLine();
        System.out.println("Enter color 2");
        String c2 = reader.nextLine();
        System.out.println("Enter color 3");
        String c3 = reader.nextLine();

        int c1Val = colorVals[findInArray(c1)]*10;
        int c2Val = colorVals[findInArray(c2)];
        double c3Val = colorMults[findInArray(c3)];
        double nomVal = (c1Val+c2Val)*c3Val;
        double high = nomVal+(nomVal*.05);
        double low = nomVal-(nomVal*.05);
        System.out.println("Nominal Value: "+ nomVal);
        System.out.println("Low: "+ low+" High: "+ high);
        

    }
    

    public static int findInArray(String color){
        int index = -1;
        for (int i=0;i<colors.length;i++) {
        	if (colors[i].equalsIgnoreCase(color)) {
        		index = i;
        		break;
            }
      	}
        return index;
    }
    


}
