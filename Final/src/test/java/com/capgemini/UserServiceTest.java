package com.capgemini;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.capgemini.lms.entities.Users;
import com.capgemini.lms.exception.UserNotFoundException;
import com.capgemini.lms.exception.ValidateUserException;
import com.capgemini.lms.serviceimpl.Usersimpl;

public class UserServiceTest  extends FinalApplicationTests{
	@Autowired
	Usersimpl ui;
	@Test
	public void testDeleteUser() throws UserNotFoundException{
		Users np=new Users(3,"Nikki@23s","Nikki","Attoti","9676540933","Nik@gm.com","2020-05-25","2020-05-25","2020-08-05","Active");
		int id =ui.deleteUser(np.getUserid());
		assertEquals(id,3);
	}
	
	@Test
	public void testViewUserList() {
		List<Users> add = ui.viewAllUsers();
		assertThat(add).size().isGreaterThan(0);
	}
	
	@Test
	public void testRegister() throws UserNotFoundException, ValidateUserException {
		Users add=new Users(1,"Nikki@12","Nikki","Attoti","9676540933","Nik@gm.com","2020-05-25","2020-05-15","2020-08-05","Active");
		add = ui.register(add);
		assertEquals(add.getPassword(),"Nikki@12");
		assertEquals(add.getMobileno(),"9676540933");
		assertEquals(add.getEmail(),"Nik@gm.com");
		assertEquals(add.getDate_of_birth(),"2020-05-25");
		assertEquals(add.getSubscription_date(),"2020-05-15");
		assertEquals(add.getSub_expire_date(),"2020-08-05");
		assertEquals(add.getSubscription_status(),"Active");
    }
	@Test
	public void testUpdateUserDetails() throws UserNotFoundException, ValidateUserException {
		Users add = new Users(2,"Nikki@23s","Hellow","Atto","9676980933","Nikou@gm.com","2020-05-10","2020-05-27","2020-08-14","Active");
			add = ui.updateUserDetails(add);
		assertEquals(add.getEmail(),"Nikou@gm.com");
	}
}
