package com.example.currencyconverter

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.ImageView
import com.airbnb.lottie.LottieAnimationView
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {

    //edit views
    lateinit var rupeeEditText: EditText
    lateinit var dollarEditText: EditText

    //arrow views
    lateinit var bottom:ImageView
    lateinit var up:ImageView

    //lottie views
    lateinit var rupeeLottie:LottieAnimationView
    lateinit var dollarLottie:LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        bottom.setOnClickListener{
            //get rupee value and pass it to function
            val Rupee=rupeeEditText.text.toString().toDouble()
            val DollarValue=ConversionR2D(Rupee).toRound(2)

            //set the value
            dollarEditText.text = DollarValue.toString().toEditable()

            //start animation
            dollarLottie.playAnimation()


        }

        up.setOnClickListener{
            //get rupee value and pass it to function
            val Dollar=dollarEditText.text.toString().toDouble()
            val RupeeValue=ConversionD2R(Dollar).toRound(2)

            //set the value
            rupeeEditText.text = RupeeValue.toString().toEditable()

            //start animation
            rupeeLottie.playAnimation()


        }



    }

    private fun ConversionD2R(DollarValue:Double)=DollarValue*75.24

    private fun ConversionR2D(RupeeValue:Double)=RupeeValue/75.24

     private fun initView(){

         rupeeEditText=findViewById(R.id.et)
         dollarEditText=findViewById(R.id.et2)

         bottom=findViewById(R.id.imageView)
         up=findViewById(R.id.imageView2)

         rupeeLottie=findViewById(R.id.coin)
         dollarLottie=findViewById(R.id.coin2)


     }

    private fun String.toEditable():Editable= Editable.Factory.getInstance().newEditable(this)

    private fun Double.toRound(n:Int):Double="%.${n}f".format(this).toDouble()

    private fun String.toUpperCase():String{
        return this.toUpperCase()
    }


}