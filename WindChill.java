import java.util.Scanner;

public class WindChill {

	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
				
				double temp,windSpeed;
				
				
				System.out.println("Enter the temperature in Fahrenheit between -45-40");
				temp = input.nextDouble();
				if(temp < -45 || temp > 40) {
					System.out.println("Eror temperature is not between the -45-40 degrees.");
				}
				
				
				System.out.println("Enter the Wind Speed between 5-60");
				windSpeed = input.nextDouble();
				if(windSpeed < 5 || windSpeed > 60) {
					System.out.println("Error the wind is eathier to fast or slow for calculation.");
			}
				
				double windChill = 35.74 + 0.6215 *temp - 35.75 * Math.pow(windSpeed, .16) + 0.4275 * temp * Math.pow(windSpeed, .16);
				
				System.out.println("the WindChill is " + windChill);
				
				System.out.print("Programmer: Walter Jones");
			}


	}


