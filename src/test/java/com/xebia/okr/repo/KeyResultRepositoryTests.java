package com.xebia.okr.repo;

import com.xebia.okr.domain.KeyResult;
import com.xebia.okr.domain.KeyResultStatus;
import com.xebia.okr.domain.Objective;
import com.xebia.okr.domain.Plan;
import com.xebia.okr.repository.KeyResultRepository;
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
public class KeyResultRepositoryTests {
    //@Autowired
    //private TestEntityManager entityManager;

    @Autowired
    private ObjectiveRepository objectiveRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private KeyResultRepository keyResultRepository;

    @Test
    public void contextLoads() {
    }

    //Create Test Case for Plan Repository
    @Test
    public void should_create_keyResult_when_I_provide_valid_data() {

        Plan savePlan = planRepository.save(new Plan("JAVA DEVELOPER", new Date(), Date.from(LocalDate.of(2019, 9, 30).atStartOfDay().atZone(ZoneId.systemDefault())
                .toInstant())));
        Objective saveObjective=objectiveRepository.save(new Objective("2nd Quarter","Label",savePlan));
        KeyResult saveKeyResult=keyResultRepository.save(new KeyResult("Title",78, KeyResultStatus.COMPLETED,95,saveObjective));
        assertThat(saveKeyResult.getId()).isNotNull();
		/*//Read Test Case for Plan Repository
		List<Plan> plans = repository.findByTitle("JAVA DEVELOPER");

		System.out.println("dataaaa-->"+plans.get(0).getTitle());
		assertEquals(1, plans.size());

		assertThat(plans).extracting(Plan::getTitle).containsOnly("JAVA DEVELOPER");*/

    }

    @Test
    public void should_read_keyResult_when_I_provide_valid_data() {

        Plan savePlan = planRepository.save(new Plan("JAVA DEVELOPER", new Date(), Date.from(LocalDate.of(2019, 9, 30).atStartOfDay().atZone(ZoneId.systemDefault())
                .toInstant())));
        Objective saveObjective=objectiveRepository.save(new Objective("2nd Quarter","Label",savePlan));
        KeyResult saveKeyResult=keyResultRepository.save(new KeyResult("Title",78, KeyResultStatus.COMPLETED,95,saveObjective));
        Objective findObjective = objectiveRepository.findById(saveObjective.getId()).get();
        assertThat(findObjective).isNotNull();

    }

    //Update Test Case for Plan Respository
    @Test
    public void should_update_keyResult_when_I_provide_valid_data() {

        Plan savePlan = planRepository.save(new Plan("JAVA DEVELOPER", new Date(), Date.from(LocalDate.of(2019, 9, 30).atStartOfDay().atZone(ZoneId.systemDefault())
                .toInstant())));
        Objective saveObjective=objectiveRepository.save(new Objective("2nd Quarter","Label",savePlan));
        KeyResult saveKeyResult=keyResultRepository.save(new KeyResult("Title",78, KeyResultStatus.COMPLETED,95,saveObjective));
        saveKeyResult.setTitle("1st Quarter");
        keyResultRepository.save(saveKeyResult);
        KeyResult updatedKeyResult = keyResultRepository.findById(saveKeyResult.getId()).get();
        assertThat(updatedKeyResult.getTitle()).isEqualToIgnoringCase("1st Quarter");
        //(updatedPlan).extracting(Plan::getTitle).containsOnly("MIDDLEWARE DEVELOPER");
    }

    @Test
    public void should_delete_keyResult_when_I_provide_valid_data() {
        Plan savePlan = planRepository.save(new Plan("JAVA DEVELOPER", new Date(), Date.from(LocalDate.of(2019, 9, 30).atStartOfDay().atZone(ZoneId.systemDefault())
                .toInstant())));
        Objective saveObjective=objectiveRepository.save(new Objective("2nd Quarter","Label",savePlan));
        KeyResult saveKeyResult=keyResultRepository.save(new KeyResult("Title",78, KeyResultStatus.COMPLETED,95,saveObjective));
        keyResultRepository.deleteById(saveKeyResult.getId());
        assertThat(keyResultRepository.findById(saveKeyResult.getId()).isPresent()).isFalse();
    }

}
