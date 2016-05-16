//*************************************************************
//  RollingDiceNEW.java
//
//  Demonstrates the creation and use of a user-defined class.
//*************************************************************

public class RollingDiceNEW
{
   //-----------------------------------------------------------------
   //  Creates two Die objects and rolls them several times.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      DiceNEW dice1, dice2, dice3;
      int sum;

   //  Test 1: roll()
      dice1 = new DiceNEW();
      dice1.roll();
      System.out.println ("Test 1 (1-6): " + dice1);
      
   //  Test 2: setFaceValue()
      dice1 = new DiceNEW();
      dice1.setFaceValue(4);
      System.out.println ("Test 2 (4): " + dice1);

   //  Test 3: setMAX(), setMIN()
      dice1 = new DiceNEW();
      dice2 = new DiceNEW();
      dice3 = new DiceNEW();
      dice1.setMAX(3);
      dice2.setMIN(4);
      dice3.setMAX(13);
      dice3.setMIN(7);
      sum = dice3.roll() - dice2.roll() + dice1.roll();
      System.out.println ("Test 3 (2-12): " + sum);

   //  Test 4: isWin()
      dice1 = new DiceNEW();
      System.out.println ("Test 4: " + dice1.isWin() + ", faceValue = " + dice1.getFaceValue());
   }
}
