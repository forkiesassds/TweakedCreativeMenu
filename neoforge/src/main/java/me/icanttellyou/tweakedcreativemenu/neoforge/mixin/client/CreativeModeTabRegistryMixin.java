package me.icanttellyou.tweakedcreativemenu.neoforge.mixin.client;

import me.icanttellyou.tweakedcreativemenu.util.ItemGroupUtil;
import net.minecraft.item.ItemGroup;
import net.neoforged.neoforge.common.CreativeModeTabRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collections;
import java.util.List;

@Mixin(CreativeModeTabRegistry.class)
public abstract class CreativeModeTabRegistryMixin {
    @Inject(method = "getSortedCreativeModeTabs", at = @At(value = "TAIL"), cancellable = true)
    private static void addCustomTabs(CallbackInfoReturnable<List<ItemGroup>> cir) {
        List<ItemGroup> original = cir.getReturnValue();
        List<ItemGroup> modified = ItemGroupUtil.addCustomItemGroups(original);
        cir.setReturnValue(Collections.unmodifiableList(modified));
    }
}
