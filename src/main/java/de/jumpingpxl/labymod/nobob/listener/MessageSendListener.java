package de.jumpingpxl.labymod.nobob.listener;

import de.jumpingpxl.labymod.nobob.util.Settings;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.chat.MessageSendEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponent;

public class MessageSendListener {

	private final Settings settings;

	public MessageSendListener(Settings settings) {
		this.settings = settings;
	}

	@Subscribe
	public void onMessageSend(MessageSendEvent event) {
		if (!event.getMessage().equals("+nobob disablebobbing")) {
			return;
		}

		event.setCancelled(true);
		if (!settings.isEnabled()) {
			return;
		}

		Minecraft minecraft = Minecraft.getInstance();
		if (minecraft.gameSettings.viewBobbing) {
			return;
		}

		minecraft.gameSettings.viewBobbing = true;
		TextComponent textComponent = new StringTextComponent(
				"§7[§eNoBob§7] §aSuccessfully enabled bobbing. NoBob will now work like expected.");
		minecraft.ingameGUI.getChatGUI().printChatMessage(textComponent);
	}
}
