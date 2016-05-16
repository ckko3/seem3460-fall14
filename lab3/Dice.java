//*************************************************************
//  Dice.java
//
//  Represents one dice  with faces showing values
//  between 1 and 6 randomly.
//*************************************************************

public class Dice
{
   private int MAX = 6;  // maximum face value

   private int faceValue;  // current value showing on the dice

   //-----------------------------------------------------------------
   //  Constructor: Sets the initial face value.
   //-----------------------------------------------------------------
   public Dice()
   {
      faceValue = 1;
   }
   //-----------------------------------------------------------------
   //  Rolls the dice and returns the result.
   //  Math.random() return a random float number t, 0 <= t < 1
   //  e.g., t=0.4, then t*MAX = 0.4*6 = 2.4, (int)(2.4)+1 = 2+1 = 3. Finally ,return 3.
   //  So, 1<= roll()<(int)(1*6)+1 = 7.   1<=roll()<=6
   //-----------------------------------------------------------------
   public int roll()
   {
      faceValue = (int)(Math.random() * MAX) + 1;

      return faceValue;
   }
   //-----------------------------------------------------------------
   //  Face value mutator.
   //-----------------------------------------------------------------
   public void setFaceValue (int value)
   {
      faceValue = value;
   }
   //-----------------------------------------------------------------
   //  Face value accessor.
   //-----------------------------------------------------------------
   public int getFaceValue()
   {
      return faceValue;
   }
   //-----------------------------------------------------------------
   //  Returns a string representation of this dice.
   //  e.g., faceValue=5, then return a string "5".
   //-----------------------------------------------------------------
   public String toString()
   {
	   
      String result = Integer.toString(faceValue);

      return result;
   }
}
