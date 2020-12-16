package org.csystem.math;

public class RationalException extends NumberFormatException {
    private final RationalExceptionStatus m_rationalExceptionStatus;

    public RationalException(String message, RationalExceptionStatus rationalExceptionStatus)
    {
        super(message);
        m_rationalExceptionStatus = rationalExceptionStatus;
    }

    public RationalExceptionStatus getRationalExceptionStatus()
    {
        return m_rationalExceptionStatus;
    }

    @Override
    public String getMessage()
    {
        return String.format("Message:%s, Exception Status:%s", super.getMessage(), m_rationalExceptionStatus);
    }
}
