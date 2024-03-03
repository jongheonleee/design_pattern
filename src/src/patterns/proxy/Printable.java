package patterns.proxy;

// Printer 와 PrinterProxy 의 공통 인터페이스
public interface Printable {
    // 이름 설정
    void setPrinterName(String name);

    // 이름 취득
    String getPrinterName();

    // 문자열 표시(프린트 아웃)
    void print(String string);
}
