package ca.uwaterloo.Lab1_206_03;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

public class AccelerometerSensorEventListener implements SensorEventListener {
        TextView xView, yView, zView, xMaxView, yMaxView, zMaxView;
        float xValue, yValue, zValue, xMaxValue = 0, yMaxValue = 0, zMaxValue = 0;

        public AccelerometerSensorEventListener(TextView view1, TextView view2, TextView view3, TextView view4, TextView view5, TextView view6) {
            xView = view1;
            yView = view2;
            zView = view3;
            xMaxView = view4;
            yMaxView = view5;
            zMaxView = view6;
        }

        public void onAccuracyChanged(Sensor s, int i) {

        }

        public void onSensorChanged(SensorEvent se) {
            if (se.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                // Get the 3 different acceleration values from se.values
                xValue = se.values[0];
                yValue = se.values[1];
                zValue = se.values[2];
                // Update the text views
                xView.setText("Accelerometer X-Value: " + xValue);
                yView.setText("Accelerometer Y-Value: " + yValue);
                zView.setText("Accelerometer Z-Value: " + zValue);
                // Update the max value text views
                if(Math.abs(xValue) > Math.abs(xMaxValue)) {
                    xMaxValue = xValue;
                    xMaxView.setText("Max Accelerometer X-Value: " + xMaxValue);
                }
                if(Math.abs(yValue) > Math.abs(yMaxValue)) {
                    yMaxValue = yValue;
                    yMaxView.setText("Max Accelerometer Y-Value: " + yMaxValue);
                }
                if(Math.abs(zValue) > Math.abs(zMaxValue)) {
                    zMaxValue = zValue;
                    zMaxView.setText("Max Accelerometer Z-Value: " + zMaxValue);
                }

            }
        }
    }
