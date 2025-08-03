package edu.unikom.praktikfragmentproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class FragmentA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnsubmit = view.findViewById<Button>(R.id.btn_submit)
        val btntofragmentB = view.findViewById<Button>(R.id.btn_tofragmentB)
        val fragmentManager = parentFragmentManager
        val txtvalue = view.findViewById<TextView>(R.id.txtvalue)
        val dataFromFragmentB = arguments?.getString("DATA_KEY")
        if (dataFromFragmentB != null) {
            txtvalue.text = dataFromFragmentB
        }
        txtvalue.text = dataFromFragmentB
        btnsubmit.setOnClickListener {
            Toast.makeText(requireContext(), "Submit di halaman ini", Toast.LENGTH_SHORT).show()
        }
        btntofragmentB.setOnClickListener {
            val fragmentB = FragmentB()
            fragmentManager.beginTransaction()
                .replace(R.id.frameContainer, fragmentB, FragmentB::class.java.simpleName)
                .addToBackStack(null)
                .commit()
        }
    }

}