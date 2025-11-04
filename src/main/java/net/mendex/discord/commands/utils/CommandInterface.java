package net.mendex.discord.commands.utils;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public interface CommandInterface {

    String getCommandName();
    default CommandData getCommandData() {
        return Commands.slash(getCommandName(), "Команда без описания");
    }

    void onCommand(SlashCommandInteractionEvent event);

}
