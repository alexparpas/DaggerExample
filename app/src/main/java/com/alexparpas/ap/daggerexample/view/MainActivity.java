package com.alexparpas.ap.daggerexample.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alexparpas.ap.daggerexample.R;
import com.alexparpas.ap.daggerexample.component.DaggerVehicleComponent;
import com.alexparpas.ap.daggerexample.component.VehicleComponent;
import com.alexparpas.ap.daggerexample.model.Vehicle;
import com.alexparpas.ap.daggerexample.module.VehicleModule;

/**
 * Created by Alex on 3/8/2017.
 * In this activity, we need to obtain an instance of the component interface and invoke its methods to
 * obtain the object we need.
 *
 * When we try to create a new object of the component interface, we have to do it using the prefix
 * Dagger<NameOfTheComponentInterface>, and then use the builder method to instantiate all the modules.
 *
 * Once we create the component object, we can access our dependent object using the provide method
 * we defined in the module class.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Vehicle vehicle;
    private TextView speedTv;
    private Button increaseBt, decreaseBt, stopBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speedTv = (TextView) findViewById(R.id.speed_display_text_view);
        increaseBt = (Button) findViewById(R.id.increase_speed_button);
        decreaseBt = (Button) findViewById(R.id.decrease_speed_button);
        stopBt = (Button) findViewById(R.id.stop_button);

        increaseBt.setOnClickListener(this);
        decreaseBt.setOnClickListener(this);
        stopBt.setOnClickListener(this);

        VehicleComponent vehicleComponent = DaggerVehicleComponent
                .builder()
                .vehicleModule(new VehicleModule())
                .build();

        vehicle = vehicleComponent.provideVehicle();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == increaseBt.getId()) {
            vehicle.increaseSpeed(10);
        } else if (v.getId() == decreaseBt.getId()) {
            vehicle.decreaseSpeed(10);
        } else if (v.getId() == stopBt.getId()) {
            vehicle.stop();
        }
        speedTv.setText(String.valueOf(vehicle.getSpeed()));
    }

}
