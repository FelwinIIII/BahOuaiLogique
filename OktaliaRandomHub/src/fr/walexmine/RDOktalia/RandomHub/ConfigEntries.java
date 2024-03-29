package fr.walexmine.RDOktalia.RandomHub;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import fr.walexmine.RDOktalia.faucet.ConfigEntry;
import fr.walexmine.RDOktalia.faucet.ConfigEntryHolder;

public class ConfigEntries implements ConfigEntryHolder {
    public static final ConfigEntry<Boolean> CHECK_UPDATES = new ConfigEntry<>(0, "settings.check_updates", true);
    public static final ConfigEntry<List<String>> SERVERS = new ConfigEntry<>(0, "settings.servers", Arrays.asList("hub1", "hub2", "hub3", "hub4", "hub5"));

    public static final ConfigEntry<Boolean> COMMAND_ENABLED = new ConfigEntry<>(0, "settings.lobby_command.enabled", true);
    public static final ConfigEntry<String> COMMAND_NAME = new ConfigEntry<>(0, "settings.lobby_command.name", "lobby");
    public static final ConfigEntry<String> COMMAND_PERMISSION = new ConfigEntry<>(0, "settings.lobby_command.permission", "");
    public static final ConfigEntry<List<String>> COMMAND_ALIASES = new ConfigEntry<>(0, "settings.lobby_command.aliases", Arrays.asList("hub", "central"));

    public static final ConfigEntry<Boolean> KICK_RECONNECT_ENABLED = new ConfigEntry<>(0, "settings.kick_reconnect.enabled", true);
    public static final ConfigEntry<List<String>> KICK_RECONNECT_REASONS = new ConfigEntry<>(0, "settings.kick_reconnect.reasons", Arrays.asList("You have been kicked", "Server is restarting"));

    public static final ConfigEntry<Boolean> SERVER_CHECK_ENABLED = new ConfigEntry<>(0, "settings.server_check.enabled", true);
    public static final ConfigEntry<String> SERVER_CHECK_MODE = new ConfigEntry<>(0, "settings.server_check.tactic", "CUSTOM");
    public static final ConfigEntry<List<String>> SERVER_CHECK_MARKERS = new ConfigEntry<>(0, "settings.server_check.markers", Collections.emptyList());
    public static final ConfigEntry<Integer> SERVER_CHECK_INTENTS = new ConfigEntry<>(0, "settings.server_check.intents", 5);
    public static final ConfigEntry<Integer> SERVER_CHECK_TIMEOUT = new ConfigEntry<>(0, "settings.server_check.timeout", 7000);
    public static final ConfigEntry<Integer> SERVER_CHECK_INTERVAL = new ConfigEntry<>(0, "settings.server_check.interval", 1000);

    public static final ConfigEntry<String> ALREADY_IN_LOBBY = new ConfigEntry<>(0, "messages.already", "&cVous �tes d�ja connect�e sur un Hub !");
    public static final ConfigEntry<String> NO_SERVER_FOUND = new ConfigEntry<>(0, "messages.unsuccessful", "�cHub Introuvable !");
    public static final ConfigEntry<String> CONNECTING_MESSAGE = new ConfigEntry<>(0, "messages.connected", "�aT�l�portation � un hub !");
}
