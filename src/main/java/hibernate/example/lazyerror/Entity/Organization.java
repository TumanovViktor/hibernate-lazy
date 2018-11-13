package hibernate.example.lazyerror.Entity;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;


@Entity
public class Organization {
	@Id
	@GeneratedValue
	private int organizationId;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "organization")
	@LazyToOne(LazyToOneOption.NO_PROXY)
	private OrganizationExt organizationExt;

	public Organization() {
	}

	public Organization(OrganizationExt organizationExt) {
		this.organizationExt = organizationExt;
	}

	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public OrganizationExt getOrganizationExt() {
		return organizationExt;
	}

	public void setOrganizationExt(OrganizationExt organizationExt) {
		this.organizationExt = organizationExt;
	}
}
