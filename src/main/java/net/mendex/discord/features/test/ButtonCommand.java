package net.mendex.discord.features.test;

import net.dv8tion.jda.api.components.MessageTopLevelComponent;
import net.dv8tion.jda.api.components.buttons.ButtonStyle;
import net.dv8tion.jda.api.components.container.Container;
import net.dv8tion.jda.api.components.textdisplay.TextDisplay;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.mendex.discord.utils.Utils;
import net.mendex.discord.utils.commands.CommandInterface;

public class ButtonCommand extends ListenerAdapter implements CommandInterface {
    @Override
    public String getCommandName() {
        return "button";
    }

    @Override
    public void onCommand(SlashCommandInteractionEvent event) {
        MessageTopLevelComponent messageComponent = Container.of(
                Utils.createButton(
                        ButtonStyle.PRIMARY,
                        "hello-button-1",
                        "Привет",
                        "Привет " + event.getUser().getAsMention() + "!"
                )
        );

        event.replyComponents(
                messageComponent
        ).useComponentsV2().setEphemeral(true).queue();
    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        MessageTopLevelComponent firstClickMessage = Container.of(
                Utils.createButton(
                        ButtonStyle.PRIMARY,
                        "hello-button-2",
                        "Да",
                        "ЕБАТЬ, ТЫ РАЗГОВАРИВАЕШЬ?"
                )
        );
        MessageTopLevelComponent secondsClickMessage = Container.of(
                TextDisplay.of("💀💀💀")
        );

        switch (event.getComponentId()) {
            case "hello-button-1": {
                event.editComponents(
                        firstClickMessage
                ).useComponentsV2().queue();
            }
            case "hello-button-2": {
                event.editComponents(
                        secondsClickMessage
                ).useComponentsV2().queue();
            }
        }
    }
}
