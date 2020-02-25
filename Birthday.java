package wjones;

import javax.swing.JOptionPane;
import java.util.Random; 
public class Birthday {

	public static void main(String[] args) {
			String name;
			int age;
			String ageStr;
			String Toy;
			boolean valid = true;
			String ans =" ";
			String Card;
			String Balloon;
			double Cost=0;
			String Another;
			
			JOptionPane.showMessageDialog(null, "Welcome to the Toy Company to choose gifts for young children");
			name = JOptionPane.showInputDialog("Enter the name of the child.");
			ageStr = JOptionPane.showInputDialog("How old is the child");
			age = Integer.parseInt(ageStr);
			
			do {
				do {
					do {
			
			Toy = JOptionPane.showInputDialog("Choose a toy: Plushie,Blocks,or a Book");
		
			switch(Toy) {
			
			case "Plushie" : valid = true;
			break;
			case "Blocks" : valid = true;
			break;
			case "Book" : valid = true;
			break;
			default: valid = false;
			}
				 Toy Gift = new Toy(Toy,age);
				 if(Gift.ageOK()==false) {
					ans = JOptionPane.showInputDialog("Toy is not age-appropiate, would you like to choose another toy? Yes or no?");
				 }
				 } while(ans.equals("yes"));
			 
			if (valid == false) {
			JOptionPane.showMessageDialog(null,"The answer you enetered is invalid please try again");
			}
		
			Toy Cs = new Toy();
			Cs.setCost(Toy);
			
			
			
			}while(valid == false);
			
			
			JOptionPane.showMessageDialog(null,"Good Choice!");
			
			 Toy output = new Toy();
			  output.setCost(Toy);
			  
			Card = JOptionPane.showInputDialog("do you want a card with the gift yes or no?");
			
				output.addCard(Card);
			
			
			
			Balloon = JOptionPane.showInputDialog("Do you want a balloon with the gift yes or no?");
				
			      output.addBalloon(Balloon);
			      
			      
			      output.setAge(age);
			      output.setToy(Toy);
			      output.getAge();
			      output.getCost();
			      output.getToy();
			      output.addCost(Cost);
			      
			      JOptionPane.showMessageDialog(null,"The Gift for "+ name + output.toString());
		           Another = JOptionPane.showInputDialog("Do you want another Toy?");
		           JOptionPane.showMessageDialog(null,"The Total cost of your order is " + output.getCost());
			} while(Another.equals("yes"));
			
						  
			  
			  
			 Random R = new Random();
			 
			  
			  JOptionPane.showMessageDialog(null,"Order Number is: " + R.nextInt(10000) + 1 +"\nProgrammer Name: Walter Jones");
		}

		
	}



