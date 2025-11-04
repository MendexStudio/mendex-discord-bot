package net.mendex.discord;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.mendex.discord.commands.ModalCommand;
import net.mendex.discord.commands.TestCommand;
import net.mendex.discord.commands.utils.CommandManager;
import net.mendex.discord.listeners.utils.ListenerManager;

public class Bot {

    void main() {
        CommandManager.addCommands(
                new TestCommand(),
                new ModalCommand()
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
