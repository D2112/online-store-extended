package com.epam.store;

import com.epam.store.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-config/application-context.xml"})
public class DaoTest {
    /* @Autowired private PodamFactory randomPojoFactory;*/
    private User user;

    @Before
    public void setup() {
        /*user = randomPojoFactory.manufacturePojo(User.class);*/
    }

    @Test
    public void insertUpdateFindAndDeleteTest() {
        /*dao.insert(user);
        user.setName("VasiliyTheChanged");
        dao.update(user);
        User foundUser = dao.find(User.class, this.user.getId());
        dao.delete(this.user);*/
    }
}
