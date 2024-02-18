package com.pedruhb.createarmouryweapon;

import com.pedruhb.createarmouryweapon.blocks.AllPartialModels;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class CreateArmouryWeaponClient {
    
        public CreateArmouryWeaponClient(){
                IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
                AllPartialModels.init();
                modEventBus.register(this);
        }
}
