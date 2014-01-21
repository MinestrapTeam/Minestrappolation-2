package clashsoft.cslib.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The annotation Immutable.
 * <p>
 * This annotation defines that objects of the annotated type can be used with
 * {@link ImmutableObjectFactory}.
 * 
 * @author Clashsoft
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Immutable
{
}
