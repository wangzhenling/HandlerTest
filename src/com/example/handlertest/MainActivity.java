package com.example.handlertest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView myText;
	private Handler myHandler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		myText=(TextView)findViewById(R.id.myText);
		myText.setText("生成的随机数为："+Math.random());
		
		myHandler=new Handler(){
			public void handleMessage(Message msg){
				super.handleMessage(msg);
				if(msg.what==0x12){
					
					myText.setText("生成的随机数为\n："+Math.random());
				}
			}
			
		};
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					while(true)/*for(int i=0;i<5;i++)*/{
						Thread.sleep(300);
						/*8Double random=Math.random();
						System.out.println(random);
						myText.setText("生成的随机数为："+random);*/
						//这句代码无法执行，控制台打印错误信息，Only the original thread that
						//create a view hierarchy can touch its views.即该线程不能改变
						//TextView的显示，只有创建TextView的线程可以改变
						
					/*Message msg=new Message();
					msg.what=0x12;
					myHandler.sendMessage(msg);*/
					
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}).start();
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
