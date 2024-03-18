package patterns.proxy.implement;


// 이름 붙인 프린터를 나타내는 클래스(본인)
public class Printer implements Printable {
    // 이름
    private String name;

    public Printer(String name) {
        this.name = name;

    }

    // 이름 설정
    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    // 이름 취득
    @Override
    public String getPrinterName() {
        return name;
    }

    // 이름 붙여서 표시
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
