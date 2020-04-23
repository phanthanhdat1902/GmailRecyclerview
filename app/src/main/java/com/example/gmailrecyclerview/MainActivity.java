package com.example.gmailrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gmailrecyclerview.Adapter.ItemAdapter;
import com.example.gmailrecyclerview.Models.gmail_item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    List<gmail_item> listItem;
    List<gmail_item> listFavorite;
    EditText searchEditText;
    Button favoriteButton;
    RecyclerView recyclerView;
    ItemAdapter adapter;
    String keyword;
    boolean FavoriteLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchEditText=findViewById(R.id.edit_search);
        listItem=new ArrayList<gmail_item>();
        listFavorite=new ArrayList<gmail_item>();
        FavoriteLayout=false;
        listItem.add(new gmail_item("Chang Le","Beo U","Em có sai với ai đi nữa, có làm cái gì đi nữa. Nếu có phải trả giá thì em cũng xin chấp nhận"));
        listItem.add(new gmail_item("Trang Le","Beo U","Ra xã hội làm ăn bươn chải. Liều thì ăn nhiều, không liều thì ăn ít. Muốn thành công thì phải chấp nhận chịu qua đắng cay ngọt bùi"));
        listItem.add(new gmail_item("Phan Le","Beo U","Làm ăn muốn kiếm được tiền phải chấp nhận mạo hiểm, nguy hiểm một tý, nhưng “trong tầm kiểm soát"));
        listItem.add(new gmail_item("Dat Le","Beo U","Xã hội này chỉ có làm, chịu khó, cần cù thì bù siêng năng. Chỉ có làm thì mới có ăn. Những cái loại không làm mà đòi có ăn thì chỉ có ăn..., ăn shit."));
        listItem.add(new gmail_item("Chang Le","Beo U","Còn xã hội này, sống muốn được người ta tôn trọng thì mình phải tôn trọng người khác trước, Muốn người ta quý mình thì mình phải quý người ta trước"));
        listItem.add(new gmail_item("Chang Le","Beo U","Những người cho mình vay tiền, lúc mình khó khăn, lúc mình khổ, lúc mình vỡ nợ, không phải vì người ta ngu, không phải vì người ta dại, mà vì chính người đó mình nên tôn trọng, bởi những người đó coi mình là anh em bạn bè thì những lúc mình vỡ nợ, khó khăn, khổ người ta mới đưa tiền cho mình vay."));
        listItem.add(new gmail_item("Chang Le","Beo U","Những người có tiền, không phải người ta ngu đâu, không phải người ta thừa tiền đâu. Người ta coi mình quan trọng hơn tiền bạc,người ta mới giúp lúc mình khó khăn, lúc mình khổ"));
        listItem.add(new gmail_item("Chang Le","Beo U","Còn anh em, bạn bè chơi với nhau, có ăn thì tìm đến có đòn thì tìm đi. Những cái loại đấy là ăn anh, ăn em."));
        listItem.add(new gmail_item("Chang Le","Beo U","Ở cái xã hội này phải chịu khó làm, chịu khó học hỏi, khắc có tiền. Nay không kiếm được nhiều thì kiếm được ít, mình tích tiểu thành đại, mình chưa có thì mình không được chơi bời"));
        listItem.add(new gmail_item("Chang Le","Beo U","Chưa có thì mình phải làm, làm được bao nhiêu thì mình tiết kiệm, mình tích tiểu thành đại."));
        listItem.add(new gmail_item("Chang Le","Beo U","Là một thằng đàn ông, kể cả mình bỏ ra 3 năm để làm ăn, kiếm tiền làm vốn chỉ làm ăn thôi, không giao lưu với đéo ai hết. Bởi vì khi các bạn đã không có tiền ý, đi giao lưu thì các bạn chỉ có thiệt thôi."));
        listItem.add(new gmail_item("Chang Le","Beo U","Tất cả chỉ vì đứa con của mình, vì tương lai của vợ con mình thôi, chứ vì cái gì. Để cho vợ con mình, nó vượt khó vượt khổ."));
        listItem.add(new gmail_item("Chang Le","Beo U","Mình có chấp nhận hi sinh, hi sinh một tý có sao, có tương sau này. Hi sinh đời bố,, củng cố cho đời con."));
        listItem.add(new gmail_item("Chang Le","Beo U","Mình sinh ra là từ con số 0. Mình phải cô gắng. Từ con số 0 mà đi lên được mới là đẳng cấp"));
        listItem.add(new gmail_item("Chang Le","Beo U","Chứ còn chúng nó sinh ra ở vạch đích rồi, nó làm sao hiểu được cảm giác của anh em mình, ra xã hội, vừa phải đối mặt nguy hiểm, vừa phải đánh đổi bằng máu, hi sinh, bán lưng cho đất, bán mặt cho trời, phải cày tiền như con chó, thức đêm thức hôm."));
        listItem.add(new gmail_item("Chang Le","Beo U","Đúng vậy đã là người việt nam máu đỏ da vàng. Cuộc đời ai biết trước sự việc gì từ đâu ùa về...hãy sống sao khỏi phải tiếc nuối hụt hẩng hối hận hơn thua gì với đời..sống sao cho khỏi thẹn lòng hổ danh...vì cuộc đời này thực ra nó đẹp đẽ lắm"));
        listItem.add(new gmail_item("Chang Le","Beo U","ãy kề vai giang tay vun vén từng mảnh đời khỏi mọi bề âu lo tiêu cực của số phận. Bản thân mỗi cá nhân có chí vượt nghịch cảnh, có lập trường ý nghĩ vượt cái cùng,cực"));
        listItem.add(new gmail_item("Chang Le","Beo U","Mà sih ra là nam nhi nhãn quan soi sao cho tới bình minh đỏ thẫm.,lắng sao cho hết muộn phiền tính toan,. Nam nhi nhìn cao vạn trượng xa thấu đất trời..1 bước ngàn cân xông pha mọi nẻo đường,được sinh thời ở bầu trời xanh sáng"));
        for(int i=0;i<listItem.size()-1;i++){
            if(listItem.get(i).isFavorite()==true){
                listFavorite.add(listFavorite.get(i));
            }
        }
        favoriteButton=findViewById(R.id.button_favorite);
        recyclerView=findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new ItemAdapter(listItem);
        recyclerView.setAdapter(adapter);
        favoriteButton.setOnClickListener(this);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                keyword=s.toString();
                if(keyword.length()>2){
                    adapter.displaySearch(keyword);
                }else{
                    adapter.showAllItem();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.button_favorite){
            if(FavoriteLayout){
                FavoriteLayout=!FavoriteLayout;
                adapter.showAllItem();
            }else{
                FavoriteLayout=!FavoriteLayout;
                adapter.displayFavorite();
            }
        }
    }
}
