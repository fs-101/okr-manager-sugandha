package com.xebia.okr.repo;

import com.xebia.okr.domain.Objective;
import com.xebia.okr.domain.Plan;
import com.xebia.okr.repository.ObjectiveRepository;
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
public class ObjectiveRepositoryTests {
    //@Autowired
    //private TestEntityManager entityManager;

    @Autowired
    private ObjectiveRepository objectiveRepository;

    @Autowired
    private PlanRepository planRepository;

    @Test
    public void contextLoads() {
    }

    //Create Test Case for Plan Repository
    @Test
    public void should_create_objective_when_I_provide_valid_data() {

        Plan savePlan = planRepository.save(new Plan("JAVA DEVELOPER", new Date(), Date.from(LocalDate.of(2019, 9, 30).atStartOfDay().atZone(ZoneId.systemDefault())
                .toInstant())));
        Objective saveObjective=objectiveRepository.save(new Objective("2nd Quarter","Label",savePlan));
        assertThat(saveObjective.getId()).isNotNull();
		/*//Read Test Case for Plan Repository
		List<Plan> plans = repository.findByTitle("JAVA DEVELOPER");

		System.out.println("dataaaa-->"+plans.get(0).getTitle());
		assertEquals(1, plans.size());

		assertThat(plans).extracting(Plan::getTitle).containsOnly("JAVA DEVELOPER");*/

    }

    @Test
    public void should_read_objective_when_I_provide_valid_data() {

        Plan savePlan = planRepository.save(new Plan("JAVA DEVELOPER", new Date(), Date.from(LocalDate.of(2019, 9, 30).atStartOfDay().atZone(ZoneId.systemDefault())
                .toInstant())));
        Objective saveObjective=objectiveRepository.save(new Objective("2nd Quarter","Label",savePlan));
        Objective findObjective = objectiveRepository.findById(saveObjective.getId()).get();
        assertThat(findObjective).isNotNull();

    }

    //Update Test Case for Plan Respository
    @Test
    public void should_update_objective_when_I_provide_valid_data() {

        Plan savePlan = planRepository.save(new Plan("JAVA DEVELOPER", new Date(), Date.from(LocalDate.of(2019, 9, 30).atStartOfDay().atZone(ZoneId.systemDefault())
                .toInstant())));
        Objective saveObjective=objectiveRepository.save(new Objective("2nd Quarter","Label",savePlan));

        saveObjective.setTitle("1st Quarter");
        objectiveRepository.save(saveObjective);
        Objective updatedObjective = objectiveRepository.findById(saveObjective.getId()).get();
        assertThat(updatedObjective.getTitle()).isEqualToIgnoringCase("1st Quarter");
        //(updatedPlan).extracting(Plan::getTitle).containsOnly("MIDDLEWARE DEVELOPER");
    }

    @Test
    public void should_delete_objective_when_I_provide_valid_data() {
        Plan savePlan = planRepository.save(new Plan("JAVA DEVELOPER", new Date(), Date.from(LocalDate.of(2019, 9, 30).atStartOfDay().atZone(ZoneId.systemDefault())
                .toInstant())));
        Objective saveObjective=objectiveRepository.save(new Objective("2nd Quarter","Label",savePlan));
        objectiveRepository.deleteById(saveObjective.getId());
        assertThat(objectiveRepository.findById(saveObjective.getId()).isPresent()).isFalse();
    }

}
