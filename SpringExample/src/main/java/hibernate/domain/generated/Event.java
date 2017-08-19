package hibernate.domain.generated;

import org.hibernate.annotations.ValueGenerationType;
import org.hibernate.tuple.AnnotationValueGeneration;
import org.hibernate.tuple.GenerationTiming;
import org.hibernate.tuple.ValueGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;

@Entity(name = "Event")
public class Event {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "`timestamp`")
    @FunctionCreationTimestamp
    private Date timestamp;

    public Event() {}

    public Long getId() {
        return id;
    }

    public Date getTimestamp() {
        return timestamp;
    }
    @ValueGenerationType(generatedBy = FunctionCreationValueGeneration.class)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FunctionCreationTimestamp {}

    public static class FunctionCreationValueGeneration
            implements AnnotationValueGeneration<FunctionCreationTimestamp> {

        @Override
        public void initialize(FunctionCreationTimestamp annotation, Class<?> propertyType) {
        }

        /**
         * Generate value on INSERT
         * @return when to generate the value
         */
        public GenerationTiming getGenerationTiming() {
            return GenerationTiming.INSERT;
        }

        /**
         * Returns the in-memory generated value
         * @return {@code true}
         */
        public ValueGenerator<?> getValueGenerator() {
            return (session, owner) -> new Date( );
        }

        /**
         * Returns true because the value is generated by the database.
         * @return true
         */
        public boolean referenceColumnInSql() {
            return true;
        }

        /**
         * Returns the database-generated value
         * @return database-generated value
         */
        public String getDatabaseGeneratedReferencedColumnValue() {
            return "current_timestamp";
        }
    }
}