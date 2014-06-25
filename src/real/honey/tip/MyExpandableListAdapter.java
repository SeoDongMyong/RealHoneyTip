package real.honey.tip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyExpandableListAdapter extends BaseExpandableListAdapter {

	Context context;
	public static String[][] child = {
			{ "페이스북 페이지 명품유용정보에서 2014년 6월 18일,\n공식 앱인 '리얼꿀팁'을 출시하였습니다." },
			{ "페이스북 페이지 명품유용정보에서 2014년 6월 18일,\n공식 앱인 '리얼꿀팁'을 출시하였습니다." },
			{ "페이스북 페이지 명품유용정보에서 2014년 6월 18일,\n공식 앱인 '리얼꿀팁'을 출시하였습니다." } };
	public static String[] group = { "리얼꿀팁을 이용해주셔서 감사합니다.",
			"리얼꿀팁을 이용해주셔서 감사합니다.", "리얼꿀팁을 이용해주셔서 감사합니다." };

	public MyExpandableListAdapter(Context context) {
		super();
		this.context = context;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return child[groupPosition][childPosition];
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return child[groupPosition].length;
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return group[groupPosition];
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return group.length;
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	public View getConvertView(View v, int resourceId) {
		if (v == null) {
			// LayoutInflater를 이용하여 list_row를 view로 설정한다.
			LayoutInflater vi = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(resourceId, null);
		}
		return v;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView = getConvertView(convertView, R.layout.child_row);
		TextView groupTV = (TextView) convertView.findViewById(R.id.childName);
		LinearLayout li1 = (LinearLayout) convertView
				.findViewById(R.id.child_linear01);
		li1.setBackgroundResource(R.drawable.round_box);
		groupTV.setText(group[groupPosition]);
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View convertView1 = parent.getRootView();
		LinearLayout li1 = (LinearLayout) convertView1
				.findViewById(R.id.child_linear01);
		li1.setBackgroundResource(R.drawable.round_box1);

		convertView = getConvertView(convertView, R.layout.child_row1);
		TextView childTV = (TextView) convertView
				.findViewById(R.id.wordsContent);
		LinearLayout li2 = (LinearLayout) convertView
				.findViewById(R.id.child_linear02);
		li2.setBackgroundResource(R.drawable.round_box2);

		childTV.setText(child[groupPosition][childPosition]);
		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}
}
