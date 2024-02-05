package net.swofty.types.generic.data.datapoints;

import net.swofty.types.generic.data.Datapoint;
import net.swofty.types.generic.item.SkyBlockItem;
import net.swofty.types.generic.serializer.InventorySerializer;

import java.util.HashMap;
import java.util.Map;

public class DatapointBackpacks extends Datapoint<DatapointBackpacks.PlayerBackpacks> {
    private static final InventorySerializer<DatapointBackpacks.PlayerBackpacks> serializer =
            new InventorySerializer<>(DatapointBackpacks.PlayerBackpacks.class);

    public DatapointBackpacks(String key, DatapointBackpacks.PlayerBackpacks value) {
        super(key, value, serializer);
    }

    public DatapointBackpacks(String key) {
        super(key, new PlayerBackpacks(), serializer);
    }

    public record PlayerBackpacks(Map<Integer, SkyBlockItem> backpacks, int unlockedSlots) {
        public PlayerBackpacks() {
            this(new HashMap<>(), 1);
        }
    }
}