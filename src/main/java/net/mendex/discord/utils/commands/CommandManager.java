package net.mendex.discord.utils.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;

import java.util.*;
import java.util.stream.Collectors;

public class CommandManager extends ListenerAdapter {

    private static final HashMap<String, CommandInterface> COMMANDS_MAP = new HashMap<>();

    public static void addCommands(CommandInterface... commandsClasses) {
        for (CommandInterface command: commandsClasses) {
            COMMANDS_MAP.put(command.getCommandName(), command);
        }
    }

    public static Collection<CommandData> getCommandsData() {
        return COMMANDS_MAP.values().stream()
                .map(CommandInterface::getCommandData)
                .collect(Collectors.toList());
    }

    public static Collection<CommandInterface> getCommandsWithListener() {
        return COMMANDS_MAP.values().stream()
                .filter(command -> command.getClass().getSuperclass().isAssignableFrom(ListenerAdapter.class))
                .collect(Collectors.toList());
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        CommandInterface command = COMMANDS_MAP.get(event.getName());
        if (command != null) command.onCommand(event);
    }

}
