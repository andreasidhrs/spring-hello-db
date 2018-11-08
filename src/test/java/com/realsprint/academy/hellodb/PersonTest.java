package com.realsprint.academy.hellodb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private PeopleRepository peopleRepository;

    @Test
    public void findByNameTest() {
        Person william = new Person("William", 25);
        entityManager.persist(william);
        entityManager.flush();

        Person found = peopleRepository.findByName(william.getName());

        assertThat(found.getName())
                .isEqualTo(william.getName());
    }
}
