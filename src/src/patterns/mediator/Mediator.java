package patterns.mediator;

// 중재자 인터페이스
public interface Mediator {
    // Colleague를 생성
    void createColleagues();

    // Colleague의 상태가 변화했을 때 호출
    void colleagueChanged();
}
