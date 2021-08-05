package com.coxtunes.buttonStateRecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.coxtunes.buttonStateRecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var productCategoryList: MutableList<ProductCategory> = ArrayList()
    var recyclerAdapter: RecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        recyclerAdapter = RecyclerAdapter(this@MainActivity, productCategoryList)
        binding.RvPets.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = recyclerAdapter
        }

        preparePetsData()
    }

    private fun preparePetsData() {

        productCategoryList.add(ProductCategory("Travel & Tour"))
        productCategoryList.add(ProductCategory("Safety & Security"))
        productCategoryList.add(ProductCategory("Home Applience"))
        productCategoryList.add(ProductCategory("Even & Media"))
        productCategoryList.add(ProductCategory("Fashion For Man"))
        productCategoryList.add(ProductCategory("Fashion For Woman"))
        productCategoryList.add(ProductCategory("Home & Living"))
        productCategoryList.add(ProductCategory("Jewellary"))
        productCategoryList.add(ProductCategory("Paints"))
        productCategoryList.add(ProductCategory("Watch & Clock"))
        productCategoryList.add(ProductCategory("Kitchen & Dining"))
        productCategoryList.add(ProductCategory("Vehicles & Parts"))
        productCategoryList.add(ProductCategory("Book & Stationary"))
        productCategoryList.add(ProductCategory("Grocery"))
        productCategoryList.add(ProductCategory("Health Care"))
        productCategoryList.add(ProductCategory("Mother kids & Toys"))
        productCategoryList.add(ProductCategory("Beauty Care"))
        productCategoryList.add(ProductCategory("Shoes"))
        recyclerAdapter!!.notifyDataSetChanged()
    }
}