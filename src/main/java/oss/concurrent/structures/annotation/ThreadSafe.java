package oss.concurrent.structures.annotation;

import java.lang.annotation.*;

/**
 * Marks the type where used thread-safe.
 * Sequences of threaded read-writes on the critical section
 * of the code is taken care of using the locks.
 * It is important to note that the annotation just marks the type threadsafe,
 * does not make it thread-safe. Thread safety implementation
 * is done by the user themselves.
 */

@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@net.jcip.annotations.ThreadSafe
public @interface ThreadSafe {
    public String value() default "";
}
