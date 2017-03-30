package ls.ljpf.repository;

import com.google.common.collect.Lists;
import ls.ljpf.PluginRepository;
import ls.ljpf.PluginRepositoryEntry;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by souzen on 30.03.2017.
 */
public class MultiPluginRepository implements PluginRepository {

    private final List<PluginRepository> pluginRepositories;

    public MultiPluginRepository(PluginRepository... pluginRepositories) {
        this.pluginRepositories = Lists.newArrayList(pluginRepositories);
    }

    public void addRepository(final PluginRepository pluginRepository) {
        pluginRepositories.add(pluginRepository);
    }

    public void removeRepository(final PluginRepository pluginRepository) {
        pluginRepositories.remove(pluginRepository);
    }

    @Override
    public boolean containsPlugin(String id) {
        return pluginRepositories.stream().anyMatch(r -> r.containsPlugin(id));
    }

    @Override
    public PluginRepositoryEntry getPlugin(String id) {
        return pluginRepositories.stream().filter(r -> r.containsPlugin(id)).findFirst().map(r -> r.getPlugin(id)).orElse(null);
    }

    @Override
    public Collection<PluginRepositoryEntry> getPlugins() {
        return pluginRepositories.stream().flatMap(r -> r.getPlugins().stream()).distinct().collect(toList());
    }
}