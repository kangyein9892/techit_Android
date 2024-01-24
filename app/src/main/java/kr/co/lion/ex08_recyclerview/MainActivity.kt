package kr.co.lion.ex08_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.divider.MaterialDividerItemDecoration
import kr.co.lion.ex08_recyclerview.databinding.ActivityMainBinding
import kr.co.lion.ex08_recyclerview.databinding.IdNameLayoutBinding

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding

    val idList = mutableListOf<String>()
    val nameList = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.apply{

            // 어뎁터 객체 생성
            val recyclerViewAdapter = RecyclerViewAdapter()
            // 어뎁터를 적용해준다.
            recyclerView.adapter = recyclerViewAdapter

            // RecyclerView 의 항목을 보여줄 방식을 설정한다.
            // 위에서 아래 방향
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

            // RecyclerView Decoration
            // 각 항목을 구분하기 위한 구분선
            val deco = MaterialDividerItemDecoration(this@MainActivity, MaterialDividerItemDecoration.VERTICAL)
            recyclerView.addItemDecoration(deco)

            submitBtn.setOnClickListener {
                idList.add(idTextField.text.toString())
                nameList.add(nameTextField.text.toString())

                // recyclerView 갱신
                recyclerViewAdapter.notifyDataSetChanged()
            }

        }
    }
    inner class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolderClass>(){

        // ViewHolder
        inner class ViewHolderClass(idNameLayoutBinding: IdNameLayoutBinding) : RecyclerView.ViewHolder(idNameLayoutBinding.root){
            // 매개변수로 들어오는 바인딩객체를 담을 프로퍼티
            var idNameLayoutBinding: IdNameLayoutBinding

            init{
                this.idNameLayoutBinding = idNameLayoutBinding
            }
        }

        // ViewHolder 객체를 생성하여 반환한다.
        // 새롭게 항목이 보여질 때 재사용 가능한 항목이 없다면 이 메서드를 호출한다.
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
            // View Binding
            val idNameLayoutBinding = IdNameLayoutBinding.inflate(layoutInflater)
            // View Holder
            val viewHolderClass = ViewHolderClass(idNameLayoutBinding)

            // 반환한다.
            return viewHolderClass
        }

        // RecyclerView를 통해 보여줄 항목 전체의 개수를 반환한다.
        override fun getItemCount(): Int {
            return idList.size
        }

        // 항목의 View에 보여주고자 하는 데이터를 설정한다.
        // 첫 번째 매개변수 : ViewHolder 객체. 재사용 가능한 것이 없다면 onCreateViewHolder 메서드를
        // 호출하고 반환하는 ViewHolder 객체가 들어오고 재사용 가능한 것이 있다면 재사용 가능한 ViewHolder 객체가
        // 들어온다.
        // 두 번째 매개변수 : 구성하고자 하는 항목의 순서 값(0 부터 1씩 증가)
        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
            holder.idNameLayoutBinding.idTextView.text = "아이디: ${idList[position]}"
            holder.idNameLayoutBinding.nameTextView.text = "이름: ${nameList[position]}"
        }

    }
}