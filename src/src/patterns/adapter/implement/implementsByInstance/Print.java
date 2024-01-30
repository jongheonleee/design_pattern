package patterns.adapter.implement.implementsByInstance;

/**
 * 대상자, 사용해야할 것들이 있음, 어댑터로 제공 받은 것과 적절히 연결해서 사용해야함
 */
abstract public class Print {
    public abstract void printWeak();
    public abstract void printStrong();
}
