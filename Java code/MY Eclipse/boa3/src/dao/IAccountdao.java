package dao;

public interface IAccountdao {
	boolean findAccoutByIdandPin (String cardnum, String pin);
	boolean changepin(String id, String cardnum, String newpin);
	double queryaccount(String cardnum);
	boolean fetch(String cardnum, double money);
	boolean deposit(String cardnum, double money);

}
