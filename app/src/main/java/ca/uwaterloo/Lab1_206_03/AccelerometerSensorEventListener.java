package ca.uwaterloo.Lab1_206_03;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

/**
 * Created by blake on 15-05-19.
 */
public class AccelerometerSensorEventListener implements SensorEventListener {
        TextView output;
        float accelerometer;

        public AccelerometerSensorEventListener(TextView outputView) {
            output = outputView;
        }

        public void onAccuracyChanged(Sensor s, int i) {

        }

        public void onSensorChanged(SensorEvent se) {
            if (se.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                accelerometer = se.values[0];
                System.out.println(se.values);
                output.setText("Accelerometer X-Value" + accelerometer);
            }
        }
    }
