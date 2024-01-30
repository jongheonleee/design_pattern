package patterns.adapter.implement.implementsByClass;

/**
 * adapter, 맞는거 끼리 맞춰줌
 */
public class PrintBanner extends Banner implements Print{
    public PrintBanner(String string) {
        super(string);
    }
    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
