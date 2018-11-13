package hibernate.example.lazyerror;

import hibernate.example.lazyerror.Entity.Organization;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LazyErrorApplicationTests {
	@Autowired
	private OrganizationRepository repo;

	@Test
	public void contextLoads() {
		Organization org = repo.getOrganization();
		// Error org.hibernate.LazyInitializationException: Unable to perform requested lazy initialization
		System.out.println(org.getOrganizationExt());
	}

}
