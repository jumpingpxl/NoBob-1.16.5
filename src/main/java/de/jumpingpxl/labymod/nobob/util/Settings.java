package de.jumpingpxl.labymod.nobob.util;

import com.google.gson.JsonObject;
import de.jumpingpxl.labymod.nobob.NoBob;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.HeaderElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Material;

import java.util.List;

public class Settings {

	private final NoBob noBob;

	private boolean enabled;

	public Settings(NoBob noBob) {
		this.noBob = noBob;
	}

	public void loadConfig() {
		enabled = !getConfig().has("enabled") || getConfig().get("enabled").getAsBoolean();
	}

	public void fillSettings(List<SettingsElement> settingsElements) {
		settingsElements.add(new HeaderElement("§eNoBob v" + NoBob.VERSION));
		settingsElements.add(new HeaderElement(""));
		settingsElements.add(
				new BooleanElement("§6Enabled", new ControlElement.IconData(Material.LEVER), newValue -> {
					enabled = newValue;
					getConfig().addProperty("enabled", newValue);
					saveConfig();
				}, enabled));
		settingsElements.add(new HeaderElement(""));
		settingsElements.add(new HeaderElement("§4§lIMPORTANT"));
		settingsElements.add(new HeaderElement(
				"§cIn order for NoBob to work, the following setting has to be enabled:"));
		settingsElements.add(new HeaderElement("§cOptions -> Video Settings -> View Bobbing"));
	}

	public boolean isEnabled() {
		return enabled;
	}

	private JsonObject getConfig() {
		return noBob.getConfig();
	}

	private void saveConfig() {
		noBob.saveConfig();
	}
}
