package js.satya.healthyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details5 ={
            {"Doctor Name : Satya" , "Hospital Address : Amalapuram" ,"Exp : 3yrs","Mobile No:9381567288","600"},
            {"Doctor Name : Sai" , "Hospital Address : Ongole" ,"Exp : 3yrs","Mobile No:8790234729","500"},
            {"Doctor Name : Ayyappa" , "Hospital Address : Hyderabad" ,"Exp : 15yrs","Mobile No:8985188539","1000"},
            {"Doctor Name : Mahesh " , "Hospital Address : Rajahmundry" ,"Exp : 3yrs","Mobile No:882373920","400"},
            {"Doctor Name : Nani" , "Hospital Address : Nellore" ,"Exp : 3yrs","Mobile No:9652202629","800"}

    };
    private String[][] doctor_details1 ={
            {"Doctor Name : premalatha" , "Hospital Address : Amalapuram" ,"Exp : 3yrs","Mobile No:9381567288","600"},
            {"Doctor Name : pravallika" , "Hospital Address : Ongole" ,"Exp : 3yrs","Mobile No:8790234729","500"},
            {"Doctor Name : Pawan" , "Hospital Address : Hyderabad" ,"Exp : 15yrs","Mobile No:8985188539","1000"},
            {"Doctor Name : siddu " , "Hospital Address : Rajahmundry" ,"Exp : 3yrs","Mobile No:882373920","400"},
            {"Doctor Name : hanisha" , "Hospital Address : Nellore" ,"Exp : 3yrs","Mobile No:9652202629","800"}

    };
    private String[][] doctor_details2 ={
            {"Doctor Name : murali" , "Hospital Address : Amalapuram" ,"Exp : 3yrs","Mobile No:9381567288","600"},
            {"Doctor Name : saibaba" , "Hospital Address : Ongole" ,"Exp : 3yrs","Mobile No:8790234729","500"},
            {"Doctor Name : sree" , "Hospital Address : Hyderabad" ,"Exp : 15yrs","Mobile No:8985188539","1000"},
            {"Doctor Name : mrudhula " , "Hospital Address : Rajahmundry" ,"Exp : 3yrs","Mobile No:882373920","400"},
            {"Doctor Name :sirisha" , "Hospital Address : Nellore" ,"Exp : 3yrs","Mobile No:9652202629","800"}

    };
    private String[][] doctor_details3 ={
            {"Doctor Name : tejaa" , "Hospital Address : Amalapuram" ,"Exp : 3yrs","Mobile No:9381567288","600"},
            {"Doctor Name : sandhya" , "Hospital Address : Ongole" ,"Exp : 3yrs","Mobile No:8790234729","500"},
            {"Doctor Name : mounika" , "Hospital Address : Hyderabad" ,"Exp : 15yrs","Mobile No:8985188539","1000"},
            {"Doctor Name : jalavathi " , "Hospital Address : Rajahmundry" ,"Exp : 3yrs","Mobile No:882373920","400"},
            {"Doctor Name : indhupriya" , "Hospital Address : Nellore" ,"Exp : 3yrs","Mobile No:9652202629","800"}

    };
    private String[][] doctor_details4 ={
            {"Doctor Name : sahitha" , "Hospital Address : Amalapuram" ,"Exp : 3yrs","Mobile No:9381567288","600"},
            {"Doctor Name : maneesha" , "Hospital Address : Ongole" ,"Exp : 3yrs","Mobile No:8790234729","500"},
            {"Doctor Name : mahesh" , "Hospital Address : Hyderabad" ,"Exp : 15yrs","Mobile No:8985188539","1000"},
            {"Doctor Name : lakshman " , "Hospital Address : Rajahmundry" ,"Exp : 3yrs","Mobile No:882373920","400"},
            {"Doctor Name : javeed" , "Hospital Address : Nellore" ,"Exp : 3yrs","Mobile No:9652202629","800"}

    };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textView2);
        btn = findViewById(R.id.buttonLTBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details =doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details =doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details =doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details =doctor_details4;
        else
            doctor_details =doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));

            }
        });
        list = new ArrayList();
        for (int i=0;i<doctor_details.length;i++) {
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:" + doctor_details[i][4] + "/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst =findViewById(R.id.listViewLT);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);

            }
        });
        }



    }
