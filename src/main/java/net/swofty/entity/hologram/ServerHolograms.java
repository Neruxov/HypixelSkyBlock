package net.swofty.entity.hologram;

import lombok.Builder;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.instance.Instance;

import java.util.ArrayList;
import java.util.Arrays;

public enum ServerHolograms {
    TO_ISLAND(new Pos(-6.5, 71, -74), "§a§l» §f§lSkyBlock §a§l«", "§7Teleport to your island"),
    ;

    private static ArrayList<ExternalHologram> externalHolograms = new ArrayList<>();

    private Pos pos;
    private final String[] text;

    ServerHolograms(Pos pos, String... text) {
        this.pos = pos;
        this.text = text;
    }

    public static void spawnAll(Instance instance) {
        for (ServerHolograms hologram : values()) {
            int i = 0;
            for (String s : hologram.text) {
                HologramEntity entity = new HologramEntity(s);
                entity.setInstance(instance, hologram.pos.add(0, -(i * 0.25), 0));
                entity.setAutoViewable(true);
                entity.spawn();

                i++;
            }
        }

        for (ExternalHologram hologram : externalHolograms) {
            int i = 0;
            for (String s : hologram.text) {
                HologramEntity entity = new HologramEntity(s);
                entity.setInstance(hologram.instance, hologram.pos.add(0, -(i * 0.25), 0));
                entity.setAutoViewable(true);
                entity.spawn();

                i++;
            }
        }
    }

    public static void addExternalHologram(ExternalHologram hologram) {
        externalHolograms.add(hologram);
    }

    @Builder
    public static class ExternalHologram {
        private final Instance instance;
        private final Pos pos;
        private final String[] text;
    }
}
