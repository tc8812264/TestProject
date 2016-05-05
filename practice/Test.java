package practice;

public class Test {
	public static void main(String[] args){
		View tc = new View("田璨");
		tc.setOnClickListener(new OnClickListener(){
			public void onclick(View v) {
				System.out.println("我被"+v.name+"点击了！");
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
		System.out.println("OnClickListener出生了！");
	}
	public void onclick(View v) {
		System.out.println("我被点击了！");
	}
}
