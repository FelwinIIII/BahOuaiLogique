package fr.walexmine.RDOktalia.RandomHub;

import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.scheduler.ScheduledTask;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class StatusManager {
    private boolean stopped = true;
    private PingTactic tactic;
    private ScheduledTask task;
    private final Map<ServerInfo, StatusInfo> storage = new HashMap<>();

    public void start(final RandomHub plugin) {
        if (task != null) {
            stop();
        }

        stopped = false;
        tactic = PingTactic.valueOf((ConfigEntries.SERVER_CHECK_MODE.get()).toUpperCase());
        plugin.getLogger().info(String.format("Starting the ping task, the interval is %s", ConfigEntries.SERVER_CHECK_INTERVAL.get()));

        task = plugin.getProxy().getScheduler().schedule(plugin, () -> {
            storage.forEach((k, v) -> v.setOutdated(true));

            for (ServerInfo server : plugin.getServers()) {
                if (stopped) {
                    break;
                }

                if (getStatus(server).isOutdated()) {
                    update(plugin, server);
                }
            }

        }, 0L, ConfigEntries.SERVER_CHECK_INTERVAL.get(), TimeUnit.MILLISECONDS);
    }

    public void stop() {
        if (task != null) {
            task.cancel();
            task = null;
            stopped = true;
        }
    }

    private void update(RandomHub plugin, ServerInfo server) {
        tactic.ping(server, (status, throwable) -> {
            if (status == null) {
                status = new StatusInfo();
            }

            status.setOutdated(false);
            storage.put(server, status);
        }, plugin);
    }

    public StatusInfo getStatus(ServerInfo server) {
        StatusInfo status = storage.get(server);

        if (status == null) {
            return new StatusInfo(server);
        } else {
            return status;
        }
    }
}
