package edu.unikom.praktikfragmentproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class FragmentB : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val edtdata = view.findViewById<TextInputEditText>(R.id.edtdata)
        val btntofragmentA = view.findViewById<Button>(R.id.btntofragmentA)
        val fragmentManager = parentFragmentManager

        btntofragmentA.setOnClickListener {
            val valueEditText = edtdata.text.toString()
            val dataToBeSend: String? = if (valueEditText.isNotEmpty()) {
                valueEditText
            } else {
                null
            }
            val fragmentA = FragmentA()
            fragmentA.arguments = Bundle().apply {
                putString("DATA_KEY", dataToBeSend)
            }
            fragmentManager.beginTransaction()
                .replace(R.id.frameContainer, fragmentA, FragmentA::class.java.simpleName)
                .commit()

        }}


}