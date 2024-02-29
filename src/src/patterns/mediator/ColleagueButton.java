package patterns.mediator;

import java.awt.Button;

// Colleague 구현체 1
public class ColleagueButton extends Button implements Colleague {

    private Mediator mediator;

    public ColleagueButton(String caption) {
        super(caption);
    }

    // Mediator를 설정함
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }


    // Mediator에서 활성/비활성을 지시함
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }
}
