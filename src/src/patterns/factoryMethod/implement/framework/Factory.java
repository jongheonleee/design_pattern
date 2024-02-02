package patterns.factoryMethod.implement.framework;

// 템플릿 메서드 패턴 적용 -> 상위에서 틀 잡고 하위에서 구체 내용 구현
public abstract class Factory {
    // 전체 흐름 구성
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    // 하위에서 구현
    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product product);
}
