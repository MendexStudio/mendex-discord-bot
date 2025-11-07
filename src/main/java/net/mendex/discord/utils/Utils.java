package net.mendex.discord.utils;

import net.dv8tion.jda.api.components.buttons.Button;
import net.dv8tion.jda.api.components.buttons.ButtonStyle;
import net.dv8tion.jda.api.components.mediagallery.MediaGallery;
import net.dv8tion.jda.api.components.mediagallery.MediaGalleryItem;
import net.dv8tion.jda.api.components.section.Section;
import net.dv8tion.jda.api.components.textdisplay.TextDisplay;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import org.jetbrains.annotations.NotNull;

public class Utils {

    public static Section createButton(
            @NotNull ButtonStyle style,
            @NotNull String idOrUrl,
            @NotNull String label,
            Emoji emoji,
            @NotNull String text
    ) {
        return Section.of(
                Button.of(style, idOrUrl, label, emoji),
                TextDisplay.of(text)
        );
    }

    public static Section createButton(
            @NotNull ButtonStyle style,
            @NotNull String idOrUrl,
            @NotNull String label,
            @NotNull String text
    ) {
        return Section.of(
                Button.of(style, idOrUrl, label, null),
                TextDisplay.of(text)
        );
    }

    public static MediaGallery createMediaGallery(String url) {
        return MediaGallery.of(
                MediaGalleryItem.fromUrl(url)
        );
    }

}
