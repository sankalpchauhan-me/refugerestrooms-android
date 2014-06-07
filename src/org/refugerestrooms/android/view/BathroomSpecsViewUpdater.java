package org.refugerestrooms.android.view;

import org.refugerestrooms.android.model.Bathroom;

import com.jmpumphrey.refugerestrooms.R;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BathroomSpecsViewUpdater {

	public static void update(View view, Bathroom bathroom) {
		TextView scoreTv = (TextView) view.findViewById(R.id.score);
		int score = bathroom.getScore();
		scoreTv.setText("" + score);
		scoreTv.setBackgroundColor(getScoreColour(score));
		
		if (bathroom.isAccessible()) {
			ImageView iv = (ImageView) view.findViewById(R.id.accessible);
			iv.setVisibility(View.VISIBLE);
		}
		if (bathroom.isUnisex()) {
			ImageView iv = (ImageView) view.findViewById(R.id.unisex);
			iv.setVisibility(View.VISIBLE);
		}
	}
	
	private static int getScoreColour(int score) {
		float[] hsv = new float[3];
		hsv[0] = ((float) score) / 100 * 120;
		hsv[1] = 1;
		hsv[2] = 1;
		return Color.HSVToColor(hsv);
	}
}