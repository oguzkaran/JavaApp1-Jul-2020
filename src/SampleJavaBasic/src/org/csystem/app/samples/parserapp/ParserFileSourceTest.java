package org.csystem.app.samples.parserapp;

public final class ParserFileSourceTest {
    private ParserFileSourceTest()
    {
    }

    public static void run()
    {
        try (var fileSource = new FileSource("test.txt")) {
            var parser = new Parser(fileSource);

            parser.doParse();
        }
        catch (Throwable ex) {
            System.err.println(ex.getMessage());
        }
    }
}
