package patterns.builder;

/**
 * 빌더 구현체, 실제 복잡한 인스턴스를 생성해줌
 * 예제에서는 텍스트파일을 상단부, 중간, 하단부로 나눠서 처리함
 */
public class TextBuilder extends Builder {
    private StringBuilder sb = new StringBuilder();

    @Override
    void makeTitle(String title) {
        sb.append("=====================\n");
        sb.append("[");
        sb.append(title);
        sb.append("]\n\n");
    }

    @Override
    void makeString(String str) {
        sb.append("#");
        sb.append(str);
        sb.append("\n\n");
    }

    @Override
    void makeItems(String[] items) {
        for (String s : items) {
            sb.append("-");
            sb.append(s);
            sb.append("\n");
        }
        sb.append("\n");
    }

    @Override
    void close() {
        sb.append("=====================\n");
    }

    public String getTextResult() {
        return sb.toString();
    }
}
