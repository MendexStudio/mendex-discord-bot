package net.mendex.discord.commands;

import net.dv8tion.jda.api.components.attachmentupload.AttachmentUpload;
import net.dv8tion.jda.api.components.container.Container;
import net.dv8tion.jda.api.components.label.Label;
import net.dv8tion.jda.api.components.mediagallery.MediaGallery;
import net.dv8tion.jda.api.components.mediagallery.MediaGalleryItem;
import net.dv8tion.jda.api.components.textdisplay.TextDisplay;
import net.dv8tion.jda.api.components.textinput.TextInput;
import net.dv8tion.jda.api.components.textinput.TextInputStyle;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.modals.Modal;
import net.mendex.discord.commands.utils.CommandInterface;

import java.util.List;
import java.util.stream.Collectors;

public class ModalCommand extends ListenerAdapter implements CommandInterface {
    @Override
    public String getCommandName() {
        return "modal-command";
    }

    @Override
    public void onCommand(SlashCommandInteractionEvent event) {
        Modal modal = Modal.create("modal", "Сообщить об баге")
                        .addComponents(
                                TextDisplay.of("""
                                # Заполните все поля ниже
                                Распишите баг и приложите дополнительные файлы (если есть), которые могут помочь в решении бага
                                -# Пожелайте удачи команде разработчиков...
                                
                                **Правила заполнения баг-репорта:**
                                1. Опишите баг подробно
                                2. Распишите шаги для вызова бага
                                """),
                                Label.of("Описание проблемы", TextInput.of("description", TextInputStyle.PARAGRAPH)),
                                Label.of("Дополнительные файлы", AttachmentUpload.of("files"))
                        ).build();
        event.replyModal(modal).queue();
    }

    @Override
    public void onModalInteraction(ModalInteractionEvent event) {
        if (!event.getModalId().equals("modal")) return;

        String description = event.getValue("description").getAsString();
        List<Message.Attachment> attachments = event.getValue("files").getAsAttachmentList();
        List<MediaGalleryItem> gallery = attachments.stream()
                .map(attach -> MediaGalleryItem.fromUrl(attach.getUrl()))
                .collect(Collectors.toList());

        event.replyComponents(
                Container.of(
                        TextDisplay.of("# Новый баг репорт!"),
                        TextDisplay.of(description),
                        MediaGallery.of(gallery)
                )
        ).useComponentsV2().queue();
    }
}
