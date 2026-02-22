package com.aimbooster.ff.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.aimbooster.ff.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.slider.Slider

class SensitivityFragment : Fragment() {

    private lateinit var prefs: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sensitivity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prefs = requireContext().getSharedPreferences("sensitivity", 0)

        val tvGeneral = view.findViewById<TextView>(R.id.tvGeneral)
        val tvRedDot = view.findViewById<TextView>(R.id.tvRedDot)
        val tvScope2x = view.findViewById<TextView>(R.id.tvScope2x)
        val tvScope4x = view.findViewById<TextView>(R.id.tvScope4x)
        val tvAwm = view.findViewById<TextView>(R.id.tvAwm)

        val sliderGeneral = view.findViewById<Slider>(R.id.sliderGeneral)
        val sliderRedDot = view.findViewById<Slider>(R.id.sliderRedDot)
        val sliderScope2x = view.findViewById<Slider>(R.id.sliderScope2x)
        val sliderScope4x = view.findViewById<Slider>(R.id.sliderScope4x)
        val sliderAwm = view.findViewById<Slider>(R.id.sliderAwm)

        sliderGeneral.value = prefs.getFloat("general", 75f)
        sliderRedDot.value = prefs.getFloat("red_dot", 70f)
        sliderScope2x.value = prefs.getFloat("scope_2x", 60f)
        sliderScope4x.value = prefs.getFloat("scope_4x", 50f)
        sliderAwm.value = prefs.getFloat("awm", 45f)

        fun updateLabel(tv: TextView, label: String, value: Int) {
            tv.text = "$label: $value"
        }

        sliderGeneral.addOnChangeListener { _, value, _ ->
            updateLabel(tvGeneral, "General Sensitivity", value.toInt())
        }
        sliderRedDot.addOnChangeListener { _, value, _ ->
            updateLabel(tvRedDot, "Red Dot", value.toInt())
        }
        sliderScope2x.addOnChangeListener { _, value, _ ->
            updateLabel(tvScope2x, "2x Scope", value.toInt())
        }
        sliderScope4x.addOnChangeListener { _, value, _ ->
            updateLabel(tvScope4x, "4x Scope", value.toInt())
        }
        sliderAwm.addOnChangeListener { _, value, _ ->
            updateLabel(tvAwm, "AWM Scope", value.toInt())
        }

        updateLabel(tvGeneral, "General Sensitivity", sliderGeneral.value.toInt())
        updateLabel(tvRedDot, "Red Dot", sliderRedDot.value.toInt())
        updateLabel(tvScope2x, "2x Scope", sliderScope2x.value.toInt())
        updateLabel(tvScope4x, "4x Scope", sliderScope4x.value.toInt())
        updateLabel(tvAwm, "AWM Scope", sliderAwm.value.toInt())

        view.findViewById<MaterialButton>(R.id.btnSavePreset).setOnClickListener {
            prefs.edit()
                .putFloat("general", sliderGeneral.value)
                .putFloat("red_dot", sliderRedDot.value)
                .putFloat("scope_2x", sliderScope2x.value)
                .putFloat("scope_4x", sliderScope4x.value)
                .putFloat("awm", sliderAwm.value)
                .apply()
            Toast.makeText(requireContext(), "Preset saved! Apply in Free Fire Settings → Sensitivity", Toast.LENGTH_LONG).show()
        }
    }
}
