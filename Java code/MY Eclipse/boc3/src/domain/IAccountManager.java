package domain;

public interface IAccountManager {
	boolean login (String cardnum, String pin);
	boolean changepin(String cardnum, String pin, String newpin);
	double querybalance(String cardnum);
	boolean fetch(String cardnum, double money);
	boolean deposit(String cardnum, double money);
	

}
