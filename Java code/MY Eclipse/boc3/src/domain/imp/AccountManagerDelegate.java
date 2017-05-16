package domain.imp;

import dao.IAccountdao;
import dao.jdbc.Accountdao;
import domain.IAccountManager;

@javax.jws.WebService(targetNamespace = "http://imp.domain/", serviceName = "AccountManagerService", portName = "AccountManagerPort")
public class AccountManagerDelegate {

	domain.imp.AccountManager accountManager = new domain.imp.AccountManager();

	public boolean login(String cardnum, String pin) {
		return accountManager.login(cardnum, pin);
	}

	public boolean changepin(String cardnum, String pin, String newpin) {
		return accountManager.changepin(cardnum, pin, newpin);
	}

	public double querybalance(String cardnum) {
		return accountManager.querybalance(cardnum);
	}

	public boolean fetch(String cardnum, double money) {
		return accountManager.fetch(cardnum, money);
	}

	public boolean deposit(String cardnum, double money) {
		return accountManager.deposit(cardnum, money);
	}

}