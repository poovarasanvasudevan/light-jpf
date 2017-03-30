package ls.ljpf;

import ls.ljpf.versions.Version;

/**
 * Created by souzen on 25.03.2017.
 */
public class PluginDescriptor {

    private final String id;
    private final Version version;
    private final String pluginClass;
    private final String description;

    public PluginDescriptor(String id, Version version, String pluginClass, String description) {
        this.id = id;
        this.version = version;
        this.pluginClass = pluginClass;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public Version getVersion() {
        return version;
    }

    public String getPluginClass() {
        return pluginClass;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Plugin{" +
                "id='" + id + '\'' +
                ", version=" + version +
                '}';
    }
}