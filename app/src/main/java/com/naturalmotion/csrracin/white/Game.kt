package com.naturalmotion.csrracin.white

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import com.naturalmotion.csrracin.R
import com.naturalmotion.csrracin.databinding.ActivityGameBinding
import kotlinx.android.synthetic.main.activity_game.*

class Game : AppCompatActivity() {
    lateinit var binding : ActivityGameBinding
    var pos=3
    var pos1=0
    var pos2=0
    var step=0
    var scr=0
    lateinit var score:String
    var rolld= mutableListOf<Int>(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14)
    private var timer: CountDownTimer?=null
    lateinit var but1:Array<Button>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        but1= arrayOf(ims1,ims2,ims3,ims4,ims5,imas1,imas2,imas3,imas4,imas5,imasa1,imasa2,imasa3,imasa4,imasa5)
        for( i in 0..14){
            but1[i].setVisibility(View.GONE)
        }
        binding.im1.setVisibility(View.GONE)
        binding.im2.setVisibility(View.GONE)
        binding.im3.setVisibility(View.VISIBLE)
        binding.im4.setVisibility(View.GONE)
        binding.im5.setVisibility(View.GONE)
        binding.up.setOnClickListener {
            if(pos>1){
                pos--
                if(pos==1){
                    binding.im1.setVisibility(View.VISIBLE)
                    binding.im2.setVisibility(View.GONE)
                    binding.im3.setVisibility(View.GONE)
                    binding.im4.setVisibility(View.GONE)
                    binding.im5.setVisibility(View.GONE)
                }
                else if(pos==2){
                    binding.im1.setVisibility(View.GONE)
                    binding.im2.setVisibility(View.VISIBLE)
                    binding.im3.setVisibility(View.GONE)
                    binding.im4.setVisibility(View.GONE)
                    binding.im5.setVisibility(View.GONE)
                }
                else if(pos==3){
                    binding.im1.setVisibility(View.GONE)
                    binding.im2.setVisibility(View.GONE)
                    binding.im3.setVisibility(View.VISIBLE)
                    binding.im4.setVisibility(View.GONE)
                    binding.im5.setVisibility(View.GONE)
                }
                else if(pos==4){
                    binding.im1.setVisibility(View.GONE)
                    binding.im2.setVisibility(View.GONE)
                    binding.im3.setVisibility(View.GONE)
                    binding.im4.setVisibility(View.VISIBLE)
                    binding.im5.setVisibility(View.GONE)
                }
                else if(pos==5){
                    binding.im1.setVisibility(View.GONE)
                    binding.im2.setVisibility(View.GONE)
                    binding.im3.setVisibility(View.GONE)
                    binding.im4.setVisibility(View.GONE)
                    binding.im5.setVisibility(View.VISIBLE)
                }
            }


        }
        binding.down.setOnClickListener {
            if(pos<5){
                pos++
                if(pos==1){
                    binding.im1.setVisibility(View.VISIBLE)
                    binding.im2.setVisibility(View.GONE)
                    binding.im3.setVisibility(View.GONE)
                    binding.im4.setVisibility(View.GONE)
                    binding.im5.setVisibility(View.GONE)
                }
                else if(pos==2){
                    binding.im1.setVisibility(View.GONE)
                    binding.im2.setVisibility(View.VISIBLE)
                    binding.im3.setVisibility(View.GONE)
                    binding.im4.setVisibility(View.GONE)
                    binding.im5.setVisibility(View.GONE)
                }
                else if(pos==3){
                    binding.im1.setVisibility(View.GONE)
                    binding.im2.setVisibility(View.GONE)
                    binding.im3.setVisibility(View.VISIBLE)
                    binding.im4.setVisibility(View.GONE)
                    binding.im5.setVisibility(View.GONE)
                }
                else if(pos==4){
                    binding.im1.setVisibility(View.GONE)
                    binding.im2.setVisibility(View.GONE)
                    binding.im3.setVisibility(View.GONE)
                    binding.im4.setVisibility(View.VISIBLE)
                    binding.im5.setVisibility(View.GONE)
                }
                else if(pos==5){
                    binding.im1.setVisibility(View.GONE)
                    binding.im2.setVisibility(View.GONE)
                    binding.im3.setVisibility(View.GONE)
                    binding.im4.setVisibility(View.GONE)
                    binding.im5.setVisibility(View.VISIBLE)
                }
            }
        }
        startTimer(100000000)
    }

    private fun startTimer(timeMillis:Long){

        timer=object : CountDownTimer(timeMillis,750){

            override fun onTick(TimeEl: Long) {
                step++
                if(step==1){
                    pos1=rolld.random()
                    but1[pos1].animate().apply {
                        but1[pos1].setVisibility(View.VISIBLE)
                        translationX(-500f)
                        duration=1250
                    }.withEndAction {
                        if(but1[pos1].text=="$pos"){
                            score="Your score : $scr"
                            timer?.cancel()
                            val intent=Intent(this@Game,Res::class.java)
                            intent.putExtra("key",score)
                            startActivity(intent)

                        }else{
                            scr++
                            binding.score.text="Score : $scr"
                            but1[pos1].animate().apply {
                                but1[pos1].setVisibility(View.GONE)
                                translationX(500f)
                                duration=1
                            }
                        }
                    }
                }else if(step==2){
                    step=0
                    pos2=rolld.random()
                    if(pos2==pos1){
                        pos2=rolld.random()
                    }
                    else{
                        but1[pos2].animate().apply {
                            but1[pos2].setVisibility(View.VISIBLE)
                            translationX(-500f)
                            duration=1250
                        }.withEndAction {
                            if(but1[pos2].text=="$pos"){
                                score="Your score : $scr"
                                timer?.cancel()
                                val intent=Intent(this@Game,Res::class.java)
                                intent.putExtra("key",score)
                                startActivity(intent)

                            }else{
                                scr++
                                binding.score.text="Score : $scr"
                                but1[pos2].animate().apply {
                                    but1[pos2].setVisibility(View.GONE)
                                    translationX(500f)
                                    duration=1
                                }
                            }
                        }
                    }
                }

            }

            override fun onFinish() {

            }

        }.start()

    }


}