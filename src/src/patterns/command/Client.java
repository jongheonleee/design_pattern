package patterns.command;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import patterns.command.command.Command;
import patterns.command.command.MacroCommand;
import patterns.command.drawer.DrawCanvas;
import patterns.command.drawer.DrawCommand;

public class Client extends JFrame implements MouseMotionListener, WindowListener {
    // 그리기 이력
    private MacroCommand history = new MacroCommand();
    // 그리는 영역
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    // 삭제 버튼
    private JButton clearButton = new JButton("clear");

    // 생성자
    public Client(String title) {
        super(title);

        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);

        clearButton.addActionListener(e -> {
            history.clear();
            canvas.repaint();
        });

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        Box clientBox = new Box(BoxLayout.Y_AXIS);
        clientBox.add(buttonBox);
        clientBox.add(canvas);
        getContentPane().add(clientBox);

        pack();
        setVisible(true);
    }

    // MouseMotionListener 용
    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
    }


    @Override
    public void windowOpened(WindowEvent e) {

    }

    // WindowListener 용
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }


    public static void main(String[] args) {
        new Client("Command Pattern Sample");
    }
}
