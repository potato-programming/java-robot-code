/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonClass;
import com.squareup.moshi.Moshi;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class JSONPlotter(private String label) {

	private Double[] pointsList = [];
	private double setpoint = 0.0;

	private Moshi moshi = new Moshi.Builder().build();
	private JsonAdapter adapter = moshi.adapter(JSONModel::class.java);

	void resetCapture() {
		// Empty list
		pointsList.clear();
	}

	void recordSetpoint(Number point) {
		setpoint = point.toDouble();
	}

	void changeLabel(String newLabel) {
		label = newLabel;
	}

	void outputDataAsJSON() {
		// Output json formatted data to console
		System.out.println(adapter.toJson(JSONModel(label, setpoint, pointsList)));
	}

	void getJSON() {
		adapter.toJson(JSONModel(label, setpoint, pointsList));
	}

}

public class JSONPlotterNT {

	private NetworkTableInstance ntInst = new NetworkTableInstance.getDefault();
	private NetworkTable table = ntInst.getTable("/");
	private NetworkTableEntry jsonStringEntry = table.getEntry("json_string");

	public JSONPlotterNT() {
		jsonStringEntry.setString("{\"label\": \"default\", \"setpoint\": 0.0, \"data\": []}");
	}

	void publishJSONsToNT(List<String> json) {
		jsonStringEntry.setString(json.joinToString(separator = "|"));
	}

}

@JsonClass(generateAdapter = true)
class JSONModel {
	String label;
	double setpoint;
	List<Double> data;
}
