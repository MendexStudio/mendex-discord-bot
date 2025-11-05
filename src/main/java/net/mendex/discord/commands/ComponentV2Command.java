package net.mendex.discord.commands;

import net.dv8tion.jda.api.components.buttons.Button;
import net.dv8tion.jda.api.components.buttons.ButtonStyle;
import net.dv8tion.jda.api.components.container.Container;
import net.dv8tion.jda.api.components.container.ContainerChildComponent;
import net.dv8tion.jda.api.components.mediagallery.MediaGallery;
import net.dv8tion.jda.api.components.mediagallery.MediaGalleryItem;
import net.dv8tion.jda.api.components.section.Section;
import net.dv8tion.jda.api.components.separator.Separator;
import net.dv8tion.jda.api.components.textdisplay.TextDisplay;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.mendex.discord.commands.utils.CommandInterface;

public class ComponentV2Command implements CommandInterface {
    @Override
    public String getCommandName() {
        return "cv2-command";
    }

    @Override
    public void onCommand(SlashCommandInteractionEvent event) {
        event.replyComponents(
                Container.of(
                        MediaGallery.of(
                                MediaGalleryItem.fromUrl("https://cdn.discordapp.com/attachments/697138785317814292/1364347504702914602/docs-header.png?ex=690c65e1&is=690b1461&hm=3b717bc742260928fe622ee5f614b7a87573b4a1c9e8f7896e82124862e47556&")
                        ),
                        TextDisplay.of("""
                                ## Introducing New Components for Messages!
                                We're bringing new components to messages that you can use in your apps. They allow you to have full control over the layout of your messages.
                                
                                Our previous components system, while functional, had limitations:
                                - Content, attachments, embeds, and components had to follow fixed positioning rules
                                - Visual styling options were limited
                                
                                Our new component system addresses these challenges with fully composable components that can be arranged and laid out in any order, allowing for a more flexible and visually appealing design. Check out the [changelog](https://discord.com/developers/docs/change-log) for more details."""
                        ),
                        MediaGallery.of(
                                MediaGalleryItem.fromUrl("https://cdn.discordapp.com/attachments/697138785317814292/1364347505642569850/components-hero.png?ex=690c65e1&is=690b1461&hm=70118161f8b065ba18811133c80fb6cb04a128741e0a732848553b633d448410&")
                        ),
                        Section.of(
                                Button.of(ButtonStyle.LINK, "https://discord.com/developers/docs/components/overview", "Overview", null),
                                TextDisplay.of("A brief overview of components:")
                        ),
                        Section.of(
                                Button.of(ButtonStyle.LINK, "https://discord.com/developers/docs/components/reference#what-is-a-component-component-types", "Reference", null),
                                TextDisplay.of("A list of all the components:")
                        ),
                        Section.of(
                                Button.of(ButtonStyle.LINK, "https://discord.com/developers/docs/components/using-message-components", "Guide", null),
                                TextDisplay.of("Get started with message components:")
                        ),
                        Separator.createDivider(Separator.Spacing.SMALL),
                        TextDisplay.of("""
                                -# This message is taken as an example from the official Discord server \"Discord Developers\"
                                -# https://discord.gg/discord-developers; [Message](https://ptb.discord.com/channels/613425648685547541/697138785317814292/1364347506200416307)
                                """)

                )
        ).useComponentsV2().queue();
    }
}
