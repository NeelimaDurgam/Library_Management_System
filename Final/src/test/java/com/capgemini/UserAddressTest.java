package com.capgemini;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.lms.entities.UserAddress;
import com.capgemini.lms.entities.Users;
import com.capgemini.lms.exception.AddressNotFoundException;
import com.capgemini.lms.exception.UserNotFoundException;
import com.capgemini.lms.exception.ValidateAddressException;
import com.capgemini.lms.exception.ValidateUserException;
import com.capgemini.lms.serviceimpl.UserAddressimpl;
import com.capgemini.lms.serviceimpl.Usersimpl;

public class UserAddressTest extends FinalApplicationTests{
	@Autowired
	UserAddressimpl as;
	@Autowired
	Usersimpl ui;
	@Test
	public void testDeleteUserAddress() throws AddressNotFoundException, UserNotFoundException, ValidateUserException{
		Users u = new Users(19,"Nikki@23s","Nikki","Attoti","9676540933","Nik@gm.com","2020-05-25","2020-05-25","2020-08-05","Active");
		u = ui.register(u);
		UserAddress np=new UserAddress(10,"Ameert","ECIL","Hyderabad","Telangana","123456",u);
		int id =as.deleteUserAddress(np.getAddressId());
		assertEquals(id,10);
	}
	
	@Test
	public void testViewUserAddressList() {
		List<UserAddress> add = as.viewUserAddressList();
		assertThat(add).size().isGreaterThan(0);
	}
	@Test
	public void testAddUserAddress() throws AddressNotFoundException, UserNotFoundException, ValidateUserException, ValidateAddressException {
		Users u = new Users(19,"Nikki@23s","Nikki","Attoti","9676540933","Nik@gm.com","2020-05-25","2020-05-25","2020-08-05","Active");
		u = ui.register(u);
		UserAddress add=new UserAddress(26,"Ameert","ECIL","Hyderabad","Telangana","123456",u);
		add = as.addUserAddress(add);
		assertEquals(add.getAddress1(),"Ameert");
		assertEquals(add.getAddress2(),"ECIL"); 
    }
	
	@Test
	public void testUpdateUserAddressDetails() throws AddressNotFoundException, UserNotFoundException, ValidateAddressException, ValidateUserException{
		Users u = new Users(19,"Nikki@23s","Nikki","Attoti","9676540933","Nik@gm.com","2020-05-25","2020-05-25","2020-08-05","Active");
		u = ui.register(u);
		UserAddress add=new UserAddress(9,"Ameert","ECIL","Hyderabad","Telangana","123456",u);
		add = as.updateUserAddressDetails(add);
		assertEquals(add.getCity(),"Hyderabad"); 
		assertEquals(add.getState(),"Telangana"); 
		assertEquals(add.getPincode(),"123456"); 
	}
	
	@Test
	public void testViewAddressByUserId() throws AddressNotFoundException, UserNotFoundException, ValidateAddressException, ValidateUserException{
		Users u = new Users(19,"Nikki@23s","Nikki","Attoti","9676540933","Nik@gm.com","2020-05-25","2020-05-25","2020-08-05","Active");
		u = ui.register(u);
		UserAddress add=new UserAddress(27,"Ameert","ECIL","Hyderabad","Telangana","123456",u);
		UserAddress np=as.addUserAddress(add);
		assertEquals(np.getAddressId(),27);
	}
	
}
