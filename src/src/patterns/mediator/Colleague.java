package patterns.mediator;

// 멤버 인터페이스, 중재자에게 상담을 의뢰할 멤버를 나타냄
public interface Colleague {
    // Mediator를 설정함
    void setMediator(Mediator mediator);

    // Mediator에서 활성/비활성을 지시함
    void setColleagueEnabled(boolean enabled);
}
