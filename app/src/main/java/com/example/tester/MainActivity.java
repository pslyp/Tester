package com.example.tester;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.TypedArrayUtils;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.skyhope.materialtagview.TagView;
import com.skyhope.materialtagview.TagView_me;
import com.skyhope.materialtagview.enums.TagSeparator;
import com.skyhope.materialtagview.model.TagModel;

import java.util.ArrayList;
import java.util.List;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;

public class MainActivity extends AppCompatActivity {

    private SpinnerDialog spinnerDialog;
    private TagView_me tagViewMe;

    private TagView tagView;

    private TextView foodLoseText;
    private ImageView addImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button add = findViewById(R.id.add_text_button);

//        foodLoseText = findViewById(R.id.food_lose_text_view);

        final LinearLayout l1 = findViewById(R.id.r1);

        final LayoutParams lp = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );

        addImage = findViewById(R.id.add_image_view);
        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerDialog.showSpinerDialog();
            }
        });

        tagView = findViewById(R.id.tag_view);
        tagView.setHint("Adddd");
        tagView.addTagLimit(5);

        String[] tagList = new String[]{"C++", "Java", "PHP"};
        tagView.setTagList(tagList);


        tagViewMe = findViewById(R.id.tag_view_me);
//        tagView.setHint("Add your skill");

        tagViewMe.setText("ไม่มี");
//        tagViewMe.setDrawable(R.drawable.ic_cancel, 0, R.drawable.ic_cancel, 0);
        tagViewMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Tag View", Toast.LENGTH_SHORT).show();

//                spinnerDialog.showSpinerDialog();
            }
        });

        tagViewMe.addTagLimit(10);


        final TextView[] tv = new TextView[10];
        final LinearLayout[] layoutText = new LinearLayout[10];
        final ImageView[] imageView = new ImageView[10];

        final EditText editText = findViewById(R.id.edit_text_view);

//        tv.setLayoutParams(lp);

//        tv.setText("This is a sample TextView...");

        final AllergicFoodList[] afl = new AllergicFoodList[10];

        final int[] index = {0};
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                layoutText[index[0]] = new LinearLayout(getApplicationContext());
//                layoutText[index[0]].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
//                layoutText[index[0]].setOrientation(LinearLayout.HORIZONTAL);
//                layoutText[index[0]].setGravity(Gravity.CENTER);
//                layoutText[index[0]].setBackgroundColor(Color.GRAY);
//
//
//                int id = getResources().getIdentifier(Integer.toString(index[0]), "drawable", getPackageName());
//
//                imageView[index[0]] = new ImageView(getApplicationContext());
//                imageView[index[0]].setId(id);
//                imageView[index[0]].setLayoutParams(new LayoutParams(60, 60));
//                imageView[index[0]].setImageResource(R.drawable.ic_cancel_black_24dp);
//                imageView[index[0]].setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
////                        imageView[0].remo
//                        removeTheElement(imageView, imageView[1].getId());
//                        l1.addView(null);
//                        l1.addView(imageView[index[0]]);
//                    }
//                });
//
////
//                tv[index[0]] = new TextView(getApplicationContext());
//                tv[index[0]].setLayoutParams(lp);
//                tv[index[0]].setTextColor(Color.parseColor("#ffffff"));
//                tv[index[0]].setText(editText.getText().toString().trim());
//                tv[index[0]].setTextSize(15);
//
//                tv[index[0]].setPadding(8, 0, 0, 0);
//
//                lp.addRule(RelativeLayout.BELOW, tv[index[0]].getId());
//
//                layoutText[index[0]].addView(tv[index[0]]);
//                layoutText[index[0]].addView(imageView[index[0]]);
//                l1.addView(layoutText[index[0]]);
//                l1.addView(tv[index[0]]);



                afl[index[0]] = AllergicFoodList.init(getApplicationContext());
                afl[index[0]].setLayoutSize(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                afl[index[0]].setLayoutBackgroundColor(Color.GRAY);
                afl[index[0]].setText(editText.getText().toString().trim());
                afl[index[0]].setImage(R.drawable.ic_cancel_black_24dp);
                afl[index[0]].setImageSize(60, 60);

                afl[index[0]].image().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, afl[1].text().getText().toString().trim(), Toast.LENGTH_SHORT).show();
                    }
                });

