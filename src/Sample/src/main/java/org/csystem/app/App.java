/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki örnek aşağıdaki gibi bir sınıf ile genelleştirilebilir. Bu durumda aynı işi yapan n-tane sınıf
    yazma gereksinimi de ortadan kalkar. Aşağıdaki örnekte MyInputStream sınıfının InputStream referansını kullanma
    ve dışarıdan alma biçimine "dependency injection" denir. Dışarıdan alma biçimi ctor yoluyla yapıldığından
    bir çok teknolojide bu tarz bir yapıya "constructor injection" da denir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.io.*;
import java.util.Arrays;

class App {
    public static void main(String[] args)
    {
        try (var fileStream = new MyInputStream(new FileInputStream("test.dat"))
                    ; var fileDataStream = new MyInputStream(new DataInputStream(new FileInputStream("mest.dat")))) {
            //...
        }
        catch (IOException ex) {
            //...
        }
    }
}

class MyInputStream implements Closeable {
    private final InputStream m_inputStream;

    public MyInputStream(InputStream inputStream)
    {
        m_inputStream = inputStream;
    }

    public byte [] read(int length) throws IOException
    {
        byte [] data = new byte[length];

        int result = m_inputStream.read(data, 0, length);

        return Arrays.copyOfRange(data, 0, result);
    }

    @Override
    public void close() throws IOException
    {
        m_inputStream.close();
    }
}

