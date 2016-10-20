package kr.hs.emirim.dahoe0304.alphalayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editName, editAge;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName=(EditText)findViewById(R.id.edit_name);
        editAge=(EditText)findViewById(R.id.edit_age);
        sp=getSharedPreferences("appInfo", Context.MODE_PRIVATE);

    }

    @Override
    protected void onResume() { //다시 나타날때 호출
        super.onResume();
        String name=sp.getString("name",""); //저장된 값을 꺼내온다.이름이 없으면 나타날 문자열
        String age=sp.getString("age","");
        editName.setText(name);
        editAge.setText(age);
    }

    @Override
    protected void onStop() {   //액티비티가 화면에 안보일때 호출
        super.onStop();
        SharedPreferences.Editor edit=sp.edit();    //에디터의 참조값을 반환함
        edit.putString("name",editName.getText().toString());  //에디터텍스트에 입력된값을 키네임으로 변환
        edit.putString("age",editAge.getText().toString());
        edit.commit();  //실제로 저장이됨
    }
}
