package domain.imp;

import wsclient.AccountManagerDelegate;

import wsclient.AccountManagerService;
import dao.IAccountdao;
import dao.jdbc.Accountdao;
import domain.IAccountManager;

public class AccountManager implements IAccountManager {
	
	
	private String bankPrefix = "4367";
	@Override
	public boolean login(String cardnum, String pin) {
		IAccountdao accountdao = null;
		boolean flag = false;
		//if this is my bank, call my own dao
		if(this.bankPrefix.equals(cardnum.substring(0,4))){
			accountdao = new Accountdao();
			flag = accountdao.findAccoutByIdandPin(cardnum, pin);
		}else{
			//else call web service client function
			AccountManagerService client = new AccountManagerService();
			AccountManagerDelegate accountmanager = client.getAccountManagerPort();
			flag = accountmanager.login(cardnum, pin);
		
		}
		
		return flag;
	}

	@Override
	public boolean changepin(String cardnum, String pin, String newpin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double querybalance(String cardnum) {
		IAccountdao accountdao = null;
		double money = -1;
		//if this is my bank, call my own dao
		if(this.bankPrefix.equals(cardnum.substring(0,4))){
			accountdao = new Accountdao();
			money = accountdao.queryaccount(cardnum);
		}else{
		//else call web service client function
			AccountManagerService client = new AccountManagerService();
			AccountManagerDelegate accountmanager = client.getAccountManagerPort();
			money = accountmanager.querybalance(cardnum);
			
		}
		
		return money;
	}

	@Override
	public boolean fetch(String cardnum, double money) {
		IAccountdao accountdao = null;
		boolean flag = false;
		//if this is my bank, call my own dao
		if(this.bankPrefix.equals(cardnum.substring(0,4))){
			accountdao = new Accountdao();
			flag = accountdao.fetch(cardnum, money);
		}else{
			//else call web service client function
			AccountManagerService client = new AccountManagerService();
			AccountManagerDelegate accountmanager = client.getAccountManagerPort();
			flag = accountmanager.fetch(cardnum, money);
		}
		
		return flag;
	}

	@Override
	public boolean deposit(String cardnum, double money) {
		IAccountdao accountdao = null;
		boolean flag = false;
		//if this is my bank, call my own dao
		if(this.bankPrefix.equals(cardnum.substring(0,4))){
			accountdao = new Accountdao();
			flag = accountdao.deposit(cardnum, money);
		}else{
			//else call web service client function
			AccountManagerService client = new AccountManagerService();
			AccountManagerDelegate accountmanager = client.getAccountManagerPort();
			flag = accountmanager.deposit(cardnum, money);
		}
		
		return flag;
	}

}
