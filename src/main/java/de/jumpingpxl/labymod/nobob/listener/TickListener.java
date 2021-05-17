package de.jumpingpxl.labymod.nobob.listener;

import de.jumpingpxl.labymod.nobob.util.Settings;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.TickEvent;
import net.minecraft.client.Minecraft;

import java.util.Objects;

public class TickListener {

	private final Settings settings;

	public TickListener(Settings settings) {
		this.settings = settings;
	}

	@Subscribe
	public void onClientTick(TickEvent event) {
		Minecraft minecraft = Minecraft.getInstance();
		if(settings.isEnabled() && Objects.nonNull(minecraft.player)) {
			minecraft.player.distanceWalkedModified = 0.0F;
		}
	}
}
