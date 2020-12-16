package org.csystem.application.commandprompt;

import org.csystem.commandpromptapp.common.TextInfo;
import org.csystem.util.Console;

import java.util.ArrayList;

public class ListCommandController {
    private final String[] m_arguments;
    private final ArrayList m_textInfoList;

    public void doWorkForNone()
    {
        for (Object obj : m_textInfoList) {
            var textInfo = (TextInfo)obj;

            Console.writeLine(textInfo.getText());
        }
    }

    public void doWorkForOne()
    {
        var length = Integer.parseInt(m_arguments[0]);

        for (Object obj : m_textInfoList) {
            var textInfo = (TextInfo)obj;

            if (textInfo.getText().length() == length)
                Console.writeLine(textInfo.getText());
        }
    }

    public ListCommandController(ArrayList textInfoList, String...arguments)
    {
        m_arguments = arguments;
        m_textInfoList = textInfoList;
    }

    public void doWork()
    {
        if (m_arguments.length > 1)
            throw new IllegalArgumentException();

        if (m_arguments.length == 1)
            this.doWorkForOne();
        else
            this.doWorkForNone();
    }
}
