package hibernate.example.lazyerror;

import hibernate.example.lazyerror.Entity.Organization;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class OrganizationRepositoryImpl implements OrganizationRepository {
	@PersistenceContext
	EntityManager em;

	@Override
	public Organization getOrganization() {
		Organization org = (Organization) em.createQuery(
			"from Organization as org " +
				"inner join fetch org.extA as exta " +
				"where org.organizationId=1")
			.getSingleResult();
		return org;
	}
}
