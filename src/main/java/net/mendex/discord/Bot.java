package net.mendex.discord;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Bot {

    static void main() {
        JDA bot = JDABuilder.createLight(Dotenv.load().get("BOT_TOKEN"))
                .build();
    }

}
