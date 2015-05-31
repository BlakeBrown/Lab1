package ca.uwaterloo.Lab1_206_03;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

public class RotationVectorSensorEventListener implements SensorEventListener {

    TextView xView, yView, zView, xMaxView, yMaxView, zMaxView;
    float xValue, yValue, zValue, xMaxValue = 0, yMaxValue = 0, zMaxValue = 0;

    public RotationVectorSensorEventListener(TextView view1, TextView view2, TextView view3, TextView view4, TextView view5, TextView view6) {
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
        if (se.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {
            // Get the 3 different acceleration values from se.values
            xValue = se.values[0];
            yValue = se.values[1];
            zValue = se.values[2];
            // Update the text views
            xView.setText("Rotation Vector X-Value: " + xValue);
            yView.setText("Rotation Vector Y-Value: " + yValue);
            zView.setText("Rotation Vector Z-Value: " + zValue);
            // Update the max value text views
            if(Math.abs(xValue) > Math.abs(xMaxValue)) {
                xMaxValue = xValue;
                xMaxView.setText("Max Rotation Vector X-Value: " + xMaxValue);
            }
            if(Math.abs(yValue) > Math.abs(yMaxValue)) {
                yMaxValue = yValue;
                yMaxView.setText("Max Rotation Vector Y-Value: " + yMaxValue);
            }
            if(Math.abs(zValue) > Math.abs(zMaxValue)) {
                zMaxValue = zValue;
                zMaxView.setText("Max Rotation Vector Z-Value: " + zMaxValue);
            }

        }
    }
}
