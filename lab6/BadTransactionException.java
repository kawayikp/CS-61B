

public class BadTransactionException extends Exception{
	private int badTransactionAmount;
	
	public BadTransactionException(int amount) {
		super("Invalid transaction amount: " + amount);
		badTransactionAmount = amount;
	}

}
