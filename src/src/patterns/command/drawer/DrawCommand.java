package patterns.command.drawer;


import java.awt.Point;
import patterns.command.command.Command;

// '점 그리기 명령'을 표현하는 클래스
public class DrawCommand implements Command {
    // 그리는 대상
    protected Drawable drawable;


    // 그리는 위치
    private Point position;

    // 생성자
    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    // 실행

    @Override
    public void execute() {
        drawable.draw(position.x, position.y);
    }
}
