package patterns.interpreter;


// <program>에 대응하는 클래스
// <program> ::= program <command list>
public class ProgramNode extends Node {
    // 해당 필드는 자신의 뒤에 이어지는 <command list>에 대응하는 구조를 저장하기 위한 것
    private Node commandListNode;

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("program");
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    @Override
    public String toString() {
        return "[program " + commandListNode + "]";
    }
}