//                afl[index[0]].remove(afl, 1);


                l1.addView(afl[index[0]].createItem());


                index[0]++;
            }
        });

        initSearchSpinner();

//        foodLoseText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                spinnerDialog.showSpinerDialog();
//            }
//        });

        Button showButton = findViewById(R.id.show_tag_button);
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<TagModel> tagArr = tagViewMe.getSelectedTags();

                String text = "";
                for(TagModel tag : tagArr) {
                    text += (tag.getTagText() + " ");
                }

                Log.e("Show tag", text);
            }
        });

    }

    private void initSearchSpinner() {
        ArrayList<String> item = new ArrayList<>();

        item.add("ไม่มี");
        item.add("เนื้อปู");
        item.add("เนื้อเป็ด");
        item.add("เนื้อปลาหมึก");
        item.add("เนื้อหอยนางรม");
        item.add("เนื้อหอยโข่ง");
        item.add("เนื้อห่าน");
        item.add("เนื้อตะพาบ");
        item.add("เนื้อเต่า");
        item.add("เนื้อกระต่าย");
        item.add("เนื้อปลาไหล");
        item.add("เนื้อหอยเชลล์");
        item.add("เนื้อปลา");
        item.add("กล้วย");
        item.add("ส้ม");
        item.add("สาลี่");
        item.add("อ้อย");
        item.add("แตงโม");
        item.add("สับปะรด");
        item.add("น้ำส้ม");
        item.add("องุ่น");
        item.add("มะพร้าว");
        item.add("มะละกอ");
        item.add("ทับทิม");
        item.add("ส้มโอ");
        item.add("มะขาม");
        item.add("แอ๊ปเปิ้ล");
        item.add("มังคุด");
        item.add("มะเฟือง");
        item.add("มะม่วงดิบ");
        item.add("ถั่วเขียว");
        item.add("ถั่วเหลือง");
        item.add("เต้าหู้");
        item.add("ข้าวฟ่าง");
        item.add("ลูกเดือย");
        item.add("ถั่วแดง");
        item.add("ข้าวโพด");
        item.add("แตงกวา");
        item.add("มะเขือยาว");
        item.add("สาหร่ายทะเล");
        item.add("ผักกาดหอม");
        item.add("ฟัก");
        item.add("มะเขือเทศ");
        item.add("ฟักทอง");
        item.add("ผักกระเฉด");
        item.add("ขึ้นฉ่าย");
        item.add("ใบตำลึง");
        item.add("บวบ");
        item.add("ชา");
        item.add("มะระ");
        item.add("ผักกาดขาว");
        item.add("ผักบุ้ง");
        item.add("เห็ดฟาง");
        item.add("หัวไช้เท้า");
        item.add("หน่อไม้");
        item.add("เหง้าบัว");
        item.add("เห็ดหูหนูขาว");
        item.add("เห็ดหูหนูดำ");
        item.add("เก๊กฮวย");
        item.add("บัวบก");
        item.add("เม็ดแมงลัก");
        item.add("ดอกไม้จีน");
        item.add("เห็ดหอม");
        item.add("ผักกาดแก้ว");
        item.add("ถั่วลันเตา");
        item.add("บีตรู้ต");
        item.add("เซเลอรี่");
        item.add("เยื่อไผ่");
        item.add("หน่อไม้ฝรั่ง");
        item.add("ดอกขจร");
        item.add("ยอดฟักแม้ว");
        item.add("สายบัว");
        item.add("ถั่วฝักยาว");
        item.add("แห้ว");
        item.add("เห็ดเข็มทอง");
        item.add("ผักสลัด");
        item.add("รากบัว");
        item.add("ถั่วงอก");
        item.add("สะระแหน่");
        item.add("เนื้อวัว");
        item.add("เนื้อไก่");
        item.add("เนื้อกุ้ง");
        item.add("เนื้อแพะ");
        item.add("เนื้องู");
        item.add("ไข่");
        item.add("ปลาหมึกแห้ง");
        item.add("เงาะ");
        item.add("ลำไย");
        item.add("มะม่วง");
        item.add("เนื้อมะพร้าว");
        item.add("ลิ้นจี่");
        item.add("ทุเรียน");
        item.add("ขนุน");
        item.add("มะกอก");
        item.add("พริก");
        item.add("ผักชี");
        item.add("พริกไทย");
        item.add("ใบแมงลัก");
        item.add("ขิง");
        item.add("กระเทียม");
        item.add("งาดำ");
        item.add("หอมหัวใหญ่");
        item.add("หอมเล็ก");
        item.add("ข้าวเหนียว");
        item.add("ข่า");
        item.add("กะเพรา");
        item.add("โหระพา");
        item.add("ตะไคร้");
        item.add("ต้นหอม");
        item.add("ใบยี่หร่า");
        item.add("ชะอม");
        item.add("มัน");
        item.add("เหล้า");
        item.add("เครื่องเทศ");
        item.add("น้ำพริกแกง");
        item.add("เนย");
        item.add("เนยถั่ว");
        item.add("น้ำพริกเผา");
        item.add("ซอสพริก");
        item.add("น้ำมัน");

        spinnerDialog = new SpinnerDialog(MainActivity.this, item, "กรุณาเลือกวัถุดิบที่แพ้", "ปิด");

        spinnerDialog.setCancellable(true);
        spinnerDialog.setShowKeyboard(false);
        spinnerDialog.setUseContainsFilter(true);
        spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
//                foodLoseText.setText(item);

//                tagViewMe.setText("กรุณาเลือกวัตถุดิบที่แพ้");
                tagViewMe.addTag(item, false);
            }
        });
    }

    private ImageView[] removeTheElement(ImageView[] arr, int index) {
        if(arr == null || index > 0 || index >= arr.length)
            return arr;

        ImageView[] imageViewList = new ImageView[arr.length - 1];

        for(int i=0; i<arr.length; i++) {
            if(i == index)
                continue;

            imageViewList[i] = arr[i];
        }

        return imageViewList;
    }
}

