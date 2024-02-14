package patterns.abstractFactory.listfactory;

import patterns.abstractFactory.factory.Factory;
import patterns.abstractFactory.factory.Link;
import patterns.abstractFactory.factory.Page;
import patterns.abstractFactory.factory.Tray;

public class ListFactory extends Factory {

    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return null;
    }
}
