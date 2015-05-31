package ca.uwaterloo.Lab1_206_03;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

public class LightSensorEventListener implements SensorEventListener {
    TextView output;
    float light;

    public LightSensorEventListener(TextView outputView) {
        output = outputView;
    }

    public void onAccuracyChanged(Sensor s, int i) {

    }

    public void onSensorChanged(SensorEvent se) {
        if (se.sensor.getType() == Sensor.TYPE_LIGHT) {
            // the variable se.values is an array of type int[] or double[].
            // the first value (se.values[0]) contains the value
            // of the light sensor. store it somewhere useful.
            light = se.values[0];
            output.setText("Light = " + light);
        }
    }
}