class AllergicFoodList {

    private static AllergicFoodList allergicFood;
    private Context mContext;

    private LinearLayout layout;
    private TextView textView;
    private ImageView imageView;

    public AllergicFoodList(Context mContext) {
        this.mContext = mContext;
        create();
    }

    public static synchronized AllergicFoodList getInstance(final Context context) {
        if(allergicFood == null)
            allergicFood = new AllergicFoodList(context);
        return allergicFood;
    }

    protected static AllergicFoodList init(Context mContext) {
        return new AllergicFoodList(mContext);

//        layout = new LinearLayout(mContext);
//        textView = new TextView(mContext);
//        imageView = new ImageView(mContext);
    }

    public LinearLayout layout() {
        return layout;
    }

    public TextView text() {
        return textView;
    }

    public ImageView image() {
        return imageView;
    }

    private void create() {
        layout = new LinearLayout(mContext);
        textView = new TextView(mContext);
        imageView = new ImageView(mContext);
    }

    public void setLayoutSize(final Integer width, final Integer height) {
        layout.setLayoutParams(new LinearLayout.LayoutParams(width, height));
    }

    public void setLayoutBackgroundColor(final Integer color) {
        layout.setBackgroundColor(color);
    }

    public void setText(final String text) {
        textView.setText(text);
    }

    public void setImage(final Integer resId) {
        imageView.setImageResource(resId);
    }

    public void setImageSize(final Integer width, final Integer height) {
        imageView.setLayoutParams(new LinearLayout.LayoutParams(width, height));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void setImageOnClick() {
//        imageView.setOnClickListener();
    }

    public LinearLayout createItem() {
        layout.addView(textView);
        layout.addView(imageView);

        return layout;
    }

    public AllergicFoodList[] remove(final AllergicFoodList[] arr, final Integer index) {
        AllergicFoodList[] aflArr = new AllergicFoodList[arr.length - 1];

        for(int i=0; i<arr.length; i++) {
            if(i == index)
                continue;
            aflArr[i] = arr[i];
        }
        return aflArr;
    }

}
