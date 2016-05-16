//*************************************************************
//  RollingDice.java
//
//  Demonstrates the creation and use of a user-defined class.
//*************************************************************

public class RollingDice
{
   //-----------------------------------------------------------------
   //  Creates two Dice objects and rolls them several times.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      Dice dice1, dice2;
      int sum;

      dice1 = new Dice();
      dice2 = new Dice();

      dice1.roll();
      dice2.roll();
      System.out.println ("Dice One: " + dice1 + ", Dice Two: " + dice2);
      
      dice1.roll();
      dice2.setFaceValue(4);
      System.out.println ("Dice One: " + dice1 + ", Dice Two: " + dice2);
      sum = dice1.getFaceValue() + dice2.getFaceValue();
      System.out.println ("Sum: " + sum);

      sum = dice1.roll() + dice2.roll();
      System.out.println ("Dice One: " + dice1 + ", Dice Two: " + dice2);
      System.out.println ("New sum: " + sum);
   }
}
