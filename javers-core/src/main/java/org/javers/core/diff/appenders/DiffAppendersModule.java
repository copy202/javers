package org.javers.core.diff.appenders;

import org.javers.common.collections.Lists;
import org.javers.core.ListCompareAlgorithm;
import org.javers.core.diff.changetype.container.ListChange;
import org.javers.core.pico.InstantiatingModule;
import org.picocontainer.MutablePicoContainer;

import java.util.Collection;

/**
 * @author bartosz walacik
 */
public class DiffAppendersModule extends InstantiatingModule {

    private final Class<? extends CorePropertyChangeAppender<ListChange>> listChangeAppender;

    public DiffAppendersModule(MutablePicoContainer container, ListCompareAlgorithm listChangeAppender) {
        super(container);
        this.listChangeAppender = listChangeAppender.getAppenderClass();
    }

    @Override
    protected Collection<Class> getImplementations() {
        return (Collection)Lists.asList(
                NewObjectAppender.class,
                MapChangeAppender.class,
                listChangeAppender,
                SetChangeAppender.class,
                ArrayChangeAppender.class,
                ObjectRemovedAppender.class,
                ReferenceChangeAppender.class,
                ValueChangeAppender.class
        );
    }
}
