package g;

public class AccountDTO {
	public long accountNo;
	public String userName;
	public String password;
	public double amount;
	public String address;
	public double phone;
	
	public AccountDTO() {
		super();
	}
	public AccountDTO(long accountNo, String userName, String password, double amount, String address, double phone) {
		super();
		this.accountNo = accountNo;
		this.userName = userName;
		this.password = password;
		this.amount = amount;
		this.address = address;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "AccountDTO [accountNo=" + accountNo + ", userName=" + userName + ", password=" + password + ", amount="
				+ amount + ", address=" + address + ", phone=" + phone + "]";
	}
}
