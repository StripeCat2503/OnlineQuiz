package quiz;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Quiz.class)
public abstract class Quiz_ {

	public static volatile SingularAttribute<Quiz, Integer> id;
	public static volatile SingularAttribute<Quiz, Date> created_date;
	public static volatile SingularAttribute<Quiz, String> title;

}

