package clashsoft.cslib.addon;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The clas Addon.
 * <p>
 * An annotation that marks mod parts / mod extensions.
 * 
 * @author Clashsoft
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Addon
{
	public String modName() default "Clashsoft API";
	public String addonName();
}
