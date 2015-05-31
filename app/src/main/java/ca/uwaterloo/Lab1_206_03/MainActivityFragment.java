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

import java.util.Arrays;

import ca.uwaterloo.sensortoy.LineGraphView;

public class MainActivityFragment extends Fragment {

    // Variable declarations
    private SensorManager sensorManager;
    private SensorEventListener lightEventListener, accelerometerEventListener, magneticFieldEventListener, rotationVectorEventListener;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


        // Create a linear layout so that we can scroll in case the content goes off screen
        LinearLayout layout = (LinearLayout) rootView.findViewById(R.id.label);
        layout.setOrientation(LinearLayout.VERTICAL);

        // Initialize a graph for displaying accelerometer data
        LineGraphView graph;
        graph = new LineGraphView(rootView.getContext(),100, Arrays.asList("x", "y", "z"));
        layout.addView(graph);
        graph.setVisibility(View.VISIBLE);

        // Initialize the sensor manager for our sensors
        sensorManager = (SensorManager) rootView.getContext().getSystemService(rootView.getContext().SENSOR_SERVICE);
        // Create the light sensor event listener
        TextView lightTextView = new TextView(rootView.getContext());
        lightEventListener = new LightSensorEventListener(lightTextView);
        sensorManager.registerListener(lightEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT), SensorManager.SENSOR_DELAY_NORMAL);

        // Create the accelerometer sensor event listener
        TextView xAccelerometerTextView = new TextView(rootView.getContext());
        TextView yAccelerometerTextView = new TextView(rootView.getContext());
        TextView zAccelerometerTextView = new TextView(rootView.getContext());
        TextView xMaxAccelerometerTextView = new TextView(rootView.getContext());
        TextView yMaxAccelerometerTextView = new TextView(rootView.getContext());
        TextView zMaxAccelerometerTextView = new TextView(rootView.getContext());
        accelerometerEventListener = new AccelerometerSensorEventListener(graph, xAccelerometerTextView, yAccelerometerTextView, zAccelerometerTextView, xMaxAccelerometerTextView, yMaxAccelerometerTextView, zMaxAccelerometerTextView);
        sensorManager.registerListener(accelerometerEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        // Create the magnetic field sensor event listener
        TextView xMagneticFieldTextView = new TextView(rootView.getContext());
        TextView yMagneticFieldTextView = new TextView(rootView.getContext());
        TextView zMagneticFieldTextView = new TextView(rootView.getContext());
        TextView xMaxMagneticFieldTextView = new TextView(rootView.getContext());
        TextView yMaxMagneticFieldTextView = new TextView(rootView.getContext());
        TextView zMaxMagneticFieldTextView = new TextView(rootView.getContext());
        magneticFieldEventListener = new MagneticFieldSensorEventListener(xMagneticFieldTextView, yMagneticFieldTextView, zMagneticFieldTextView, xMaxMagneticFieldTextView, yMaxMagneticFieldTextView, zMaxMagneticFieldTextView);
        sensorManager.registerListener(magneticFieldEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), SensorManager.SENSOR_DELAY_NORMAL);

        // Create the rotation vector sensor event listener
        TextView xRotationTextView = new TextView(rootView.getContext());
        TextView yRotationTextView = new TextView(rootView.getContext());
        TextView zRotationTextView = new TextView(rootView.getContext());
        TextView xMaxRotationTextView = new TextView(rootView.getContext());
        TextView yMaxRotationTextView = new TextView(rootView.getContext());
        TextView zMaxRotationTextView = new TextView(rootView.getContext());
        rotationVectorEventListener = new RotationVectorSensorEventListener(xRotationTextView, yRotationTextView, zRotationTextView, xMaxRotationTextView, yMaxRotationTextView, zMaxRotationTextView);
        sensorManager.registerListener(rotationVectorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR), SensorManager.SENSOR_DELAY_NORMAL);

        // Add the text views to our layout
        TextView newLine1 = new TextView(rootView.getContext()),newLine2 = new TextView(rootView.getContext()), newLine3 = new TextView(rootView.getContext()), newLine4 = new TextView(rootView.getContext());
        newLine1.setText("");
        newLine2.setText("");
        newLine3.setText("");
        newLine4.setText("");
        layout.addView(newLine1);
        layout.addView(lightTextView);
        layout.addView(newLine2);
        layout.addView(xAccelerometerTextView);
        layout.addView(yAccelerometerTextView);
        layout.addView(zAccelerometerTextView);
        layout.addView(xMaxAccelerometerTextView);
        layout.addView(yMaxAccelerometerTextView);
        layout.addView(zMaxAccelerometerTextView);
        layout.addView(newLine3);
        layout.addView(xMagneticFieldTextView);
        layout.addView(yMagneticFieldTextView);
        layout.addView(zMagneticFieldTextView);
        layout.addView(xMaxMagneticFieldTextView);
        layout.addView(yMaxMagneticFieldTextView);
        layout.addView(zMaxMagneticFieldTextView);
        layout.addView(newLine4);
        layout.addView(xRotationTextView);
        layout.addView(yRotationTextView);
        layout.addView(zRotationTextView);
        layout.addView(xMaxRotationTextView);
        layout.addView(yMaxRotationTextView);
        layout.addView(zMaxRotationTextView);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Re-register sensor event listeners
        sensorManager.registerListener(lightEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT), SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(accelerometerEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(magneticFieldEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(rotationVectorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onPause() {
        // Unregister sensor event listeners
        sensorManager.unregisterListener(lightEventListener);
        sensorManager.unregisterListener(accelerometerEventListener);
        sensorManager.unregisterListener(magneticFieldEventListener);
        sensorManager.unregisterListener(rotationVectorEventListener);
        super.onPause();
    }


}
