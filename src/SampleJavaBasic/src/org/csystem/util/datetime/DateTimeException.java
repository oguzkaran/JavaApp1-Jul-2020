/*----------------------------------------------------------------------------------------------------------------------
	DateTimeException sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.datetime;

@Deprecated(since = "Java 8", forRemoval = true)
public class DateTimeException extends RuntimeException {
    public DateTimeException()
    {
    }

    public DateTimeException(String message)
    {
        super(message);
    }
}
