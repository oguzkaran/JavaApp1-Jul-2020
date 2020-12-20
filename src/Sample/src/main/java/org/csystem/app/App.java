/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki örnek aşağıdaki gibi bir sınıf ile genelleştirilebilir. Bu durumda aynı işi yapan n-tane sınıf
    yazma gereksinimi de ortadan kalkar. Aşağıdaki örnekte MyInputStream sınıfının InputStream referansını kullanma
    ve dışarıdan alma biçimine "dependency injection" denir. Dışarıdan alma biçimi ctor yoluyla yapıldığından
    bir çok teknolojide bu tarz bir yapıya "constructor injection" da denir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        boolean result = Boolean.parseBoolean("ali");

        System.out.printf("result=%b%n", result);
    }
}

