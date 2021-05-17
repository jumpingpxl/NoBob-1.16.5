package de.jumpingpxl.labymod.nobob;

import net.labymod.addon.AddonTransformer;
import net.labymod.api.TransformerType;

public class Transformer extends AddonTransformer {

	@Override
	public void registerTransformers() {
		this.registerTransformer(TransformerType.VANILLA, "addon.mixin.json");
	}
}