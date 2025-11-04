package net.mendex.discord.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.mendex.discord.commands.utils.CommandInterface;

public class TestCommand extends ListenerAdapter implements CommandInterface {
    @Override
    public String getCommandName() {
        return "test-command";
    }

    @Override
    public void onCommand(SlashCommandInteractionEvent event) {
        event.reply(
                "Ватсап " + event.getUser().getAsMention() + "!"
        ).setEphemeral(true).queue();
    }
}
