# hibernate-lazy
Problem with fetch LazyToOne associations

This project reproduces bug (?) with hibernate lazy associations fetching, with bytecode instrumentation and @LazyToOne(LazyToOneOption.NO_PROXY).

Project has two entities: Organization and OrganizationExt. They have bidirectional OneToOne assoc. Because of that bytecode enhancement is up, I have to use NO_PROXY lazy loading. I have next situation: I load Organization entity and I want to fetch lazy assoc. using "join fetch" (OrganizationRepositoryImpl.java). Select looks ok, but result Organization instance does not have OrganizationExt fetched. Interesting is that assoc. is fetched in Session and if I use, for example, Hibernate.initialize(org.getOrganizationExt()), assoc. is being initialized without any new selects. 
