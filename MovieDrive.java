import java.util.Scanner;

public class MovieDrive {

	public static void main(String[] args) {
		
       Scanner input = new Scanner(System.in);
		String ans;
		
		do {
		System.out.println("What is the name of the movie?");
		String title = input.nextLine();
		
				
		System.out.println("What is the rating of the movie?");
		String rating= input.nextLine();

		System.out.println("How many tickets sold?");
		int SoldTickets= input.nextInt();
		
		Movie a = new Movie(title, rating, SoldTickets);
		
		System.out.println(a); 
		
		input.nextLine();
		System.out.println("Do you want to continue? yes or no");
		ans = input.nextLine();

	}while(ans.equals("yes"));


	}
}
