package com.mugerwa.icare

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

import java.net.URL



class MainFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root=inflater.inflate(R.layout.fragment_main,container,false)
        val recyclerview=root.findViewById<RecyclerView>(R.id.recyclerview)
        val products= arrayListOf<Product>()

        val images= arrayListOf<String>(
            "https://images.unsplash.com/photo-1611186871348-b1ce696e52c9?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870",
            "https://png.pngitem.com/pimgs/s/27-274613_megatron-ll-laptop-blue-hd-png-download.png",
            "https://banner2.cleanpng.com/20180304/wuq/kisspng-desktop-computer-computer-graphics-computer-monito-computer-vector-5a9cbbbabe22c4.1821490115202211147788.jpg",
           "https://spng.pngfind.com/pngs/s/209-2092203_49-toshiba-full-hd-wlan-tv-43-toshiba.png",
            "https://spng.pngfind.com/pngs/s/51-515741_samsung-uhd-4k-flat-smart-tv-tv-43.png",
            "https://spng.pngfind.com/pngs/s/60-603095_cable-tv-png-pic-cable-tv-png-transparent.png",
            "https://spng.pngfind.com/pngs/s/209-2092148_samsung-led-tv-samsung-curved-65-inch-tv.png",
            "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=60&raw_url=true&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8c21hcnQlMjBwaG9uZXN8ZW58MHx8MHx8&auto=format&fit=crop&w=500",
            "https://images.unsplash.com/photo-1642101373432-a9c683c34902?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=60&raw_url=true&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fHNtYXJ0JTIwd2F0Y2hlc3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500",
            "https://images.unsplash.com/photo-1585123334904-845d60e97b29?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=60&raw_url=true&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTd8fHNtYXJ0JTIwd2F0Y2hlc3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500"

        )
        val desc= arrayListOf<String>(
            "Apple MacBook Pro is a macOS laptop with a 13.30-inch display that has a resolution of 2560x1600 pixels. It is powered by a Core i5 processor and it comes with 12GB of RAM. The Apple MacBook Pro packs 512GB of SSD storage.", "PC Desktop Specifications: Processor: Intel Core i7-2600 Processor, 3.4GHz, 8M Cache. Operating system: Windows 7 Professional 64",
             "Intel Core i5 8th Gen · Quad Core, 1.6 GHz Clock Speed · 8 GB DDR4 RAM · 1 TB Hard Disk · 256 GB SSD · 2 GB Intel Graphics Card · 13.3 inches",
            "Display, 65.00-inch ; Screen Type, OLED ; Resolution Standard, 4K ; Smart TV, Yes ; LG 65 Inch OLED Ultra HD (4K) TV (B9 OLED65B9PTA) Full Specs ..",
            "Display, 65.00-inch ; Screen Type, OLED ; Resolution Standard, 4K ; Smart TV, Yes ; LG 65 Inch OLED Ultra HD (4K) TV (B9 OLED65B9PTA) Full Specs ..",
        "Startimes has really affordable decoders. For terrestrial package that doesn't require a dish, you pay UGX 85, 000. It comes with one month of classic package.",
        "Screen Size27  Dynamic Contrast RatioMega  Flat / CurvedCurved  Resolution1920X1080  Active Display Size (HxV)597.89mm x 336.31mm",
        "Height: 5.65 inches (143.6 mm) · Width: 2.79 inches (70.9 mm) · Depth: 0.30 inch (7.7 mm) · Weight: 6.14 ounces (174 grams) ..",
        "smartwatch, a small smartphonelike device worn on the wrist. Many smartwatches are connected to a smartphone that notifies the user of incoming calls, e-mail messages, and notifications from applications. Some smartwatches can even make telephone calls.",
        "An analog watch is one in which the display is not digital, but is indicated (typically) by the continuous motion of one, two, or three rotating pointers or hands pointing to numbers arrayed on a circular dial (the hour hand's movement being analogous to the path of the sun across the sky)."

        )
        val title= arrayListOf<String>(
            "Mac book",
            "Windows Laptop",
            "Desktop",
            "Toshiba",
            "Flat Smart",
            "Cable Tv",
            "Samsung-curved",
            "Iphone X",
            "Smart Watch",
            "Original Watch"
        )
        val price= arrayListOf<Double>(
            250.0,
            150.0,
            400.0,
            300.0,
            200.0,
            100.0,
            500.4,
            750.3,
            255.5,
            234.5
        )


        for(i in images.indices)
        {
            products.add(Product(title[i], images[i],price[i],desc[i]))
        }
        recyclerview.apply{
            layoutManager= GridLayoutManager(activity,2)
            adapter=ProductAdapter(products)
        }

//        categories recycler view
        val categories= listOf("Radios","Televisions","Computers","Softwares","Phones","Clothes")
        val categoriesRecy:RecyclerView=root.findViewById(R.id.categories)
        categoriesRecy.apply {
            layoutManager=LinearLayoutManager(activity,RecyclerView.HORIZONTAL,false)
            adapter=CategoriesAdapter(categories)
        }
        return root
    }
}