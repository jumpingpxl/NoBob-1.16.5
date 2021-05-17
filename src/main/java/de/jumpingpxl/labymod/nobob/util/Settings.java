package de.jumpingpxl.labymod.nobob.util;

import com.google.gson.JsonObject;
import de.jumpingpxl.labymod.nobob.NoBob;
import net.labymod.settings.elements.HeaderElement;
import net.labymod.settings.elements.SettingsElement;

import java.util.List;

public class Settings {

	private final NoBob noBob;

	public Settings(NoBob noBob) {
		this.noBob = noBob;
	}

	public void loadConfig() {

	}

	public void fillSettings(List<SettingsElement> settingsElements) {
		settingsElements.add(new HeaderElement("§eNoBob v" + NoBob.VERSION));
	}

	private JsonObject getConfig() {
		return noBob.getConfig();
	}

	private void saveConfig() {
		noBob.saveConfig();
	}
}
