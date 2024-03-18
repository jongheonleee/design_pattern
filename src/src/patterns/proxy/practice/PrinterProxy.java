package patterns.proxy.practice;

public class PrinterProxy implements Printable {
    private String name;
    private Printable real;
    private String className;

    public PrinterProxy(String name, String className) {
        this.name = name;
        this.real = null;
        this.className = className;
    }

    @Override
    public synchronized void setPrinterName(String name) {
        if (real != null) {
            real.setPrinterName(name);
        }
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String string) {
        realize();
        real.print(string);
    }

    private synchronized void realize() {
        if (real == null)  {
            try {
                real = (Printable) Class.forName(className).getDeclaredConstructor().newInstance();
            } catch (ClassNotFoundException e) {
                System.out.println("클래스 " + className + " 가 발견되지 않았습니다.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
