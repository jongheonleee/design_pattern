package patterns.builder;

/**
 * Builder의 인터페이스를 활용하여 인스턴스 생성
 */
public class Director {
    private Builder builder;

    // 의존성 주입 : '소스 코드에 쓰여져 있지 않지만, 실제로 특정 인스턴스를 이용해(의존해) 동작하게끔 하는것'
    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.makeTitle("Greeting");
        builder.makeString("일반적인 인사");
        builder.makeItems(new String[]{
                "how are you?",
                "hello",
                "hi"
        });

        builder.makeString("시간대별 인사");
        builder.makeItems(new String[] {
                "good morning",
                "good afternoon",
                "good evening"
        });
        builder.close();
    }
}
