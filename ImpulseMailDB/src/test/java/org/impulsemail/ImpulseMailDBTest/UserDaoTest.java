package org.impulsemail.ImpulseMailDBTest;

import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.impulsemail.ImpulseMailDB.dao.UserDao;
import org.impulsemail.ImpulseMailDB.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.Timestamp;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-database.xml" })
public class UserDaoTest {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void testSaveOrupdate() {
		try{
			User user=new User();
			user.setUsername("impulse");
			user.setPassword("impulse");
			user.setUserEmail("impulse@impulsemail.com");
			user.setUserFirstName("impulse");
			user.setUserLastName("impulse");
			user.setUserAdminRole("Y");
			user.setUserStatus("ACTIV");
			user.setCretDtm(new Timestamp(new Date().getTime()));
			user.setLstUpdtDtm(new Timestamp(new Date().getTime()));
			
			getUserDao().saveOrUpdate(user);
		}
		catch(Exception e) {
			fail("Exception Thrown: " +e.getMessage());
		}
	}
	
	@Test
	public void testFindAll() {
		try{
			if(getUserDao().findAll().size()<=0)
				throw new Exception("Size of fetched list is Zero...");
		}
		catch(Exception e) {
			fail("Exception Thrown: " +e.getMessage());
		}
	}
	
	@Test
	public void testDelete() {
		try{
			User delUser=getUserDao().findUserByUsername("impulse");
			getUserDao().delete(delUser);
		}
		catch(Exception e) {
			fail("Exception Thrown: " +e.getMessage());
		}
	}

	

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	

}
