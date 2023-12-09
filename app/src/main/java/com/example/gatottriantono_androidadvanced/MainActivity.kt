package com.example.gatottriantono_androidadvanced

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gatottriantono_androidadvanced.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView : BottomNavigationView
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    lateinit var imageList : Array<Int>
    lateinit var titleList : Array<String>
    lateinit var descList : Array<String>
    lateinit var detailImageList : Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initUI()

        imageList = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img212,
            R.drawable.img067
        )

        titleList = arrayOf(
            "Entrok",
            "Sumur",
            "Saman",
            "Ronggeng Dukuh Paruk",
            "Bumi Manusia",
            "Cantik itu Luka",
            "Laut Bercerita",
            "Perjalanan Menuju Pulang",
            "Laskar Pelangi",
            "Tenggelamnya Kapal van der Wijck"
        )

        descList = arrayOf(
            getString(R.string.Entrok),
            getString(R.string.Sumur),
            getString(R.string.Saman),
            getString(R.string.Ronggeng_Dukuh_Paruk),
            getString(R.string.Bumi_Manusia),
            getString(R.string.Cantik_itu_Luka),
            getString(R.string.Laut_Bercerita),
            getString(R.string.Perjalanan_Menuju_Pulang),
            getString(R.string.Laskar_Pelangi),
            getString(R.string.Tenggelamnya_Kapal_van_der_Wijck)
        )
        detailImageList = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img212,
            R.drawable.img067
        )

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        dataList = arrayListOf<DataClass>()
        getData()


    }
    private fun getData(){
        for (i in imageList.indices){
            val dataClass = DataClass(imageList[i], titleList[i], descList[i], detailImageList[1])
            dataList.add(dataClass)
        }
        recyclerView.adapter = AdapterClass(dataList)
    }

    @SuppressLint("SetTextI18n")
    private fun initUI(){
        binding.customtoolbar.book.setOnClickListener {
            Toast.makeText(this, "App logo", Toast.LENGTH_SHORT).show()
        }
        binding.customtoolbar.setting.setOnClickListener {
            Toast.makeText(this, "Setting button", Toast.LENGTH_SHORT).show()
        }
        binding.customtoolbar.notification.setOnClickListener {
            Toast.makeText(this, "Notification button", Toast.LENGTH_SHORT).show()
        }
        binding.customtoolbar.appname.text = "Book"

        bottomNavigationView = findViewById(R.id.button_navigation)
        bottomNavigationView.setOnItemReselectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.button_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.button_explore -> {
                    replaceFragment(ExploreFragment())
                    true
                }
                else -> false
            }
        }
        replaceFragment(HomeFragment())

    }

    private fun replaceFragment (fragment:Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
    }

}