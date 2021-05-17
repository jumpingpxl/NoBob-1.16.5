package de.jumpingpxl.labymod.nobob;

import de.jumpingpxl.labymod.nobob.listener.TickListener;
import de.jumpingpxl.labymod.nobob.util.Settings;
import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.SettingsElement;

import java.util.List;

/**
 * @author Nico (JumpingPxl) Middendorf
 * @date 17.05.2021
 * @project LabyMod-Addon: NoBob-1.16.5
 */

public class NoBob extends LabyModAddon {

	public static final String VERSION = "1";

	private Settings settings;

	@Override
	public void onEnable() {
		settings = new Settings(this);

		getApi().getEventService().registerListener(new TickListener(settings));
	}

	@Override
	public void loadConfig() {
		settings.loadConfig();
	}

	@Override
	protected void fillSettings(List<SettingsElement> settingsElements) {
		settings.fillSettings(settingsElements);
	}
}
