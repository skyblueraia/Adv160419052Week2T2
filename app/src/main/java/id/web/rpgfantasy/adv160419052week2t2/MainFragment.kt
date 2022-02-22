package id.web.rpgfantasy.adv160419052week2t2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
    var score = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var randomNumber1 = (0..99).random()
        var randomNumber2 = (0..99).random()
        var result = randomNumber1 + randomNumber2
        txtTebakJumlah.text = "$randomNumber1 + $randomNumber2"
        btnSubmit.setOnClickListener {
            if(txtJawaban.text.toString() == result.toString()) {
                score++
            }
            else{
                val action = MainFragmentDirections.actionMainFragmentToResultFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
            randomNumber1 = (0..99).random()
            randomNumber2 = (0..99).random()
            result = randomNumber1 + randomNumber2
            txtTebakJumlah.text = "$randomNumber1 + $randomNumber2"
            txtJawaban.setText("")
        }
    }
}