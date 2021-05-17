package de.jumpingpxl.labymod.nobob;

import de.jumpingpxl.labymod.nobob.listener.LoginServerListener;
import de.jumpingpxl.labymod.nobob.listener.MessageSendListener;
import de.jumpingpxl.labymod.nobob.listener.TickListener;
import de.jumpingpxl.labymod.nobob.util.Settings;
import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.SettingsElement;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;

import java.util.List;

/**
 * @author Nico (JumpingPxl) Middendorf
 * @date 17.05.2021
 * @project LabyMod-Addon: NoBob-1.16.5
 */

public class NoBob extends LabyModAddon {

	public static final String VERSION = "2";

	private Settings settings;

	@Override
	public void onEnable() {
		settings = new Settings(this);

		getApi().getEventService().registerListener(new LoginServerListener(this));
		getApi().getEventService().registerListener(new MessageSendListener(settings));
		getApi().getEventService().registerListener(new TickListener(settings));

		notifyAboutDeactivatedBobbing();
	}

	@Override
	public void loadConfig() {
		settings.loadConfig();
	}

	@Override
	protected void fillSettings(List<SettingsElement> settingsElements) {
		settings.fillSettings(settingsElements);
	}

	public void notifyAboutDeactivatedBobbing() {
		if (!settings.isEnabled()) {
			return;
		}

		Minecraft minecraft = Minecraft.getInstance();
		if (!minecraft.gameSettings.viewBobbing) {
			TextComponent textComponent = new StringTextComponent(
					"§7[§eNoBob§7] §4§lIMPORTANT: §cIn order for NoBob to work, the following setting has to"
							+ " be enabled: ");
			TextComponent settingComponent = new StringTextComponent(
					"§cOptions -> Video Settings -> View Bobbing §l[CLICK]");

			Style style = Style.EMPTY;
			style = style.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
					new StringTextComponent("§cClick to enable bobbing")));
			style = style.setClickEvent(
					new ClickEvent(ClickEvent.Action.RUN_COMMAND, "+nobob disablebobbing"));
			settingComponent.setStyle(style);
			textComponent.append(settingComponent);
			minecraft.ingameGUI.getChatGUI().printChatMessage(textComponent);
		}
	}
}
