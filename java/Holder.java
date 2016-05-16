public class Holder {
	public static void main(String[] args){
		Coin coinA = new Coin();
		coinA.flip();
		System.out.println(coinA.getValue());
		System.out.println(coinA.getOrientation());
	}	
}
