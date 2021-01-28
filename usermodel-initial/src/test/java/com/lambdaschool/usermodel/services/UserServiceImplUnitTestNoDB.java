package com.lambdaschool.usermodel.services;

import com.lambdaschool.UserModelApplicationTest;
import com.lambdaschool.usermodel.models.Role;
import com.lambdaschool.usermodel.models.User;
import com.lambdaschool.usermodel.models.UserRoles;
import com.lambdaschool.usermodel.models.Useremail;
import com.lambdaschool.usermodel.repository.RoleRepository;
import com.lambdaschool.usermodel.repository.UserRepository;
import org.junit.After;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserModelApplicationTest.class,
properties = {"command.line.runner.enabled=false"})
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceImplUnitTestNoDB
{

    @Autowired
    private UserService userServ;

    @MockBean
    private UserRepository userRepo;

    @MockBean
    private RoleService roleServ;

    @MockBean
    private RoleRepository roleRepo;

    private List<User> userList = new ArrayList<>();


    @Before
    public void setUp() throws Exception
    {
        // set up 'seed data' for testing
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        r1.setRoleid(1);
        r2.setRoleid(2);
        r3.setRoleid(3);

        // admin, data, user
        User u1 = new User("testadmin",
            "password",
            "testadmin@lambdaschool.local");
        u1.setUserid(10);

        u1.getRoles()
            .add(new UserRoles(u1,
                r1));
        u1.getUseremails()
            .add(new Useremail(u1,
                "testadmin@email.local"));

        // Add u1 to user list
        userList.add(u1);

        // data, user
        User u2 = new User("testcinnamon",
            "1234567",
            "testcinnamon@lambdaschool.local");
        u2.setUserid(20);

        u2.getRoles()
            .add(new UserRoles(u2,
                r2));

        u2.getUseremails()
            .add(new Useremail(u2,
                "testcinnamon@mymail.local"));

        // Add u2 to user list
       userList.add(u2);

        // user
        User u3 = new User("testbarnbarn",
            "ILuvM4th!",
            "testbarnbarn@lambdaschool.local");
        u3.setUserid(30);
        u3.getRoles()
            .add(new UserRoles(u3,
                r2));
        u3.getUseremails()
            .add(new Useremail(u3,
                "testbarnbarn@email.local"));

        // Add U3 to user list
        userList.add(u3);

        //Initialize Mockito for tests
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception
    {
        // Dont add anything here
    }
    //---------- GET tests -------------
    @Test
    public void findUserById()
    {
        Mockito.when(userRepo.findById(4L))
            .thenReturn(Optional.of(userList.get(0)));
        System.out.println(userList.get(0));
        assertEquals("testadmin", userServ.findUserById(4).getUsername());
    }

    @Test
    public void findUserByIdNotFound()
    {

    }

    @Test
    public void findByNameContaining()
    {
    }

    @Test
    public void findAll()
    {
    }

    @Test
    public void findByName()
    {
    }

    // ------- DELETE, POST, PUT tests ---------
    @Test
    public void delete()
    {
    }

    @Test
    public void save()
    {
    }

    @Test
    public void update()
    {
    }

    @Test
    public void deleteAll()
    {
    }
}