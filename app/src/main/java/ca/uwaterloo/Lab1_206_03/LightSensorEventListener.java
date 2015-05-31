package ca.uwaterloo.Lab1_206_03;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

public class LightSensorEventListener implements SensorEventListener {
    TextView lightView;
    float lightValue;

    public LightSensorEventListener(TextView view1) {
        lightView = view1;
    }

    public void onAccuracyChanged(Sensor s, int i) {

    }

    public void onSensorChanged(SensorEvent se) {
        if (se.sensor.getType() == Sensor.TYPE_LIGHT) {
            // Get the sensor value from se.values
            lightValue = se.values[0];
            // Update the TextView
            lightView.setText("Light: " + lightValue);
        }
    }
}
