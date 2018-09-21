package g;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAO {
	public Long getMaxAccoutNo() {
		try {
			Connection con = GetCon.getCon();
			PreparedStatement ps = con.prepareStatement("Select max(accountno) from newaccount");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				long accountno = rs.getLong(1);
				return accountno;
			}
			
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Exception in AccountDAO -> getMaxAccoutNo", e);
		}
	}
	
	public AccountDTO getAccountDetails(long accountno) {
		try {
			Connection con = GetCon.getCon();
			PreparedStatement ps = con.prepareStatement("Select ACCOUNTNO, USERNAME, PASSWORD, AMOUNT, ADDRESS, PHONE from NEWACCOUNT where accountno='" + accountno + "'");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				AccountDTO dto = new AccountDTO();
				dto.accountNo = rs.getLong( "ACCOUNTNO" ) ;
				dto.userName = rs.getString( "USERNAME" ) ;
				dto.password = rs.getString( "PASSWORD" ) ;
				dto.amount = rs.getDouble( "AMOUNT" ) ;
				dto.address = rs.getString( "ADDRESS" ) ;
				dto.phone = rs.getDouble( "PHONE" ) ;
				
				return dto;
			}
			
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Exception in AccountDAO -> getAccountDetails", e);
		}
	}
}
