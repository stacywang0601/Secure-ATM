package dao;

public interface IAccountdao {
	boolean findAccoutByIdandPin (String id, String pin);
	boolean changepin(String id, String pin, String newpin);
	double queryaccount(String id);
	boolean fetch(String id, double money);
	boolean deposit(String id, double money);

}
