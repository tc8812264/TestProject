package practice;

public class Test {
	public static void main(String[] args){
		View tc = new View("���");
		tc.setOnClickListener(new OnClickListener(){
			public void onclick(View v) {
				System.out.println("�ұ�"+v.name+"����ˣ�");
			}
		});
		tc.onClickListener.onclick(tc);
	}
}
class View{
	public String name;
	public OnClickListener onClickListener;
	View(String name) {
		this.name = name;
	}
	public void setOnClickListener(OnClickListener OnClickListener) {
		this.onClickListener = OnClickListener;
	}

	public OnClickListener getOnClickListener() {
		return onClickListener;
	}
	
}
class OnClickListener{

	OnClickListener(){
		System.out.println("OnClickListener�����ˣ�");
	}
	public void onclick(View v) {
		System.out.println("�ұ�����ˣ�");
	}
}
