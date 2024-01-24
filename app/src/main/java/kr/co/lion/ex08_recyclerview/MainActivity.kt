package kr.co.lion.ex08_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.divider.MaterialDividerItemDecoration
import kr.co.lion.ex08_recyclerview.databinding.ActivityMainBinding
import kr.co.lion.ex08_recyclerview.databinding.IdNameLayoutBinding
import kr.co.lion.ex08_recyclerview.databinding.RowBinding

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding

    // val idList = mutableListOf<String>()
    //  val nameList = mutableListOf<String>()

    // RecyclerView를 구성하기 위한 데이터를 담을 리스트
    val listRow1 = mutableListOf<String>()
    val listRow2 = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        initView()
        setViewEvent()
        // setTestData()

        activityMainBinding.apply{



            /*// 어뎁터 객체 생성
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
            }*/

        }
    }

    // 테스트용 데이터 셋팅
    fun setTestData(){
        // RecyclerView 구성을 위한 임시 데이터 셋팅
        listRow1.addAll(arrayOf("문자열1-1", "문자열1-2", "문자열1-3"))
        listRow2.addAll(arrayOf("문자열2-1", "문자열2-2", "문자열2-3"))
    }

    // View를 초기화하는 메서드
    fun initView(){
        activityMainBinding.apply {
            // RecyclerView 설정
            recyclerViewResult.apply {
                // 어뎁터
                adapter = RecyclerViewAdapter()
                // 레이아웃 매니저
                layoutManager = LinearLayoutManager(this@MainActivity)
                // 데코레이션
                val deco = MaterialDividerItemDecoration(this@MainActivity, MaterialDividerItemDecoration.VERTICAL)
                addItemDecoration(deco)
            }
        }
    }
    // 이벤트를 설정하는 메서드
    fun setViewEvent(){
        activityMainBinding.apply {
            // 버튼 이벤트
            buttonSubmit.setOnClickListener {
                // 사용자가 입력한 내용을 리스트에 담는다.
                listRow1.add(textFieldUserId.text!!.toString())
                listRow2.add(textFieldUserName.text!!.toString())

                // 입력 요소를 비워준다.
                textFieldUserId.setText("")
                textFieldUserName.setText("")

                // 리사이클러 뷰를 갱신한다.
                recyclerViewResult.adapter?.notifyDataSetChanged()
            }
        }
    }

    // 리사이클러 뷰의 어뎁터
    inner class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolderClass>(){
        // ViewHolder
        inner class ViewHolderClass(rowBinding: RowBinding) : RecyclerView.ViewHolder(rowBinding.root){
            val rowBinding:RowBinding

            init {
                this.rowBinding = rowBinding
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
            val rowBinding = RowBinding.inflate(layoutInflater)
            val viewHolderClass = ViewHolderClass(rowBinding)

            return viewHolderClass
        }

        override fun getItemCount(): Int {
            return listRow1.size
        }

        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
            holder.rowBinding.textViewRow1.text = listRow1[position]
            holder.rowBinding.textViewRow2.text = listRow2[position]
        }
    }

    /*inner class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolderClass>(){

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

    }*/
}