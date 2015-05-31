package ca.uwaterloo.Lab1_206_03;

import android.app.Fragment;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */

public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        TextView tv = (TextView) rootView.findViewById(R.id.label1);
        tv.setText("I’ve replaced the label!");


        TextView tv1 = new TextView(rootView.getContext());
        tv1.setText("Example text");

        TextView tv2 = new TextView(rootView.getContext());
        tv2.setText("Example text 2");

        LinearLayout l1 = (LinearLayout) rootView.findViewById(R.id.label);
        l1.setOrientation(LinearLayout.VERTICAL);
        l1.addView(tv1);
        l1.addView(tv2);
        SensorManager sensorManager = (SensorManager) rootView.getContext().getSystemService(rootView.getContext().SENSOR_SERVICE);

        Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        TextView lightTextView = new TextView(rootView.getContext());
        SensorEventListener light = new LightSensorEventListener(lightTextView);
        sensorManager.registerListener(light, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);

        Sensor accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        TextView accelerometerTextView = new TextView(rootView.getContext());
        SensorEventListener accelerometer = new AccelerometerSensorEventListener(accelerometerTextView);
        sensorManager.registerListener(accelerometer, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);


        l1.addView(lightTextView);
        l1.addView(accelerometerTextView);
        return rootView;
    }


}
