package com.alexparpas.ap.daggerexample.module;

import com.alexparpas.ap.daggerexample.model.Motor;
import com.alexparpas.ap.daggerexample.model.Vehicle;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alex on 3/8/2017.
 * We create this class to provide the dependant object (in this case 'Vehicle') all the dependencies it needs.
 * 'Vehicle' needs 'Motor' to work properly. This is why we need to create two provides, one for
 * the independent model (Motor), and another one for the dependent model (Vehicle),
 * indicating its dependency.
 *
 * Every provider method must have the @Provides annotation and the class must have the @Module annotation.
 * The @Singleton annotation indicates that there will be only one instance of the object.
 */

@Module
public class VehicleModule {

    @Provides @Singleton
    Motor provideMotor(){
        return new Motor();
    }

    @Provides @Singleton
    Vehicle provideVehicle(){
        return new Vehicle(new Motor());
    }
}
