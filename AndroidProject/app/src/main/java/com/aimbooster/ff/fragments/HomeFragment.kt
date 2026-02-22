package com.aimbooster.ff.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aimbooster.ff.MainActivity
import com.aimbooster.ff.R
import com.google.android.material.card.MaterialCardView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<MaterialCardView>(R.id.cardEnhancedAim).setOnClickListener {
            (activity as? MainActivity)?.showFragment(EnhancedAimFragment(), true)
        }
        view.findViewById<MaterialCardView>(R.id.cardBoostAim).setOnClickListener {
            (activity as? MainActivity)?.showFragment(BoostAimFragment(), true)
        }
        view.findViewById<MaterialCardView>(R.id.cardSensitivity).setOnClickListener {
            (activity as? MainActivity)?.showFragment(SensitivityFragment(), true)
        }
        view.findViewById<MaterialCardView>(R.id.cardAbout).setOnClickListener {
            (activity as? MainActivity)?.showFragment(AboutFragment(), true)
        }
    }
}
