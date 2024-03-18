package patterns.proxy.practice;

public class Printer implements Printable {

    private String name;
    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String string) {
        System.out.println("===" + name + "===");
        System.out.println(string);
    }

    // 무거운 작업이라고 가정
    private void heavyJob(String msg) {
        System.out.println(msg);

        for (int i=0; i<5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(".");
        }

        System.out.println("완료");
    }
}
