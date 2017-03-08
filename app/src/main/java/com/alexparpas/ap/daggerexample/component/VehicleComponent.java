package com.alexparpas.ap.daggerexample.component;

import com.alexparpas.ap.daggerexample.model.Vehicle;
import com.alexparpas.ap.daggerexample.module.VehicleModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Alex on 3/8/2017.
 * The component interface is responsible to establish the connection between the
 * modules (which provide the dependencies), and the calsses requesting them through @Inject.
 *
 * Next to the @Component annotation, we have to specify which modules are going to be used.
 * If we need to create more modules, we simply add them using a comma as a seperator.
 *
 * Within the interface, we need to add methods for every object we need to provide,
 * and it will automatically give us one with all its dependencies satisfied.
 */

@Singleton
@Component (modules = {VehicleModule.class})
public interface VehicleComponent {
    Vehicle provideVehicle();
}
