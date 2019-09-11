package com.xebia.okr.repo;

import com.xebia.okr.domain.Plan;
import com.xebia.okr.repository.PlanRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PlanRepositoryTests {
    //@Autowired
    //private TestEntityManager entityManager;

    @Autowired
    private PlanRepository repository;

    @Test
    public void contextLoads() {
    }

    //Create Test Case for Plan Repository
    @Test
    public void should_create_plan_when_I_provide_valid_data() {

        Plan savePlan = repository.save(new Plan("JAVA DEVELOPER", new Date(), Date.from(LocalDate.of(2019, 9, 30).atStartOfDay().atZone(ZoneId.systemDefault())
                .toInstant())));
        assertThat(savePlan).isNotNull();
		/*//Read Test Case for Plan Repository
		List<Plan> plans = repository.findByTitle("JAVA DEVELOPER");

		System.out.println("dataaaa-->"+plans.get(0).getTitle());
		assertEquals(1, plans.size());

		assertThat(plans).extracting(Plan::getTitle).containsOnly("JAVA DEVELOPER");*/

    }

    @Test
    public void should_read_plan_when_I_provide_valid_data() {

        Plan savePlan = repository.save(new Plan("JAVA DEVELOPER", new Date(), Date.from(LocalDate.of(2019, 9, 30).atStartOfDay().atZone(ZoneId.systemDefault())
                .toInstant())));
        Plan findPlan = repository.findById(savePlan.getId()).get();
        assertThat(findPlan).isNotNull();

    }

    //Update Test Case for Plan Respository
    @Test
    public void should_update_plan_when_I_provide_valid_data() {

    	Plan updatePlan= repository.save(new Plan("JAVA DEVELOPER", new Date(), Date.from(LocalDate.of(2019, 9, 30).atStartOfDay().atZone(ZoneId.systemDefault())
				.toInstant())));
    	//Plan updatePlan = repository.findById(savePlan.getId()).get();
        updatePlan.setTitle("MIDDLEWARE DEVELOPER");
        repository.save(updatePlan);
        Plan updatedPlan = repository.findById(updatePlan.getId()).get();
        assertThat(updatePlan.getTitle()).isEqualToIgnoringCase("MIDDLEWARE DEVELOPER");
        //(updatedPlan).extracting(Plan::getTitle).containsOnly("MIDDLEWARE DEVELOPER");
    }

    @Test
    public void should_delete_plan_when_I_provide_valid_data() {
        Plan savePlan =repository.save(new Plan("JAVA DEVELOPER", new Date(), Date.from(LocalDate.of(2019, 9, 30).atStartOfDay().atZone(ZoneId.systemDefault())
                .toInstant())));
        repository.deleteById(savePlan.getId());
        assertThat(repository.findById(savePlan.getId()).isPresent()).isFalse();
    }

}
