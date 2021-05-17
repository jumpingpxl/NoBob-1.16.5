package de.jumpingpxl.labymod.nobob.listener;

import de.jumpingpxl.labymod.nobob.NoBob;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.network.server.LoginServerEvent;

public class LoginServerListener {

	private final NoBob noBob;

	public LoginServerListener(NoBob noBob) {
		this.noBob = noBob;
	}

	@Subscribe
	public void onServerLogin(LoginServerEvent event) {
		noBob.notifyAboutDeactivatedBobbing();
	}
}
