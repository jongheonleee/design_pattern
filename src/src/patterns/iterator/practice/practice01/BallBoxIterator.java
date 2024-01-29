package patterns.iterator.practice.practice01;

public class BallBoxIterator implements Iterator{

    private BallBox box;
    private int last = 0;
    private int baseBallLast = 0;
    private int basketBallLast = 0;
    private int tennisBallLast = 0;

    public BallBoxIterator(BallBox box) {
        this.box = box;
    }

    @Override
    public boolean hasNext() {
        return last < box.size();
    }

    @Override
    public Ball next() {
        return box.getAt(last++);
    }

    public boolean hasBaseBall() {
        return hasNext() && baseBallLast < box.size();
    }

    public BaseBall nextBaseBall() {
        BaseBall target = null;
        while (baseBallLast < box.size()) {
            if (box.getAt(baseBallLast++) instanceof BaseBall) {
                target = (BaseBall) box.getAt(baseBallLast-1);
                break;
            }
        }
        return target;
    }

    public boolean hasBasketBall() {
        return hasNext() && basketBallLast < box.size();
    }

    public BasketBall nextBasketBall() {
        BasketBall target = null;
        while (basketBallLast < box.size()) {
            if (box.getAt(basketBallLast++) instanceof BasketBall) {
                target = (BasketBall) box.getAt(basketBallLast-1);
                break;
            }
        }
        return target;
    }
    public boolean hasTennisBall() {
        return hasNext() && tennisBallLast < box.size();
    }

    public TennisBall nextTennisBall() {
        TennisBall target = null;
        while (tennisBallLast < box.size()) {
            if (box.getAt(tennisBallLast++) instanceof TennisBall) {
                target = (TennisBall) box.getAt(tennisBallLast-1);
                break;
            }
        }
        return target;
    }
}
