package patterns.abstractFactory.divfactory;

import patterns.abstractFactory.factory.Factory;
import patterns.abstractFactory.factory.Link;
import patterns.abstractFactory.factory.Page;
import patterns.abstractFactory.factory.Tray;

public class DivFactory extends Factory {

    @Override
    public Link createLink(String caption, String url) {
        return null;
    }

    @Override
    public Tray createTray(String caption) {
        return null;
    }

    @Override
    public Page createPage(String title, String author) {
        return null;
    }
}
