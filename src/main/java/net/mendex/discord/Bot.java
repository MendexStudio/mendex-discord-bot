package net.mendex.discord;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.mendex.discord.features.componentV2.ComponentV2Command;
import net.mendex.discord.features.modal.ModalCommand;
import net.mendex.discord.features.test.ButtonCommand;
import net.mendex.discord.utils.commands.CommandManager;
import net.mendex.discord.utils.listeners.ListenerManager;

public class Bot {

    void main() {
        CommandManager.addCommands(
                new ButtonCommand(),
                new ModalCommand(),
                new ComponentV2Command()
        );

        ListenerManager.addListeners(
                new CommandManager(),
                CommandManager.getCommandsWithListener()
        );

        JDA bot = JDABuilder.createDefault(Dotenv.load().get("BOT_TOKEN"))
                .addEventListeners(ListenerManager.getListeners().toArray())
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();

        bot.updateCommands().addCommands(CommandManager.getCommandsData()).queue();
    }

}
